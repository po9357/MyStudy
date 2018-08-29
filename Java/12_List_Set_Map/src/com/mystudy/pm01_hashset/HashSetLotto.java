package com.mystudy.pm01_hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetLotto {

	public static void main(String[] args) {
		Set lotto = new HashSet();
		
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
		System.out.println(lotto);
		
		System.out.println("--- set타입을 list타입으로 ---");
		List lottoList = new ArrayList(lotto);					//set, list 모두 Collection 타입
		
		System.out.println("--- 오름차순 정렬 (Collections.sort) ---");
		Collections.sort(lottoList);
		
		Iterator ite = lottoList.iterator();
		
		System.out.print("로또 추첨 번호 : "+ ite.next());
		while (ite.hasNext()) {
			System.out.print(", "+ ite.next());
		}
		System.out.println();
		
	}
}
