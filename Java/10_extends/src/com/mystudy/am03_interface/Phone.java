package com.mystudy.am03_interface;

import java.util.Scanner;

//�������̽��� ����(implements)
//I_Phone �������̽��� ����ؼ� Phone Ŭ������ ����
public class Phone implements I_Phone{
	
	Scanner sc = new Scanner(System.in);
	
	private String type;
	private String phoneNo;
	
	Phone(){
		this.type = "�⺻ Ÿ��";
		this.phoneNo = "000-0000-0000";
	}
	Phone(String phoneNo){
		this.type = "�⺻ Ÿ��";
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
		System.out.println("��ȭ ��ȣ�� �Է��Ͽ� �ֽʽÿ�.");
		String phNo = sc.nextLine();
		System.out.println(phNo +"��ȣ�� ��ȭ�� �̴ϴ�.");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("��ȭ �ޱ�");
		
	}

	@Override
	public void sendMsg() {
		System.out.println("�޽����� �Է��Ͽ��ֽʽÿ�");
		String sms = sc.nextLine();
		System.out.println("�޽����� �����մϴ� : "+ sms);
	}

	@Override
	public void receiveMsg(String rms) {
		System.out.println("�޽����� ���� �޾ҽ��ϴ� : "+ rms);
	}
	

}
