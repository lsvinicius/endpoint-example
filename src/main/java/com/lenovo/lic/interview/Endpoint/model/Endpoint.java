package com.lenovo.lic.interview.Endpoint.model;

public class Endpoint {

	private final long id;
    private final String model;
    private final String serialNumber;
    private final String name;
    private final String processor;
    private final String memory;
    private final String hd;
    private final String temperature;
    private final String powerStatus;

    public Endpoint(long id) {
        this.id = id;
        this.model = "Lenovo ThinkServer";
        this.serialNumber = "ABC123";
        this.name = "Machine 1";
        this.processor = "Intel i7 5th gen";
        this.memory = "16Gb";
        this.hd = "1 Tb";
        this.temperature = "38ºC";
        this.powerStatus = "On";
    }

    public long getId() {
        return id;
    }

	public String getModel() {
		return model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getName() {
		return name;
	}

	public String getProcessor() {
		return processor;
	}

	public String getMemory() {
		return memory;
	}

	public String getHd() {
		return hd;
	}

	public String getTemperature() {
		return temperature;
	}

	public String getPowerStatus() {
		return powerStatus;
	}

}
