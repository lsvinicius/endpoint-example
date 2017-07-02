package com.lenovo.lic.interview.Endpoint.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lenovo.lic.interview.Endpoint.model.Account;
import com.lenovo.lic.interview.Endpoint.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(method = {RequestMethod.POST}, value="/register")
	public Map<String, Object> register(@RequestBody Account account) {
		account.setUsername(account.getUsername().trim());
		account.setPassword(account.getPassword().trim());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("message", "invalid account. check password and username");
		if(!Account.isValid(account)) {
			return result;
		}
		result.put("message", "username already taken");
		if(accountRepository.findByUsername(account.getUsername()) == null) {
			account.setPassword(passwordEncoder.encode(account.getPassword()));
			accountRepository.save(account);
			result.put("success", true);
			result.put("message", "account registered successfully");
			result.put("user", account.getUsername());
		}
		return result;
	}
	
	@RequestMapping(method = {RequestMethod.GET}, value="/validate")
	public Map<String, Object> validate(Principal principal) { 
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("message", "valid user");
		result.put("user", accountRepository.findByUsername(principal.getName()));
		return result;
	}
}