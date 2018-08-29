package com.mystudy.am01_exception;

public class ExceptionEx {

	public static void main(String[] args) {
		System.out.println("--- main() 시작  ---");
		int num = 100;
		int num1 = 0;
		int num2 = 30;
		int result = 0;
		System.out.println(">> 연산시작");
//		result = num / num1;
//		System.out.println("연산결과 : "+ result);
		
		
		//if문으로 예외 처리
//		if (num1 == 0) {
//			System.out.println("[예외발생] 0으로 나누려고 했습니다.");
//		} else {
//			result = num / num1;
//			System.out.println("연산결과 : "+ result);
//		}
		
		try {
			num1 = 0;
			result = num / num1;	//0으로 나눌 때 예외 발생
			System.out.println("연산결과 : "+ result);
		} catch (ArithmeticException e) {
			System.out.println("[예외발생-메시지]"+ e.getMessage());
			e.printStackTrace();					//실행되고 있는 명령문들의 목록을 출력
		} catch (RuntimeException e) {
			System.out.println("[예외발생-Runtime]"+ e.getMessage());
		} catch (Exception e) {
			System.out.println("[예외발생] 0으로 나누려고 했습니다."+ e.getMessage());
		}
		
		
		System.out.println("--- main() 종료 ---");

	}

}
