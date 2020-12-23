package com.github.ooa.study.pattern.simple_factory;

public class Minus  extends Calculator {
	
	@Override
	int getResult() {
		return this.numbA-this.numbB;
	}
}
