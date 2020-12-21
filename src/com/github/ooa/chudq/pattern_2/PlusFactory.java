package com.github.ooa.chudq.pattern_2;

public class PlusFactory extends Factory{

	@Override
	public Calculator createCalculator() {
		return new Plus();
	}


}
