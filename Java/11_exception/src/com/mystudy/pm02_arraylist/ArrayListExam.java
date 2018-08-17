package com.mystudy.pm02_arraylist;

import java.util.*; //java.util에 있는 모든 클래스

public class ArrayListExam {

	public static void main(String[] args) {
		//배열의 속성과 List 속성을 가짐
		ArrayList list1 = new ArrayList();
		System.out.println("list1.size : " + list1.size());
		list1.add(new Integer(5));
		list1.add(1); //int -> Integer 자동 형변환 되어 입력처리
		list1.add(new Integer(5));
		list1.add(new Integer(6));
		list1.add(new Integer(7));
		list1.add(new Integer(8));
		System.out.println(list1);
		System.out.println(list1.toString());
		System.out.println("list1.size : " + list1.size());
		Collections.reverse(list1);
		System.out.println("reverse()후: " + list1);
		
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
		//reverse() : 처음과 끝의 위치를 서로 바꾸는 형태로 동작
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
		System.out.println(">> list2에서 list1에 포함된 객체 삭제");
		print(list1, list2);
		
//		System.out.println("list2.removeAll(list1) 실행: "
//				+ list2.removeAll(list1));
//		print(list1, list2);
		
		//삭제는 데이타가 있는 확인하고 있으면 삭제
		System.out.println("list1.contains(list2.get(0)): "
				+ list1.contains(list2.get(0)));
		if (list1.contains(list2.get(0))) {
			list2.remove(0);
		}
		print(list1, list2);
		
		System.out.println("---- 반복문을 이용한 데이타 삭제 ---");
		//주의할 것 : 특정 인덱스 값을 삭제하면 뒤쪽에 있는 데이타가 앞으로 이동됨
		System.out.println("list1: " + list1);
		//int listCnt = list1.size();
		//데이타 전체에 대하여 삭제 처리하려고 하였으나 일부만 삭제되는 결과를 얻음
		//뒤쪽에서 부터 삭제 처리 작업해야 정상적으로 처리 가능
		for (int i = 0; i < list1.size(); i++) {
			list1.remove(i);
		}
		System.out.println("list1: " + list1);
		System.out.println("---------------------");
		print(list1, list2);
		
		//데이터 수정(인덕스 위치값 이용)
		System.out.println("list2.set(0, \"A\") : "+ list2.set(0, "A"));
		print(list1, list2);
		
		list2.add(1, "BB");					//추가(insert)
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
		//null 여부 확인
		if (list == null) return;
		
		System.out.print(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			System.out.print(", "+ list.get(i));
		}
		System.out.println();
	}
	
	static void printData(String str, List list) {
		//null 여부 확인
		if (list == null) return;
		
		System.out.print(str+ " : ");
		System.out.print(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			System.out.print(", "+ list.get(i));
		}
		System.out.println();
	}
}
