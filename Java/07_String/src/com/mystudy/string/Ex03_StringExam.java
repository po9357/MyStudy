package com.mystudy.string;

public class Ex03_StringExam {

	public static void main(String[] args) {
		/*	���ڿ� �ֹι�ȣ ó��
		String str = "900108-1234567";		//�ֹι�ȣ
		����1. ��Ȯ�� �Է��� �� ���������� Ȯ��
				(��ü �ڸ����� 14, '-' ��ġ : 7��°)
		����2. ������� ���
		����3. ����Ȯ���ϰ� ���(1,3: ����, 2,4: ����)
		����4. ������ �� ����
				(��: 1~12, ��: 1~31)
		���� : int num = Integer.parseInt("12")	-> "12" -> 12
		*/
		
		
		String str = "900108-2234567";
		//����1. ��ü �ڸ��� 14, '-' ��ġ 7��°
		if (str.length() == 14 && str.charAt(6) == '-') {
			System.out.println("�ֹι�ȣ�� ����� �ԷµǾ����ϴ�.");
		} else {
			System.out.println("�ֹι�ȣ�� �ٽ� Ȯ���Ͽ� �ֽʽÿ�.");
		}
		
		//����2. ������� ���
		System.out.println("�Է��Ͻ� �ֹι�ȣ�� ��������� "+ str.substring(0, 2) +"�� "
							+ str.substring(2, 4)+ "�� "+str.substring(4, 6) +"�� �Դϴ�.");
		
		//����3. ���� Ȯ�� (1,3 : ��, 2,4 : ��)
		if (str.charAt(7) == '1' || str.charAt(7) == '3') {
			System.out.println("�����Դϴ�.");
		} else if (str.charAt(7) == '2' || str.charAt(7) == '4') {
			System.out.println("�����Դϴ�.");
		} else {
			System.out.println("�ֹι�ȣ�� �ٽ� Ȯ���Ͽ� �ֽʽÿ�.");
		}
		
		//����4. �����Ͱ� ����	(��: 1~12, ��: 1~31)
		int month = Integer.parseInt(str.substring(2, 4));
		System.out.println(month);
		
		int day = Integer.parseInt(str.substring(4, 6));
		System.out.println(day);
		
		if (1<=month && month<=12) {
			System.out.println("��� ���� ���������� �ԷµǾ����ϴ�.");
		} else {
			System.out.println("�ֹι�ȣ�� �ٽ� Ȯ���Ͽ� �ֽʽÿ�.");	
		}
		
		if (1<=day && day<=31) {
			System.out.println("��� ���� ���������� �ԷµǾ����ϴ�.");
		} else {
			System.out.println("�ֹι�ȣ�� �ٽ� Ȯ���Ͽ� �ֽʽÿ�.");
		}
		
	}
	
}
