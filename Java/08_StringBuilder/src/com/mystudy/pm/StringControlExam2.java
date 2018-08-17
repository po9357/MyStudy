package com.mystudy.pm;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringControlExam2 {

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
		StringBuilder sb = new StringBuilder();
		//sb.append(str1).append(str2);
		sb = new StringBuilder(str1);
		sb.append(str2);
		System.out.println(sb);
		
		System.out.println("------------------------------");
		//2. sb�� ���ڿ��� ��ĭ (" ")�� �����ڷ� �߶� (�̸��� ����) ȭ�����
		//		(String.split() �Ǵ� StringTokenizer ���)
		StringTokenizer stk = new StringTokenizer(sb.toString(), " ");
		
		//�߶� �����͸� �迭�� ����
		
		int tokenCnt = stk.countTokens();
		String[] names = new String[tokenCnt];
		
		//names <- stk ���� ����
		for (int i=0; i<tokenCnt; i++) {
			names[i] = stk.nextToken();
			System.out.println(stk.countTokens());
		}
		System.out.println(Arrays.toString(names));
		
		for (String name : names) {
			System.out.print(name +" ");
		}
		System.out.println();
		
		System.out.println("------------------------------");
		//3. ������ �޸�(,)�� �����Ͽ� �Ѷ��ο� ���(StringBuilder ���)
		//	(��¿�: ȫ�浿,�̼���,�̼���,Tom,ȫ�浿,TOM,��������,������,�����ҹ�)
		StringBuilder sbResult = new StringBuilder();
		
		System.out.println("----- ��� 1 -----");
		sbResult.setLength(0);
		sbResult.append(names[0]);
		for (int i=1; i<names.length; i++) {
			sbResult.append(",").append(names[i]);
			//�������϶��� �̸��� ���̱�
		}
		System.out.println(sbResult.toString());
		
		System.out.println("----- ��� 2 -----");
		sbResult.setLength(0);
		boolean isFirst = true;
		for (int i=0; i<names.length; i++) {
			if (isFirst) {
				//ù��° �����Ϳ� ���� ó��
				//isFirst = false;
				System.out.print(names[i]);
				isFirst = false;
			} else {
				System.out.print(","+ names[i]);
			}
		}
		System.out.println();
		
		System.out.println("----- ��� 3 -----");
		sbResult.setLength(0);
		for (int i=0; i<names.length; i++) {
			//������ �����͸�
			if (i == names.length-1) {
				sbResult.append(names[i]);
			} else {
				sbResult.append(names[i]).append(",");
			}
		}
		System.out.println(sbResult);
		
		//--------------------------------------------------------
		//4. �������� ù���ڸ� �����ؼ� �޸�(,)�� �����Ͽ� �Ѷ��ο� ���(StringBuilder ���)
		//		(��: ȫ,��,��,T,ȫ,T,��,��,��)
		sbResult.setLength(0);
		isFirst = true;
		for (String name : names) {
			if (isFirst) {
				sbResult.append(name.charAt(0));
				isFirst = false;
			} else {
				sbResult.append(",").append(name.charAt(0));
			}
		}
		System.out.println(sbResult);
		
		//5. �迭�� ���ڿ� �� �̸��� ���ڼ��� 4 �̻��� ���� "��ȣ:�̸�" ���
		//		��¿�:
		//		6:��������
		//		8:�����ҹ�
		sbResult.setLength(0);
		int idx=0;
		for (String str : names) {
			if (str.length() >= 4) {
				System.out.println(idx+ " : "+ str);
			}
			idx++;
		}
		
		
	}
	
}
