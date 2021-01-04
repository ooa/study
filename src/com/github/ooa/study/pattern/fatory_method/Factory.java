package com.github.ooa.study.pattern.fatory_method;

/**
 * @description Factory Method Pattern
 * 抽象类是对整个类整体进行抽象，包括属性、行为，接口却是对类局部（行为）进行抽象。
 * 抽象类作为很多子类的父类，它是一种模板式设计。而接口是一种行为规范，它是一种辐射式设计。
 * @author Covet
 */
public abstract class Factory {
	public abstract Animal createAnimal();
}
