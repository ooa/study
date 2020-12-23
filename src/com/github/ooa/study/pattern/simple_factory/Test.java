package com.github.ooa.study.pattern.simple_factory;

public class Test {

	public static void main(String[] args) {
		Calculator cal = Factory.createOperate("+");
		cal.numbA=4;
		cal.numbB=6;
		System.out.println(cal.getResult());
		cal = Factory.createOperate("-");
		cal.numbA=19;
		cal.numbB=4;
		System.out.println(cal.getResult());;
	}

}
