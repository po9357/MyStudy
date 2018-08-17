
public class Ex06_for_sum {

	public static void main(String[] args) {
		//문제: 1~10까지의 합계를 구하시오(화면출력)
		//System.out.println(55);
		//System.out.println("1~10까지 합계: " + (1+2+3+4+5+6+7+8+9+10));
		//힌트
		int num = 0;
		int sum = 0;
		
//		num = num + 1;
//		sum = sum + num; //sum 누적
//		System.out.println(sum);
		
		//최종 프로그램 결과
		for (int i=1; i<=10; i++) {
			sum = sum + i;
		}
		System.out.println("1~10까지의 합계 : " + sum);
		
		//---------------------
		System.out.println("====================");
		num = 1; //1~10까지 변하는 수
		sum = 0; //누적한 값을 저장할 변수
/*		
		//반복: 1
		sum = sum + num; //sum = 0 + 1
		System.out.println("sum: " + sum);
		num = num + 1; //num: 2 -  num++, num += 1 
		
		//반복: 2
		sum = sum + num; //sum = (0 + 1) + 2
		System.out.println("sum: " + sum);
		num = num + 1; //num: 3 -  num++, num += 1 
		
		//반복: 3
		sum = sum + num; //sum = (0 + 1 + 2) + 3
		System.out.println("sum: " + sum);
		num = num + 1; //num: 3 -  num++, num += 1 
*/
		
		for (int i=1; i<=10; i++) {
			sum = sum + num; 
			System.out.println("i: "+ i +", num: "+ num + ", sum: " + sum);
			num = num + 1; 
		}
		System.out.println("1~10까지의 합계: " + sum);
		
		System.out.println(">>>>> ");
		sum = 0;
		for (int i=1; i<=10; i++) {
			sum = sum + i; 
			System.out.println("i: "+ i +", sum: " + sum);
		}
		System.out.println("1~10까지의 합계: " + sum);
		
		//-------------------------
		//10 ~ 1 출력(for문)
		/*
		10
		9
		8
		...
		1
		*/
		
		System.out.println("====================");
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
		System.out.println();
		System.out.print(4);
		System.out.print(5);
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
