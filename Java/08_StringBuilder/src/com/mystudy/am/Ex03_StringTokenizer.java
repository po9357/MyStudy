package com.mystudy.am;

import java.util.StringTokenizer;

public class Ex03_StringTokenizer {

	public static void main(String[] args) {
		//String.split() vs StringTokenizer
		System.out.println("--- String.split() ---");	//String.split�� �� ���ڿ��� �������� �ʴ´�
		String str = "���,��,������,,����";
		System.out.println("str : "+ str);
		String[] strSplit = str.split(",");
		System.out.println("�迭�� ����� ������ ���� : "+strSplit.length);
		System.out.println("str.splt(\",\") ���");
		System.out.println(strSplit[0]);
		
		//���� for��
		//for (������Ÿ�� ������ : ���հ�ü) {}
		
//		for (int i=0; i<strSplit.length; i++) {			//������ ���� for��
//			System.out.print(strSplit[i] + " ");
//		}
//		System.out.println();
		
		for (String str2 : strSplit) {
			System.out.print(str2 +"-");
		}
		System.out.println();
		System.out.println("�迭�� ����� ������ ���� : "+strSplit.length);
		
		System.out.println("==============================");
		System.out.println("--- StringTokenizer ��� ---");
		System.out.println("str : "+ str);
		StringTokenizer strToken = new StringTokenizer(str, ",");
		System.out.println("����� ��ū ���� : "+ strToken.countTokens());
		while (strToken.hasMoreTokens()) {				//StringTokenizer�� �� ���ڿ� ����
			String token = strToken.nextToken();
			System.out.print(token+ "-");
		}
		System.out.println();
		
		System.out.println("����� ��ū ���� : "+ strToken.countTokens());
		//����� ��ū�� ���� ���� ������ ��ū ������ 0
		//�� �� �� ��ū�̹Ƿ� �ٽ� �� �� ����.
		
		//String.split�� ���� �迭�� ����Ǿ� �ش� �迭�� �ҷ����� �Ҹ���� �ʴ´�.
		
		//----------------------------------------------------------
		System.out.println("------------------------------");
		strToken = new StringTokenizer(str, ",");
		System.out.println("����� ��ū ���� : "+ strToken.countTokens());
		int tokenCnt = strToken.countTokens();
		for (int i=0; i<tokenCnt; i++) {			//��ū�� ���� �������� �Ҹ�Ǳ⶧���� 
			String token = strToken.nextToken();	//i<strToken.countTokens();
			System.out.println((i+1) +" : "+ token);			//�� ����ϸ� i���� �þ������
		}											//strToken.countTokens()���� �پ���.
		System.out.println();
		
		int i=1;
		strToken = new StringTokenizer(str, ",");
		while (strToken.hasMoreTokens()) {
			String token = strToken.nextToken();
			System.out.println((i)+ " : "+ token);
			i++;
		}
		
		
	}
}
