package ru.cetelem.supplier.domain;

public class Car {
	private int id;
	private String vin;
	private String model;
	
	
	public Car(int id, String vin, String model) {
		
		super();
		
		this.id = id;
		this.vin = vin;
		this.model = model;
	}
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
