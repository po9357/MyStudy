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
			System.out.println("��ǻ�Ͱ� 1 ~ 100���� ������ ������ �����߽��ϴ�.");
			System.out.println("1 ~ 100 ���� ������ �Է��Ͽ� �ֽʽÿ�.");
			inner:
			while (true) {
				if (cnt < max) {
					System.out.println(cnt +"�� ° ��ȸ�Դϴ�.");
					input = sc.nextInt();
					while (input <= 0 || input > 100) {		//���� ����
						System.out.println("1 ~ 100 ���� ������ �Է��Ͽ� �ֽʽÿ�.");
						input = sc.nextInt();
					}
					
					if (input > com) {						//�Է��� ���� ���亸�� Ŭ ���
						System.out.println("�� ���� ���ڸ� �Է��Ͽ� �ֽʽÿ�."+ (max - cnt)+"�� ��ȸ ���ҽ��ϴ�");
						cnt++;
					} else if (input < com) {				//�Է��� ���� ���亸�� ���� ���
						System.out.println("�� ���� ���ڸ� �Է��Ͽ� �ֽʽÿ�."+ (max - cnt)+"�� ��ȸ ���ҽ��ϴ�");
						cnt++;
					} else {								//������ ���
						win++;
						System.out.println("�����Դϴ�!!!"+ cnt+ "�� ° ���� ���߼̽��ϴ�!");
						System.out.println("���� ������ "+ win +"��, "+ lose+ "�� �Դϴ�.");
						System.out.println("������ ��� �Ͻ÷��� 1�� �Է��Ͽ� �ֽʽÿ�");
						chance = sc.nextInt();
						if (chance == 1) {
							break inner;
						} else {
							System.out.println("������ �����մϴ�.");
							break outter;
						}
					}
				} else {
					System.out.println("������ ��ȸ�Դϴ�.");
					input = sc.nextInt();
					while (input <= 0 || input > 100) {		//���� ����
						System.out.println("1 ~ 100 ���� ������ �Է��Ͽ� �ֽʽÿ�.");
						input = sc.nextInt();
					}
					if (input == com){								//������ ���
						win++;
						System.out.println("�����Դϴ�!!!"+ cnt+ "�� ° ���� ���߼̽��ϴ�!");
						System.out.println("���� ������ "+ win +"��, "+ lose+ "�� �Դϴ�.");
						System.out.println("������ ��� �Ͻ÷��� 1�� �Է��Ͽ� �ֽʽÿ�");
						chance = sc.nextInt();
						if (chance == 1) {
							break inner;
						} else {
							System.out.println("������ �����մϴ�.");
							break outter;
						}
					} else {						//��ȸ�� ��� �Ҹ����� ���
						lose++;
						System.out.println("Ʋ�Ƚ��ϴ�! ������ "+ com+ "�̾����ϴ�!\n���� ������ "+ win +"��, "+ lose+ "�� �Դϴ�.\n���ο� ������ �Ͻ÷��� 1�� �Է��Ͽ� �ֽʽÿ�");
						chance = sc.nextInt();
						if (chance == 1) {
							break inner;
						} else {
							System.out.println("������ �����մϴ�.");
							break outter;
						}
					}
				}
			}	//inner while ��
		}	//outter while ��
		
	}	//main ��
}	//class ��
