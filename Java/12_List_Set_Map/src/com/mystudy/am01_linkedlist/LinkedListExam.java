package com.mystudy.am01_linkedlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExam {

	public static void main(String[] args) {
		//LinkedList : List �Ӽ�
		LinkedList list = new LinkedList();
		
		String str = "ȫ�浿,������,������,��������,ȫ�淡";
		String[] strs = str.split(",");
		System.out.println("strs : "+ Arrays.toString(strs));
		
		//�迭�� �ִ� ���� ����Ʈ�� �߰�
		for (int i = 0; i < strs.length; i++) {
			list.add(strs[i]);
		}
		System.out.println("list : "+ list);
		printData(list);
		printData("list", list);
		
		System.out.println("-----------------------");
		Collections.reverse(list);
		printData("reverse(list)", list);
		
		Collections.sort(list);
		printData("list", list);
		
		//������ ����
		list.remove("������");
		printData(list);
		
		//ȫ�浿 -> ȫ�浿2 ����
		//ȫ�浿 �ε����� ã��, set �޼ҵ� ���
		System.out.println("ȫ�浿 ��ġ��(indexOf) : "+ list.indexOf("ȫ�浿"));
		//list.set(3, "ȫ�浿2");
		list.set(list.indexOf("ȫ�浿"),  "ȫ�浿2");
		printData("list", list);
		
		System.out.println("--- ��ü ������ ��ȣ : �̸� ���� ��� ---");
		//1 : ������
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + " : " + list.get(i));
		}
		
		System.out.println("--------------------------");
		int cnt=0;
		while (true) {
			System.out.println((cnt+1) + " : " + list.get(cnt));
			cnt++;
			if(cnt == list.size()) break;
		}
//		cnt=0;
//		while (cnt < list.size()) {
//			System.out.println((cnt+1) + " : " + list.get(cnt));
//			cnt++;
//		}
		System.out.println("--------------------------");
		cnt=1;
		for (Object obj : list) {
			System.out.println(cnt +" : "+ obj);
			cnt++;
		}
		
	}
	
	static void printData(List list) {
		//null ���� Ȯ��
		if (list == null) return;
		
		System.out.print(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			System.out.print(", "+ list.get(i));
		}
		System.out.println();
	}
	
	static void printData(String str, List list) {
		//null ���� Ȯ��
		if (list == null) return;
		
		System.out.print(str+ " : ");
		System.out.print(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			System.out.print(", "+ list.get(i));
		}
		System.out.println();
	}
}
