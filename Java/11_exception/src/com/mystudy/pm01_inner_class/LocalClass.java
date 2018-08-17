package com.mystudy.pm01_inner_class;

//지역클래스 (Local class) : 메소드 내 또는 초기화 블럭 내에 선언
public class LocalClass {
	int a = 100;
	
	
	void innerTest(int k) {
		int b = 200;		//지역변수 (local variable)
		final int c = k;
		
		//메소드 내에 있는 클래스(지역 클래스 (Local class))
		//선언된 메소드 내부에서만 사용 가능
		class Inner {
			void printData() {
				System.out.println("int a : "+ a);
				System.out.println("int b : "+ b);
				System.out.println("int c : "+ c);
			}
		}
		Inner in = new Inner();
		in.printData();
	}
	
	
	{//초기화 블럭 (static 붙일 수 있음 - static변수 초기화)
	}
	
	
	
	public static void main(String[] args) {
		LocalClass outer = new LocalClass();
		outer.innerTest(999);
		
	}
}
