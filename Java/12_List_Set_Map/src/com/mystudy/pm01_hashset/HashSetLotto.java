package com.mystudy.pm01_hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetLotto {

	public static void main(String[] args) {
		Set lotto = new HashSet();
		
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
		System.out.println(lotto);
		
		System.out.println("--- setŸ���� listŸ������ ---");
		List lottoList = new ArrayList(lotto);					//set, list ��� Collection Ÿ��
		
		System.out.println("--- �������� ���� (Collections.sort) ---");
		Collections.sort(lottoList);
		
		Iterator ite = lottoList.iterator();
		
		System.out.print("�ζ� ��÷ ��ȣ : "+ ite.next());
		while (ite.hasNext()) {
			System.out.print(", "+ ite.next());
		}
		System.out.println();
		
	}
}
