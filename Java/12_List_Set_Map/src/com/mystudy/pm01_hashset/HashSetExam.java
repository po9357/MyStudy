package com.mystudy.pm01_hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		//Set �������̽��� ������ ����ü
		//HashSet set = new HashSet();
		Set set = new HashSet();
		
		set.add("1");						//String Ÿ��
		set.add(new Integer(1));			//Integer Ÿ��
		set.add("ȫ�浿");
		set.add("ȫ�浿");
		System.out.println(set);			//�ߺ��� ������� �ʴ´�. (���� �����ʹ� ������ ������ ���)
		
		set.remove("1");
		System.out.println(set);
		System.out.println("set.contains(1) : "+ set.contains(1));
		System.out.println("set.size() : "+ set.size());
		set.add("������");
		set.add("��������");
		
		System.out.println("--- Set ��ü ������ ��ȸ ---");
		Iterator ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		//���� : ������ -> ȫ�淡
		System.out.println(set);
		System.out.println("������ �ִ��� Ȯ�� : "+ set.contains("������"));
		set.remove("������");					//������ ���� �迭�̱⿡
		set.add("ȫ�淡");					//�����ϰ� �߰�. (set, get���� �޼ҵ尡 ����)
		System.out.println(set);
		
		
		
		
		//�ζ� �����
		Set lot = new HashSet();
		
		
	

	}

}
