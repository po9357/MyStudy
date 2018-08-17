package com.mystudy.pm01_inner_class;

//스태틱 클래스 : 클래스 구성멤버와 동일한 레벨에 static을 붙여 작성
public class StaticClass {
	int a = 10;
	private int b = 100;
	static int c = 200;
	
	static class Inner {
		static int d = 1000;
		int e = 2000;
		StaticClass sc = new StaticClass();
		void printData() {
//			System.out.println("int a : "+ a);		
//			System.out.println("private int b : "+ b);	//static에서 non-static은 사용할 수 없다
			System.out.println("int c : "+ c);			//객체 생성 후 사용 가능
			System.out.println("int d : "+ d);
			System.out.println("int a : "+ sc.a);
			System.out.println("private int b : "+ sc.b);
			System.out.println("Inner int e : "+ e);
		}											
	}
	
	public static void main(String[] args) {
		int num = StaticClass.c;
		StaticClass.Inner inner = new StaticClass.Inner();
		inner.printData();
	}

}
