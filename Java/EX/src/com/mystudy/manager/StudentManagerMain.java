package com.mystudy.manager;

public class StudentManagerMain {

	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		//StudentManager 클래스의 메소드 이용 CRUD 테스트
		StudentVO vo = new StudentVO("1", "홍길동", 90, 80, 70);
		manager.printSungjuk();
		System.out.println(vo.toString());
		manager.insert1(vo);
		manager.printSungjuk();

	}

}
