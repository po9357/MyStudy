package com.mystudy.score_exam_scanner;

import java.util.*;

public class ScoreExamTest {

	public static void main(String[] args) {
		ScoreExamVO sev = new ScoreExamVO();
		
		ArrayList stu1 = new ArrayList();
		ArrayList stu2 = new ArrayList();
		ArrayList stu3 = new ArrayList();
		ArrayList stu4 = new ArrayList();
		ArrayList stu5 = new ArrayList();
		
		ArrayList[] stu = new ArrayList[5];
		stu[0] = stu1;
		stu[1] = stu2;
		stu[2] = stu3;
		stu[3] = stu4;
		stu[4] = stu5;
		
		for (int i = 0; i < stu.length; i++) {
			System.out.println("�̸��� �Է��� �ֽʽÿ�.");
			stu[i].add(sev.setName());
			System.out.println("���� ������ �Է��� �ֽʽÿ�.");
			stu[i].add(sev.setKor());
			System.out.println("���� ������ �Է��� �ֽʽÿ�.");
			stu[i].add(sev.setEng());
			System.out.println("���� ������ �Է��� �ֽʽÿ�.");
			stu[i].add(sev.setMath());
			stu[i].add(sev.tot());
			stu[i].add(sev.avg());
		}
		
		
		System.out.println("===========================================");
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		sev.printData(stu1);
		sev.printData(stu2);
		sev.printData(stu3);
		sev.printData(stu4);
		sev.printData(stu5);
		System.out.println("===========================================");
	}
}
