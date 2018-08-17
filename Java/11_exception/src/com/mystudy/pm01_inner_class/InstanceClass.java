package com.mystudy.pm01_inner_class;

//내부클래스 : 클래스 내에 선언된 클래스를 통칭
//인스턴스클래스 : 필드변수와 같은 레벨 위치에 선언
public class InstanceClass {
	int a = 100;
	private int b = 10;
	static int c = 200;
	int sum = 0;
	
	void sum() {
		sum = a + b;
	}
		
	
	class Inner {
		int in = 100;
		void printData() {
			System.out.println("int a : "+ a);
			System.out.println("private int b : "+ b);
			System.out.println("static int c : "+ c);
			System.out.println(sum);
			System.out.println("내부클래스 필드 in : "+ in);
		}
	}
	public static void main(String[] args) {
		//외부클래스에서 내부 클래스 사용
		InstanceClass out = new InstanceClass();
		
		//외부클래스명.내부클래스명 : 내부 클래스의 타입
		//new InstanceClass().new Inner() : 외부클래스 객체 생성 후 내부클래스 객체 생성
		InstanceClass.Inner inner = new InstanceClass().new Inner();
		inner.printData();
		System.out.println("----------------------------");
		System.out.println("Inner 클래스의 필드변수 in : "+ inner.in);
		
	}
}
