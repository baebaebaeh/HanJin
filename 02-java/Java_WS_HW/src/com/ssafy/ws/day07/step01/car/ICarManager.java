package com.ssafy.ws.day07.step01.car;

public interface ICarManager {
	boolean add (Car car); // 인터페이스는 중괄호를 하지 않는다
	Car[] getList();
	Car[] searchByModelName(String modelName);
	ElectricCar[] getElectricCars();
	int getTotalMileage();
}
