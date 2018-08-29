package com.mystudy.am02_myexception;

public class MyException extends Exception {
	MyException() {
		super(">> 내가 만든 Exception");
	}
	
	MyException(String msg){
		super(">> 내가 만든 Exception : "+ msg);
	}	

}
