package com.mystudy.pm01_hashset;

import java.util.*;
import java.util.Iterator;
import java.util.Set;

class Person {
	String name;
	int age;
	String jumin;
	Person(String name, int age, String jumin) {
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", jumin=" + jumin + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jumin == null) ? 0 : jumin.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (jumin == null) {
			if (other.jumin != null)
				return false;
		} else if (!jumin.equals(other.jumin))
			return false;
		return true;
	}
	
	
}

public class HashSetExam2 {
	
	public static void main(String[] args) {
		//Set은 중복데이터는 하나만 저장
		//참조형 데이터의 동일 데이터 여부는 equals 메소드 기준
		HashSet set = new HashSet();
		set.add("ab");
		set.add("abc");
		set.add("def");
		set.add(new Person("홍길동", 27, "901010-1111111"));
		Person person = new Person("홍길동2", 28, "901010-1222222");
		set.add(person);
		Person person2 = person;
		set.add(person);
		System.out.println("--------");
		System.out.println(set.contains("홍길동"));
		System.out.println("--------");
		
		System.out.println(set);
		System.out.println("=====================");
		
		//전체 데이터 조회해서 화면 출력
		Iterator ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		//--------
		set.add(new Person("홍길동", 27, "901010-1111111"));
		System.out.println("-----------------");
		//전체 데이터 조회
		ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
	}
	
		static void printData(Set set) {
			Iterator ite = set.iterator();
			
		}
	
}