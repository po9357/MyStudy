package com.mystudy.am01_extends;

public class PhoneTest {
	
	public static void main(String[] args) {
		System.out.println("=== Phone ===");
		Phone ph1 = new Phone("010-1111-1111");
		ph1.view();
		ph1.call();
		ph1.receiveCall();

		Phone ph2 = new Phone("�Ｚ������", "010-2222-2222");
		ph2.view();
		ph2.call();
		ph2.receiveCall();
		
		System.out.println("=== Mp3Phone ===");
		Mp3Phone mp3ph = new Mp3Phone("010-3333-3333");
		mp3ph.view();
		System.out.println("��ȭŸ��: " + mp3ph.getType());
		System.out.println("��ȭ��ȣ: " + mp3ph.getPhoneNo());
		mp3ph.call();
		mp3ph.receiveCall();
		mp3ph.playMusic();
		
		System.out.println("=== WebPhone ===");
		WebPhone wp = new WebPhone("010-1111-3333");
		wp.view();
		wp.call();
		wp.receiveCall();
		wp.webSearch();
	}
}
