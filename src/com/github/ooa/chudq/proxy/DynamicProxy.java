package com.github.ooa.chudq.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;


public class DynamicProxy implements InvocationHandler{

	Subject mSubject;
	
    public DynamicProxy(Subject mSubject){
    	this.mSubject = mSubject;
    }

    
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
        System.out.println("this is Dynamic proxy invode");
        if(mSubject != null){
            result = method.invoke(mSubject, args);
        }
        return result;
	}

	

}
