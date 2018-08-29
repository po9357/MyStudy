package com.mystudy.am03_score;

public class ScoreTest {

	public static void main(String[] args) {
		ScoreVO scv = new ScoreVO("홍길동", 100, 90, 70);
		System.out.println(scv.toString());
		scv.setKor(999);
		System.out.println(scv.toString());
		try {
			scv.setEng(1000);
		} catch (ScoreOutOfValueException e) {
			System.out.println(">> main()에서 예외를 catch 처리 "+ e.getMessage());
//			e.printStackTrace();
		}
		System.out.println(scv.toString());
		
		
		System.out.println("--- main() 종료 ---");
	}

}
