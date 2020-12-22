package com.github.ooa.chudq.pattern_4;

/**
 * @description 登记�?/静�?�内部类
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
		return "使用静�?�内部类的方式实现单例模�?";
	}
}
