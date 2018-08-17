package com.mystudy.sort;

public class ArraySelectionSort {

	public static void main(String[] args) {
		//�迭�� ����� ���� ����
		//30, 20, 50, 40, 10
		int[] num = {30, 20, 50, 40, 10};
		
		//������ Ȯ��
//		for (int i=0; i<num.length; i++) {
//			System.out.print(num[i] +" ");
//		}
//		System.out.println();
		printData(num);
		
		System.out.println("--- ���Ľ��� ---");
		//ù��° �� �������� �� �۾�(0�ε��� - 1�ε���)
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
//		//ù��° �� �������� �� �۾�(0�ε��� - �Ǹ������ε���)
//		if (num[0] > num[4]) {
//			temp = num[0];
//			num[0] = num[4];
//			num[4] = temp;
//		}
//		printData(num);
//		
//		//�ݺ��� ó��
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
		//for���� ������ �����ε��� + 1 ������ �����ϰ� ������ �ε�������
		//num[0]�� num[1~4]��, num[1]�� num[2~4]��, num[2]�� num[3~4]��, num[3]�� num[4]��
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
		//�� �� �� ��ġ���� Ȯ���ϰ� �������� �� ��ȯ �� ���� ����
		printData(num);
		
		System.out.println("--- ���� ���� ---");
		int changeIdx;	//������ ����� �Ǵ� �ε��� �� �����
		for (int idx=0; idx<num.length-1; idx++) {
			changeIdx = idx;
			for (int i=idx+1; i<num.length; i++) {
				if (num[changeIdx]>num[i]) {						
					changeIdx = i;									//ũ�� �� �� �迭�� ��ȣ�� �Է�
				}
			}
			//���ذ��� ���� �ε����� ��ġ���� ��ȯ
			if (changeIdx != idx) {									//�Էµ� ��ȣ�� �迭�� �־� ��ȯ
				System.out.println(changeIdx +" < - > "+ idx);
				temp = num[idx];
				num[idx] = num[changeIdx];
				num[changeIdx] = temp;
			}
		}
		//�������� ����. �ε�ȣ ���⸸ �ٲ��ָ� �ȴ�.
//		for (int idx=0; idx<num.length-1; idx++) {
//			for (int i=idx+1; i<num.length; i++) {
//				if (num[idx]<num[i]) {
//					temp = num[idx];
//					num[idx] = num[i];
//					num[i] = temp;
//				}
//			}
//		}
		
		//num[0]�� num[1], num[1]�� num[2], num[2]�� num[3], num[3]��num[4]�� ��
		//num[1]�� num[2], num[2]�� num[3], num[3]�� num[4]�� �� ...
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
