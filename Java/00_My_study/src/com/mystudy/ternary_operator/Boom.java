package com.mystudy.ternary_operator;

import java.util.ArrayList;


public class Boom {
	public static void main(String[] args) {
		
		Hungry.abc();
//		Hungry.cba();
		System.out.println(Hungry.a);
//		System.out.println(Hungry.b);
		Hungry hg = new Hungry();
		System.out.println(hg.abc());
		System.out.println(hg.a);
		Hungry.slist.add(1);
		hg.b = 0;
		hg.list.add(1);
		hg.list.add(2);
		hg.list.add(3);
		hg.list.add(4);
		hg.list.add(5);
		for (int i = 0; i < hg.list.size(); i++) {
			System.out.println(hg.list.get(i));
		}
	}
}
