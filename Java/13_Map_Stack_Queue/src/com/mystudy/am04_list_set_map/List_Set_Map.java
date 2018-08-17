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
		//1, List 사용
		//이름 등록 : 홍길동, 강감찬, 홍경래, 이순신
		//저장된 데이터를 조회해서 화면에 출력 (index : 데이터)
		System.out.println("--- List 사용 ---");
		List list = new ArrayList();
		list.add("홍길동");
		list.add("강감찬");
		list.add("홍경래");
		list.add("이순신");
		list.add("김유신");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1)+ " : "+ list.get(i));
		}
		
		/////////////////////////////////////
		//2. Set 사용
		//이름 등록 : 홍길동, 강감찬, 홍경래, 이순신
		//저장된 데이터를 조회해서 화면에 출력 (오름차순으로 출력)
		System.out.println("--- Set 사용 ---");
		Set set = new TreeSet(list);
		Iterator ite = set.iterator();
		int index = 1;
		while (ite.hasNext()) {
			System.out.println(index + " : "+ ite.next());
			index++;
		}
		/////////////////////////////////
		//3. Map 사용
		//k - v : 1810 - 홍길동, 1811 - 강감찬, 1812 - 홍경래, 1813 - 이순신
		//저장된 데이터를 조회해서 화면에 출력 (key 기준 오름차순으로 출력)
		System.out.println("--- Map 사용 ---");
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("홍길동", 1810);
		map.put("강감찬", 1811);
		map.put("홍경래", 1812);
		map.put("이순신", 1813);
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
