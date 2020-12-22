package com.github.ooa.chudq.proxy;

/**
 * 静态代理的实现
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
