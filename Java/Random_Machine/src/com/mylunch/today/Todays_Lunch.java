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
				System.out.println("������ �ĺ����� �Է��� �ּ��� (�׸� �Է��Ϸ��� 0�� �����ּ���)");
				lunch = sc.nextLine();
				if (!lunch.equals("0")) {
					list.add(lunch);
				} else if (lunch.equals("0"))
					break;
			}
			while (true) {
				System.out.println("�Է��Ͻ� ������ �ĺ����Դϴ�.");
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i)+ " ");
				}
				System.out.println("\n��÷�� �����Ϸ��� 1, �ĺ����� �ٽ� �Է��Ϸ��� 0�� �����ּ���");
				cancel = sc.nextLine();
				if (cancel.equals("1")) {
					random = (int)(Math.random()*list.size());
					System.out.println("������ ���� �޴���....\n");
					char[] lunchArr = list.get(random).toCharArray();
					for (int i =0; i < lunchArr.length; i++) {
						System.out.print(list.get(random).charAt(i) + " ");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {}
					}
					System.out.println("\n�����մϴ�!! ������ �޴��� "+ list.get(random)+ "�Դϴ�!!");
					break Outter;
				} else if (cancel.equals("0")) {
					break;
				} else {
					System.out.println("�ٽ� �Է��� �ּ���");
				}
			}
		}
		
		
	}
}
