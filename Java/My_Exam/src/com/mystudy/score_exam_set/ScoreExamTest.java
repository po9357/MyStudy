package com.mystudy.score_exam_set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScoreExamTest {

	public static void main(String[] args) {
		ScoreExamVO svo = new ScoreExamVO();
		ScoreExamVO svo1 = new ScoreExamVO("홍길동", 90, 80, 70);
		ScoreExamVO svo2 = new ScoreExamVO("홍길동2", 50, 70, 20);
		ScoreExamVO svo3 = new ScoreExamVO("홍길동3", 60, 70, 20);
		ScoreExamVO svo4 = new ScoreExamVO("홍길동4", 70, 40, 80);
		ScoreExamVO svo5 = new ScoreExamVO("홍길동5", 80, 60, 90);
		System.out.println(svo1);
		
//		List list = new ArrayList();
//		list.add(svo1);
//		list.add(svo2);
//		list.add(svo3);
//		list.add(svo4);
//		list.add(svo5);
//		
//		Set set = new HashSet(list);
		ArrayList stu1 = new ArrayList();
		ArrayList stu2 = new ArrayList();
		ArrayList stu3 = new ArrayList();
		ArrayList stu4 = new ArrayList();
		ArrayList stu5 = new ArrayList();
		
		svo1.addList(svo1, stu1);
		svo2.addList(svo2, stu2);
		svo3.addList(svo3, stu3);
		svo4.addList(svo4, stu4);
		svo5.addList(svo5, stu5);
		
		System.out.println("=============================================");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		svo1.printData(stu1);
		svo2.printData(stu2);
		svo3.printData(stu3);
		svo4.printData(stu4);
		svo5.printData(stu5);
		System.out.println("=============================================");
		
		System.out.println("--- List -> Set ---");
		Set[] setStu = new HashSet[5];
		setStu[0] = new HashSet(stu1);
		setStu[1] = new HashSet(stu2);
		setStu[2] = new HashSet(stu3);
		setStu[3] = new HashSet(stu4);
		setStu[4] = new HashSet(stu5);
		for (int i=0; i<setStu.length; i++) {
			System.out.println(setStu[i]);
		}
		System.out.println();
		
		
		System.out.println("--- List를 List[]에 추가 ---");
		ArrayList[] stuList = new ArrayList[5];
		stuList[0] = stu1;
		stuList[1] = stu2;
		stuList[2] = stu3;
		stuList[3] = stu4;
		stuList[4] = stu5;
		svo.addTotAvg(stuList);						//총점과 평균 list에 추가
		for (int i=0; i<setStu.length; i++) {		//출력
			System.out.println(stuList[i]);
		}
		System.out.println();
		
		System.out.println("--- 이름으로 학생 찾기 ---");
		System.out.println("홍길동 이름을 가진 학생의 성적 : ");
		svo.findName("홍길동", stuList);
		System.out.println();
		System.out.println("--- 평균 점수로 학생 찾기 ---");
		System.out.println("평균 65점 이상을 받은 학생의 점수 : ");
		svo.findAvg(65, stuList);
	}
}
