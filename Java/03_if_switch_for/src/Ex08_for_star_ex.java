
public class Ex08_for_star_ex {

	public static void main(String[] args) {
		//문제 ----------------------------
		//*****
		//****
		//***
		//**
		//*
		int lineCnt = 10;
		int starCnt = lineCnt;
		String dispStr = "#";
		
		for (int line=1; line<=lineCnt; line++) {
			for (int star=1; star<=starCnt; star++) {
				System.out.print(dispStr);
			}
			System.out.println();
			starCnt--;
		}
		
		System.out.println("------------------");
		//문제 ----------------------------
		//    *
		//   **
		//  ***
		// ****
		//*****
		
		int spaceCnt = 4;
		starCnt = 1;
		
		for (int line=1; line<=5; line++) {
			for (int space=1; space<=spaceCnt; space++) {
				System.out.print(" ");
			}
			for (int star=1; star<=starCnt; star++) {
				System.out.print("*");
			}
			System.out.println();
			spaceCnt--;
			starCnt++;
		}
		
		
		//문제 ----------------------------
		//*****
		// ****
		//  ***
		//   **
		//    *
		spaceCnt = 0;
		starCnt = 5;
		
		for (int line=1; line<=5; line++) {
			for (int space=1; space<=spaceCnt; space++) {
				System.out.print(" ");
			}
			for (int star=1; star<=starCnt; star++) {
				System.out.print("*");
			}
			System.out.println();
			spaceCnt++;
			starCnt--;
		}
		
		System.out.println("==================");
		//문제 ----------------------------
		//1 
		//1 2
		//1 2 3
		//1 2 3 4
		int dispNumCnt = 1;
		for (int line=3; line<=8; line++) {
			for (int dispNum=1; dispNum<=dispNumCnt; dispNum++) {
				System.out.print(dispNum);
				System.out.print(" ");
			}
			System.out.println();
			dispNumCnt++;
		}
		System.out.println();
		
		for (int line=3; line<=8; line++) {
			for (int dispNum=1; dispNum<=line; dispNum++) {
				System.out.print(dispNum);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println("================");
		//문제 ----------------------------
		//1
		//2 3
		//4 5 6
		//7 8 9 10
		int dispNum = 1;
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=i; j++) {
				//System.out.print(dispNum++);
				System.out.print(dispNum);
				dispNum++;
				
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}

}
