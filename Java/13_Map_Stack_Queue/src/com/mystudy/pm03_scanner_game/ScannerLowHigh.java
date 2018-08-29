package com.mystudy.pm03_scanner_game;

import java.util.Scanner;

public class ScannerLowHigh {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int com;
		int input;
		int chance;
		int max = 5;
		int cnt;
		int win = 0;
		int lose = 0;
		outter:
		while (true) {
			cnt=1;
			com = (int)(Math.random()*100+1);
			System.out.println("컴퓨터가 1 ~ 100사이 랜덤한 정수를 생성했습니다.");
			System.out.println("1 ~ 100 사이 정수를 입력하여 주십시오.");
			inner:
			while (true) {
				if (cnt < max) {
					System.out.println(cnt +"번 째 기회입니다.");
					input = sc.nextInt();
					while (input <= 0 || input > 100) {		//범위 설정
						System.out.println("1 ~ 100 사이 정수를 입력하여 주십시오.");
						input = sc.nextInt();
					}
					
					if (input > com) {						//입력한 값이 정답보다 클 경우
						System.out.println("더 낮은 숫자를 입력하여 주십시오."+ (max - cnt)+"번 기회 남았습니다");
						cnt++;
					} else if (input < com) {				//입력한 값이 정답보다 작을 경우
						System.out.println("더 높은 숫자를 입력하여 주십시오."+ (max - cnt)+"번 기회 남았습니다");
						cnt++;
					} else {								//정답일 경우
						win++;
						System.out.println("정답입니다!!!"+ cnt+ "번 째 만에 맞추셨습니다!");
						System.out.println("현재 전적은 "+ win +"승, "+ lose+ "패 입니다.");
						System.out.println("게임을 계속 하시려면 1을 입력하여 주십시오");
						chance = sc.nextInt();
						if (chance == 1) {
							break inner;
						} else {
							System.out.println("게임을 종료합니다.");
							break outter;
						}
					}
				} else {
					System.out.println("마지막 기회입니다.");
					input = sc.nextInt();
					while (input <= 0 || input > 100) {		//범위 설정
						System.out.println("1 ~ 100 사이 정수를 입력하여 주십시오.");
						input = sc.nextInt();
					}
					if (input == com){								//정답일 경우
						win++;
						System.out.println("정답입니다!!!"+ cnt+ "번 째 만에 맞추셨습니다!");
						System.out.println("현재 전적은 "+ win +"승, "+ lose+ "패 입니다.");
						System.out.println("게임을 계속 하시려면 1을 입력하여 주십시오");
						chance = sc.nextInt();
						if (chance == 1) {
							break inner;
						} else {
							System.out.println("게임을 종료합니다.");
							break outter;
						}
					} else {						//기회를 모두 소모했을 경우
						lose++;
						System.out.println("틀렸습니다! 정답은 "+ com+ "이었습니다!\n현재 전적은 "+ win +"승, "+ lose+ "패 입니다.\n새로운 게임을 하시려면 1을 입력하여 주십시오");
						chance = sc.nextInt();
						if (chance == 1) {
							break inner;
						} else {
							System.out.println("게임을 종료합니다.");
							break outter;
						}
					}
				}
			}	//inner while 끝
		}	//outter while 끝
		
	}	//main 끝
}	//class 끝
