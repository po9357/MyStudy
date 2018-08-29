package com.mystudy.pm02_person;

import java.util.ArrayList;

public class PersonManager {

	public static void main(String[] args) {
		ArrayList<PersonVO> list = new ArrayList<>();
		
		PersonVO person = new PersonVO("홍길동", 27);
		
		list.add(person);
		
		System.out.println(list);
		System.out.println("-----------------------");
		System.out.println("person : "+ person);
		person = new PersonVO("김유신", 30);
		System.out.println("person : "+ person);
		
		list.add(person);
		System.out.println(list);
		
		for (PersonVO vo : list) {
			System.out.println("이름 : "+ vo.getName());
			System.out.println("나이 : "+ vo.getAge());
		}
		
		
		
	}

}
