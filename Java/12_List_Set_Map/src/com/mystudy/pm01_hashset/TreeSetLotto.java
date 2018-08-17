package com.mystudy.pm01_hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetLotto {

	public static void main(String[] args) {
		//TreeSet : Set Ư�� + �������� ����
		Set lotto = new TreeSet();
		
		//Set�� �̿��� �ζ� ����� : 1~45 �������� 6���� set�� ����
		//�ζǹ�ȣ 6���� ��÷�ϰ�, ���� ���ں��� ������� ȭ�鿡 ǥ��
		//Math.random();
		//��� ���
		//������ �ζǹ�ȣ : 5, 8, 10, 25, 33, 44
		
		
		int ran;
//		for (; lotto.size() < 6;) {}			//�̿� ���� for�� ��� ����
		while (lotto.size()<6) {
			ran = (int)(Math.random()*45+1);
			lotto.add(ran);
		}
		System.out.println("-- TreeSet�� �����ϸ鼭 ���� --");
		System.out.println(lotto);				//KEY���� �������� ����
		((TreeSet)lotto).pollFirst();
		System.out.println(lotto);
		((TreeSet)lotto).pollLast();
		System.out.println(lotto);
		
		
		//Set -> List�� ���� ��ȯ �� Collections.sort�� �̿���
		//������ �� �ʿ䰡 ����. TreeSet�� ����ϴ� ��� �����Ͱ� ������ �Ǿ� ����Ǳ� ����.
		Iterator ite = lotto.iterator();
		
		System.out.print("�ζ� ��÷ ��ȣ : "+ ite.next());
		while (ite.hasNext()) {
			System.out.print(", "+ ite.next());
		}
		System.out.println();
		
	}
}
