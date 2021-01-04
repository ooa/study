package com.github.ooa.study.pattern.fatory_method;

public class DogFactory extends Factory{

	@Override
	public Animal createAnimal() {
		return new Dog();
	}
}
