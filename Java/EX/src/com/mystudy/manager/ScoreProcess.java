package com.mystudy.manager;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ScoreProcess {

	/* **** ����ó��(ȭ���۾�)
	����ó��(ver 1.0)
	-------------------------------
	 1.��ȸ   2.�Է�   3.����   4.����    0.���� 
	-------------------------------
	>>�۾�����: 
	****************************/
	Scanner sc = new Scanner(System.in);
	StudentManager sm = new StudentManager();
	int button;
	
	public void end() {
		while(true) {
			System.out.println("���� ȭ������ ���ư��ðڽ��ϱ�? (1.�� / 0.����)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				main();
				break;
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("���� 1 Ȥ�� 0�� �Է��Ͽ� �ֽʽÿ�.");
			}
		}
	}
	
	public void exit() {
		System.out.println("�ý����� �����մϴ�.");
		System.exit(0);
	}
	
	public void main() {
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("1.��ȸ\t2.�Է�\t3.����\t4.����\t0.����");
			System.out.println("-------------------------------------");
			System.out.println("���Ͻô� �۾��� �����Ͽ� �ֽʽÿ� (���� 0 ~ 4)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				checkScore();
				end();
				break;
			} else if (button == 2) {
				inputDataMain();
				end();
				break;
			} else if (button == 3) {
				updateData();
				end();
				break;
			} else if (button == 4) {
				removeData();
				break;
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("0 ~ 4 ������ ������ �Է��Ͽ� �ֽʽÿ�.");
			}
		}
	}
	
	public void checkScore() {
		while(true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.�̸����� ��ȸ\t2.id�� ��ȸ\t3.��ü ��ȸ \t0.����");
			System.out.println("-----------------------------------------------------");
			System.out.println("���Ͻô� �۾��� �����Ͽ� �ֽʽÿ� (���� 0 ~ 3)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				System.out.println("�̸��� �Է��Ͽ� �ֽʽÿ�");
				String name = sc.nextLine();
				if (sm.checkName(name)) {
					sm.displayOneName(name);
					break;
				} else {
					System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");
					break;
				}
			} else if (button == 2) {
				System.out.println("id�� �Է��Ͽ� �ֽʽÿ�");
				String id = sc.nextLine();
				if (sm.checkId(id)) {
					sm.displayOne(id);
					break;
				} else {
					System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");
					break;
				}
			} else if (button == 3) {
				sm.printScore();
				break;
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("0 ~ 3 ������ ������ �Է��Ͽ� �ֽʽÿ�.");
			}
		}
	}
	
	public void inputDataMain() {
		StudentVO vo = new StudentVO();
		System.out.println("�����͸� �Է��մϴ�.");
		String id;
		while(true) {
			System.out.println("id�� �Է��Ͽ� �ֽʽÿ�.");
			id = sc.nextLine();
			if (sm.checkId(id)) {
				System.out.println("�ߺ��� id�� �����մϴ�. \n���ο� id�� �Է��Ͽ� �ֽʽÿ�.");
			} else {
				System.out.println("���������� id�Է��� �Ϸ�Ǿ����ϴ�.");
				break;
			}
		}
		System.out.println("�̸��� �Է��Ͽ��ֽʽÿ�.");
		String name = sc.nextLine();
		System.out.println("���� ������ �Է��Ͽ� �ֽʽÿ�.");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.println("���� ������ �Է��Ͽ� �ֽʽÿ�.");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.println("���� ������ �Է��Ͽ� �ֽʽÿ�.");
		int math = Integer.parseInt(sc.nextLine());
		sm.inputData(id, name, kor, eng, math);
		System.out.println("�Է��Ͻ� ������ �Դϴ�.");
		sm.lastData();
	}
	
	public void updateData() {
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("1.�̸����� �Է�\t2.id�� �Է�\t0.����");
			System.out.println("-------------------------------------");
			System.out.println("���Ͻô� �۾��� �����Ͽ� �ֽʽÿ� (���� 0 ~ 2)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				System.out.println("�̸��� �Է��Ͽ� �ֽʽÿ�.");
				String name = sc.nextLine();
				if (sm.checkName(name)) {
					updateDataMain(sm.checkNameInt(name));
					break;
				} else {
					System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");
					break;
				}
			} else if (button == 2) {
				System.out.println("id�� �Է��Ͽ� �ֽʽÿ�.");
				String id = sc.nextLine();
				if (sm.checkId(id)) {
					updateDataMain(sm.checkIdInt(id));
					break;
				} else {
					System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");
					break;
				}
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("0 ~ 2 ������ ������ �Է��Ͽ� �ֽʽÿ�.");
			}
		}
	}
	
	public void updateDataMain(int index) {
		while(true) {
			System.out.println("-----------------------------");
			System.out.println("1.�̸�\t2.����\t3.����\n4.����\t5.��ü\t0.����");
			System.out.println("-----------------------------");
			System.out.println("���Ͻô� �۾��� �����Ͽ� �ֽʽÿ� (���� 0 ~ 5)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				System.out.println("�ٲٷ��� �̸��� �Է��Ͽ� �ֽʽÿ�.");
				String name = sc.nextLine();
				sm.updateName(name, index);
				break;
			} else if (button == 2) {
				System.out.println("�ٲٷ��� ���� ������ �Է��Ͽ� �ֽʽÿ�.");
				int kor = Integer.parseInt(sc.nextLine());
				sm.updateKor(kor, index);
				break;
			} else if (button == 3) {
				System.out.println("�ٲٷ��� ���� ������ �Է��Ͽ� �ֽʽÿ�.");
				int eng = Integer.parseInt(sc.nextLine());
				sm.updateEng(eng, index);
				break;
			} else if (button == 4) {
				System.out.println("�ٲٷ��� ���� ������ �Է��Ͽ� �ֽʽÿ�.");
				int math = Integer.parseInt(sc.nextLine());
				sm.updateMath(math, index);
				break;
			} else if (button == 5) {
				System.out.println("�ٲٷ��� �̸��� �Է��Ͽ� �ֽʽÿ�.");
				String name = sc.nextLine();
				System.out.println("�ٲٷ��� ���� ������ �Է��Ͽ� �ֽʽÿ�.");
				int kor = Integer.parseInt(sc.nextLine());
				System.out.println("�ٲٷ��� ���� ������ �Է��Ͽ� �ֽʽÿ�.");
				int eng = Integer.parseInt(sc.nextLine());
				System.out.println("�ٲٷ��� ���� ������ �Է��Ͽ� �ֽʽÿ�.");
				int math = Integer.parseInt(sc.nextLine());
				sm.updateAll(name, kor, eng, math, index);
				break;
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("0 ~ 5 ������ ������ �Է��Ͽ� �ֽʽÿ�.");
			}
		}
	}
	
	public void removeData() {
		Outter :
		while(true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.�̸����� ��ȸ ����\t2.id�� ��ȸ ����\t3.��ü ���� \t0.����");
			System.out.println("-----------------------------------------------------");
			System.out.println("���Ͻô� �۾��� �����Ͽ� �ֽʽÿ� (���� 0 ~ 3)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				System.out.println("�̸��� �Է��Ͽ� �ֽʽÿ�");
				String name = sc.nextLine();
				if (sm.checkName(name)) {
					System.out.println(name+ "�� �����͸� �����մϴ�.");
					sm.removeData(sm.checkNameInt(name));
					break;
				} else {
					System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");
					break;
				}
			} else if (button == 2) {
				System.out.println("id�� �Է��Ͽ� �ֽʽÿ�");
				String id = sc.nextLine();
				if (sm.checkId(id)) {
					sm.removeData(sm.checkIdInt(id));
					break;
				} else {
					System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");
					break;
				}
			} else if (button == 3) {
				while (true) {
					System.out.println("��ü �����͸� �����Ͻðڽ��ϱ�? (�� : 1 / �ƴϿ� : �ƹ� ����");
					button = Integer.parseInt(sc.nextLine());
					if (button == 1) {
						sm.removeDataAll();
						break Outter;
					} else end();
				}
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("0 ~ 3 ������ ������ �Է��Ͽ� �ֽʽÿ�.");
			}
		}
	}
	
	
}
