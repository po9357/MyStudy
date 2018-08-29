package com.mystudy.phone;

//접근제한자 : public, protected, (default), private
//클래스 : public, (default)
//생성자 : 클래스와 같은 범위의 제한자 사용
//필드, 메소드 : public, protected, (default), private
public class Phone {
	//필드선언(속성)
	String name;	//참조형 : null로 초기화
	String type;
	int hsize;	//int : 0 초기화 (초기값을 정해주지 않을시)
	int vsize;
	boolean hasLCD;
	
	Phone () {}				//기본 생성자
	public Phone(String n, String t) {
		name = n;
		type = t;
		hsize = 55;
		vsize = 115;
	}
	
	public Phone(String n, String t, boolean l) {
		this.name = n;			//this	-> 현재 객체가 가진 속성값 의미
		type = t;				//super	-> super class(객체)가 가진 속성값 의미
		hasLCD = l;
		hsize = 50;
		vsize = 87;
	}
	
	void call() {
		System.out.println(">>전화 걸기");
	}
	
	void receiveCall() {
		System.out.println(">>전화 받기");
	}
	
	void sendSms(String sm) {
		System.out.println("[메시지 전송] : " + sm);
	}
	
	public String receiveSms(String rm) {
		System.out.println("[메시지 수신] : "+rm);
		return rm;
	}
	
	public void view() {
		System.out.println("=== 기기 정보 ===");
		System.out.println("모델명 : " + name);
		System.out.println("타입 : " + type);
		System.out.println("가로 크기 : " + hsize +"mm");
		System.out.println("세로 크기 : " + vsize +"mm");
		System.out.println("LCD 유무 : " + hasLCD);
	}
	

}
