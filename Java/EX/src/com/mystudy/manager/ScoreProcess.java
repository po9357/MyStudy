package com.mystudy.manager;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ScoreProcess {

	/* **** 성적처리(화면작업)
	성적처리(ver 1.0)
	-------------------------------
	 1.조회   2.입력   3.수정   4.삭제    0.종료 
	-------------------------------
	>>작업선택: 
	****************************/
	Scanner sc = new Scanner(System.in);
	StudentManager sm = new StudentManager();
	int button;
	
	public void end() {
		while(true) {
			System.out.println("메인 화면으로 돌아가시겠습니까? (1.예 / 0.종료)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				main();
				break;
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("숫자 1 혹은 0을 입력하여 주십시오.");
			}
		}
	}
	
	public void exit() {
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
	}
	
	public void main() {
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("1.조회\t2.입력\t3.수정\t4.삭제\t0.종료");
			System.out.println("-------------------------------------");
			System.out.println("원하시는 작업을 선택하여 주십시오 (숫자 0 ~ 4)");
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
				System.out.println("0 ~ 4 사이의 정수를 입력하여 주십시오.");
			}
		}
	}
	
	public void checkScore() {
		while(true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.이름으로 조회\t2.id로 조회\t3.전체 조회 \t0.종료");
			System.out.println("-----------------------------------------------------");
			System.out.println("원하시는 작업을 선택하여 주십시오 (숫자 0 ~ 3)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				System.out.println("이름을 입력하여 주십시오");
				String name = sc.nextLine();
				if (sm.checkName(name)) {
					sm.displayOneName(name);
					break;
				} else {
					System.out.println("일치하는 데이터가 없습니다.");
					break;
				}
			} else if (button == 2) {
				System.out.println("id를 입력하여 주십시오");
				String id = sc.nextLine();
				if (sm.checkId(id)) {
					sm.displayOne(id);
					break;
				} else {
					System.out.println("일치하는 데이터가 없습니다.");
					break;
				}
			} else if (button == 3) {
				sm.printScore();
				break;
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("0 ~ 3 사이의 정수를 입력하여 주십시오.");
			}
		}
	}
	
	public void inputDataMain() {
		StudentVO vo = new StudentVO();
		System.out.println("데이터를 입력합니다.");
		String id;
		while(true) {
			System.out.println("id를 입력하여 주십시오.");
			id = sc.nextLine();
			if (sm.checkId(id)) {
				System.out.println("중복된 id가 존재합니다. \n새로운 id를 입력하여 주십시오.");
			} else {
				System.out.println("정상적으로 id입력이 완료되었습니다.");
				break;
			}
		}
		System.out.println("이름을 입력하여주십시오.");
		String name = sc.nextLine();
		System.out.println("국어 점수를 입력하여 주십시오.");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.println("영어 점수를 입력하여 주십시오.");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.println("수학 점수를 입력하여 주십시오.");
		int math = Integer.parseInt(sc.nextLine());
		sm.inputData(id, name, kor, eng, math);
		System.out.println("입력하신 데이터 입니다.");
		sm.lastData();
	}
	
	public void updateData() {
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("1.이름으로 입력\t2.id로 입력\t0.종료");
			System.out.println("-------------------------------------");
			System.out.println("원하시는 작업을 선택하여 주십시오 (숫자 0 ~ 2)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				System.out.println("이름을 입력하여 주십시오.");
				String name = sc.nextLine();
				if (sm.checkName(name)) {
					updateDataMain(sm.checkNameInt(name));
					break;
				} else {
					System.out.println("일치하는 데이터가 없습니다.");
					break;
				}
			} else if (button == 2) {
				System.out.println("id를 입력하여 주십시오.");
				String id = sc.nextLine();
				if (sm.checkId(id)) {
					updateDataMain(sm.checkIdInt(id));
					break;
				} else {
					System.out.println("일치하는 데이터가 없습니다.");
					break;
				}
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("0 ~ 2 사이의 정수를 입력하여 주십시오.");
			}
		}
	}
	
	public void updateDataMain(int index) {
		while(true) {
			System.out.println("-----------------------------");
			System.out.println("1.이름\t2.국어\t3.영어\n4.수학\t5.전체\t0.종료");
			System.out.println("-----------------------------");
			System.out.println("원하시는 작업을 선택하여 주십시오 (숫자 0 ~ 5)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				System.out.println("바꾸려는 이름을 입력하여 주십시오.");
				String name = sc.nextLine();
				sm.updateName(name, index);
				break;
			} else if (button == 2) {
				System.out.println("바꾸려는 국어 점수를 입력하여 주십시오.");
				int kor = Integer.parseInt(sc.nextLine());
				sm.updateKor(kor, index);
				break;
			} else if (button == 3) {
				System.out.println("바꾸려는 영어 점수를 입력하여 주십시오.");
				int eng = Integer.parseInt(sc.nextLine());
				sm.updateEng(eng, index);
				break;
			} else if (button == 4) {
				System.out.println("바꾸려는 수학 점수를 입력하여 주십시오.");
				int math = Integer.parseInt(sc.nextLine());
				sm.updateMath(math, index);
				break;
			} else if (button == 5) {
				System.out.println("바꾸려는 이름을 입력하여 주십시오.");
				String name = sc.nextLine();
				System.out.println("바꾸려는 국어 점수를 입력하여 주십시오.");
				int kor = Integer.parseInt(sc.nextLine());
				System.out.println("바꾸려는 영어 점수를 입력하여 주십시오.");
				int eng = Integer.parseInt(sc.nextLine());
				System.out.println("바꾸려는 수학 점수를 입력하여 주십시오.");
				int math = Integer.parseInt(sc.nextLine());
				sm.updateAll(name, kor, eng, math, index);
				break;
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("0 ~ 5 사이의 정수를 입력하여 주십시오.");
			}
		}
	}
	
	public void removeData() {
		Outter :
		while(true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.이름으로 조회 삭제\t2.id로 조회 삭제\t3.전체 삭제 \t0.종료");
			System.out.println("-----------------------------------------------------");
			System.out.println("원하시는 작업을 선택하여 주십시오 (숫자 0 ~ 3)");
			button = Integer.parseInt(sc.nextLine());
			if (button == 1) {
				System.out.println("이름을 입력하여 주십시오");
				String name = sc.nextLine();
				if (sm.checkName(name)) {
					System.out.println(name+ "의 데이터를 삭제합니다.");
					sm.removeData(sm.checkNameInt(name));
					break;
				} else {
					System.out.println("일치하는 데이터가 없습니다.");
					break;
				}
			} else if (button == 2) {
				System.out.println("id를 입력하여 주십시오");
				String id = sc.nextLine();
				if (sm.checkId(id)) {
					sm.removeData(sm.checkIdInt(id));
					break;
				} else {
					System.out.println("일치하는 데이터가 없습니다.");
					break;
				}
			} else if (button == 3) {
				while (true) {
					System.out.println("전체 데이터를 삭제하시겠습니까? (예 : 1 / 아니오 : 아무 숫자");
					button = Integer.parseInt(sc.nextLine());
					if (button == 1) {
						sm.removeDataAll();
						break Outter;
					} else end();
				}
			} else if (button == 0) {
				exit();
			} else {
				System.out.println("0 ~ 3 사이의 정수를 입력하여 주십시오.");
			}
		}
	}
	
	
}
