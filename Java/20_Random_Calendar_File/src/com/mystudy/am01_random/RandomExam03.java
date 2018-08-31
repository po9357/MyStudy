package com.mystudy.am01_random;

import java.util.Calendar;
import java.util.Random;

public class RandomExam03 {

	public static void main(String[] args) {
		//(실습) Calendar, Math.random(), Random 사용
		//오늘 날짜 당신의 행운지수(0~100)
		//Calendar 클래스 이용해서 오늘 날짜 구하고,
		//Math.random(), Random 클래스 이용해서 행운지수 값 만들기
        //실행결과
		//2018년 8월 30일 당신의 행운지수(0~100)는 77 입니다.
		/////////////////////////////////////////
		
		//오늘 날짜 값(년, 월, 일) 구하기
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		//년, 월, 일 구하기
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1; //(0 ~ 11) + 1
		int date = now.get(Calendar.DATE);
		
		System.out.println(year + "년 " + month + "월 " + date + "일");
		System.out.println("-----------------------------");
		
		//행운지수 값 만들기
		int result = 0;
		
		System.out.println("오늘 나의 행운지수는 얼마일까요?");
		
		//방법1 - Random nextInt(숫자)
		Random ran = new Random();
		result = ran.nextInt(101); //0 ~ 100 범위의 난수
		System.out.print(year + "년 " + month + "월 " + date + "일 ");
		System.out.println("당신의 행운지수(0~100)는 " + result + " 입니다.");
		
		
		//방법2 - Math.random()
		result = (int)(Math.random() * 101);
		System.out.print(year + "년 " + month + "월 " + date + "일 ");
		System.out.println("당신의 행운지수(0~100)는 " + result + " 입니다.");
		
		//-----------------
		//방법3 - Random nextInt();
		int su = ran.nextInt();
		result = Math.abs(su) % 101;
		System.out.print(year + "년 " + month + "월 " + date + "일 ");
		System.out.println("당신의 행운지수(0~100)는 " + result + " 입니다.");
		
		
		
	}

}
