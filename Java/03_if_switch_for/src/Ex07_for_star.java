
public class Ex07_for_star {

	public static void main(String[] args) {
		//��øfor�� ���
		//* * * * *
		//*****
		//*****
		//*****
		//*****
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("-----------");
		
		System.out.println("---��ø ���� for�� ���---");
		for (int j=1; j<=5; j++) {
			for (int i=1; i<=3; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=3; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//---------------------------
		System.out.println("======================");
		/* �ﰢ�� �׸���
		 * 
		 **
		 ***
		 ****
		 *****
		*/
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		//****************************
		System.out.println("========================");
		System.out.print("*");
		System.out.println();
		
		System.out.print("*");
		System.out.print("*");
		System.out.println();
		
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.println();
		System.out.println("===================");
		System.out.print("*");
		System.out.println();
		
		for (int i=1; i<=2; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i=1; i<=3; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i=1; i<=4; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for (int i=1; i<=5; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.println("===================");
//		for (int i=1; i<=1; i++) {
//			System.out.print("*");
//		}
//		System.out.println();
		
		for (int out=1; out<=5; out++) {
			for (int i=1; i<=out; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}
