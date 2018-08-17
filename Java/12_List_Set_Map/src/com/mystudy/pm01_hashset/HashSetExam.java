package com.mystudy.pm01_hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		//Set 인터페이스를 구현한 구현체
		//HashSet set = new HashSet();
		Set set = new HashSet();
		
		set.add("1");						//String 타입
		set.add(new Integer(1));			//Integer 타입
		set.add("홍길동");
		set.add("홍길동");
		System.out.println(set);			//중복을 허용하지 않는다. (같은 데이터는 동일한 데이터 취급)
		
		set.remove("1");
		System.out.println(set);
		System.out.println("set.contains(1) : "+ set.contains(1));
		System.out.println("set.size() : "+ set.size());
		set.add("김유신");
		set.add("을지문덕");
		
		System.out.println("--- Set 전체 데이터 조회 ---");
		Iterator ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		//수정 : 김유신 -> 홍경래
		System.out.println(set);
		System.out.println("김유신 있는지 확인 : "+ set.contains("김유신"));
		set.remove("김유신");					//순서가 없는 배열이기에
		set.add("홍경래");					//삭제하고 추가. (set, get등의 메소드가 없다)
		System.out.println(set);
		
		
		
		
		//로또 만들기
		Set lot = new HashSet();
		
		
	

	}

}
