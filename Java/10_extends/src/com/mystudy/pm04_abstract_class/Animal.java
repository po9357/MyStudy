package com.mystudy.pm04_abstract_class;

//추상클래스 : abstract class
//구현메소드와 추상메소드를  함께 가지고 있는 클래스
//추상메소드가 있기 때문에 객체를 생성할 수 없음
public abstract class Animal {
	String name; //이름, 명칭
	int legCnt; //다리갯수
	
	//구현메소드
	void eat() {
		System.out.println(">> 먹는다");
	}
	void sleep() {
		System.out.println(">> 잠을 잔다");
	}
	
	abstract void sound(); //추상메소드
}
