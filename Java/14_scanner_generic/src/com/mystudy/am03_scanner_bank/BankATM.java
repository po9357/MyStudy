package com.mystudy.am03_scanner_bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankATM {

	public static void main(String[] args) {
		// ������ ATM
		//1. �Ա� 	2. ��� 		3. ����Ȯ�� 	0. ����
		//----------------------------------------
		//���¸� �ϳ� ����� �Ա�/���/����Ȯ��/����
		Scanner sc = new Scanner(System.in);
		BankFuntion bf = new BankFuntion();
		
		bf.Menu();
//		���� �̸� ���¹�ȣ ��й�ȣ �ܾ�
 
	}

}

class BankFuntion{
	private List<BankVO> list = new ArrayList<BankVO>();
	BankVO newAcc = new BankVO();
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	int button;
	
	
	public BankFuntion () {
		list.add(new BankVO("1234-5678", "ȫ�浿", 1234, 0));
		list.add(new BankVO("5678-5678", "���긴��", 5678, 10000));
		list.add(new BankVO("1234-1234", "Ŀ��", 4321, 50000));
		list.add(new BankVO("8765-4321", "�Ƹ޸�ī��", 8765, 123));
		list.add(new BankVO("8765-8765", "�����", 7913, 587));
		list.add(new BankVO("4321-4321", "��ǻ��", 1346, 97000));
	}
	
	public void SignUp() {
		String newName;
		int newPsw;
		int newPsw2;
		
		System.out.println("�̸��� �Է��Ͽ� �ֽʽÿ�.");
		newName = sc.nextLine();
		while (true) {
			System.out.println("���ο� ��� ��ȣ 4�ڸ��� �Է��Ͽ� �ֽʽÿ�.");
			newPsw = Integer.parseInt(sc.nextLine());
			System.out.println("��� ��ȣ4�ڸ��� �ٽ� �Է��Ͽ� �ֽʽÿ�.");
			newPsw2 = Integer.parseInt(sc.nextLine());
			if (newPsw == newPsw2) {
				System.out.println("��� ��ȣ �Է��� �Ϸ�Ǿ����ϴ�.");
				break;
			} else System.out.println("��й�ȣ ������ �ٽ� �����մϴ�.");
		}
		BankVO newAcc = new BankVO(addAccNum(), newName, newPsw2);
		list.add(newAcc);
	}
	
	String addAccNum() {
		String newAccNum;
		Outter:
		while (true) {
			System.out.println("���¹�ȣ�� �������Դϴ�.");
			char[] accN = new char[9];
			for (int i = 0; i < accN.length; i++) {
				accN[i] = (char)((int)(Math.random()*10));
			}
			accN[4] = '-';
			newAccNum = String.valueOf(accN);
			for (int i = 0; i < list.size(); i++) {
				if (String.valueOf(accN).equals(list.get(i).getAccNum())) {
					break;
				} else {
					System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
					break Outter;
				}
			}
		}
		return newAccNum;
	}
	
	void inputData(BankVO vo) {
		list.add(vo);
	}
	
	
	
	public void AddAcc (String accNum, String name, int psw, int money) {
		list.add(new BankVO(accNum, name, psw, money));
	}
	
	public void InMoney (int i, int money) {
		System.out.println(money+ "���� �Ա��մϴ�.");
		list.get(i).getMoney(money);
		
		System.out.println("�ԱݵǾ����ϴ�. ���� �ܾ���"+list.get(i).getMoney() + "�� �Դϴ�.");
	}
	
	public void OutMoney (int i, int money) {
		System.out.println(money+ "���� ����մϴ�.");
		list.get(i).outMoney(money);
		if (list.get(i).getMoney() < 0) {
			System.out.println("�ܾ��� �����Ͽ� ����� �� �����ϴ�.");
			list.get(i).getMoney(money);
		} else System.out.println("��ݵǾ����ϴ�. ���� �ܾ���"+ list.get(i).getMoney()+ "�� �Դϴ�.");
	}
	
	public void CheckMoney (int i) {
		System.out.println("���� �ܾ��� "+ list.get(i).getMoney() +"�� �Դϴ�.");
	}
	
