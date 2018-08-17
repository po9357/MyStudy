package com.mystudy.am01_hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExam2 {

	public static void main(String[] args) {
		//Map�� ����� �����͸� Ȯ��
		Map<String, String> map = new HashMap<String, String>();
		map.put("Ű1", "��1");
		map.put("Ű2", "��2");
		map.put("Ű3", "��3");
		map.put("Ű4", "��4");
		map.put("Ű5", "��5");
		System.out.println(map);
		
		int[] num = {1, 2, 3, 4};
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		System.out.println("--- ���� for��(forEach) �̿��� �迭�� ��� ---");
		for (int i : num) {
			System.out.print(i+ " ");
		}
		System.out.println();
		
		//Map ��½� ������ for�� ���
		System.out.println("--- Map�� ������ for������ ��ȸ ---");
		for (String key : map.keySet()) {
			System.out.println("key : "+ key + ", value : "+ map.get(key));
		}
		
		System.out.println("--- Map.Entry Ÿ���� ���� for������ ��ȸ ---");
		for (Map.Entry<String, String> entry : map.entrySet()) {				//���� for��
			System.out.println(entry.getKey() +" : "+ entry.getValue());
		}
		//Entry Ÿ���� ���� �޾Ƽ� Ű-�� ��ȸ (iterator)
		System.out.println("--- Map.Entry Ÿ���� ������ ��ȸ(iterator) ---");
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> ite = entrySet.iterator();
		while (ite.hasNext()) {
			Map.Entry<String, String> e = ite.next();
			System.out.println("Ű : "+ e.getKey()+ ", �� : "+ e.getValue());
		}
		
		
		//Ű (key) ���� �޾Ƽ� Ű-�� ��ȸ (iterator)
		System.out.println("--- Map���� Ű (key)�� �޾Ƽ� iterator ��ȸ ---");
		Iterator<String> stringSet = map.keySet().iterator();
		while (stringSet.hasNext()) {
			String key = stringSet.next();
			String value = map.get(key);
			System.out.println("Ű : "+ key+ ", �� : "+ value);
		}
		
		
	}
}
