package com.mystudy.pm03_phone;

public class Phone_mine {

	public static void main(String[] args) {
		Phone ph = new Phone("내 번호");
		System.out.println(ph);
		
		ph.view();
		
		Mp3Phone mp3 = new Mp3Phone("mp3번호", "mp3폰");
		System.out.println(mp3);
		mp3.view();
		
		mp3.playMusic();
		
		
	}
}