	//��й�ȣ ��ȸ
	public void ComparePsw(Integer psw) {
		int i;
		while (true) {
			try {
			for (i = 0; i < list.size(); i++) {
				if (psw == list.get(i).getPsw()) {
					System.out.println("\n��й�ȣ�� Ȯ�εǾ����ϴ�.");
						Menu(i);
						return;
					} else System.out.print("-");
				}
				System.out.println("��� ��ȣ�� �ٽ� �Է��Ͽ� �ֽʽÿ�");
				psw = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��Ͽ� �ֽʽÿ�.");
			continue;
			}
		}
	}
	
	//�̸����� ��ȸ
	public void CompareName(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())) {
				System.out.println("\n�̸��� Ȯ�εǾ����ϴ�.");
				return;
			} else System.out.print("-");
		}
		int yesNo;
		System.out.println("ȸ�� ����� �Ǿ����� �ʽ��ϴ�.");
		System.out.println("ȸ�������� �Ͻðڽ��ϱ�? (1 : ��/ 2 : �ƴϿ�)");
		yesNo = Integer.parseInt(sc.nextLine());
		while (true) {
			if (yesNo == 1) {
				SignUp();
				break;
			} else if (yesNo == 2) {
				System.out.println("���� ȭ������ ���ư��ðڽ��ϱ�?\n(1 : �� , 2 : ����)");
				yesNo = Integer.parseInt(sc.nextLine());
				while (true) {
					if (yesNo == 1) {
						Menu();
						return;
					} else if (yesNo == 2) {
						System.out.println("�ý����� �����մϴ�.");
						System.exit(0);
					} else System.out.println("���ڸ� �ٽ� �����ֽʽÿ�.");
				}
			} else System.out.println("���ڸ� �ٽ� �����ֽʽÿ�.");
		}
	}
	
	
	public void Menu(int i) {
		Outter:
		while (true) {
			while (true) {
				try {
					if (button == 1) {
						System.out.println("�Ա��� �ݾ��� �Է��Ͻʽÿ�.");
						InMoney(i, Integer.parseInt(sc.nextLine()));
						break Outter;
					} else if (button == 2) {
						System.out.println("����� �ݾ��� �Է��Ͻʽÿ�.");
						OutMoney(i, Integer.parseInt(sc.nextLine()));
						break Outter;
					} else if (button == 3) {
						CheckMoney(i);
						break Outter;
					} else if (button == 4) {
						System.exit(0);
					} else {
						System.out.println("�ٽ� �Է��Ͽ� �ֽʽÿ�.");
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("���ڸ� �Է��Ͽ� �ֽʽÿ�.");
				}
			}
		}
		 
	}
	
	public void Menu() {
		while (true) {
			try {
				System.out.println("------------------------------");
				System.out.println("1. �Ա�   2. ���   3. ����Ȯ��   4. ����");
				System.out.println("------------------------------");
				button = Integer.parseInt(sc.nextLine());
				while (true) {
					if (button == 1) {
						System.out.println("�̸��� �Է��Ͽ� �ֽʽÿ�.");
						CompareName(sc.nextLine());
						System.out.println("��й�ȣ�� �Է��Ͽ� �ֽʽÿ�.");
						ComparePsw(Integer.parseInt(sc.nextLine()));
						break;
					} else if (button == 2) {
						System.out.println("�̸��� �Է��Ͽ� �ֽʽÿ�.");
						CompareName(sc.nextLine());
						System.out.println("��й�ȣ�� �Է��Ͽ� �ֽʽÿ�.");
						ComparePsw(Integer.parseInt(sc.nextLine()));
						break;
					} else if (button == 3) {
						System.out.println("�̸��� �Է��Ͽ� �ֽʽÿ�.");
						CompareName(sc.nextLine());
						System.out.println("��й�ȣ�� �Է��Ͽ� �ֽʽÿ�.");
						ComparePsw(Integer.parseInt(sc.nextLine()));
						break;
					} else if (button == 4) {
						System.out.println("�ý����� �����մϴ�.");
						System.exit(0);
					} else {
						System.out.println("�ٽ� �Է��Ͽ� �ֽʽÿ�.");
						break;
					}
				}
			} catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��Ͽ� �ֽʽÿ�.");
			}
		}
	}
}
	
	
	


