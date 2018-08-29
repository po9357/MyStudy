package com.mystudy.am03_interface;

public class PhoneTest {

	public static void main(String[] args) {
		Phone ph = new Phone("Phone", "010-2020-5757");
		ph.sendMsg();
		ph.receiveMsg("dkdkdk");
	}
}
