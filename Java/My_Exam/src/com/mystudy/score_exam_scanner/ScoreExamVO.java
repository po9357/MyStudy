package com.mystudy.score_exam_scanner;

import java.util.*;

public class ScoreExamVO {
	Scanner sc = new Scanner(System.in);
	String name;
	int kor;
	int eng;
	int math;
	int tot;
	double avg;
	
	public ScoreExamVO() {
		name = "ȫ�浿";
		kor = 0;
		eng = 0;
		math = 0;
	}
	
	public ScoreExamVO(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	public void printData(ArrayList list) {
		System.out.println(list.get(0)+ "\t"+list.get(1) + "\t"+list.get(2) + "\t"+list.get(3) + "\t"+ list.get(4)+ "\t"+list.get(5) );
	}
	
	
	public String setName() {
		sc = new Scanner(System.in);
		name = sc.nextLine();
		return name;
	}
	
	public int setKor() {
		kor = sc.nextInt();
		return kor;
	}
	public int setEng() {
		eng = sc.nextInt();
		return eng;
	}
	public int setMath() {
		math = sc.nextInt();
		return math;
	}
	
	public int tot() {
		return tot = kor + eng + math;
	}
	
	public double avg() {
		return avg = (tot*100) / 3 / 100.0;
	}
	
}