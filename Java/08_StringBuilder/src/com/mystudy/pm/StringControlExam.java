package com.mystudy.pm;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringControlExam {

	public static void main(String[] args) {
		/*
		0. ���ڿ� ������
			String str1 = "ȫ�浿 �̼���  �̼��� Tom ȫ�浿"
			String str2 = "     TOM    �������� ������ �����ҹ�"
		1. ���� ���ڿ��� StringBuilder ���� sb�� �̿��ؼ� �ϳ��� ���ڿ��� �����,
		2. sb�� ���ڿ��� ��ĭ (" ")�� �����ڷ� �߶� (�̸��� ����) ȭ�����
		       (String.split() �Ǵ� StringTokenizer ���)
		3. ������ �޸�(,)�� �����Ͽ� �Ѷ��ο� ���(StringBuilder ���)
			(��¿�: ȫ�浿,�̼���,�̼���,Tom,ȫ�浿,TOM,��������,������,�����ҹ�)
		4. �������� ù���ڸ� �����ؼ� �޸�(,)�� �����Ͽ� �Ѷ��ο� ���(StringBuilder ���)
			(��: ȫ,��,��,T,ȫ,T,��,��,��)
		5. �迭�� ���ڿ� �� �̸��� ���ڼ��� 4 �̻��� ���� "��ȣ:�̸�" ���
			��¿�:
			6:��������
			8:�����ҹ�
		 ***********************************************************/
		String str1 = "ȫ�浿 �̼���  �̼��� Tom ȫ�浿";
		String str2 = "     TOM    �������� ������ �����ҹ�";
		//"ȫ�浿 �̼���  �̼��� Tom ȫ�浿    TOM     �������� ������ �����ҹ�"

		//1. ���� ���ڿ��� StringBuilder ���� sb�� �̿��ؼ� �ϳ��� ���ڿ��� �����,
		System.out.println("--- 1�� ���� ---");
		StringBuilder sb = new StringBuilder();
		sb.append(str1).append(str2);
		System.out.println(sb.toString());
		
		//2. sb�� ���ڿ��� ��ĭ (" ")�� �����ڷ� �߶� (�̸��� ����) ȭ�����
	    //   (String.split() �Ǵ� StringTokenizer ���)
		System.out.println("--- 2�� ���� ---");
		StringTokenizer st = new StringTokenizer(sb.toString(), " ");
		int tkNum =  st.countTokens();
		
		String[] str = new String[tkNum];
		for (int i=0; i<tkNum; i++) {
			str[i] = st.nextToken();
		}
		System.out.println(Arrays.toString(str));
		
		for (String strTmp : str) {
			System.out.print(strTmp+ " ");
		}
		System.out.println();
		//3. ������ �޸�(,)�� �����Ͽ� �Ѷ��ο� ���(StringBuilder ���)
		//(��¿�: ȫ�浿,�̼���,�̼���,Tom,ȫ�浿,TOM,��������,������,�����ҹ�)
		System.out.println("--- 3�� ���� ---");
		for (int i=0; i<tkNum; i++) {
			if (i==0) {
				System.out.print(str[i]);
			} else {
				System.out.print(", "+ str[i]);
			}
		}
		System.out.println();
		
		//4. �������� ù���ڸ� �����ؼ� �޸�(,)�� �����Ͽ� �Ѷ��ο� ���(StringBuilder ���)
		//(��: ȫ,��,��,T,ȫ,T,��,��,��)
		System.out.println("--- 4�� ���� ---");
		for (int i=0; i<tkNum; i++) {
			if (i==0) {
				System.out.print(str[i].charAt(0));
			} else {
				System.out.print(", "+ str[i].charAt(0));
			}
		}
		System.out.println();
		
		//5. �迭�� ���ڿ� �� �̸��� ���ڼ��� 4 �̻��� ���� "��ȣ:�̸�" ���
		//��¿�:
		//6:��������
		//8:�����ҹ�
		System.out.println("--- 5�� ���� ---");
		int num = 1;
		for (int i=0; i<tkNum; i++) {
			if (str[i].length() >= 4) {
				System.out.println(num+ " : "+ str[i]);
			}
			num++;
		}
		System.out.println();
		
		
	}
}
