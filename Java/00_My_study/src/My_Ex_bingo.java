import java.util.*;

public class My_Ex_bingo {

	public static void main(String[] args) {
		final int SIZE = 5;
		int x=0, y=0;
		Scanner sc = new Scanner(System.in);
		
		int[][] bingo = new int[SIZE][SIZE];
		
		
		for (int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				bingo[i][j] = i*SIZE + j + 1;
			}
		}
		System.out.println("--------------");
		int tmp;
		for (int i=0; i<SIZE; i++) {
			for (int j=0; j<SIZE; j++) {
				x = (int)(Math.random()*SIZE);
				y = (int)(Math.random()*SIZE);
				tmp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = tmp;
			}
		}
		int temp;
		
		do {
			System.out.println("1 ~ 25사이의 숫자를 입력하여 주십시오. (종료 : 0)>");
			printArray(bingo);
			temp = sc.nextInt();
			
			outer:
			for (int i=0; i<SIZE; i++) {
				for (int j=0; j<SIZE; j++) {
					if (temp == bingo[i][j]) {
						bingo[i][j] = 0;
						break outer;
					}
				}
			}
		} while (temp != 0);
	}//main 종료
	
	static void printArray(int[][] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
			System.out.println();
		}
	}
}
