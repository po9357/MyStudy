package com.mystudy.am03_score;

public class ScoreOutOfValueException extends Exception {
	ScoreOutOfValueException(){
		super("��������(0~100)�� ��� ���Դϴ�.");
	}
	
	ScoreOutOfValueException(String msg){
		super();
	}

}
