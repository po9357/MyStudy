package com.mystudy.am02_scanner_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//[실습] 숫자 맞추기 게임
//컴퓨터가 1~100 사이의 숫자를 정하면 사람이 맞추는 게임
//선택 기회 5회
//컴숫자 : 70 인 경우 -Math.random()
//사람이 선택한 숫자가 크면(80) : 작다는 메시지 출력
//사람이 선택한 숫자가 작으면(50) : 크다는 메시지 출력
//5번 이내에 맞추면 : 성공!!! n번 만에 맞췄습니다.(화면출력)
//5번을 넘기면 : 실패~~ 내가 생각한 숫자는 70입니다.(화면출력)
//-----
//다시 도전하시겠습니까?(y,n) 
//////////////////////////////////////////
/* 
1~100까지 숫자 중에 하나를 생각했습니다. 맞춰보세요!!!
숫자 입력(1~100) : 80
>> 80보다 작습니다.
숫자입력 : 50
>> 50보다 큽니다.
...
숫자입력 : 73 - 5번째시도
>> 실패~~ 내가 생각한 숫자는 70입니다.
---
숫자입력 : 70 - 5번째시도
>> 성공!! 5번 만에 맞췄습니다.
*/
////////////////////////////////////////////
public class GuessNumberGame {
	int comNo = 0;
	int meNo = 0;
	int tryCnt = 0;
	Scanner scan = new Scanner(System.in);
	
//	public static void main(String[] args) {
//		
//		GuessNumberGame game = new GuessNumberGame();
//		game.startGame();
//		
//	}//main end
	
	void startGame() {
		while (true) {
			//게임 플레이
			playGame();
			
			//게임을 더할 지 결정
			if (!tryAgain()) {
				System.out.println(">> 게임을 더이상 진행하지 않습니다.(종료)");
				break;
			}
		}
		scan.close();
	}
	
	boolean tryAgain() {
		boolean result = false; //게임 안함
		System.out.println("-------------------");
		System.out.print(">> 다시 도전하시겠습니까?(y/n) ");
		String tryYesNo = scan.nextLine();
		if ("y".equalsIgnoreCase(tryYesNo)) {
			result = true; //한번 더
		}
		
		return result;
	}
	
	void playGame() {
		tryCnt = 0;
		//1. 메시지 출력 및 컴퓨터가 1~100까지 숫자 중 하나를 생각해서 정하기
		comNo = (int)(Math.random() * 100) + 1;
		System.out.println("1~100까지 숫자 중에 하나를 생각했습니다."+
				" 맞춰보세요");
		System.out.println("컴퓨터 생각 숫자: " + comNo);
		
		while (tryCnt < 5) {
			tryCnt++; //1~
			//2. 사람에게 선택하도록 메시지 출력, 값을 입력 받기
			System.out.print("("+ tryCnt + "번째)숫자를 선택 : ");
			meNo = Integer.parseInt(scan.nextLine());
			
			//3. 입력한 값과 컴퓨터의 숫자 비교(>, ==, <)
			if (comNo > meNo) {
				System.out.println(">> " + meNo+ "보다 큽니다.");
			}
			if (comNo < meNo) {
				System.out.println(">> " + meNo+ "보다 작습니다.");
			}
			if (comNo == meNo) {
				System.out.println(">> 맞췄습니다.");
				System.out.println("게임을 종료합니다. 다시 시작하세요");
				break;
			}
			
			//못맞춘 상태 + 5번째이면 실패 처리하고 반복문 빠져나가기
			if (tryCnt >= 5) {
				System.out.println(">> 실패~~ 내가 생각한 숫자는 "
						+ comNo + "입니다");
				break;
			}
		}
	}

}//class end




