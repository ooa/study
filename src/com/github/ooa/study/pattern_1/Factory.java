package com.github.ooa.chudq.pattern_1;

/**
 * @description �򵥹���ģʽ(��̬����)
 * @author Covet
 */
public class Factory{

	public static Calculator createOperate(String operator) {
		if(operator.equals("+")) {
			return new Plus();
		}else if(operator.equals("-")) {
			return new Minus();
		}else {
			System.out.println("��ʱ��֧��:"+operator+"����");
			return null;
		}
	}

}
