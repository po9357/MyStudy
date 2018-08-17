package com.mystudy.pm01_inner_class;

//����ƽ Ŭ���� : Ŭ���� ��������� ������ ������ static�� �ٿ� �ۼ�
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
//			System.out.println("private int b : "+ b);	//static���� non-static�� ����� �� ����
			System.out.println("int c : "+ c);			//��ü ���� �� ��� ����
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
