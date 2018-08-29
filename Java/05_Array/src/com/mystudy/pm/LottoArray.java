package com.mystudy.pm;

public class LottoArray {

	public static void main(String[] args) {
		//랜덤 한 숫자를 만들기 : Math.random()
		//Math.random() : 0.0 <= 리턴값 < 1.0
		System.out.println(Math.random());
		System.out.println((Math.random()*10));
		for (int i=0; i<100; i++) {
			System.out.print((int)(Math.random()*45)+" ");
		}
		System.out.println();
		System.out.println("---------------------------");
		//로또만들기
		//1. 정수값 45개를 저장할 수 있는 배열 선언
		int[] nums = new int[45];
		
		//2. 숫자 1 ~ 45를 배열에 저장
		for (int i=0; i<nums.length; i++) {
			nums[i] = i+1;
			System.out.print(nums[i]+ " ");
		}
		System.out.println();
		
		int rNum;	//0 ~ 44까지의 숫자를 저장
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
		
		//로또번호 추출 : 맨 앞에서 6개 번호 추출
		for (int i=0; i<6; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		System.out.println("---------------");
		//오름차순으로 정리
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
