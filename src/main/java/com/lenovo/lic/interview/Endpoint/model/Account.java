package com.lenovo.lic.interview.Endpoint.model;

import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private long id;
	@Column(unique=true)
	private String username;
	private String password;
	
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Account() {
		this("", "");
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	public boolean equals(Account account) {
		return this.username == account.username && this.password == account.password;
	}
	
	public static boolean isValid(Account account) {
		return account.getUsername().length() > 0 && account.getPassword().length() > 0;
	}
}
