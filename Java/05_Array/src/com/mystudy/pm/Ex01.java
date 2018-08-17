package com.mystudy.pm;
import java.util.*;

public class Ex01 {

	public static void main(String[] args) {
		//변수값 교환하기
		int i = 100;
		int k = 200;
		int tmp;
		System.out.println("i : "+ i + ", k: "+ k);
		
		//i <-> k
		tmp = i;
		i = k;
		k = tmp;
		System.out.println("i : "+ i + ", k: "+ k);
		
		////////////////////////////////////////
		int[] nums = {100, 200, 300, 400, 500};
		tmp = nums[0];
		nums[0] = nums[4];
		nums[4] = tmp;
		System.out.println(Arrays.toString(nums));
		printArray(nums);
		
		tmp = nums[1];
		nums[1] = nums[3];
		nums[3] = tmp;
		System.out.println(Arrays.toString(nums));
		printArray(nums);
		
		
	}
	
	static void printArray(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
