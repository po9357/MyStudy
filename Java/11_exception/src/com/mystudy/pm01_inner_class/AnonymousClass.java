package com.mystudy.pm01_inner_class;

interface TestInter {
	int DATA = 100;
	void printData();
}

class TestInterImp implements TestInter{
	@Override
	public void printData() {
		
	}
	
	public static void main(String[] args) {
		TestInterImp imp = new TestInterImp();
	}
}

//익명클래스 : 클래스의 이름이 없는 클래스
//한 번만 사용하는 용도로 만들어 사용하는 클래스
public class AnonymousClass {

	void test() {
		(new TestInter() {
			@Override
			public void printData() {
				System.out.println("DATA : "+ DATA);
			}
		}).printData();
	}
	
	public static void main(String[] args) {
		AnonymousClass an = new AnonymousClass();
		an.test();
		
	}

	
}
