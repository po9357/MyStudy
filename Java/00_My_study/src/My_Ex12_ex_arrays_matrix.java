
public class My_Ex12_ex_arrays_matrix {
	
	public static void main(String[] args) {
		int[][] m1 = {
				{1,2,3},
				{4,5,6}
		};
		
		int[][] m2 = {
				{1,2},
				{3,4},
				{5,6}
		};
		
		final int ROW		= m1.length;	//m1의 행 길이	2
		final int M2_ROW	= m2.length;	//m2의 행 길이	3
		final int COL		= m2[0].length;	//m2의 열 길이	2
		
		int[][]	m3 = new int[ROW][COL];
		
		//행렬곱 m1 x m2 의 결과를 m3에 저장
		for (int i=0; i<ROW; i++)
			for(int j=0; j<COL; j++)
				for(int k=0; k<M2_ROW; k++) {
					m3[i][j] += m1[i][k] * m2[k][j];
				}
		
		//행렬 m3를 출력
		for (int i=0; i<ROW; i++) {
			for(int j=0; j<COL; j++) {
				System.out.print(m3[i][j] +" ");
			}
			System.out.println();
		}
	}

}
