package com.mystudy.pm01_map_score;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapScoreExam {
	
	public static void main(String[] args) {
		//1. HashMap<String, Integer> 타입의 변수 map을 선언하고
		//2. map에 이름:점수 형태의 아래의 데이타를 입력
		//   "홍길동:100, 강감찬:90, 을지문덕:95, 계백:87, 김유신:92"
		//3. 입력된 데이타를 조회해서 점수의 총점을 tot에 저장
		//4. 총점(tot)의 값을 인원 수로 나눈 평균 값을 avg에 저장
		//5. 출력하시오.
		//   성명  점수
		//   -----------
		//   이름: 점수
		//   이름: 점수
		//   ...
		//   이름: 점수
		//   ==========
		//   총점: ???
		//   평균: ???
		////////////////////////////////////////////
		int sum=0;
	
		Map<String, Integer> score = new HashMap<String, Integer>();
		score.put("홍길동", 100);
		score.put("강감찬", 90);
		score.put("을지문덕", 95);
		score.put("계백", 87);
		score.put("김유신", 92);

		Set<Map.Entry<String, Integer>> scoreSet = score.entrySet();
		Iterator<Map.Entry<String, Integer>> scoreIte = scoreSet.iterator();
		
		while (scoreIte.hasNext()) {
			Map.Entry<String, Integer> e = scoreIte.next();
			sum += e.getValue();
		}
		
		System.out.println("이름 \t점수");
		System.out.println("------------");
		scoreIte = scoreSet.iterator();
		while (scoreIte.hasNext()) {
			Map.Entry<String, Integer> e = scoreIte.next();
			System.out.println(e.getKey() +" :\t"+ e.getValue());
		}
		System.out.println("============");
		System.out.println("총점 : \t"+ sum);
		double avg = (sum * 100) / scoreSet.size() / 100.0;
		System.out.println("평균 : \t"+ avg);
		
	}
	
}
