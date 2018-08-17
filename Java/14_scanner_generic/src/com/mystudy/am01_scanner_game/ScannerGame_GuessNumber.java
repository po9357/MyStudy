package com.mystudy.am01_scanner_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//[�ǽ�] ���� ���߱� ����
public class ScannerGame_GuessNumber {

	public static void main(String[] args) {
		//��ǻ�Ͱ� 1~100 ������ ���ڸ� ���ϸ� ����� ���ߴ� ����
		//���� ��ȸ 5ȸ
		//�ļ��� : 70 �� ��� -Math.random()
		//����� ������ ���ڰ� ũ��(80) : �۴ٴ� �޽��� ���
		//����� ������ ���ڰ� ������(50) : ũ�ٴ� �޽��� ���
		//5�� �̳��� ���߸� : ����!!! n�� ���� ������ϴ�.(ȭ�����)
		//5���� �ѱ�� : ����~~ ���� ������ ���ڴ� 70�Դϴ�.(ȭ�����)
		//-----
		//�ٽ� �����Ͻðڽ��ϱ�?(y,n) 
		//////////////////////////////////////////
		/* 
		1~100���� ���� �߿� �ϳ��� �����߽��ϴ�. ���纸����!!!
		���� �Է�(1~100) : 80
		>> 80���� �۽��ϴ�.
		�����Է� : 50
		>> 50���� Ů�ϴ�.
		...
		�����Է� : 73 - 5��°�õ�
		>> ����~~ ���� ������ ���ڴ� 70�Դϴ�.
		---
		�����Է� : 70 - 5��°�õ�
		>> ����!! 5�� ���� ������ϴ�.
		*/
		////////////////////////////////////////////
		int comNo = 0;
		int meNo = 0;
		int tryCnt = 0;
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			tryCnt = 0;
			//1. �޽��� ��� �� ��ǻ�Ͱ� 1~100���� ���� �� �ϳ��� �����ؼ� ���ϱ�
			comNo = (int)(Math.random() * 100) + 1;
			System.out.println("1~100���� ���� �߿� �ϳ��� �����߽��ϴ�."+
					" ���纸����");
			System.out.println("��ǻ�� ���� ����: " + comNo);
			
			while (tryCnt < 5) {
				tryCnt++; //1~
				if (tryCnt < 5) {
					//2. ������� �����ϵ��� �޽��� ���, ���� �Է� �ޱ�
					System.out.print("("+ tryCnt + "��°)���ڸ� ���� : ");
					meNo = Integer.parseInt(scan.nextLine());
					
					//3. �Է��� ���� ��ǻ���� ���� ��(>, ==, <)
					if (comNo > meNo) {
						System.out.println(">> " + meNo+ "���� Ů�ϴ�.");
					}
					if (comNo < meNo) {
						System.out.println(">> " + meNo+ "���� �۽��ϴ�.");
					}
					if (comNo == meNo) {
						System.out.println(">> ������ϴ�.");
						System.out.println("������ �����մϴ�. �ٽ� �����ϼ���");
						break;
					}
				} else {
					//5��° ó�� --------------------------------
					//���� : �����մϴ�. n��° �õ��� ���� 
					//���� : ����~~ ���� ������ ���ڴ� xx�Դϴ�.
					//���� : ������ ����
					//-----------------------------------------
					//2. ������� �����ϵ��� �޽��� ���, ���� �Է� �ޱ�
					System.out.print("(������)���ڸ� ���� : ");
					meNo = Integer.parseInt(scan.nextLine());
					
					//3. �Է��� ���� ��ǻ���� ���� ��(>, ==, <)
					if (comNo > meNo) {
						System.out.println(">> ����~~ ���� ������ ���ڴ� "
								+ comNo + "�Դϴ�");
					}
					if (comNo < meNo) {
						System.out.println(">> ����~~ ���� ������ ���ڴ� "
								+ comNo + "�Դϴ�");
					}
					if (comNo == meNo) {
						System.out.println(">> ������ϴ�.");
						System.out.println("������ �����մϴ�. �ٽ� �����ϼ���");
					}
					break; //while ����
				}
			}
			System.out.println("-------------------");
			System.out.print(">> �ٽ� �����Ͻðڽ��ϱ�?(y/n) ");
			String tryYesNo = scan.nextLine();
			if ("n".equalsIgnoreCase(tryYesNo)) {
				System.out.println(">>������ �����߽��ϴ�.");
				break;
			}
			System.out.println();
		}
	}//main end

}//class end




