package com.lenovo.lic.interview.Endpoint.model;

import javax.persistence.Transient;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Endpoint {

	@Id
    @GeneratedValue
	private Long id;
    private String model;
    private String serialNumber;
    private String name;
    private String processor;
    private int memory; //GB
    private long hd; //GB
    private double celsiusDegrees;
    private Boolean turnedOn;
    @Column(nullable=false)
    private String user;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient 
    private boolean disabled;

    public Endpoint() {
        this.model = "";
        this.serialNumber = "";
        this.name = "";
        this.processor = "";
        this.memory = 0;
        this.hd = 0;
        this.celsiusDegrees = 0;
        this.turnedOn = false;
        this.user = "";
        this.disabled = true;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public long getHd() {
		return hd;
	}

	public void setHd(long hd) {
		this.hd = hd;
	}

	public double getCelsiusDegrees() {
		return celsiusDegrees;
	}

	public void setCelsiusDegrees(double celsiusDegrees) {
		this.celsiusDegrees = celsiusDegrees;
	}

	public Boolean isOn() {
		return turnedOn;
	}

	public void turnOn() {
		Random rand = new Random();
		this.celsiusDegrees = rand.nextInt(80) + 20;
		this.turnedOn = true;
	}
	
	public void turnOff() {
		this.celsiusDegrees = 0;
		this.turnedOn = false;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public void enable() {
		this.disabled = false;
	}
	
	public void disable() {
		this.disabled = false;
	}
	
	public boolean isDisabled() {
		return disabled;
	}

	public boolean equals(Endpoint endpoint) {
		return this.id == endpoint.id;
	}
	
	public static boolean isValid(Endpoint endpoint) {
		boolean valid = true;
		if(endpoint.getUser().isEmpty()) {
			valid = false;
		}
		else if(endpoint.getModel().isEmpty()) {
			valid = false;
		}
		else if(endpoint.getHd() == 0) {
			valid = false;
		}
		else if(endpoint.getMemory() == 0) {
			valid = false;
		}
		else if(endpoint.getName().isEmpty()) {
			valid = false;
		}
		else if(endpoint.getProcessor().isEmpty()) {
			valid = false;
		}
		else if(endpoint.getSerialNumber().isEmpty()) {
			valid = false;
		}
		return valid;
	}

}
