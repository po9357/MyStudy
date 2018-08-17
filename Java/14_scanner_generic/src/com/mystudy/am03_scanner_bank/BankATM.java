package com.mystudy.am03_scanner_bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankATM {

	public static void main(String[] args) {
		// 은행의 ATM
		//1. 입금 	2. 출금 		3. 통장확인 	0. 종료
		//----------------------------------------
		//계좌를 하나 만들고 입금/출금/통장확인/종료
		Scanner sc = new Scanner(System.in);
		BankFuntion bf = new BankFuntion();
		
		bf.Menu();
//		통장 이름 계좌번호 비밀번호 잔액
 
	}

}

class BankFuntion{
	private List<BankVO> list = new ArrayList<BankVO>();
	BankVO newAcc = new BankVO();
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	int button;
	
	
	public BankFuntion () {
		list.add(new BankVO("1234-5678", "홍길동", 1234, 0));
		list.add(new BankVO("5678-5678", "베브릿지", 5678, 10000));
		list.add(new BankVO("1234-1234", "커피", 4321, 50000));
		list.add(new BankVO("8765-4321", "아메리카노", 8765, 123));
		list.add(new BankVO("8765-8765", "모니터", 7913, 587));
		list.add(new BankVO("4321-4321", "컴퓨터", 1346, 97000));
	}
	
	public void SignUp() {
		String newName;
		int newPsw;
		int newPsw2;
		
		System.out.println("이름을 입력하여 주십시오.");
		newName = sc.nextLine();
		while (true) {
			System.out.println("새로운 비밀 번호 4자리를 입력하여 주십시오.");
			newPsw = Integer.parseInt(sc.nextLine());
			System.out.println("비밀 번호4자리를 다시 입력하여 주십시오.");
			newPsw2 = Integer.parseInt(sc.nextLine());
			if (newPsw == newPsw2) {
				System.out.println("비밀 번호 입력이 완료되었습니다.");
				break;
			} else System.out.println("비밀번호 설정을 다시 시작합니다.");
		}
		BankVO newAcc = new BankVO(addAccNum(), newName, newPsw2);
		list.add(newAcc);
	}
	
	String addAccNum() {
		String newAccNum;
		Outter:
		while (true) {
			System.out.println("계좌번호를 생성중입니다.");
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
					System.out.println("계좌 생성이 완료되었습니다.");
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
		System.out.println(money+ "원을 입금합니다.");
		list.get(i).getMoney(money);
		
		System.out.println("입금되었습니다. 현재 잔액은"+list.get(i).getMoney() + "원 입니다.");
	}
	
	public void OutMoney (int i, int money) {
		System.out.println(money+ "원을 출금합니다.");
		list.get(i).outMoney(money);
		if (list.get(i).getMoney() < 0) {
			System.out.println("잔액이 부족하여 출금할 수 없습니다.");
			list.get(i).getMoney(money);
		} else System.out.println("출금되었습니다. 현재 잔액은"+ list.get(i).getMoney()+ "원 입니다.");
	}
	
	public void CheckMoney (int i) {
		System.out.println("현재 잔액은 "+ list.get(i).getMoney() +"원 입니다.");
	}
	
	//비밀번호 조회
	public void ComparePsw(Integer psw) {
		int i;
		while (true) {
			try {
			for (i = 0; i < list.size(); i++) {
				if (psw == list.get(i).getPsw()) {
					System.out.println("\n비밀번호가 확인되었습니다.");
						Menu(i);
						return;
					} else System.out.print("-");
				}
				System.out.println("비밀 번호를 다시 입력하여 주십시오");
				psw = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			System.out.println("숫자만 입력하여 주십시오.");
			continue;
			}
		}
	}
	
	//이름으로 조회
	public void CompareName(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (name.equals(list.get(i).getName())) {
				System.out.println("\n이름이 확인되었습니다.");
				return;
			} else System.out.print("-");
		}
		int yesNo;
		System.out.println("회원 등록이 되어있지 않습니다.");
		System.out.println("회원가입을 하시겠습니까? (1 : 네/ 2 : 아니오)");
		yesNo = Integer.parseInt(sc.nextLine());
		while (true) {
			if (yesNo == 1) {
				SignUp();
				break;
			} else if (yesNo == 2) {
				System.out.println("메인 화면으로 돌아가시겠습니까?\n(1 : 네 , 2 : 종료)");
				yesNo = Integer.parseInt(sc.nextLine());
				while (true) {
					if (yesNo == 1) {
						Menu();
						return;
					} else if (yesNo == 2) {
						System.out.println("시스템을 종료합니다.");
						System.exit(0);
					} else System.out.println("숫자를 다시 눌러주십시오.");
				}
			} else System.out.println("숫자를 다시 눌러주십시오.");
		}
	}
	
	
	public void Menu(int i) {
		Outter:
		while (true) {
			while (true) {
				try {
					if (button == 1) {
						System.out.println("입금할 금액을 입력하십시오.");
						InMoney(i, Integer.parseInt(sc.nextLine()));
						break Outter;
					} else if (button == 2) {
						System.out.println("출금할 금액을 입력하십시오.");
						OutMoney(i, Integer.parseInt(sc.nextLine()));
						break Outter;
					} else if (button == 3) {
						CheckMoney(i);
						break Outter;
					} else if (button == 4) {
						System.exit(0);
					} else {
						System.out.println("다시 입력하여 주십시오.");
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("숫자만 입력하여 주십시오.");
				}
			}
		}
		 
	}
	
	public void Menu() {
		while (true) {
			try {
				System.out.println("------------------------------");
				System.out.println("1. 입금   2. 출금   3. 통장확인   4. 종료");
				System.out.println("------------------------------");
				button = Integer.parseInt(sc.nextLine());
				while (true) {
					if (button == 1) {
						System.out.println("이름을 입력하여 주십시오.");
						CompareName(sc.nextLine());
						System.out.println("비밀번호를 입력하여 주십시오.");
						ComparePsw(Integer.parseInt(sc.nextLine()));
						break;
					} else if (button == 2) {
						System.out.println("이름을 입력하여 주십시오.");
						CompareName(sc.nextLine());
						System.out.println("비밀번호를 입력하여 주십시오.");
						ComparePsw(Integer.parseInt(sc.nextLine()));
						break;
					} else if (button == 3) {
						System.out.println("이름을 입력하여 주십시오.");
						CompareName(sc.nextLine());
						System.out.println("비밀번호를 입력하여 주십시오.");
						ComparePsw(Integer.parseInt(sc.nextLine()));
						break;
					} else if (button == 4) {
						System.out.println("시스템을 종료합니다.");
						System.exit(0);
					} else {
						System.out.println("다시 입력하여 주십시오.");
						break;
					}
				}
			} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하여 주십시오.");
			}
		}
	}
}
	
	
	


