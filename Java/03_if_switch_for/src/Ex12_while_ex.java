
public class Ex12_while_ex {
	public static void main(String[] args) {
		//while문을 사용해서 처리
		//문제1 : 1~10까지의 합계(sum)를 구하고 출력
		int sum = 0;
		int i = 0;
		while (i<10) {
			i++;
			sum+=i;
			System.out.println("1 ~ "+i+ "까지의 합은 "+ sum +"입니다.");
		}
		
		//문제2
		/* 삼각형 그리기
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
		int line = 1;//(바깥쪽)초기값 설정
		while (line <= 5) {//(바깥쪽)조건식
			starCnt = 1;//(안쪽)초기값 설정
			while (starCnt <= line) {//(안쪽)조건식
				System.out.print("*");
				starCnt++;//(안쪽)증감식
			}
			System.out.println();
			line++;//(바깥쪽)증감식
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
			//증감치 설정
			outNum++;
		}
	}
}
