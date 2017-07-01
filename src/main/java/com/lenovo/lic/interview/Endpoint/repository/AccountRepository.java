package com.lenovo.lic.interview.Endpoint.repository;

import org.springframework.data.repository.CrudRepository;

import com.lenovo.lic.interview.Endpoint.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
	public Account findByUsername(String username);
}
