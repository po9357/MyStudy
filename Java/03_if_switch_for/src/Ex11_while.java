
public class Ex11_while {
	public static void main(String[] args) {
		// 반복문: for, while do ~ while
		// break : 반복문을 종료하고 빠져나감(현재 실행중인 반복문에서 빠져나감)
		/* while
		초기값 설정
		while (실행조건문) {
			조건문변수 증감설정 (반복문시작 지검 - 선택)
			실행할 문장;
			조건문변수 증감설정 (반복문끝나는 지점 - 선택)
		}
		 */
		
		//1~10 출력
		for (int i=1; i<=10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("---------------------------------");
		//while 문으로 변경
		int num = 1;
		while (num <=10) {
			System.out.print(num + " ");
			num++;
		}
		System.out.println();
		
		
		System.out.println("--- while문 무한반복 ---");
		num = 1;
		while (true) {
			System.out.print(num + " ");
			if (num == 7) break; //반복 종료하고 빠져나감
			num++;
		}
		
		//-------------------------------
		/*do ~ while : 무조건 1번은 실행
		초기값설정;
		do {
			증감치 설정(실행명령문 전/후)
			실행할 명령문;
		} while (조건문);
		*/
		System.out.println("===========================");
		//1~10까지 출력
		num = 1;
		do {
			System.out.println("do ~ while : "+ num);
			num++;
		} while (num<=10);
		
		System.out.println("--------------------");
		num = 0;
		do {
			num++;
			System.out.println("do ~ while : "+ num);
		} while (num<10);
		
		System.out.println("==== break, continue ====");
		////////////////////////////////////////
		//break : 현재 실행중인 반복문을 종료하고 빠져나감
		//continue : 반복문의 끝으로 이동 후 증감식 또는 조건문 처리
		//			(continue문 이후의 실행문을 실행하지 않음)
		
		//1~10까지 출력 (7까지 출력 후 중단)
		for (int i =1; i<=10; i++) {
			System.out.print(i +" ");
			if (i == 7) break; //7까지 출력 후 반복 종료
		}
		System.out.println();
		//1~10까지 출력 (7만 출력하지 않는다)
		for (int i=1; i<=10; i++) {
			if (i != 7) {
				System.out.print(i +" ");
			}
		}
		System.out.println();
		
		for (int i=1; i<=10; i++) {
			if (i == 7) continue; // 현재위체이서 다음 반복문 시작
			System.out.print(i +" ");
		}
		System.out.println();
	
		System.out.println("----------------------");
		int num2 = 0;
		
		while (num2 < 10) {
			num2++;
			if (num2 == 7) continue; //while문에서 사용시 증감식 처리 이후 사용 (continue)
			System.out.print(num2 + " ");
		}
		System.out.println();
		/////////////////////////////////////////////
		//
		for (int i=1; i<=3; i++) {
			for (int j=1; j<=5; j++) {
				System.out.println("i: "+ i +", j: " +j);
				if (j == 3) break;//안쪽에 있는 for문을 빠져나감
			}
		}
		System.out.println("---------------------");
		//중첩 반복문을 모두 종료하는 경우 (위치지정)
		outFor: //라벨지정
		for (int i=1; i<=3; i++) {
			inFor:
			for (int j=1; j<=5; j++) {
				System.out.println("i: "+ i +", j: " +j);
				if (j == 4) break outFor; //outFor 이름이 있는 for문을 빠져나감
			}
		}
		
		
		
		
		
		
		
	}
}
