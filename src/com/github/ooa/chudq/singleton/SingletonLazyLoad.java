package com.github.ooa.chudq.singleton;

/**
 * @description 登记式/静态内部类
 * @author Covet
 *
 */
public class SingletonLazyLoad {
	
	private SingletonLazyLoad(){
		 
	}
	
	public static class SingletonHolder{
		private static final SingletonLazyLoad instance = new SingletonLazyLoad();
	}
	
	public static SingletonLazyLoad getInstance(){
		return SingletonHolder.instance;
	}
	
	@Override
	public String toString(){
		return "使用静态内部类的方式实现单例模式";
	}
}
