import java.util.*;

public class My_Ex_baseball {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String com;
		String input;
		
		
		char chc1;
		char chc2;
		char chc3;
		char chc4;
		while(true) {
			System.out.println("중복된 수가 없는 4자리 정수를 생성중입니다.(1000 ~ 9999)");
			com = (int)(Math.random()*9000+1000)+"";
		 	chc1 = com.charAt(0);
		 	chc2 = com.charAt(1);
		 	chc3 = com.charAt(2);
		 	chc4 = com.charAt(3);
		 	
		 	if (!(chc1==chc2 || chc1==chc3 || chc1==chc4 || chc2==chc3 || chc2==chc4 || chc3==chc4))
		 		break;
		}
		
		while(true){
			System.out.println("1000 ~ 9999사이의 4자리 정수를 입력하여 주십시오.");
			input = sc.nextLine();
			char chi1 = input.charAt(0);
			char chi2 = input.charAt(1);
			char chi3 = input.charAt(2);
			char chi4 = input.charAt(3);
		
			if (com.equals(input)) {
				System.out.println("정답입니다!!");
				break;
			}
			
			if (chi1=='1' && chi2=='1' && chi3=='1' && chi4=='1') {
				System.out.println(com);
			}
			
			if (chi1 == chc1) {
				System.out.println("Strike");
			}else if (chi1==chc2 || chi1==chc3 || chi1==chc4) {
				System.out.println("ball");
			}
			
			if (chi2 == chc2) {
				System.out.println("Strike");
			}else if (chi2==chc1 || chi2==chc3 || chi2==chc4) {
				System.out.println("ball");
			}
			
			if (chi3 == chc3) {
				System.out.println("Strike");
			}else if (chi3==chc1 || chi3==chc2 || chi3==chc4) {
				System.out.println("ball");
			}
			
			if (chi4 == chc4) {
				System.out.println("Strike");
			}else if (chi4==chc1 || chi4==chc2 || chi4==chc3) {
				System.out.println("ball");
			}
		
		}
		
	}
}
