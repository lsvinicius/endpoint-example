package com.lenovo.lic.interview.Endpoint.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lenovo.lic.interview.Endpoint.model.Endpoint;
import com.lenovo.lic.interview.Endpoint.model.User;

public interface EndpointRepository extends CrudRepository<Endpoint, Long>{
	public List<Endpoint> findByUser(User user);
}
