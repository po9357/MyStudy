package com.mystudy.pm02_arraylist;

import java.util.*; //java.util�� �ִ� ��� Ŭ����

public class ArrayListExam {

	public static void main(String[] args) {
		//�迭�� �Ӽ��� List �Ӽ��� ����
		ArrayList list1 = new ArrayList();
		System.out.println("list1.size : " + list1.size());
		list1.add(new Integer(5));
		list1.add(1); //int -> Integer �ڵ� ����ȯ �Ǿ� �Է�ó��
		list1.add(new Integer(5));
		list1.add(new Integer(6));
		list1.add(new Integer(7));
		list1.add(new Integer(8));
		System.out.println(list1);
		System.out.println(list1.toString());
		System.out.println("list1.size : " + list1.size());
		Collections.reverse(list1);
		System.out.println("reverse()��: " + list1);
		
		System.out.println("-----");
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		System.out.println(list2);
		
		System.out.println("---- Collections.sort() ----");
		System.out.println("list1 : " + list1);
		Collections.sort(list1);
		System.out.println("list1 : " + list1);
		
		Collections.sort(list2);
		System.out.println("list2 : " + list2);
		
		System.out.println("----- Collections.reverse() ---");
		//reverse() : ó���� ���� ��ġ�� ���� �ٲٴ� ���·� ����
		Collections.reverse(list1);
		System.out.println("list1 : " + list1);
		
		
		System.out.println("==========================");
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		
		list2.add("B");
		list2.add("TEST");
		System.out.println("list2: "+ list2);
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " - " + list2.get(i));
		}
		System.out.println("------");
		print(list1, list2);
		System.out.println("list1.retainAll(list2): " 
				+ list1.retainAll(list2));
		print(list1, list2);
		
		System.out.println("------------------");
		System.out.println(">> list2���� list1�� ���Ե� ��ü ����");
		print(list1, list2);
		
//		System.out.println("list2.removeAll(list1) ����: "
//				+ list2.removeAll(list1));
//		print(list1, list2);
		
		//������ ����Ÿ�� �ִ� Ȯ���ϰ� ������ ����
		System.out.println("list1.contains(list2.get(0)): "
				+ list1.contains(list2.get(0)));
		if (list1.contains(list2.get(0))) {
			list2.remove(0);
		}
		print(list1, list2);
		
		System.out.println("---- �ݺ����� �̿��� ����Ÿ ���� ---");
		//������ �� : Ư�� �ε��� ���� �����ϸ� ���ʿ� �ִ� ����Ÿ�� ������ �̵���
		System.out.println("list1: " + list1);
		//int listCnt = list1.size();
		//����Ÿ ��ü�� ���Ͽ� ���� ó���Ϸ��� �Ͽ����� �Ϻθ� �����Ǵ� ����� ����
		//���ʿ��� ���� ���� ó�� �۾��ؾ� ���������� ó�� ����
		for (int i = 0; i < list1.size(); i++) {
			list1.remove(i);
		}
		System.out.println("list1: " + list1);
		System.out.println("---------------------");
		print(list1, list2);
		
		//������ ����(�δ��� ��ġ�� �̿�)
		System.out.println("list2.set(0, \"A\") : "+ list2.set(0, "A"));
		print(list1, list2);
		
		list2.add(1, "BB");					//�߰�(insert)
		print(list1, list2);
		
		System.out.println("--------------");
		printData(list1);
		printData(list2);
		
		printData("list1", list1);
		
	}

	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		System.out.println();
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
