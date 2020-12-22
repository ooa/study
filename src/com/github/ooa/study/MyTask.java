package com.github.ooa.chudq;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<3;i++){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" is running ---"+i);
		}
		
	}

}
