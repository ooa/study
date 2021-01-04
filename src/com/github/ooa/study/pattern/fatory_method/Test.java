package com.github.ooa.study.pattern.fatory_method;

public class Test {

	public static void main(String[] args) {
		Factory factory;
		factory = new DogFactory();
		Animal animal = factory.createAnimal();
		animal.eat();
		factory = new CatFactory();
		animal = factory.createAnimal();
		animal.eat();
	}

}
