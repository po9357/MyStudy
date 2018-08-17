package com.mystudy.am01_exception;

public class ExceptionFinally {
public static int a = 0;
public int b = 1;
	public static void main(String[] args) {
		//try ~ catch  finally
		System.out.println("--- main() 시작 ---");
		int num = 0;
		try {
			System.out.println(">> try문 시작");
			System.out.println(">> 연산처리 시작");
			int result = 100 / num;			//예외발생 가능 : 0으로 나눔
			System.out.println(">> 연산처리 정살 실행");
			System.out.println(">> try문 종료");
		} catch (ArithmeticException e) {
			System.out.println(">> catch문 실행");
		} finally {
			System.out.println(">> finally : 항상 실행(무조건)");
		}
		System.out.println("------------------");
		System.out.println("test() 실행 결과 : "+ test());
		
		
		System.out.println("--- main() 종료 ---");
//		System.out.println(a);		//스태틱 메소드에서 스태틱 변수는 사용 가능
////		System.out.println(b);		//스태틱 메소드에서 인스턴스 변수는 사용 불가능
//		ExceptionFinally ef = new ExceptionFinally();
//		System.out.println(ef.b);	//스태틱 메소드에서 인스턴스 변수를 객체생성 후 사용 가능
	}
		static String test() {
			String result = "";
			int[] num = new int[3];
			
			try {
				num[3] = 100;
				result = "<정상실행>";
			} catch (Exception e) {
				result = "<예외발생>"+ e.getMessage();
				e.printStackTrace();
			} finally {
				System.out.println("finally : 무조건 실행");
			}
		
			return result;
		}
		
		
		
		
		
		
		
		
		
	
}

