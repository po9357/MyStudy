package com.mystudy.string;

public class Ex03_StringExam {

	public static void main(String[] args) {
		/*	문자열 주민번호 처리
		String str = "900108-1234567";		//주민번호
		문제1. 정확히 입력이 된 데이터인지 확인
				(전체 자리수가 14, '-' 위치 : 7번째)
		문제2. 생년월일 출력
		문제3. 성별확인하고 출력(1,3: 남성, 2,4: 여성)
		문제4. 데이터 값 검증
				(월: 1~12, 일: 1~31)
		참고 : int num = Integer.parseInt("12")	-> "12" -> 12
		*/
		
		
		String str = "900108-2234567";
		//문제1. 전체 자리수 14, '-' 위치 7번째
		if (str.length() == 14 && str.charAt(6) == '-') {
			System.out.println("주민번호가 제대로 입력되었습니다.");
		} else {
			System.out.println("주민번호를 다시 확인하여 주십시오.");
		}
		
		//문제2. 생년월일 출력
		System.out.println("입력하신 주민번호의 생년월일은 "+ str.substring(0, 2) +"년 "
							+ str.substring(2, 4)+ "월 "+str.substring(4, 6) +"일 입니다.");
		
		//문제3. 성별 확인 (1,3 : 남, 2,4 : 여)
		if (str.charAt(7) == '1' || str.charAt(7) == '3') {
			System.out.println("남자입니다.");
		} else if (str.charAt(7) == '2' || str.charAt(7) == '4') {
			System.out.println("여자입니다.");
		} else {
			System.out.println("주민번호를 다시 확인하여 주십시오.");
		}
		
		//문제4. 데이터값 검증	(월: 1~12, 일: 1~31)
		int month = Integer.parseInt(str.substring(2, 4));
		System.out.println(month);
		
		int day = Integer.parseInt(str.substring(4, 6));
		System.out.println(day);
		
		if (1<=month && month<=12) {
			System.out.println("출생 월이 정상적으로 입력되었습니다.");
		} else {
			System.out.println("주민번호를 다시 확인하여 주십시오.");	
		}
		
		if (1<=day && day<=31) {
			System.out.println("출생 일이 정상적으로 입력되었습니다.");
		} else {
			System.out.println("주민번호를 다시 확인하여 주십시오.");
		}
		
	}
	
}
