package com.mystudy.pm02_sungjuk_vo;

public class StudentDTO {

	public static void main(String[] args) {
		StudentVO sv = new StudentVO("홍길동", 80, 90, 88);
		System.out.println(sv);
		System.out.println("------------------");
		System.out.println(sv);
		sv.printData();
		sv.setEng(100);
		System.out.println("--- 영어 점수 변경 ---");
		System.out.println(sv);
		sv.printData();
		
		System.out.println("--- 홍금보 성적 ---");
		StudentVO sv2 = new StudentVO("홍금보", 50, 10, 33);
		System.out.println(sv2);
		sv2.printData();
		
		System.out.println("--- 홍석천 성적 ---");
		StudentVO sv3 = new StudentVO("홍석천", 31, 28, 88);
		System.out.println(sv3);
		sv3.printData();
		sv3.setEng(100);
		sv3.printData();
		
		StudentVO[] stArr = new StudentVO[2];
		stArr[0] = new StudentVO("재수생", 80, 70, 95);
		stArr[1] = new StudentVO("삼수생", 70, 60, 85);
		
		stArr[0].printData();
		System.out.println(stArr[0]);
		
	}
}
