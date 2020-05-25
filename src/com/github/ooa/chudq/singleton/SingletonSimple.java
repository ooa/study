package com.github.ooa.chudq.singleton;

public class SingletonSimple {
	
	private static final SingletonSimple instance = new SingletonSimple();
	
	private SingletonSimple(){
		
	}
	
	public static SingletonSimple getInstance(){
		return instance;
	}
	
	@Override
	public String toString(){
		return "饿汉式，单例模式\n"+
				"优点：没有加锁，执行效率会提高。\n"+
				"缺点：类加载时就初始化，浪费内存。";
	}
}
