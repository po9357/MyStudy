package com.mystudy.am02_myexception;

public class MyException extends Exception {
	MyException() {
		super(">> ���� ���� Exception");
	}
	
	MyException(String msg){
		super(">> ���� ���� Exception : "+ msg);
	}	

}
