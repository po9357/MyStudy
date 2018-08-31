package com.mystudy.am01_random;

import java.util.Random;

public class RandomExam01 {

	public static void main(String[] args) {
		//Random 클래스 : 난수를 생성하는 클래스
		//정수추출 : nextInt() - int타입의 난수 발생
		//        nextInt(10) : 0 ~ 9 범위의 난수 발생
		//        nextLong() - long타입의 난수 발생
		//실수추출 : nextFloat() - 실수형 float 타입 난수 발생
		//        nextDouble() - 실수형 double 타입 난수 발생
		//논리형추출 : nextBoolean() - true, false 둘 중 하나 발생 
		
		Random ran = new Random();
		
		System.out.println("난수nextBoolean() : " + ran.nextBoolean());
		System.out.println("난수nextBoolean() : " + ran.nextBoolean());
		
		System.out.println("--- nextInt() ---");
		System.out.println("난수nextInt() : " + ran.nextInt());
		System.out.println("난수nextInt() : " + ran.nextInt());
		System.out.println("난수nextInt() : " + ran.nextInt());
		
		System.out.println("--- nextInt(3) ---");
		System.out.println("난수nextInt(3) : " + ran.nextInt(3));
		System.out.println("난수nextInt(3) : " + ran.nextInt(3));
		System.out.println("난수nextInt(3) : " + ran.nextInt(3));
		
		System.out.println("--- nextFloat() ---");
		System.out.println("난수nextFloat() : " + ran.nextFloat());
		System.out.println("난수nextFloat() : " + ran.nextFloat());
		System.out.println("난수nextFloat() : " + ran.nextFloat());
		
		System.out.println("--- nextDouble() ---");
		System.out.println("난수nextDouble() : " + ran.nextDouble());
		System.out.println("난수nextDouble() : " + ran.nextDouble());
		System.out.println("난수nextDouble() : " + ran.nextDouble());
		
	}

}
