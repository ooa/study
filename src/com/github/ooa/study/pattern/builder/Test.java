package com.github.ooa.study.pattern.builder;

import com.github.ooa.study.pattern.builder.entity.Person;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: XiaoMing
 * @Date: 2021年01月18日 16:10
 */
public class Test {

    public static void main(String[] args) {
        Person.PersonBuilder personBuilder = new Person.PersonBuilder("Covet", 23);
        personBuilder.setCar("Ben");
        Person person = personBuilder.build();
        System.out.println(person.toString());
    }
}
