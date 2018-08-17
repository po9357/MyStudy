package com.mystudy.am;

public class Ex01_parameter {

	public static void main(String[] args) {
		//파라미터 값을 전달할 때
		//1. 값이 전달되는 경우	: 기본 데이터 타입
		//2. 주소값이 전달되는 경우	: 참조형 데이터 타입
		//	참조형 데이터 타입을 전달받아 값을 변경시 원본 데이터의 값도 변경된다.	(같은 저장공간(주소)를 갖기 때문에 발생)
		//	기본형 데이터 타입의 경우 해당 데이터 자체가 넘어가기 때문에 (주소값x)값을 전달받아 변경 하더라도 원본 데이터는 변하지 않는다.
		int num = 100;
		int[] arr = {100, 200, 300};
		
		System.out.println("정수 num : "+ num);
		
		changeData(num);
		
		System.out.println("changeData실행 후 num : "+ num);
		
		
		System.out.println("---- 참조형 데이터 전달 ----");
		
		
		System.out.print("정수배열 arr : ");
		printData(arr);
		
		changeData(arr);
		
		System.out.print("changeData 실행 후 arr: ");
		printData(arr);
	}
	
	//메소드 오버로딩(method overloading)
	//같은 클래스 내에서 같은 메소드 이름으로 매개변수(parameter)를 다르게 정의하여
	//동일한 메소드명으로 다르게 동작하도록 처리
	static void changeData(int intValue) {
		System.out.println(">> 전달 받은 int : "+ intValue);
		intValue = 999;
		System.out.println(">> 변경된 int : "+ intValue);
	}
	
	static void changeData(int[] intArr) {
		System.out.print(">> 전달받은 int배열 : ");
		printData(intArr);
		
		//배열값 변경
		intArr[0] = 999;
		System.out.print(">> 변경 후 int배열 : ");
		printData(intArr);
	}
	
	static void printData(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
	
	
	
	
}
