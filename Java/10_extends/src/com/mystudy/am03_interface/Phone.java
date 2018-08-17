package com.mystudy.am03_interface;

import java.util.Scanner;

//인터페이스를 구현(implements)
//I_Phone 인터페이스를 사용해서 Phone 클래스를 구현
public class Phone implements I_Phone{
	
	Scanner sc = new Scanner(System.in);
	
	private String type;
	private String phoneNo;
	
	Phone(){
		this.type = "기본 타입";
		this.phoneNo = "000-0000-0000";
	}
	Phone(String phoneNo){
		this.type = "기본 타입";
		this.phoneNo = phoneNo;
	}
	Phone(String type, String phoneNo){
		this.type = type;
		this.phoneNo = phoneNo;
	}
	
	@Override
	public String toString() {
		return "Phone [type=" + type + ", phoneNo=" + phoneNo + "]";
	}
	
	@Override
	public void view() {
		System.out.println(toString());
	}

	@Override
	public void call() {
		System.out.println("전화 번호를 입력하여 주십시오.");
		String phNo = sc.nextLine();
		System.out.println(phNo +"번호로 전화를 겁니다.");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("전화 받기");
		
	}

	@Override
	public void sendMsg() {
		System.out.println("메시지를 입력하여주십시오");
		String sms = sc.nextLine();
		System.out.println("메시지를 전송합니다 : "+ sms);
	}

	@Override
	public void receiveMsg(String rms) {
		System.out.println("메시지를 전송 받았습니다 : "+ rms);
	}
	

}
