package com.github.ooa.study.pattern.fatory_method;

public class CatFactory extends Factory{


    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
