package com.mystudy.pm02_sungjuk_vo;

public class StudentDTO {

	public static void main(String[] args) {
		StudentVO sv = new StudentVO("ȫ�浿", 80, 90, 88);
		System.out.println(sv);
		System.out.println("------------------");
		System.out.println(sv);
		sv.printData();
		sv.setEng(100);
		System.out.println("--- ���� ���� ���� ---");
		System.out.println(sv);
		sv.printData();
		
		System.out.println("--- ȫ�ݺ� ���� ---");
		StudentVO sv2 = new StudentVO("ȫ�ݺ�", 50, 10, 33);
		System.out.println(sv2);
		sv2.printData();
		
		System.out.println("--- ȫ��õ ���� ---");
		StudentVO sv3 = new StudentVO("ȫ��õ", 31, 28, 88);
		System.out.println(sv3);
		sv3.printData();
		sv3.setEng(100);
		sv3.printData();
		
		StudentVO[] stArr = new StudentVO[2];
		stArr[0] = new StudentVO("�����", 80, 70, 95);
		stArr[1] = new StudentVO("�����", 70, 60, 85);
		
		stArr[0].printData();
		System.out.println(stArr[0]);
		
	}
}
