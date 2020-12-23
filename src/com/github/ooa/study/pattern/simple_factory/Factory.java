package com.github.ooa.study.pattern.simple_factory;

/**
 * @description
 * @author Covet
 */
public class Factory{

	public static Calculator createOperate(String operator) {
		if(operator.equals("+")) {
			return new Plus();
		}else if(operator.equals("-")) {
			return new Minus();
		}else {
			System.out.println("unknow:"+operator);
			return null;
		}
	}

}
