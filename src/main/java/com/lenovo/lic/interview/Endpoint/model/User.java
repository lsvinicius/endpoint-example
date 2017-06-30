package com.lenovo.lic.interview.Endpoint.model;

import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	@Column(unique=true)
	private String username;
	private String password;
	private Vector<Endpoint> endpoints;
	
	public User(String username, String password, Vector<Endpoint> endpoints) {
		this.username = username;
		this.password = password;
		this.endpoints = endpoints;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.endpoints = new Vector<Endpoint>();
	}
	
	public User() {
		this("", "");
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<Endpoint> getEndpoints() {
		return endpoints;
	}
	
	public void addMachine(Endpoint machine) {
		endpoints.add(machine);
	}
	
	public boolean equals(User user) {
		return this.username == user.username && this.password == user.password;
	}
}
