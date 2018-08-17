package com.mystudy.am02_phone;

import java.util.Scanner;

////////////////////////////////////////
//��� ����(�޼ҵ���� ���� �˾Ƽ�)
//��ȭ�� �Ӽ� : Ÿ��(type), ��ȭ��ȣ(phoneNo)
//0. ��ȭ���� Ȯ��
//1. ��ȭ�ɱ�
//2. ��ȭ �ޱ�
//3. �޽��� ������
//4. �޽��� �ޱ�
public class Phone {
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
		System.out.println("��ȭ ��ȣ�� �Է��Ͽ� �ֽʽÿ�.");
		String phNo = sc.nextLine();
		System.out.println(phNo +"��ȣ�� ��ȭ�� �̴ϴ�.");
	}
	public void receiveCall() {
		System.out.println("��ȭ �ޱ�");
	}
	public void sendMsg(String sms) {
		sms = sc.nextLine();
		System.out.println("�޽����� �����մϴ� : "+ sms);
	}
	public void receiveMsg(String rms) {
		System.out.println("�޽����� ���� �޾ҽ��ϴ� : "+ rms);
	}
	
	
	public static void main(String[] args) {
		Phone ph = new Phone("����Ʈ��", "000-1234-5678");
		ph.call();
	}
}

