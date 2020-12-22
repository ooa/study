package com.github.ooa.chudq.thread;

import java.util.concurrent.TimeUnit;

public class Demo2 {

	String name;
	double balance;
	
	public synchronized void set(String name, double balance) {
		this.name = name;
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.balance = balance;
	}
	
	public double getBance(String name) {
		return this.balance;
	}
	
	public static void main(String[] args) {
		Demo2 demo = new Demo2();
		new Thread(()->demo.set("A", 200.0)).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(demo.getBance("A"));
		new Thread(()->demo.set("A", 200.0)).start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(demo.getBance("A"));
	}
}