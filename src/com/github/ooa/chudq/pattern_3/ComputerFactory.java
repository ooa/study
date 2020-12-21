package com.github.ooa.chudq.pattern_3;

public class ComputerFactory extends AbstractFactory{

	@Override
	Computer getComputer(String brank) {
		if(brank.equals("samsung")) {
			return new Samsung();
		}else if(brank.equals("ThinkPad")){
			return new ThinkPad();
		}else {
			return null;
		}
	}

	@Override
	Phone getPhone() {
		return null;
	}

}
