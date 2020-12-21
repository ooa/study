package com.github.ooa.chudq.pattern_3;

public class PhoneFactory extends AbstractFactory{

	

	@Override
	Phone getPhone() {
		return new Huawei();
	}

	@Override
	Computer getComputer(String brank) {
		// TODO Auto-generated method stub
		return null;
	}

}
