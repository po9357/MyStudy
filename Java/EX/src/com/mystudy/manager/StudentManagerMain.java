package com.mystudy.manager;

public class StudentManagerMain {

	public static void main(String[] args) {
		StudentManager manager = new StudentManager();
		//StudentManager Ŭ������ �޼ҵ� �̿� CRUD �׽�Ʈ
		StudentVO vo = new StudentVO("1", "ȫ�浿", 90, 80, 70);
		manager.printSungjuk();
		System.out.println(vo.toString());
		manager.insert1(vo);
		manager.printSungjuk();

	}

}
