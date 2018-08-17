package com.mystudy.ternary_operator;

public class My_Ex_TernaryOperator {

	public static void main(String[] args) {
		//삼항 연산자
		//변수 = (boolean) ? (true) : (false)
		//변수는  (이게 트루면) = (요거고)
		//변수는  (이게 폴스면) = 			(요거다)
		
		int a = 100;
		int b = 500;
		int result;
		
		//기존 if - else문
		if ((a+b) > 300) {
			result = 5000;
		} else {
			result = 3000;
		}
		System.out.println(result);
		
		//삼항연산자 사용
		result = ((a+b) > 300) ? (9999) : (6666);
		System.out.println(result);
		

	}

}
