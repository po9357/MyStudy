package com.mystudy.am;

public class Ex03_array3 {

	public static void main(String[] args) {
		/*����
		*
		**
		***
		****
		*****
		 */
		///////////////////////////
		//char Ÿ���� ������ 5���� ������ �� �ִ� �迭�� ����� ���
		//�迭�� ������ : ch
		
		//���1. �迭 ��ü�� '*'�� ä��� ���������� ���
		//*
		//**
		char[] ch = new char[5];
		for (int i=0; i<ch.length; i++) {
			ch[i] = '*';
			System.out.print(ch[i]+ " ");
		}
		System.out.println();
		
		for (int i=0; i<ch.length; i++) {
			for (int j=0; j<i+1; j++) {
				System.out.print(ch[j]);
			}
			System.out.println();
		}
		
		System.out.println("---------------");
		//���2. ���������� '*'�� �����鼭 �迭�� ��ü ���
		//*
		//**
		//***
		//ù ��° ��ġ�� '*' �Է� �� ��ü ���
		//�� ��° ��ġ�� '*' �Է� �� ��ü ���
		char[] stars = new char[5];
		
		//ù ��° ��ġ�� '*' �Է� �� ��ü ���
//		stars[0] = '*';
//		for (int i=0; i<stars.length; i++) {
//			System.out.print(stars[i]);
//		}
//		System.out.println();
		
		
//		stars[1] = '*';
//		for (int i=0; i<stars.length; i++) {
//			System.out.print(stars[i]);
//		}
//		System.out.println();
//		
//		stars[2] = '*';
//		printArray(stars);
//		
//		stars[3] = '*';
//		printArray(stars);
//		
//		stars[4] = '*';
//		printArray(stars);
		
		for (int i=0; i<stars.length; i++) {
			stars[i] = '*';
			printArray(stars);
		}
	}
	static void printArray(char[] stars) {
		
		for (int i=0; i<stars.length; i++) {
			System.out.print(stars[i]);
		}
		System.out.println();

	}
}
