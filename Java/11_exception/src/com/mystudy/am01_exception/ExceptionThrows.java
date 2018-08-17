package com.mystudy.am01_exception;

public class ExceptionThrows {

	public static void main(String[] args) {
		// 예외처리 : throws - 예외를 던질 때(위임,전가) 사용
		// 예외가 발생한 곳에서 처리하지 예외를 던져서 다른 곳에서 처리하도록 함
		// 호출된 곳에서 처리하도록 예외를 던짐
		System.out.println("--- main() 시작 ---");
		int num1 = 100;
		int num2 = 20;
		int result = 0;
		
		System.out.println(">> 연산처리");
		num2 = 0;
		try {
			div(num1, num2);
		} catch(ArithmeticException e) {
			System.out.println("[main-예외처리]" + e.getMessage());
		}
		System.out.println(">> div() 정상처리");
		
		num2 = 0;
		
		
		try {
			divThrows(num1, num2);
		} catch(ArithmeticException e) {
			System.out.println("[예외처리-throws된]" + e.getMessage());
		}
		System.out.println(">> divThrows() 정상처리");
		
		System.out.println(">> 연산처리 완료");
		
		System.out.println("--- main() 종료 ---");
	}
	
	static int div(int num1, int num2) {
		int result = 0;
		try {
			result = num1 / num2;
		} catch (ArithmeticException e) {
			System.out.println("[div 예외발생]" + e.getMessage());
		}
		return result;
	}
	
	static int divThrows(int num1, int num2) 
			throws ArithmeticException {
		int result = 0;
		result = num1 / num2;
		return result;
	}

}
