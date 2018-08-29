package com.mystudy.am01_scanner_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//[실습] 숫자 맞추기 게임
public class ScannerGame_GuessNumber {

	public static void main(String[] args) {
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
		int comNo = 0;
		int meNo = 0;
		int tryCnt = 0;
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			tryCnt = 0;
			//1. 메시지 출력 및 컴퓨터가 1~100까지 숫자 중 하나를 생각해서 정하기
			comNo = (int)(Math.random() * 100) + 1;
			System.out.println("1~100까지 숫자 중에 하나를 생각했습니다."+
					" 맞춰보세요");
			System.out.println("컴퓨터 생각 숫자: " + comNo);
			
			while (tryCnt < 5) {
				tryCnt++; //1~
				if (tryCnt < 5) {
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
				} else {
					//5번째 처리 --------------------------------
					//성공 : 축하합니다. n번째 시도에 성공 
					//실패 : 실패~~ 내가 생각한 숫자는 xx입니다.
					//공통 : 무조건 종료
					//-----------------------------------------
					//2. 사람에게 선택하도록 메시지 출력, 값을 입력 받기
					System.out.print("(마지막)숫자를 선택 : ");
					meNo = Integer.parseInt(scan.nextLine());
					
					//3. 입력한 값과 컴퓨터의 숫자 비교(>, ==, <)
					if (comNo > meNo) {
						System.out.println(">> 실패~~ 내가 생각한 숫자는 "
								+ comNo + "입니다");
					}
					if (comNo < meNo) {
						System.out.println(">> 실패~~ 내가 생각한 숫자는 "
								+ comNo + "입니다");
					}
					if (comNo == meNo) {
						System.out.println(">> 맞췄습니다.");
						System.out.println("게임을 종료합니다. 다시 시작하세요");
					}
					break; //while 종료
				}
			}
			System.out.println("-------------------");
			System.out.print(">> 다시 도전하시겠습니까?(y/n) ");
			String tryYesNo = scan.nextLine();
			if ("n".equalsIgnoreCase(tryYesNo)) {
				System.out.println(">>게임을 종료했습니다.");
				break;
			}
			System.out.println();
		}
	}//main end

}//class end




