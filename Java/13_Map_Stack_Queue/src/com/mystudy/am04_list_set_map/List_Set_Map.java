package com.mystudy.am04_list_set_map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class List_Set_Map {
	
	public static void main(String[] args) {
		//1, List ���
		//�̸� ��� : ȫ�浿, ������, ȫ�淡, �̼���
		//����� �����͸� ��ȸ�ؼ� ȭ�鿡 ��� (index : ������)
		System.out.println("--- List ��� ---");
		List list = new ArrayList();
		list.add("ȫ�浿");
		list.add("������");
		list.add("ȫ�淡");
		list.add("�̼���");
		list.add("������");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1)+ " : "+ list.get(i));
		}
		
		/////////////////////////////////////
		//2. Set ���
		//�̸� ��� : ȫ�浿, ������, ȫ�淡, �̼���
		//����� �����͸� ��ȸ�ؼ� ȭ�鿡 ��� (������������ ���)
		System.out.println("--- Set ��� ---");
		Set set = new TreeSet(list);
		Iterator ite = set.iterator();
		int index = 1;
		while (ite.hasNext()) {
			System.out.println(index + " : "+ ite.next());
			index++;
		}
		/////////////////////////////////
		//3. Map ���
		//k - v : 1810 - ȫ�浿, 1811 - ������, 1812 - ȫ�淡, 1813 - �̼���
		//����� �����͸� ��ȸ�ؼ� ȭ�鿡 ��� (key ���� ������������ ���)
		System.out.println("--- Map ��� ---");
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("ȫ�浿", 1810);
		map.put("������", 1811);
		map.put("ȫ�淡", 1812);
		map.put("�̼���", 1813);
		System.out.println(map);
		
		Set<Map.Entry<String, Integer>> set1 = new TreeSet<Map.Entry<String, Integer>>();
		set1 = map.entrySet();
		Iterator<Map.Entry<String, Integer>> ite1 = set1.iterator(); 
		ite1 = set1.iterator();
		
		while (ite1.hasNext()) {
			Map.Entry<String, Integer> entry =  ite1.next();
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}
		
	
	}
	
}
