package com.mystudy.am03_score;

public class ScoreOutOfValueException extends Exception {
	ScoreOutOfValueException(){
		super("점수범위(0~100)를 벗어난 값입니다.");
	}
	
	ScoreOutOfValueException(String msg){
		super();
	}

}
