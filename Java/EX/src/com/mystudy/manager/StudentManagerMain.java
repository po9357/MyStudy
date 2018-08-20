package com.mystudy.manager;

public class StudentManagerMain {

	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		//StudentManager 클래스의 메소드 이용 CRUD 테스트

		manager.printScore();
		
		ScoreProcess sp = new ScoreProcess();
		System.out.println("여기");
		manager.displayOne("1");
		sp.main();
	}

}
