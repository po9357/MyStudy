package com.mystudy.manager;

public class StudentManagerMain {

	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		//StudentManager Ŭ������ �޼ҵ� �̿� CRUD �׽�Ʈ

		manager.printScore();
		
		ScoreProcess sp = new ScoreProcess();
		System.out.println("����");
		manager.displayOne("1");
		sp.main();
	}

}
