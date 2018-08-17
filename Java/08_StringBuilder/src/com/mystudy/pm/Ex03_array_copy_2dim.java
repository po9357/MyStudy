package com.mystudy.pm;

import java.util.Arrays;

public class Ex03_array_copy_2dim {

	public static void main(String[] args) {
		//1����, 2���� �迭 ����
		//1���� �迭 ����
		int[] num1 = {10, 20, 30};
		
		//40 ���� �߰�
		int[] num2 = new int[num1.length+1];
		System.out.println(Arrays.toString(num2));
		
		for (int i=0; i<num1.length; i++) {
			num2[i] = num1[i];
		}
		System.out.println(Arrays.toString(num2));
		num2[3] = 40;
		System.out.println(Arrays.toString(num2));
		
		//----------------------------------------
		System.out.println("======== 2���� �迭 ========");
		//2���� �迭
		int[][] num2dim = {{10, 20}, {30, 40}, {50, 60}};
		//Q1 : 2���� �迭 num2dim ���� ȭ�鿡 ��� : 10 20 30 ...
		printData(num2dim);
				
				
		//Q2 : num2dim���� ����° ���� 30�� ���� 100���� �����ϰ� ��ü ȭ�� ���
		num2dim[1][0] = 100;
		printData(num2dim);
		
		//Q3 : num2dim�� ������ ������ �迭 num2Copy�� �����ϰ� ���弼��.
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
		System.out.println("--- �ּҰ� ���� ---");
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
