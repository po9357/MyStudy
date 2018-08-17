public class  My_Ex17_stringBuffer
{
	public static void main(String[] args) 
	{
		int[][] input = {       {1, 2, 3}, 
                                {4, 5, 6}, 
                                {7, 8, 0} 
                         }; 
        int[][] data = new int[input.length][];

		for(int i = 0; i < input.length; i++){
			data[i] = (int[])input[i].clone();
		}
		
		// data배열의 값의 변경
		data[0][1] = 10;

		// input 배열의 출력
		System.out.println("input 출력");
		for(int i = 0; i < input.length; i++){
			for(int j = 0; j < input[i].length; j++){
				System.out.print(input[i][j]);
				System.out.print(",");
			} // for in
			System.out.println();
		}//for out

		// data배열의 출력
		System.out.println("data 출력");
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				System.out.print(data[i][j]);
				System.out.print(",");
			} // for in
			System.out.println();
		}//for out
	}
}