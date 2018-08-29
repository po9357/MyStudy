package com.mystudy.bean;

public class StudentMain {

	public static void main(String[] args) {
		//자바빈 사용하기
		Student stu = new Student("홍길동", 100, 90, 80);
		System.out.println(stu);
		System.out.println(stu.getName());
		
		//총점 구하고 저장
		int tot = stu.getKor() + stu.getEng() + stu.getMath();
		//stu.setTot(stu.getKor() + stu.getEng() + stu.getMath());
//		stu.setTot(tot);
		System.out.println(stu);
		
		//평균 값 구하고 저장
		double avg = (tot * 100) / 3 / 100.0;
//		stu.setAvg(avg);
		System.out.println(stu);
		
		//수학점수 80 -> 81 변경
		stu.setMath(81);
		System.out.println("수학 80->81 변경후: " + stu);
		
		//총점, 평균 재계산
//		stu.setTot(stu.getKor() + stu.getEng() + stu.getMath());
//		stu.setAvg((stu.getTot() * 100) / 3 / 100.0);
		
//		stu.setTot(300);
//		stu.setAvg(100);
		System.out.println("총점, 평균 재계산후: " + stu);
		
		Student stu2 = new Student("이순신", 100, 90, 81);
		stu2.setMath(89);
		System.out.println(stu2);
		
		
		System.out.println("-----------------------------------");
		System.out.println(stu2);
		Student st = new Student();
		System.out.println(st);
	}
	

}
