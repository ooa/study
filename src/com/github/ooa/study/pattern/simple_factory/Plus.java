package com.github.ooa.study.pattern.simple_factory;

public class Plus extends Calculator {
	
	@Override
	public int getResult() {
		return this.numbA+this.numbB;
	}
}
