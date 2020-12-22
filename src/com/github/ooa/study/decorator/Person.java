package com.github.ooa.chudq.decorator;

public class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person:{ name=" + name + "}";
	}
	

}
