package com.mystudy.pm05_interface;

public class Animal implements I_Animal {

	@Override
	public void eat() {
		System.out.println(">> �Դ´�");
	}

	@Override
	public void sleep() {
		System.out.println(">> �ܴ�");
	}

	@Override
	public void sound() {}
	
}
