
public class Ex12_while_ex {
	public static void main(String[] args) {
		//while���� ����ؼ� ó��
		//����1 : 1~10������ �հ�(sum)�� ���ϰ� ���
		int sum = 0;
		int i = 0;
		while (i<10) {
			i++;
			sum+=i;
			System.out.println("1 ~ "+i+ "������ ���� "+ sum +"�Դϴ�.");
		}
		
		//����2
		/* �ﰢ�� �׸���
		 * 
		 **
		 ***
		 ****
		 *****
		 */
		
		int starCnt = 1;
		while (starCnt <= 1) {
			System.out.print("*");
			starCnt++;
		}
		System.out.println();
		
		starCnt=1;
		while (starCnt <= 2) {
			System.out.print("*");
			starCnt++;
		}
		System.out.println();
		
		starCnt=1;
		while (starCnt <= 3) {
			System.out.print("*");
			starCnt++;
		}
		System.out.println();

		System.out.println("============================");
		int line = 1;//(�ٱ���)�ʱⰪ ����
		while (line <= 5) {//(�ٱ���)���ǽ�
			starCnt = 1;//(����)�ʱⰪ ����
			while (starCnt <= line) {//(����)���ǽ�
				System.out.print("*");
				starCnt++;//(����)������
			}
			System.out.println();
			line++;//(�ٱ���)������
		}
		
		
		int j=1;
		int k=1;
		while (j<=5) {
			while (k <=j) {
				System.out.print("*");
				k++;
			}
			System.out.println();
			j++;
			k=1;
		}

		System.out.println("-----------");
		j=5;
		k=1;
		while (j>0) {
			while (k<=j) {
				System.out.print("*");
				k++;
			}
			System.out.println();
			j--;
			k=1;
		}
		int t =5;
		j=1;
		while (j<=5) {
			while (t>j) {
				System.out.print(" ");
				t--;
			}
			while (k<=j) {
				System.out.print("*");
				k++;
			}
			System.out.println();
			j++;
			t=5;
			k=1;
		}
		
		
		int outNum = 1;
		while (outNum <=3) {
			int inNum = 1;
			while (inNum <= 3) {
				System.out.println("inNum : "+ inNum);
				inNum++;
			}
			//����ġ ����
			outNum++;
		}
	}
}
