package com.mystudy.pm;

import java.util.Arrays;

public class Ex03_array_copy_2dim {

	public static void main(String[] args) {
		//1차원, 2차원 배열 복사
		//1차원 배열 복사
		int[] num1 = {10, 20, 30};
		
		//40 숫자 추가
		int[] num2 = new int[num1.length+1];
		System.out.println(Arrays.toString(num2));
		
		for (int i=0; i<num1.length; i++) {
			num2[i] = num1[i];
		}
		System.out.println(Arrays.toString(num2));
		num2[3] = 40;
		System.out.println(Arrays.toString(num2));
		
		//----------------------------------------
		System.out.println("======== 2차원 배열 ========");
		//2차원 배열
		int[][] num2dim = {{10, 20}, {30, 40}, {50, 60}};
		//Q1 : 2차원 배열 num2dim 값을 화면에 출력 : 10 20 30 ...
		printData(num2dim);
				
				
		//Q2 : num2dim에서 세번째 값인 30의 값을 100으로 변경하고 번체 화면 출력
		num2dim[1][0] = 100;
		printData(num2dim);
		
		//Q3 : num2dim와 동일한 형태의 배열 num2Copy를 선언하고 만드세요.
		int[][] num2Copy = new int[num2dim.length][num2dim[0].length];
				
//		for (int i=0; i<num2dim.length; i++) {
//			for (int j=0; j<num2dim[0].length; j++) {
//				num2Copy[i][j] = num2dim[i][j];
//				System.out.print(num2Copy[i][j]+ " ");
//			}
//		}
//		System.out.println();	
		
		System.out.println("---------------------------");
		
		num2Copy = num2dim.clone();
		printData(num2Copy);
		
		num2dim[0][0] = 1000;
		num2dim[2][1] = 2000;
		printData(num2Copy);
		num2Copy[0][0] = 10;
		num2Copy[2][1] = 60;
		printData(num2dim);
		System.out.println("--- 주소값 공유 ---");
		System.out.println(Arrays.toString(num2Copy));
		System.out.println(Arrays.toString(num2dim));
	}
	static void printData(int[][] arr) {
		for (int d2 = 0; d2 < arr.length; d2++) {
			for (int d1 = 0; d1 < arr[d2].length; d1++) {
				System.out.print(arr[d2][d1] + " ");
			}
		}
		System.out.println();
	}


}
