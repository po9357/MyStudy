package com.mystudy.am02_phone;

import java.util.Scanner;

////////////////////////////////////////
//기능 구현(메소드명은 각자 알아서)
//전화기 속성 : 타입(type), 전화번호(phoneNo)
//0. 전화정보 확인
//1. 전화걸기
//2. 전화 받기
//3. 메시지 보내기
//4. 메시지 받기
public class Phone {
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
	
	
	public String getType() {
		return type;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void view() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "Phone [type=" + type + ", phoneNo=" + phoneNo + "]";
	}
	
	public void call() {
		System.out.println("전화 번호를 입력하여 주십시오.");
		String phNo = sc.nextLine();
		System.out.println(phNo +"번호로 전화를 겁니다.");
	}
	public void receiveCall() {
		System.out.println("전화 받기");
	}
	public void sendMsg(String sms) {
		sms = sc.nextLine();
		System.out.println("메시지를 전송합니다 : "+ sms);
	}
	public void receiveMsg(String rms) {
		System.out.println("메시지를 전송 받았습니다 : "+ rms);
	}
	
	
	public static void main(String[] args) {
		Phone ph = new Phone("스마트폰", "000-1234-5678");
		ph.call();
	}
}

