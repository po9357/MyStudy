package com.mystudy.pm03_phone;

public class Phone_mine {

	public static void main(String[] args) {
		Phone ph = new Phone("�� ��ȣ");
		System.out.println(ph);
		
		ph.view();
		
		Mp3Phone mp3 = new Mp3Phone("mp3��ȣ", "mp3��");
		System.out.println(mp3);
		mp3.view();
		
		mp3.playMusic();
		
		
	}
}
