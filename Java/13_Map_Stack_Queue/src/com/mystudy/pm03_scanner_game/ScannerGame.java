package com.mystudy.pm03_scanner_game;

import java.util.Scanner;

public class ScannerGame {

	public static void main(String[] args) {
		//Scanner�� �̿��� ���� ���� �� ����
		//��ǻ�Ϳ� �Բ��ϴ� ����(1),����(2),��(3) ����
		//1. ����, ����, �� ���� �޴� ���
		//2. ���ð� �Է�
		//3. ��ǻ�͵� ����(Math.random())
		//4. ��� ���� ����, ���� ����
		////////////////////////////////
		
		//1. ����, ����, �� ���� �޴� ���
		System.out.println("����, ����, �� �߿� �ϳ��� �����ϼ���.");
		System.out.println("1.����  2.����  3.��");
		System.out.print(">>����� ������(1~3)? ");
		
		//2. ���ð� �Է�
		Scanner sc = new Scanner(System.in);
		int select = Integer.parseInt(sc.nextLine());
		
		String strPerson = "";
		if (select == 1) {
			strPerson = "����";
		} else if (select == 2) {
			strPerson = "����";
		} else if (select == 3) {
			strPerson = "��";
		} else {
			System.out.println("1 ~ 3 �߿��� �����ϼ���");
			return;
		}
		
		//3. ��ǻ�͵� ����(Math.random())
		int comSelect = (int)(Math.random() * 3 + 1);
		String strComputer = "";
		switch (comSelect) {
		case 1:
			strComputer = "����";
			break;
		case 2:
			strComputer = "����";
			break;
		case 3:
			strComputer = "��";
			break;
		default:
			System.out.println("1 ~ 3 �߿��� �����ϼ���");
		}
		System.out.println("���: " + strPerson + ", ��ǻ��: " + strComputer);
			
		//4. ��� �� �� ����, ���� ����
		//����� '����'�� ���
		String result = "";
		if (strPerson.equals("����")) {
			//��ǻ�� : ����, ����, ��
			if (strComputer.equals("����")) {
				result = "���";
			}
			if (strComputer.equals("����")) {
				result = "��";
			}
			if (strComputer.equals("��")) {
				result = "�̱�";
			}
		}
		
		if (strPerson.equals("����")) {
			//��ǻ�� : ����, ����, ��
			if (strComputer.equals("����")) {
				result = "�̱�";
			}
			if (strComputer.equals("����")) {
				result = "���";
			}
			if (strComputer.equals("��")) {
				result = "��";
			}
		}
		
		if (strPerson.equals("��")) {
			//��ǻ�� : ����, ����, ��
			if (strComputer.equals("����")) {
				result = "��";
			}
			if (strComputer.equals("����")) {
				result = "�̱�";
			}
			if (strComputer.equals("��")) {
				result = "���";
			}
		}
		
		
		
		
		
		
		
		
	}

}
