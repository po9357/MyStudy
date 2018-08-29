package com.mystudy.am02_myexception;

public class MyExceptionTest {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ---");
		
		
		
		
		try {
			firstMethod();
		} catch (MyException e) {
//			e.printStackTrace();
			System.out.println(">> main - catch : ");
			System.out.println(">> 오류메시지 : "+e.getMessage());
		}
		
		System.out.println("--- main() 종료 ---");
	}
	static void firstMethod() throws MyException{
		System.out.println("--- firstMethod() 시작 ---");
		secondMethod();
		System.out.println("--- firstMethod() 종료 ---");
	}
	static void secondMethod() throws MyException{
		System.out.println("--- secondMethod() 시작 ---");
		//예외 발생 시키기
		throw new MyException("secondMethod()에서 예외발생");
//		System.out.println("--- secondMethod() 종료 ---");
	}
	
	
}
