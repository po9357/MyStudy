package com.mystudy;

public class Ex02 {

		public static void main(String[] args) {
			//참조형데이터타입		변수명 = new
			Ex02 ex02 = new Ex02(); //기본(default) 생성자 사용
			int num1 = 200;
			int num2 = 100;
			int sum = 0;
			sum = ex02.add(num1 , num2);
			System.out.println("sum : " + sum);
			
			System.out.println("sub : " + ex02.sub(num1, num2));
			System.out.println("mul : " + ex02.mul(num1, num2));
			System.out.println("div : " + ex02.div(num1, num2));
			
			
		}
		
		int add(int a, int b) {
//			int result = 0;
//			result = a + b;
//			return result;
			return a + b;
		}
		
		int sub(int a, int b) {
			return a - b;
		}
		
		int div(int a, int b) {
			return a / b;
		}
		
		int mul(int a, int b) {
			return a * b;
		}
		
		
		
}
