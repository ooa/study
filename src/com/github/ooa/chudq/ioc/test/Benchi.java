package com.github.ooa.chudq.ioc.test;

public class Benchi implements Car{

	@Override
	public void start() {
		System.out.println("benchi start");
		
	}

	@Override
	public void turnLeft() {
		System.out.println("benchi turn left");
		
	}

	@Override
	public void turnRight() {
		System.out.println("benchi turn right");
		
	}

	@Override
	public void stop() {
		System.out.println("benchi turn stop");
		
	}

}
