package com.mystudy.pm01_hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetLotto {

	public static void main(String[] args) {
		//TreeSet : Set 특성 + 데이터의 정렬
		Set lotto = new TreeSet();
		
		//Set을 이용한 로또 만들기 : 1~45 랜덤숫자 6개를 set에 저장
		//로또번호 6개를 추첨하고, 작은 숫자부터 순서대로 화면에 표시
		//Math.random();
		//출력 결과
		//금주의 로또번호 : 5, 8, 10, 25, 33, 44
		
		
		int ran;
//		for (; lotto.size() < 6;) {}			//이와 같은 for문 사용 가능
		while (lotto.size()<6) {
			ran = (int)(Math.random()*45+1);
			lotto.add(ran);
		}
		System.out.println("-- TreeSet은 저장하면서 정렬 --");
		System.out.println(lotto);				//KEY값을 기준으로 정렬
		((TreeSet)lotto).pollFirst();
		System.out.println(lotto);
		((TreeSet)lotto).pollLast();
		System.out.println(lotto);
		
		
		//Set -> List와 같이 변환 후 Collections.sort를 이용해
		//정렬을 할 필요가 없다. TreeSet을 사용하는 경우 데이터가 정렬이 되어 저장되기 때문.
		Iterator ite = lotto.iterator();
		
		System.out.print("로또 추첨 번호 : "+ ite.next());
		while (ite.hasNext()) {
			System.out.print(", "+ ite.next());
		}
		System.out.println();
		
	}
}
