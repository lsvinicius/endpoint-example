package com.lenovo.lic.interview.Endpoint.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    @ManyToOne
    private User user;

    public Endpoint() {
        this.model = "";
        this.serialNumber = "";
        this.name = "";
        this.processor = "";
        this.memory = 0;
        this.hd = 0;
        this.celsiusDegrees = 0;
        this.turnedOn = false;
        this.user = new User();
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
		this.turnedOn = true;
	}
	
	public void turnOff() {
		this.turnedOn = false;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User owner) {
		this.user = owner;
	}
	
	public boolean equals(Endpoint endpoint) {
		return this.id == endpoint.id;
	}

}
