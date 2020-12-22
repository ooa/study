package com.github.ooa.chudq.proxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Proxy;

public class TestProxy {
	
	@Test
	public void testProxy() {
		RealSubject realSubject = new RealSubject();
//		ProxySubject ps = new ProxySubject(realSubject);
//		ps.test();
//		ps = new ProxySubject(new AbcSubject());
//		ps.test();
		Subject  subject = (Subject)Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), new DynamicProxy(realSubject)); 
		subject.test();
		
	}
	
	
}
