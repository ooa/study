package com.github.ooa.study.pattern.builder.entity;

/**
 * @ClassName: Person
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月18日 16:03
 */
public class Person {
    /**
     * 必填
     */
    private String name;
    /**
     * 必填
     */
    private int sex;
    /**
     * 非必填
     */
    private String car;

    public Person(PersonBuilder builder){
        this.name = builder.name;
        this.sex = builder.sex;
        this.car = builder.car;
    }

    public static class PersonBuilder{
        private String name;
        private int sex;

        private String car;

        public PersonBuilder(String name, int sex){
            this.name = name;
            this.sex = sex;
        }

        public void setCar(String car) {
            this.car = car;
        }

        public Person build(){
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", car='" + car + '\'' +
                '}';
    }
}
