package com.github.ooa.chudq.thread;

import java.util.concurrent.TimeUnit;

public class Demo1 {

	Object object = new Object();
	
	public void test() {
		synchronized(object){
			while(true) {
				System.out.println(Thread.currentThread().getName());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Demo1 demo = new Demo1();
		new Thread(demo::test,"t1").start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread t2 = new Thread(demo::test,"t2");
		demo.object = new Object();
		t2.start();
	}
}