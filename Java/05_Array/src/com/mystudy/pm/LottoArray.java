package com.mystudy.pm;

public class LottoArray {

	public static void main(String[] args) {
		//���� �� ���ڸ� ����� : Math.random()
		//Math.random() : 0.0 <= ���ϰ� < 1.0
		System.out.println(Math.random());
		System.out.println((Math.random()*10));
		for (int i=0; i<100; i++) {
			System.out.print((int)(Math.random()*45)+" ");
		}
		System.out.println();
		System.out.println("---------------------------");
		//�ζǸ����
		//1. ������ 45���� ������ �� �ִ� �迭 ����
		int[] nums = new int[45];
		
		//2. ���� 1 ~ 45�� �迭�� ����
		for (int i=0; i<nums.length; i++) {
			nums[i] = i+1;
			System.out.print(nums[i]+ " ");
		}
		System.out.println();
		
		int rNum;	//0 ~ 44������ ���ڸ� ����
		int tmp;
		for (int i=0; i<10000; i++) {
			rNum = (int)(Math.random()*45);
	//		System.out.println("rNum: " +rNum);
			
	//		nums[0] <-> nums[loc]
			tmp = nums[0];
			nums[0] = nums[rNum];
			nums[rNum] = tmp;
		}
		
		for (int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+ " ");
		}
		System.out.println();
		
		//�ζǹ�ȣ ���� : �� �տ��� 6�� ��ȣ ����
		for (int i=0; i<6; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		System.out.println("---------------");
		//������������ ����
		for (int i=0; i<6; i++) {
			for(int j=0; j<6-1-i; j++) {
				if(nums[j]>nums[j+1]) {
					tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		
		System.out.println();
		for (int i=0; i<6; i++) {
			System.out.print(nums[i]+" ");
		}
		
	}

}
