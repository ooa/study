package com.github.ooa.chudq.pattern_3;

public class Test {

	public static void main(String[] args) {
		AbstractFactory computerFactory = FactoryProducer.getFactory("computer");
		
		Computer computer = computerFactory.getComputer("samsung");
		computer.work();
		
		AbstractFactory phonefactory = FactoryProducer.getFactory("phone");
		Phone phone = phonefactory.getPhone();
		phone.call();
		
	}

}
