package com.github.ooa.chudq.pattern_2;

public class Test {

	public static void main(String[] args) {
		Factory factory;
		Calculator cal;
		factory = new PlusFactory();
		cal = factory.createCalculator();
		cal.numbA=4;
		cal.numbB=6;
		System.out.println(cal.getResult());
		factory = new MinusFactory();
		cal = factory.createCalculator();
		cal.numbA=19;
		cal.numbB=4;
		System.out.println(cal.getResult());;
	}

}
