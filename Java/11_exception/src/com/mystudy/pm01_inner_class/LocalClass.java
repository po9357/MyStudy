package com.mystudy.pm01_inner_class;

//����Ŭ���� (Local class) : �޼ҵ� �� �Ǵ� �ʱ�ȭ �� ���� ����
public class LocalClass {
	int a = 100;
	
	
	void innerTest(int k) {
		int b = 200;		//�������� (local variable)
		final int c = k;
		
		//�޼ҵ� ���� �ִ� Ŭ����(���� Ŭ���� (Local class))
		//����� �޼ҵ� ���ο����� ��� ����
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
	
	
	{//�ʱ�ȭ �� (static ���� �� ���� - static���� �ʱ�ȭ)
	}
	
	
	
	public static void main(String[] args) {
		LocalClass outer = new LocalClass();
		outer.innerTest(999);
		
	}
}
