package com.mystudy.pm02_sungjuk_vo;

public class StudentDTO {

	public static void main(String[] args) {
		StudentVO sv = new StudentVO("È«±æµ¿", 80, 90, 88);
		System.out.println(sv);
		System.out.println("------------------");
		System.out.println(sv);
		sv.printData();
		sv.setEng(100);
		System.out.println("--- ¿µ¾î Á¡¼ö º¯°æ ---");
		System.out.println(sv);
		sv.printData();
		
		System.out.println("--- È«±Ýº¸ ¼ºÀû ---");
		StudentVO sv2 = new StudentVO("È«±Ýº¸", 50, 10, 33);
		System.out.println(sv2);
		sv2.printData();
		
		System.out.println("--- È«¼®Ãµ ¼ºÀû ---");
		StudentVO sv3 = new StudentVO("È«¼®Ãµ", 31, 28, 88);
		System.out.println(sv3);
		sv3.printData();
		sv3.setEng(100);
		sv3.printData();
		
		StudentVO[] stArr = new StudentVO[2];
		stArr[0] = new StudentVO("Àç¼ö»ý", 80, 70, 95);
		stArr[1] = new StudentVO("»ï¼ö»ý", 70, 60, 85);
		
		stArr[0].printData();
		System.out.println(stArr[0]);
		
	}
}
