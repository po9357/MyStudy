package com.mystudy.pm;

public class Ex02_array_2dim {

	public static void main(String[] args) {
		//2���� �迭
		/*
		Ÿ��[][] ������ = new Ÿ��[2����ũ��][1����ũ��];
		Ÿ�� ������[][] = new Ÿ��[][] {{..}, {..}, {..}, {..}, ..};
		Ÿ��[][] = {{..}, {..}, {..}, ..};
		 */
		int[][] nums = {{10, 20},		//10 : [0][0],	20: [0][1]
						{30, 40},		//[1][0],	[1][1]
						{50, 60},		//[2][0],	[2][1]
						{70, 80},		//[3][0],	[3][1]
						{90, 100, 200}	//[4][0],	[4][1],	[4][2]
		};
		System.out.println("nums : "+ nums);
		System.out.println("nums[0] : "+ nums[0]);
		System.out.println("nums[0][0] : " +nums[0][0]);
		System.out.println("------------------");
		System.out.println("nums.length : "+ nums.length);
		System.out.println("nums[0].length : "+ nums[0].length);
		System.out.println("nums[4].length : "+ nums[4].length);
		

		System.out.println("------------");
		System.out.println(nums[0][0]);
		System.out.println(nums[0][1]);
		
		System.out.println("-- 2�����迭�� ù��° �迭�� ��� ---");
		System.out.println("nums[0].length: " + nums[0].length);
		for (int i=0; i<nums[0].length; i++) {
			System.out.println(nums[0][i]);
		}
		
		System.out.println("----");
		for (int i=0; i<nums[1].length; i++) {
			System.out.println(nums[1][i]);
		}
		
		System.out.println("--- 2���� �迭 ��ü ��� ---");
		for (int k=0; k<nums.length; k++) {
			for (int i=0; i<nums[k].length; i++) {
				System.out.print(nums[k][i] + " ");
			}
			System.out.println();
		}
		
		//--------------------------------
		//2������ �迭 ����
		int[][] copyNum = new int[nums.length][];
		
	}
}
