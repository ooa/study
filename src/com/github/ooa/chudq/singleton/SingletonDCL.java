package com.github.ooa.chudq.singleton;

/**
 * double-checked locking
 * @author Covet
 *
 */
public class SingletonDCL {
	
	private volatile static SingletonDCL instance;
	
	private SingletonDCL(){
		
	}
	
	public static SingletonDCL getInstance(){
		if(instance==null){
			synchronized (SingletonDCL.class) {
				if(instance==null){
					instance = new SingletonDCL();
				}
			}
		}
		return instance;
	}
	
	@Override
	public String toString(){
		return "双检锁/双重校验锁，单例模式\n"+
				"优点：采用双锁机制，安全且在多线程情况下能保持高性能";
	}
}
