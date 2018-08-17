package com.mystudy.pm05_interface;

public class Cat implements I_Animal {

	@Override
	public void eat() {
		System.out.println(">> ¸Ô´Â´Ù");
	}

	@Override
	public void sleep() {
		System.out.println(">> ÀÜ´Ù");
	}

	@Override
	public void sound() {
		System.out.println(">> ³Ä¿À¿À¿Ë");
	}

}
