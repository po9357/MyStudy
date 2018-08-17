package com.mystudy.am03_interface;

public interface I_Phone {
	//추상 메소드(구현되지 않은 메소드)
	void view();		//0. 전화정보 확인
	void call();		//1. 전화걸기
	void receiveCall();	//2. 전화받기
	void sendMsg();		//3. 메시지 보내기
	void receiveMsg(String rms);	//4. 메시지 받기

}