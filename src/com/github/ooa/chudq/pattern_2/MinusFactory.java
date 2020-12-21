package com.github.ooa.chudq.pattern_2;

public class MinusFactory extends Factory{

	@Override
	public Calculator createCalculator() {
		return new Minus();
	}

}
