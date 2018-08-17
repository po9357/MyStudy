package com.mystudy.am;

public class Ex01_parameter {

	public static void main(String[] args) {
		//�Ķ���� ���� ������ ��
		//1. ���� ���޵Ǵ� ���	: �⺻ ������ Ÿ��
		//2. �ּҰ��� ���޵Ǵ� ���	: ������ ������ Ÿ��
		//	������ ������ Ÿ���� ���޹޾� ���� ����� ���� �������� ���� ����ȴ�.	(���� �������(�ּ�)�� ���� ������ �߻�)
		//	�⺻�� ������ Ÿ���� ��� �ش� ������ ��ü�� �Ѿ�� ������ (�ּҰ�x)���� ���޹޾� ���� �ϴ��� ���� �����ʹ� ������ �ʴ´�.
		int num = 100;
		int[] arr = {100, 200, 300};
		
		System.out.println("���� num : "+ num);
		
		changeData(num);
		
		System.out.println("changeData���� �� num : "+ num);
		
		
		System.out.println("---- ������ ������ ���� ----");
		
		
		System.out.print("�����迭 arr : ");
		printData(arr);
		
		changeData(arr);
		
		System.out.print("changeData ���� �� arr: ");
		printData(arr);
	}
	
	//�޼ҵ� �����ε�(method overloading)
	//���� Ŭ���� ������ ���� �޼ҵ� �̸����� �Ű�����(parameter)�� �ٸ��� �����Ͽ�
	//������ �޼ҵ������ �ٸ��� �����ϵ��� ó��
	static void changeData(int intValue) {
		System.out.println(">> ���� ���� int : "+ intValue);
		intValue = 999;
		System.out.println(">> ����� int : "+ intValue);
	}
	
	static void changeData(int[] intArr) {
		System.out.print(">> ���޹��� int�迭 : ");
		printData(intArr);
		
		//�迭�� ����
		intArr[0] = 999;
		System.out.print(">> ���� �� int�迭 : ");
		printData(intArr);
	}
	
	static void printData(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
	
	
	
	
}
