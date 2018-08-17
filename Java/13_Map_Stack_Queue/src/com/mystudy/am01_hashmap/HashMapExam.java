package com.mystudy.am01_hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExam {

	public static void main(String[] args) {
		//Map : Ű (Key) - �� (value) ������ �����͸� ����
		// - ������ ���� (�� TreeMap�� ��� key�� �������� ���ĵǾ� ����)
		// - Ű (key) : �ߺ� ��� ���� �ʴ´�.
		// - �� (value) : �ߺ��� ��� �ȴ�.
		HashMap map = new HashMap();
		//		key		value
		map.put("ȫ�浿", 100);		//100 -> Integer 100
		map.put("������", new Integer(95));
		map.put("������", 88);
		map.put("���", 88);
		map.put("ȫ�浿", 93);		//������ key���� �����ϸ� ����ó�� ��
		System.out.println(map);
		
		HashMap map2 = new HashMap();
		map2.put("������", 92);
		map2.put("����ġ", 82);
		System.out.println(map2);
		
		System.out.println("map.isEmpty() : "+ map.isEmpty());
		System.out.println("map.get(\"ȫ�浿\") : "+ map.get("ȫ�浿"));
		System.out.println("map.get(\"��������\") : "+ map.get("��������"));
		System.out.println("map.containsKey(\"��������\") : "+ map.containsKey("��������"));
		System.out.println("map.containsValue(88) : "+ map.containsValue(88));

		//////////////////////////////////////////////////////////////////////
		//Map�� Ű (key), �� (value)�� �Բ� �����ؼ� ���
		System.out.println("--- Ű (key) - �� (value) ����  : entrySet() ---");
		Set set = map.entrySet();			//Ű (key)�� �� (value) ��� ����
		Iterator ite = set.iterator();
		while (ite.hasNext()) {
			Map.Entry e = (Entry) ite.next();		//Map.Entry <- Object
			System.out.println("�̸� : "+ e.getKey()+ ", ���� : "+ e.getValue());
		}
		System.out.println(set);

		System.out.println("--- Ű (key) - �� (value) ����  : keySet() ---");
		set = map.keySet();					//Ű (key)�� ����
		System.out.println(set);
		ite = set.iterator();
		while (ite.hasNext()) {
			String key = (String) ite.next();
			Integer value = (Integer) map.get(key);
			System.out.println("�̸� : "+ key+ ", ���� : "+ value);
		}

		//------------------------------
		System.out.println("--- �� (value)�� ���� ��� : values() ---");
		Collection values = map.values();
		ite = values.iterator();
		int sum = 0;
		while (ite.hasNext()) {
			Integer num = (Integer) ite.next();
			System.out.print(num+ " ");
			sum += num;
		}
		System.out.println();
		System.out.println("���� �հ� : "+ sum);
		
	}
}
