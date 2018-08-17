package com.mylunch.today;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Todays_Lunch {

	public static void main(String[] args) {
		String lunch;
		int random;
		String cancel;
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		
		
		Outter:
		while (true) {
			Inner:
			while (true) {
				System.out.println("오늘의 후보지를 입력해 주세요 (그만 입력하려면 0을 눌러주세요)");
				lunch = sc.nextLine();
				if (!lunch.equals("0")) {
					list.add(lunch);
				} else if (lunch.equals("0"))
					break;
			}
			while (true) {
				System.out.println("입력하신 오늘의 후보지입니다.");
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i)+ " ");
				}
				System.out.println("\n추첨을 시작하려면 1, 후보지를 다시 입력하려면 0을 눌러주세요");
				cancel = sc.nextLine();
				if (cancel.equals("1")) {
					random = (int)(Math.random()*list.size());
					System.out.println("오늘의 점심 메뉴는....\n");
					char[] lunchArr = list.get(random).toCharArray();
					for (int i =0; i < lunchArr.length; i++) {
						System.out.print(list.get(random).charAt(i) + " ");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {}
					}
					System.out.println("\n축하합니다!! 오늘의 메뉴는 "+ list.get(random)+ "입니다!!");
					break Outter;
				} else if (cancel.equals("0")) {
					break;
				} else {
					System.out.println("다시 입력해 주세요");
				}
			}
		}
		
		
	}
}
