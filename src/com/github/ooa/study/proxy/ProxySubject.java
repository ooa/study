package com.github.ooa.chudq.proxy;

/**
 * ��̬�����ʵ��
 * 
 * @author Covet
 *
 */
public class ProxySubject implements Subject {

	Subject mSubject;

	public ProxySubject(Subject pSubject) {
		mSubject = pSubject;
	}

	@Override
	public void test() {
		if (mSubject != null) {
			mSubject.test();
		}
	}
}
