package com.github.ooa.chudq.pattern_1;

public class Minus  extends Calculator {
	
	public void setNumbB(int numbB) {
		this.numbB = numbB;
	}
	
	@Override
	int getResult() {
		return this.numbA-this.numbB;
	}
}
