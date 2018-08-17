package com.mystudy;

public class Ex01_class {
	int num;	//필드(멤버변수, 인스턴스 변수), 속성(property, attribute)
	static int staticNum;	//클래스 변수, 스태틱(static) 변수, 인스턴스(instance) 공통 변수

//	public Ex01_class() {}		기본 생성자 (default 생성자. 생성자를 작성하지 않으면 기본으로 생성됨.)
	
	public static void main(String[] args) {
		int num1 = 200;
		int num2 = 100;
		int result = 0;
		result = num1 + num2;
		System.out.println("result: "+ result);
		System.out.println("------------------");
		
		//			num1, num2(인자 (argument))
		result = add(num1, num2);
		System.out.println("result: "+ result);
		System.out.println("------------------");
		
		/////////////////////////////////////////
		// 객체 생성(인스턴스 생성)
		// 클래스타입명 변수명;
		// 변수명 = new 클래스생성자();
		// 클래스타입명 변수명 = new 클래스생성자();
		Ex01_class ex01 = new Ex01_class();	//기본생성자로 객체생성
		ex01.num = 1000;
		result = ex01.add(num1, num2);
		
		//Cannot make a static reference to the non-static field num
//		num = 2000;
//		Cannot make a static reference to the non-static method sub(int, int) from the type Ex01_class
//		스태틱 메소드 안에서 non-static메소드를 사용할 수 없다.
//		result = sub(num1, num2);
		
		//static 메소드 안에서 non-static 메소드 사용
		//생성된 객체를 통해서만 접근 가능
		result = ex01.sub(num1,  num2);
		System.out.println("ex01.sub(num1, num2) : "+ result);
		System.out.println("ex01: " + ex01);
		
	}
	//메소드 형태
	//void 메소드명() {}
	//리턴타입 메소드명() {}
	//리턴타입 메소드명(파라미터타입 파라미터명, ...) {}
	
	//2개의 정수값을 전달 받아서 2개의 정수값을 더한 결과를 되돌려줌
	//			int(리턴타입) add(메소드 명) int a, int b('a', 'b' -> 파라미터(parameter), 매개변수)
	public static int add(int a, int b) {
		return a + b;
		
	}
	public int sub(int a, int b) {
		return a-b;
	}
}
