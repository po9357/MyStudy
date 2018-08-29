package com.mystudy.sort;

public class ArraySelectionSort {

	public static void main(String[] args) {
		//배열에 저장된 숫자 정렬
		//30, 20, 50, 40, 10
		int[] num = {30, 20, 50, 40, 10};
		
		//데이터 확인
//		for (int i=0; i<num.length; i++) {
//			System.out.print(num[i] +" ");
//		}
//		System.out.println();
		printData(num);
		
		System.out.println("--- 정렬시작 ---");
		//첫번째 값 기준으로 비교 작업(0인덱스 - 1인덱스)
		int temp;
//		if (num[0] > num[1]) {
//			temp = num[0];
//			num[0] = num[1];
//			num[1] = temp;
//		}
//		printData(num);
//		
//		if (num[0] > num[2]) {
//			temp = num[0];
//			num[0] = num[2];
//			num[2] = temp;
//		}
//		printData(num);
//		//...
//		//첫번째 값 기준으로 비교 작업(0인덱스 - 맨마지막인덱스)
//		if (num[0] > num[4]) {
//			temp = num[0];
//			num[0] = num[4];
//			num[4] = temp;
//		}
//		printData(num);
//		
//		//반복문 처리
//		for (int i=1; i<=4; i++) {
//			if (num[1] > num[i]) {
//				temp = num[i];
//				num[i] = num[1];
//				num[1] = temp;
//			}
//		}
//		for (int i=2; i<=4; i++) {
//			if (num[2] > num[i]) {
//				temp = num[i];
//				num[i] = num[2];
//				num[2] = temp;
//			}
//		}
//		for (int i=3; i<=4; i++) {
//			if (num[3] > num[i]) {
//				temp = num[i];
//				num[i] = num[3];
//				num[3] = temp;
//			}
//		}
		//for문의 시작은 기준인덱스 + 1 값으로 시작하고 마지막 인덱스까지
		//num[0]과 num[1~4]비교, num[1]과 num[2~4]비교, num[2]과 num[3~4]비교, num[3]과 num[4]비교
//		for (int idx=0; idx<num.length-1; idx++) {
//			for (int i=idx+1; i<num.length; i++) {
//				//
//				if (num[idx]>num[i]) {
//					temp = num[idx];
//					num[idx] = num[i];
//					num[i] = temp;
//				}
//			}
//		}
		
		//////////////////////////////////////////////////
		//값 비교 후 위치값만 확인하고 마지막에 값 교환 한 번만 실행
		printData(num);
		
		System.out.println("--- 정렬 시작 ---");
		int changeIdx;	//변경할 대상이 되는 인덱스 값 저장용
		for (int idx=0; idx<num.length-1; idx++) {
			changeIdx = idx;
			for (int i=idx+1; i<num.length; i++) {
				if (num[changeIdx]>num[i]) {						
					changeIdx = i;									//크기 비교 후 배열의 번호만 입력
				}
			}
			//기준값과 최종 인덱스된 위치값과 교환
			if (changeIdx != idx) {									//입력된 번호를 배열에 넣어 교환
				System.out.println(changeIdx +" < - > "+ idx);
				temp = num[idx];
				num[idx] = num[changeIdx];
				num[changeIdx] = temp;
			}
		}
		//내림차순 정리. 부등호 방향만 바꿔주면 된다.
//		for (int idx=0; idx<num.length-1; idx++) {
//			for (int i=idx+1; i<num.length; i++) {
//				if (num[idx]<num[i]) {
//					temp = num[idx];
//					num[idx] = num[i];
//					num[i] = temp;
//				}
//			}
//		}
		
		//num[0]과 num[1], num[1]과 num[2], num[2]과 num[3], num[3]과num[4]비교 후
		//num[1]과 num[2], num[2]과 num[3], num[3]과 num[4]비교 후 ...
//		for (int i=0; i<num.length; i++) {
//			for (int j=0; j<num.length-1-i; j++) {
//				if (num[j]>num[j+1]) {
//					temp = num[j];
//					num[j] = num[j+1];
//					num[j+1] = temp;
//				}
//			}
//		}
		printData(num);
		
//		for (int i=0; i<num.length-1; i++) {
//			for (int j=i+1; j<num.length; j++) {
//				if (num[i]>num[j]) {
//					temp = num[i];
//					num[i] = num[j];
//					num[j] = temp;
//				}
//			}
//		}
//		printData(num);
		
	}
	
	static void printData(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
}
