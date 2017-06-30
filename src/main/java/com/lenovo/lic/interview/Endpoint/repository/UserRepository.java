package com.lenovo.lic.interview.Endpoint.repository;

import org.springframework.data.repository.CrudRepository;

import com.lenovo.lic.interview.Endpoint.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
