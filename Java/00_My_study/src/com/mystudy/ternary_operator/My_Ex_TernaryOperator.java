package com.mystudy.ternary_operator;

public class My_Ex_TernaryOperator {

	public static void main(String[] args) {
		//���� ������
		//���� = (boolean) ? (true) : (false)
		//������  (�̰� Ʈ���) = (��Ű�)
		//������  (�̰� ������) = 			(��Ŵ�)
		
		int a = 100;
		int b = 500;
		int result;
		
		//���� if - else��
		if ((a+b) > 300) {
			result = 5000;
		} else {
			result = 3000;
		}
		System.out.println(result);
		
		//���׿����� ���
		result = ((a+b) > 300) ? (9999) : (6666);
		System.out.println(result);
		

	}

}
