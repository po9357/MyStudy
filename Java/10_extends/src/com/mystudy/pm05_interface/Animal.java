package com.mystudy.pm05_interface;

public class Animal implements I_Animal {

	@Override
	public void eat() {
		System.out.println(">> 먹는다");
	}

	@Override
	public void sleep() {
		System.out.println(">> 잔다");
	}

	@Override
	public void sound() {}
	
}
