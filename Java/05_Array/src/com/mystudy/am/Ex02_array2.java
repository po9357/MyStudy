package com.mystudy.am;

public class Ex02_array2 {
	
	public static void main(String[] args) {
			//1~100까지의 수 중에 홀수의 합 구하기(배열 사용)
			//문제1. 배열의 갯수 50개 사용
			//저장공간 만들기 int 타입의 값을 저장할 수 있는 크기 50인 배열 생성
			//1~100 숫자 중 홀수 값만 배열에 저장
			//배열에 저장된 값을 모두 더한 후 결과 출력
			int sum=0;
			
			int[] odd = new int[50];
			for (int i=0; i<odd.length; i++) {
				odd[i] = i*2+1;
				System.out.print(odd[i]+ " ");
				sum+=odd[i];
			}
			System.out.println();
			System.out.println("1~100까지의 수 중 홀수의 합은 "+sum +"이다.");
			
			
			////////////////////////////////////////////////
			//1~100까지의 수 중에서 홀수의 합 구하기(배열사용)
			//1~100까지의 숫자를 배열에 저장
			//1. 배열선언(int 타입의 값 100개 저장)
			//2. 배열 초기화(1~100까지의 숫자를 순서대로 배열에 저장)
			//3. 배열 값 중 홀수 값 추출해서 합산
			//4. 홀수값 합계 출력
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
			System.out.println("1~100까지의 수 중 홀수의 합은 "+sum +"이다.");
			
			int oddSum = 0;
			int evenSum = 0;
			for (int i=0; i<numArr.length; i++) {
				if (numArr[i] % 2 == 1) {
					evenSum += numArr[i];
				} else {
					oddSum += numArr[i];
				}
			}
			System.out.println("홀수의 합 :"+evenSum+ ", 짝수의 합"+ oddSum);
			
	}
}
