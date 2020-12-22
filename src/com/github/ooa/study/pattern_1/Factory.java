package com.github.ooa.chudq.pattern_1;

/**
 * @description 简单工厂模式(静态工厂)
 * @author Covet
 */
public class Factory{

	public static Calculator createOperate(String operator) {
		if(operator.equals("+")) {
			return new Plus();
		}else if(operator.equals("-")) {
			return new Minus();
		}else {
			System.out.println("暂时不支持:"+operator+"运算");
			return null;
		}
	}

}
