package com.github.ooa.chudq.pattern_3;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if(choice.equals("phone")) {
			return new PhoneFactory();
		}
		if(choice.equals("computer")) {
			return new ComputerFactory();
		}
		return null;
	}
}
