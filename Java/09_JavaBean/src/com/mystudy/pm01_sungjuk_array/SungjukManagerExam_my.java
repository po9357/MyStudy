package com.mystudy.pm01_sungjuk_array;

public class SungjukManagerExam_my {

	public static void main(String[] args) {
		//2차원 배열을 사용한 성적 처리
		//실습문제. 
		//  국어, 영어, 수학 점수 3개를 저장한 2차원 배열(sungjuk) 만들고
		//  성적을 입력하고 개인별 총점과 평균을 계산 하여 화면에 데이터 출력
		/*
			국어	 영어	  수학	  총점	       평균
			-------------------------------------
			100  90  80  270   90.0
			100  90  81  271   90.33
			100  90  83  273   91.0
			-------------------------------------
		*/
		
		int[][] score = {
							{100, 90, 80},
							{100, 90, 81},
							{100, 90, 83}
						};
		
		int tot1 = 0;
		for (int i=0; i<score[0].length; i++) {
			tot1 += score[0][i];
		}
		System.out.println(tot1);
		
		int tot2 = 0;
		for (int i=0; i<score[1].length; i++) {
			tot2 += score[1][i];
		}
		System.out.println(tot2);
		
		int tot3 = 0;
		for (int i=0; i<score[2].length; i++) {
			tot3 += score[2][i];
		}
		System.out.println(tot3);
		

		System.out.println(tot1);
//		for (int i=0; i<score.length; i++) {
//			for (int j=0; j<score[0].length; j++) {
//				if (i == 0) {
//				tot1 += score[i][j];
//				} else if(i == 1) {
//				tot2 += score[1][j];
//				} else if(i == 2) {
//				tot3 += score[2][j];
//				}
//			}
//		}
		System.out.println(tot1);
		System.out.println(tot2);
		System.out.println(tot3);
		
		double avg1 = (tot1 * 100) / 3 / 100.0;
		double avg2 = (tot2 * 100) / 3 / 100.0;
		double avg3 = (tot3 * 100) / 3 / 100.0;
		
		System.out.println(avg1);
		System.out.println(avg2);
		System.out.println(avg3);
		System.out.println("--- 과목 별 총점 및 평균 ---");
		int korTot = 0;
		for (int i=0; i<score.length; i++) {
			korTot += score[i][0];
		}
		System.out.println("국어 총점 : "+korTot);
		int engTot = 0;
		for (int i=0; i<score.length; i++) {
			engTot += score[i][1];
		}
		System.out.println("영어 총점 : "+engTot);
		int mathTot = 0;
		for (int i=0; i<score.length; i++) {
			mathTot += score[i][2];
		}
		System.out.println("수학 총점 : "+mathTot);
		
		double korAvg = (korTot * 100) / 3 / 100.0;
		double engAvg = (engTot * 100) / 3 / 100.0;
		double mathAvg = (mathTot * 100) / 3 / 100.0;
		
		System.out.println("국어 평균 : "+ korAvg);
		System.out.println("영어 평균 : "+ engAvg);
		System.out.println("수학 평균 : "+ mathAvg);
		
	}
}
