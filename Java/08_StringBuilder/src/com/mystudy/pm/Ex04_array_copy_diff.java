package com.mystudy.pm;

public class Ex04_array_copy_diff {

	public static void main(String[] args) {
		//2차원 배열 복사 : 1차원 배열의 크기가 다를 때
		int[][] nums = {	{10, 20},
							{30, 40, 50},
							{60}
		};
		
		int[][] dest = new int[nums.length][];
//		dest[0] = new int[nums[0].length];
//		dest[1] = new int[nums[1].length];
//		dest[2] = new int[nums[2].length];
		for (int i=0; i<nums.length; i++) {
			dest[i] = new int[nums[i].length];
		}
		printData(dest);
		
		//원본(nums) -> 복사본(dest) 복사
		//복사 후 값 체크까지
		System.out.println("-------- 값 복사 --------");
		for (int i=0; i<nums.length; i++) {
			dest[i] = nums[i];
		}
		printData(dest);
		
		System.out.println("------- 주소값 확인 -------");
		nums[1][0] = 999;
		System.out.println(nums[1].toString());
		System.out.println(dest[1].toString());
		
		
		System.out.println("--- clone() 주소값 확인 ---");
		dest = nums.clone();
		nums[0][0] = 888;
		System.out.println(nums[0].toString());
		System.out.println(dest[0].toString());
		
	}//main 종료
	
	static void printData(int[][] arr) {
		for (int d2 = 0; d2 < arr.length; d2++) {
			for (int d1 = 0; d1 < arr[d2].length; d1++) {
				System.out.print(arr[d2][d1] + " ");
			}
			System.out.println("---------");
		}
		System.out.println();
	}
}
