package com.mystudy.pm03_scanner_game;

import java.util.Scanner;

public class ScannerGame {

	public static void main(String[] args) {
		//Scanner를 이용한 가위 바위 보 게임
		//컴퓨터와 함께하는 가위(1),바위(2),보(3) 게임
		//1. 가위, 바위, 보 선택 메뉴 출력
		//2. 선택값 입력
		//3. 컴퓨터도 선택(Math.random())
		//4. 결과 비교후 승자, 패자 결정
		////////////////////////////////
		
		//1. 가위, 바위, 보 선택 메뉴 출력
		System.out.println("가위, 바위, 보 중에 하나를 선택하세요.");
		System.out.println("1.가위  2.바위  3.보");
		System.out.print(">>당신의 선택은(1~3)? ");
		
		//2. 선택값 입력
		Scanner sc = new Scanner(System.in);
		int select = Integer.parseInt(sc.nextLine());
		
		String strPerson = "";
		if (select == 1) {
			strPerson = "가위";
		} else if (select == 2) {
			strPerson = "바위";
		} else if (select == 3) {
			strPerson = "보";
		} else {
			System.out.println("1 ~ 3 중에서 선택하세요");
			return;
		}
		
		//3. 컴퓨터도 선택(Math.random())
		int comSelect = (int)(Math.random() * 3 + 1);
		String strComputer = "";
		switch (comSelect) {
		case 1:
			strComputer = "가위";
			break;
		case 2:
			strComputer = "바위";
			break;
		case 3:
			strComputer = "보";
			break;
		default:
			System.out.println("1 ~ 3 중에서 선택하세요");
		}
		System.out.println("사람: " + strPerson + ", 컴퓨터: " + strComputer);
			
		//4. 결과 비교 후 승자, 패자 결정
		//사람이 '가위'인 경우
		String result = "";
		if (strPerson.equals("가위")) {
			//컴퓨터 : 가위, 바위, 보
			if (strComputer.equals("가위")) {
				result = "비김";
			}
			if (strComputer.equals("바위")) {
				result = "짐";
			}
			if (strComputer.equals("보")) {
				result = "이김";
			}
		}
		
		if (strPerson.equals("바위")) {
			//컴퓨터 : 가위, 바위, 보
			if (strComputer.equals("가위")) {
				result = "이김";
			}
			if (strComputer.equals("바위")) {
				result = "비김";
			}
			if (strComputer.equals("보")) {
				result = "짐";
			}
		}
		
		if (strPerson.equals("보")) {
			//컴퓨터 : 가위, 바위, 보
			if (strComputer.equals("가위")) {
				result = "짐";
			}
			if (strComputer.equals("바위")) {
				result = "이김";
			}
			if (strComputer.equals("보")) {
				result = "비김";
			}
		}
		
		
		
		
		
		
		
		
	}

}
