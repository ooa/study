package com.github.ooa.chudq.pattern_1;

public class Test {

	public static void main(String[] args) {
		Calculator cal = Factory.createOperate("+");
		cal.numbA=4;
		cal.numbB=6;
		System.out.println(cal.getResult());
		Calculator minus = Factory.createOperate("-");
		minus.numbA=19;
		minus.numbB=4;
		System.out.println(minus.getResult());;
	}

}
