package com.mystudy.io4_printwriter;

import java.util.Calendar;

public class Printf_Exam {

	public static void main(String[] args) {
		int a = 20;
		long b = 300000000L;
		float c = 34.95f;
		double d = 234.234;
		char e = 'A';
		String f = "Hello~~";
		boolean g = false;
		
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		System.out.printf("%tF\n", today);
		
		System.out.printf(">> "+ a +" "+ b +" "
				+ c +" "+ d +" "+ e +" "+ f +" "+ g);
		System.out.println();

		/* [] 생략가능항목
		%[인덱스]$[+|-][크기]형식문자 : %, 형식문자 필수
		- 기본은 우측정렬
		- 좌측정렬 예 : %-10d 
		*/
		System.out.printf("\\ %% %n \n");
		System.out.printf("%d %d %f %f %c %s %b %n", a,b, c,d, e, f, g);
		
		//[인덱스]$ 사용예 -------------------
		System.out.printf("%d %d %c %s \n", 65, 65, 'A', "Hello Java");
		//형식과 대상이 1:1이 아닌경우 출력 형태
		//($를 이용한 매칭 대상값을 지정한 것은 우측데이타 매칭에서 제외됨)
		System.out.printf("%1$d %1$d %c %s \n", 100, 'A', "Hello Java");
		
		//형식과 대상이 1:1이 아닌경우 명시적으로 참조위치 지정
		System.out.printf("%1$d %1$d %2$c %1$d %3$s \n", 100, 'A', "Hello Java");
		
		System.out.println("--- 실수형 데이타 출력 ----");
		System.out.printf("%f %1$a %1$e %1$f %1$g \n", 65.841243234234);
		
		System.out.println("--- 날짜 관련 ----");
		System.out.printf("%1$tY %1$tm %1$td %1$tF %1$tB %1$th \n", today);
		System.out.printf("%1$ty %1$tm %1$te \n", today);
		System.out.printf("%1$tI %1$tM %1$tS %1$ta \n", today);
		
		//폭지정
		System.out.println("--- 폭(width) 지정 ----");
		System.out.printf("%1$20f \n", 5678.1234567891); //기본 우측정렬
		System.out.printf("%1$-20f \n", 5678.1234567891); //- : 좌측정렬
		System.out.printf("%1$-20.10f \n", 5678.1234567891); //- : 좌측정렬
		
		System.out.println("---------------------");
		System.out.printf("%10s %10d %10d %10d \n", "홍길동", 100, 90, 80);
		System.out.printf("%10s %10d %10d %10d \n", "을지문덕", 100, 90, 80);
	}

}






















