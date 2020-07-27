package com.github.ooa.chudq.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IcoContainer {
	Map<String,Object> beans = new ConcurrentHashMap<String,Object>();
	
	public Object getBean(String beanId){
		return beans.get(beanId);
	}
	
	public void setBean(Class<?> clazz, String beanId,String... parentParams ){
			//���캯���Ĳ���
			Object[] beanParam = new Object[parentParams.length];
			for(int i=0;i<parentParams.length;i++){
				beanParam[i] = beans.get(parentParams[i]);
			}
			//�õ�һϵ�й��캯������
			//Constructor<?>[] constructors = clazz.getConstructors();
	        Object bean = null;
			try {
	        	for(Constructor<?> constructor : clazz.getConstructors()){
	        		bean = constructor.newInstance(beanParam);
	        	}
			} catch (InstantiationException e) {
			} catch (IllegalAccessException e) {
			} catch (IllegalArgumentException e) {
			} catch (InvocationTargetException e) {
			}
			if(bean == null){
				throw new RuntimeException("�Ҳ������ʵĹ��캯����ʼ��bean");
			}
			beans.put(beanId, bean);
		
	}
}
