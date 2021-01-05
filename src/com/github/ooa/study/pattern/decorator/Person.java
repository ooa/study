package com.github.ooa.study.pattern.decorator;

public class Person {
	private String name;

	public Person(){

	}
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person:{ name=" + name + "}";
	}

	public void show(){
		System.out.printf(" 装扮的:%S", name);
	}

}
