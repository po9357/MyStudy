package com.mystudy.am01_extends;

//클래스 상속(extends) 실습
/* 실습1 : Phone 클래스 상속 확장(extends)
 WebPhone 클래스 작성
 Phone 클래스를 상속 확장(extends)해서 작성
 생성자 정의
  - 폰번호(phoneNo)만 받아서 객체생성
  - 타입 값은 "WebPhone"으로 입력
  
 기능 추가
 웹검색 기능 추가
  - webSearch() : ">>WebPhone - 웹 검색" 문구 화면 출력
 */
public class WebPhone extends Phone {
	
	public WebPhone(String phoneNo) {
		super("WebPhone", phoneNo);
	}
	
	public void webSearch() {
		System.out.println(">>WebPhone - 웹 검색");
	}
	
	
	
	
}
