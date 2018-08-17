package com.mystudy.pm03_phone;

public class Mp3Phone {
		//��ȣ�� ���� ������ ǥ��
		//+: public, #: protected, -: private, (default) ����
		//-type: String
		//-phoneNo: String
	private String type;
	private String phoneNo;
	
		//������(phoneNo) : type�� "Phone Ÿ��" �Է�ó��
		//������(type, phoneNo)
	public Mp3Phone (String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Mp3Phone (String phoneNo, String type) {
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
		
		//call() : ">> ��ȭ�ɱ�" ȭ�����
		//receiveCall() : ">> ��ȭ�ޱ�" ȭ�����
		//playMusic() : ">> �����÷���" ȭ�����
	public void call() {
		System.out.println(">> ��ȭ�ɱ�");
	}
	public void receiveCall() {
		System.out.println(">> ��ȭ�ޱ�");
	}
	public void playMusic() {
		System.out.println(">> �����÷���");
	}
	
		//view() : toString() ȣ��
	public void view(){
		System.out.println(this.toString());
	}
	
		//toString() : ��Ŭ�������� �ڵ� ����
	@Override
	public String toString() {
		return "Mp3Phone [type=" + type + ", phoneNo=" + phoneNo + "]";
	}
	
}
