package com.mystudy.am;

public class Ex04_Wrapper {

	public static void main(String[] args) {
		//Wrapper Class : 기본 데이터 타입을 기능확장해 놓은 클래스 총칭
		//기본 데이터 타입 : 전체 소문자, char, int ...
		//Wrapper Class : 기본 데이터 타입의 첫 글자 대문자.
		//char - Character, int - Integer
		int num = 100;
		System.out.println("num : "+ num);
		
		Integer intNum = new Integer("100");
		System.out.println("intNum : "+ intNum);
		
		intNum = 900;		//Integer	<--	int : 자동형변환
		num = intNum;		//int	<--	Integer : 자동형변환
		
		System.out.println("정수형 int 최대값 : "+ Integer.MAX_VALUE);
		System.out.println("정수형 int 최대값 : "+ Integer.MIN_VALUE);
		
		num = Integer.parseInt("999");		//int	<-	Sting
		intNum = Integer.valueOf("999");	//Integer	<-	String
		
		//------------------------------------------------------
		Boolean bool = true;
		bool = new Boolean(true);
		System.out.println("bool : "+ bool);
		bool = new Boolean("true1");		//기본적으로 생성자에서 문자열을 저장할 수 있다.
		System.out.println("bool : "+ bool);
		System.out.println(Boolean.TRUE);
		System.out.println(Boolean.FALSE);
		
		System.out.println("------------------------------");
		//String타입 -> Boolean
		bool = Boolean.valueOf("true");		//true
		System.out.println(bool);
		bool = Boolean.valueOf("true1");	//false		
		System.out.println(bool);						//대,소문자 구분 없이 "true"란 문자가 오면 true값으로 반환
		bool = Boolean.valueOf("True");		//true
		System.out.println(bool);
		bool = Boolean.valueOf("TRUE");		//true
		System.out.println(bool);
		
		//--------------------------------------------------------
		//Float
		Float f = 10.5f;	//Float <- float
		f = new Float(12.5f);
		f = new Float("12.5f");
//		f = new Float("12.a5f");	//java.lang.NumberFormatException
//		System.out.println("12.a5f : "+ f);
		
		String str = String.valueOf(f);
		System.out.println(str);
		f = Float.valueOf(str);
		System.out.println(f);
		
		System.out.println("---------");
		Double d = 10.5;			//Double <-> double
		d = new Double(12.5d);
		d = new Double("12.5d");
		d = Double.valueOf("12.5");
		System.out.println(d);
		
	}
}