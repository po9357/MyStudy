package com.mystudy.am;

public class Ex02_array2 {
	
	public static void main(String[] args) {
			//1~100������ �� �߿� Ȧ���� �� ���ϱ�(�迭 ���)
			//����1. �迭�� ���� 50�� ���
			//������� ����� int Ÿ���� ���� ������ �� �ִ� ũ�� 50�� �迭 ����
			//1~100 ���� �� Ȧ�� ���� �迭�� ����
			//�迭�� ����� ���� ��� ���� �� ��� ���
			int sum=0;
			
			int[] odd = new int[50];
			for (int i=0; i<odd.length; i++) {
				odd[i] = i*2+1;
				System.out.print(odd[i]+ " ");
				sum+=odd[i];
			}
			System.out.println();
			System.out.println("1~100������ �� �� Ȧ���� ���� "+sum +"�̴�.");
			
			
			////////////////////////////////////////////////
			//1~100������ �� �߿��� Ȧ���� �� ���ϱ�(�迭���)
			//1~100������ ���ڸ� �迭�� ����
			//1. �迭����(int Ÿ���� �� 100�� ����)
			//2. �迭 �ʱ�ȭ(1~100������ ���ڸ� ������� �迭�� ����)
			//3. �迭 �� �� Ȧ�� �� �����ؼ� �ջ�
			//4. Ȧ���� �հ� ���
			sum = 0;
			int[] numArr = new int[100];
			for (int i=0; i<numArr.length; i++) {
				numArr[i] = i+1;
				if (numArr[i] % 2 == 1) {
					System.out.print(numArr[i] + " ");
					sum += numArr[i];
				}
			}
			System.out.println();
			System.out.println("1~100������ �� �� Ȧ���� ���� "+sum +"�̴�.");
			
			int oddSum = 0;
			int evenSum = 0;
			for (int i=0; i<numArr.length; i++) {
				if (numArr[i] % 2 == 1) {
					evenSum += numArr[i];
				} else {
					oddSum += numArr[i];
				}
			}
			System.out.println("Ȧ���� �� :"+evenSum+ ", ¦���� ��"+ oddSum);
			
	}
}
