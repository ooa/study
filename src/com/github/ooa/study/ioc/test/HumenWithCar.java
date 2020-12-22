package com.github.ooa.chudq.ioc.test;

public class HumenWithCar {
	Car car;
	public HumenWithCar(Car car){
		this.car = car;
	}
	
	public void goHome(){
		car.start();
		car.turnLeft();
		car.stop();
	}
}
