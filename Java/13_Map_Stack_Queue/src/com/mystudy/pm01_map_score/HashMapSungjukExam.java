package com.mystudy.pm01_map_score;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapSungjukExam {
	HashMap<String, Integer> sungjuk;
	int tot;
	double avg;
	
	void printData() {
		//5. 출력하시오.
		//   성명  점수
		//   -----------
		//   홍길동: 100
		//   강감찬: 90
		//   ...
		//   김유신: 92
		//   ==========
		//   총점: ???
		//   평균: ???
		System.out.println("성명\t점수");
		System.out.println("--------------");
		
		//데이타 출력
		displayData("\t");
		
		System.out.println("==============");
		System.out.println("총점\t" + tot);
		System.out.println("평균\t" + avg);
		
	}

	void computeAvg() {
		//4. 총점(tot)의 값을 인원 수로 나눈 평균 값을 avg에 저장
		computeTot();
		avg = (tot * 100) / sungjuk.size() / 100.0;
		
	}

	void computeTot() {
		//3. 입력된 데이타를 조회해서 점수의 총점을 tot에 저장
		tot = 0;
		for (String name : sungjuk.keySet()) {
			tot += sungjuk.get(name);
		}
		
	}

	void inputData() {
		//2. map에 이름:점수 형태의 아래의 데이타를 입력
		//   "홍길동:100, 강감찬:90, 을지문덕:95, 계백:87, 김유신:92"
		sungjuk.put("홍길동", 100);
		sungjuk.put("강감찬", 90);
		sungjuk.put("을지문덕", 95);
		sungjuk.put("계백", 87);
	}
	
	void displayData() {
		for (String name : sungjuk.keySet()) {
			System.out.println(name + ":" + sungjuk.get(name));
		}
	}
	void displayData(String delim) {
		for (String name : sungjuk.keySet()) {
			System.out.println(name + delim + sungjuk.get(name));
		}
	}
	
	
	
	
}
