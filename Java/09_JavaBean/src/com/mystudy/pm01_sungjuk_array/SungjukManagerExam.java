package com.mystudy.pm01_sungjuk_array;

public class SungjukManagerExam {
	static final String TITLE = "국어\t영어\t수학\t추가과목\t총점\t평균";
	static final String LINE = "--------------------------------"
			+ "---------------";

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
			100  90  80  270   90.0
			-------------------------------------
			300
			100
		*/
		
		
		//                 국어  영어 수학
		int[][] sungjuk = {{88,90,80, 90},
				          {100,90,81, 88},
				          {100,90,83, 77}};
		int kor = 0;
		int eng = 0;
		int math = 0;
		int tot = 0;
		double avg = 0;
		
//		System.out.println(kor);
//		System.out.println(sungjuk[0][0]);
		kor = sungjuk[0][0];
		eng = sungjuk[0][1];
		math = sungjuk[0][2];

		tot = kor + eng + math;
		avg = (tot * 100) / 3 / 100.0;
		System.out.println(kor +"\t"+ eng +"\t"+ math + "\t"+ tot +"\t" + avg);
		
		tot = sungjuk[0][0] + sungjuk[0][1] + sungjuk[0][2];
		avg = (tot * 100) / 3 / 100.0;
		System.out.println(sungjuk[0][0] +"\t"+ sungjuk[0][1] +"\t"+ sungjuk[0][2]
				+ "\t"+ tot +"\t" + avg);
		
		System.out.println("======================");
		
		for (int i = 0; i < sungjuk.length; i++) {
			tot = sungjuk[i][0] + sungjuk[i][1] + sungjuk[i][2];
			avg = (tot * 100) / 3 / 100.0;
			System.out.println(sungjuk[i][0] +"\t"+ sungjuk[i][1] +"\t"+ sungjuk[i][2]
					+ "\t"+ tot +"\t" + avg);
		}
		//====>
		System.out.println("-----");
		for (int i = 0; i < sungjuk.length; i++) {
			tot = 0;
			tot = tot + sungjuk[i][0]; //국어
			tot = tot + sungjuk[i][1]; //영어
			tot = tot + sungjuk[i][2]; //수학
			
			avg = (tot * 100) / 3 / 100.0;
			System.out.print(sungjuk[i][0] +"\t"); //국어
			System.out.print(sungjuk[i][1] +"\t"); //영어
			System.out.print(sungjuk[i][2] +"\t"); //수학
			System.out.println(tot +"\t" + avg);
		}
		
		//==========>
		System.out.println("-----");
		
		System.out.println(TITLE);
		System.out.println(LINE);
		for (int i = 0; i < sungjuk.length; i++) {
			tot = 0;
			for (int k = 0; k < sungjuk[i].length; k++) {
				tot = tot + sungjuk[i][k]; //국어 + 영어 + 수학
				System.out.print(sungjuk[i][k] +"\t");
			}
			avg = (tot * 100) / sungjuk[i].length / 100.0;
			System.out.println(tot +"\t" + avg);
		}
		System.out.println(LINE);
		
		System.out.println("\n\n\n\n");
	}
}
