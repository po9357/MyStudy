package com.mystudy.am;

public class Ex01_array {

	public static void main(String[] args) {
		//배열(Array)
		//배열의 선언 : 자료형[] 변수명
		//변수에 값 저장 : 배열 변수명[인덱스 번호] = 값;
		/* 배열 선언 및 생성
		1. 자료형[] 변수명 = new 자료형[갯수];
		       자료형 변수명[] = new 자료형[갯수];
		2. 자료형[] 변수명 = new 자료형[] {100, 200, 300};
		3. 자료형[] 변수명 = {100, 200, 300};
		 */
		
		//배열을 선언하고 사용
		//정수 데이터 5개를 저장할 수 있는 배열
		int[] arr = new int[5];
		System.out.println("arr : "+ arr);
		arr[0] = 100;
		System.out.println("arr[0] : " + arr[0]);
		arr[1] = 200;
		arr[2] = 300;
		arr[3] = 400;
		arr[4] = 500;
//		arr[5] = 600;	//ArrayIndexOutOfBoundsException
		System.out.println("arr[4] : "+ arr[4]);
		int sum = 0;
		sum = arr[0] + arr[1] + arr[2] + arr[3] + arr[4];
		System.out.println("sum : " + sum);
		
		System.out.println("----------");
		sum=0;
		for(int idx=0; idx<5; idx++) {
//			System.out.println(arr[idx]);
			sum = sum + arr[idx];
		}
		System.out.println("sum : " + sum);
		
		//배열의 크기 값 확인(조회)
		System.out.println("arr배열의 크기 : " +arr.length);
		System.out.println("-----------");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		//===========================================
		//영어 알파벳 출력
		char[] ch = new char[26];
		ch[0] = 'A';	//65
		for (int i=0; i<ch.length; i++) {
			ch[i] = (char) ('A'+i);
		}
		
		//ch 배열에 저장된 값 조회(출력)
		for (int i=0; i<ch.length; i++) {
			System.out.print(ch[i] + " ");
		}
		System.out.println();
		
		///////////////////////////////
		//배열 선언 형태별 사용
		System.out.println("--- 배열 선언형태 2번 ---");
		int[] num = new int[] {0, 1, 2, 3, 4};
		for (int i=0; i<num.length; i++) {
			System.out.print(num[i] +" ");
		}
		System.out.println();
		
		System.out.println("--- 배열 선언형태 3번 ---");
		int[] arr3 = {0, 1, 2, 3, 4};
		for (int i=0; i<arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println();
	}

}
