﻿package com.mystudy.pm03_overriding;

public class Animal {
	String name; //이름, 명칭
	int legCnt; //다리갯수
	
	void eat() {
		System.out.println(">> 먹는다");
	}
	void sleep() {
		System.out.println(">> 잠을 잔다");
	}
	
	void sound() {
		System.out.println(">> 울음없음");
	}
}
