
public class Ex10_for_gugudan2 {
	public static void main(String[] args) {
		/* ������
		2*1=2	3*1=3 ..... 9*1=9
		2*2=4 ...
		2*9=18 ...			9*9=81
		 */
		System.out.println("---������---");
		//Ÿ��Ʋ ���
		for(int dan=2; dan<=9; dan++) {
				System.out.print("--"+dan+"��--");
				System.out.print("\t");
			}
		System.out.println();
		
		for (int gop=1; gop<=9; gop++) {
				for(int dan=2; dan<=9; dan++) {
					if ((dan*gop)<10) {
						System.out.print(dan+"*"+gop+"= "+(dan*gop));
						System.out.print("\t");
					} else {
						System.out.print(dan+"*"+gop+"="+(dan*gop));
						System.out.print("\t");
					}
				}
				System.out.println();
		}
			System.out.println();
		
		
		
		
		//==========================================================
		System.out.println("-----------------------------------------");
		
		System.out.println("2*1="+(2*1));
				
		for (int i=2; i<=9; i++) {
			System.out.print(i+"*1="+(i*1));
			System.out.print("\t");
		}
		System.out.println();
		
		//2��° ����
		
		
		
		System.out.println("------------------------------------------");
		for (int g=1; g<=9; g++) {
			for (int i=2; i<=9;i++) {
				if ((i*g)<10) {
					System.out.print(i +"*"+ g +"= " +(i*g));
					System.out.print("\t");
				} else {
					System.out.print(i +"*"+ g +"=" +(i*g));
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		
		
		//===============================
		//for�� 3�� ���
		for (int i=1; i<=3; i++) {
			System.out.println(">>> ���� �ٱ��� for�� ����(i)");
			for (int j=1; j<=5; j++) {
				System.out.println(">>> �߰� for�� ����(j)");
				for (int k=1; k<=2; k++) {
					//System.out.println(">>> ���� for�� ����(k)");
					System.out.println("i: "+ i +", j: "+ j +", k: "+ k);
				}
			}
		}
		
		
		
	}
}
