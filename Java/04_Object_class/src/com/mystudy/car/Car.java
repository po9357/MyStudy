package com.mystudy.car;

public class Car {
	//필드변수(속성)
	String name = "마이카"; //차량명
	String model;	//모델명
	String color;	//차량색

	//final 제한자 : 변수에 값이 할당되면 더 이상 변경 할 수 없음
	//상수화된 변수 명명규칙 : 전체 대문자로 작성, 의미가 달라지면 '_' 사용
	final int CAR_LENGTH = 350;	//차량길이
	final int CAR_WIDTH = 200;	//차량폭(너비)
	
	boolean existAirbag;	//에어백 존재 여부
	
	//생성자 : 리턴타입 없음
	//클래스명() {}	- 기본생성자(default constructor)
	//클래스명(매개변수, ...) {}
	
	Car () {
		name = "마이카";
		model = "드럼카";
		color = "무지개색";
	}
	
	Car (String n, String m, String c) {
		name = n;
		model = m;
		color = c;
		existAirbag = true;	//에어백 있음
	}
	
	//메소드(기능, 함수)
	void run() {
		System.out.println(">> 앞으로 이동");
	}
	
	void stop() {
		System.out.println(">> 멈춤");
	}
	
	void back() {
		System.out.println(">> 뒤로 이동");
	}

//	@Override
//	public String toString() {
//		return "Car [name=" + name + ", model=" + model + ", color=" + color + ", CAR_LENGTH=" + CAR_LENGTH
//				+ ", CAR_WIDTH=" + CAR_WIDTH + ", existAirbag=" + existAirbag + "]";
		
		public void dispData() {
			System.out.println("=== 자동차 정보 ===");
			System.out.println("자동차 이름: "+ name);
			System.out.println("모델명: "+ model);
			System.out.println("색상: "+ color);
			System.out.println("차량길이: "+ CAR_LENGTH);
			System.out.println("차량너비: "+ CAR_WIDTH);
			System.out.println("에어백: " + existAirbag);
			System.out.println("===============");
	}
	
}
