package com.mystudy.pm04_abstract_class;

public class Cat extends Animal {
	//상속관계에 있는 클래스에서
	//부모타입에 있는 메소드를 자식타입의 클래스에서 재정의
	//선언은 동일하고 기능만 다르게 구현
	//선언은 동일 : 리턴타입, 메소드명, 파라미터가 동일(파라미터 순서,갯수,타입일치)
	//메소드 오버라이딩(Overriding)
	@Override
	void sound() {
		System.out.println(">> 야옹 야옹");
	}
}
