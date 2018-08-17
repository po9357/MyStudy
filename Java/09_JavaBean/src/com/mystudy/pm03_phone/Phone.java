package com.mystudy.pm03_phone;

public class Phone {
	//부호로 접근 제한자 표시
	//+: public, #: protected, -: private, (default) 없음
	//-type : String
	//-phoneNo: String
	private String type;
	private String phoneNo;
	
	//생성자(phoneNo) : type값 "Phone 타입" 입력처리
	//생성자(type, phoneNo)
	public Phone(String phoneNo) {
		this.phoneNo = phoneNo;
		this.type = "Phone 타입";
	}
	
	public Phone(String type, String phoneNo) {
		this.phoneNo = phoneNo;
		this.type = type;
	}
	
	//getType
	//getPhoneNo
	public String getType() {
		return type;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	
	//call() : ">> 전화걸기" 화면출력
	//receiveCall() : ">> 전화받기" 화면출력
	public void call() {
		System.out.println(">> 전화걸기");
	}
	
	public void receiveCall() {
		System.out.println(">> 전화받기");
	}

	
	
	//view() : toString() 호출
	public void view() {
		System.out.println(toString());
	}
	
	//toString() : 이클립스에서 자동 생성
	@Override
	public String toString() {
		return "Phone [type=" + type + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
}
