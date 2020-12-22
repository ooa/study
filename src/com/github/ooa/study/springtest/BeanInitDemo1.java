package com.github.ooa.chudq.springtest;

public class BeanInitDemo1 {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void init() {
		this.setMessage("这里是init()方法初始化设值");
	}
}
