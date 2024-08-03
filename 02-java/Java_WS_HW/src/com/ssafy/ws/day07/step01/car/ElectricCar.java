package com.ssafy.ws.day07.step01.car;

public class ElectricCar extends Car {
	private int battery;
	
	
	// 인자를 받는 생성자
	public ElectricCar(String VIN, String modelName, String color, int mileage, int battery) {
		super(VIN, modelName, color, mileage);
//		setVIN(VIN);
//		setModelName(modelName);
//		setColor(color);
//		setMileage(mileage);
//		this.VIN = VIN;
//		this.modelName = modelName;
//		this.color = color;
//		this.mileage = mileage;
		this.battery = battery;
	}
	
	public int getBattery() {
		return battery;
	}
	
	public void setBattery(int battery) {
		this.battery = battery;
	}

	@Override
	public String toString() {
		return super.toString() + ", ElectricCar [battery=" + battery + "]";
	}
}










