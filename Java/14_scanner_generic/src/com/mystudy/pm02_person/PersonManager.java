package com.mystudy.pm02_person;

import java.util.ArrayList;

public class PersonManager {

	public static void main(String[] args) {
		ArrayList<PersonVO> list = new ArrayList<>();
		
		PersonVO person = new PersonVO("ȫ�浿", 27);
		
		list.add(person);
		
		System.out.println(list);
		System.out.println("-----------------------");
		System.out.println("person : "+ person);
		person = new PersonVO("������", 30);
		System.out.println("person : "+ person);
		
		list.add(person);
		System.out.println(list);
		
		for (PersonVO vo : list) {
			System.out.println("�̸� : "+ vo.getName());
			System.out.println("���� : "+ vo.getAge());
		}
		
		
		
	}

}
