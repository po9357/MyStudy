package com.mystudy.pm01_interface;

//인터페이스 구성 요소(상수화된 클래스변수, 추상메소드)
//클래스상수 : public static final 타입 변수명
//추상메소드 : 선언부만 있는 메소드
//         public abstract 리턴타입 메소드명();
// - 메소드에 구현부 {} 가 없음
public interface I_Phone {
	//변수(클래스 상수)
	public static final boolean SUCCESS = true;
	boolean FAIL = false; //public static final 생략
	
	//추상메소드
	public abstract String getType();
	abstract String getPhoneNo(); //public 생략
	public String toString(); //abstract 생략
	void call(); //public abstract 생략
	void receiveCall(); //public abstract 생략
	void sendMsg(); //public abstract 생략
	void receiveMsg(); //public abstract 생략
}
