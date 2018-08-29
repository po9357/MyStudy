package com.mystudy.am01_extends;

public class Phone {
	//필드(속성)---------------
	private String type;
	private String phoneNo;
	
	//생성자-----------------------
//	public Phone() {}
	public Phone(String phoneNo) {
		type = "Phone 타입";
		this.phoneNo = phoneNo;
	}

	public Phone(String type, String phoneNo) {
		super();
		this.type = type;
		this.phoneNo = phoneNo;
	}

	//메소드(기능) -------------------------------
	public String getType() {
		return type;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void call() {
		System.out.println(">> 전화걸기");
	}
	public void receiveCall() {
		System.out.println(">> 전화받기");
	}
	
	public void view() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "Phone [type=" + type + ", phoneNo=" + phoneNo + "]";
	}
	
}