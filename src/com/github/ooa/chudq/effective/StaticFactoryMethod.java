package com.github.ooa.chudq.effective;

/**
 * 静态工厂方法代替构造方法
 * @author Covet
 *
 */
public class StaticFactoryMethod {
	private SEX sex;
    private String name;
    private int age;
    
    private static StaticFactoryMethod one = new StaticFactoryMethod();
    
    private StaticFactoryMethod(String name, int age, SEX sex){
        this.sex = sex;
        this.name = name;
        this.age = age;
    }

    public StaticFactoryMethod() {
    	 this.sex = SEX.man;
         this.name = "unknow";
         this.age = 0;
	}
    
    public static StaticFactoryMethod getDefaultInstance(){
    	return one;
    }

	public static StaticFactoryMethod getManInstance(String name, int age){
        return new StaticFactoryMethod(name, age, SEX.man);
    }
    
    public static StaticFactoryMethod getWomanInstance(String name, int age){
        return new StaticFactoryMethod(name, age, SEX.woman);
    }

	public static void main(String[] args) {
		StaticFactoryMethod a = StaticFactoryMethod.getDefaultInstance();
		System.out.println(a.name);
		StaticFactoryMethod b = StaticFactoryMethod.getDefaultInstance();
		b.name = "2B";
		System.out.println(a.equals(b));
		System.out.println(a.name);
	}
}

enum SEX{
    man,
    woman;
}
