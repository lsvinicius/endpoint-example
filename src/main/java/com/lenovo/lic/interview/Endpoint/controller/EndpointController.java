package com.lenovo.lic.interview.Endpoint.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lenovo.lic.interview.Endpoint.model.Endpoint;
import com.lenovo.lic.interview.Endpoint.repository.EndpointRepository;

@RestController
@RequestMapping("/endpoint")
public class EndpointController {
	@Autowired
	private EndpointRepository endpointRepository;
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public Endpoint register(@RequestBody Endpoint endpoint) {
		endpointRepository.save(endpoint);
		return endpoint;
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/modify") 
	public Map<String,Object> modify(@RequestBody Endpoint endpoint) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("message", "endpoint not found");
		if(endpointRepository.exists(endpoint.getId())) {
			endpointRepository.save(endpoint);
			result.put("message", "endpoint updated");
			result.put("endpoint", endpoint);
		}
		return result;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/list")
	public List<Endpoint> listAll() {
		List<Endpoint> result = new ArrayList<Endpoint>();
		endpointRepository.findAll().forEach(result::add);
		return result;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/remove/{id}")
	public Map<String,Object> delete(@PathVariable Long id) {
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("message", "endpoint not found");
		if(endpointRepository.exists(id)) {
			endpointRepository.delete(id);
			result.put("success", true);
			result.put("message", "endpoint removed");
		}
		return result;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/turnon/{id}")
	public Map<String,Object> turnMachineOn(@PathVariable Long id, Principal principal) {
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("user", principal.getName());
		result.put("message", "endpoint not found");
		if(endpointRepository.exists(id)) {
			Endpoint endpoint = endpointRepository.findOne(id);
			result.put("message", "invalid credentials");
			if(endpoint.getAccount().getUsername().equals(principal.getName())) {
				result.put("message", "endpoint is already on");
				if(!endpoint.isOn()) {
					endpoint.turnOn();
					endpointRepository.save(endpoint);
					result.put("success", true);
					result.put("message", "endpoint successfully turned on");
					result.put("endpoint", endpoint);
				}
			}
		}
		return result;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/turnoff/{id}")
	public Map<String,Object> turnMachineOff(@PathVariable Long id, Principal principal) {
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("message", "endpoint not found");
		if(endpointRepository.exists(id)) {
			Endpoint endpoint = endpointRepository.findOne(id);
			result.put("message", "invalid credentials");
			if(endpoint.getAccount().getUsername().equals(principal.getName())) {
				result.put("message", "endpoint is already off");
				if(endpoint.isOn()) {
					endpoint.turnOff();
					endpointRepository.save(endpoint);
					result.put("success", true);
					result.put("message", "endpoint successfully turned off");
					result.put("endpoint", endpoint);
				}
			}
		}
		return result;
	}
}
