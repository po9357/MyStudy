package com.mystudy.io6_object;

import java.io.Serializable;

//Serializable 인터페이스 : 데이타 전송을 위한 Object를 만들 때
//Serializable 인터페이스를 구현해 주어야 전송할 수 있는 타입이 됨
public class StudentVO implements Serializable {
	private String id;
	private String name;
	private int kor;
	private int eng; //property 선언
	private int math; //math : int
	private int tot;
	private double avg;
	
	public StudentVO(String id, String name, int kor, int eng, int math) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		computeTotAvg();
	}
	
	public StudentVO(String id, String name, int kor, int eng, 
			int math, int tot, double avg) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.tot = tot;
		this.avg = avg;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//명칭 : get메소드, getter, get property
	public String getName() {
		return this.name;
	}
	
	//명칭: set메소드, setter, set property
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKor() {
		return this.kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
		computeTotAvg();
	}

	@Override
	public String toString() {
		return "[ID: "+ id + ", 성명:" + name + ", 국어:" + kor + ", 영어:" + eng + 
				", 수학:" + math + ", 총점:" + tot + ", 평균:" + avg + "]";
	}

	//eng, math, tot, avg : setter, getter 정의(실습)
	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		computeTotAvg();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		computeTotAvg();
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	public void computeTotAvg() {
		this.tot = kor + eng + math;
		this.avg = (tot * 100) / 3 / 100.0;
	}
	
	
}
