package com.github.ooa.chudq.proxy;

public class RealSubject implements Subject {

	@Override
	public void test() {
		System.out.println("Real Test ...");

	}
	
	public void myself() {
		System.out.println("myself method Test ...");
	}

}
