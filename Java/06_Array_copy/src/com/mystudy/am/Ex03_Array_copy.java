package com.mystudy.am;

public class Ex03_Array_copy {

	public static void main(String[] args) {
		//1차원 배열 복사
		int[] num1 = {10, 20, 30, 40 ,50};
		int[] num2 = new int[num1.length];

		System.out.println("--- 배열의 초기값 확인 ---");
		System.out.println("num1 배열값 : ");
		printData(num1);
		System.out.println("num2 배열값 : ");
		printData(num2);
		
		System.out.println("--- 주소값 복사 형태(얕은 복사) ---");
		num2 = num1;	//num1 객체가 있는 주소값을 num2에 복사
		printData("num1", num1);
		printData("num2", num2);
		
		System.out.println("--- num2의 값 변경 후 ---");
		num2[0] = 999;
		printData("num1", num1);
		printData("num2", num2);
		
		System.out.println("=== 배열의 값을 복사(num1 -> num3) ===");
		int[] num3 = new int[num1.length];
		printData("num1", num1);
		printData("num3", num3);
		
		System.out.println(">> 값 복사 작업 진행");
		//num1[0] -> num3[0]
		for (int i=0; i<num1.length; i++) {
			num3[i] = num1[i];
		}
		printData("num1", num1);
		printData("num3", num3);
		
		System.out.println("--- num3의 값을 변경 후 확인 ---");
		num3[0] = 444;
		printData("num1", num1);
		printData("num3", num3);
		
		System.out.println("=================================");
		System.out.println("--- System.arraycopy() ---");
		//System.arraycopy(src, srcPos, dest, destPos, length);
		int[] arr = {100, 200, 300, 400, 500};
		int[] arr2 = new int[arr.length];
		printData("arr",arr);
		printData("arr2",arr2);
		
		System.out.println(">> System.arraycopy() 복사 후 ---");
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		printData("arr",arr);
		printData("arr2",arr2);
		
		System.out.println("--- arr의 값 변경 후 ---");
		arr[0] = 999;
		printData("arr",arr);
		printData("arr2",arr2);
	}
	
	static void printData(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
	
	static void printData(String name, int[] num) {
		System.out.print(name + ": ");
		for (int i=0; i<num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}
}
