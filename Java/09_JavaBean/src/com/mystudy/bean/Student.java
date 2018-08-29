package com.mystudy.bean;

public class Student {
	//자바 빈 생성 규칙
	//1. 멤버변수(property)의 접근제한자는 private 선언
	//2. 멤버변수(property)를 사용할 수 있는 set/get 메소드 제공
	//   (필요에 따라 get 메소드만 제공 할 수 있음)
	//2-1. get메소드는 파라미터가 없고, set메소드는 1개 이상의 파라미터를 가진다
	//3. set/get 메소드는 접근제한자를 public 선언
	//4. 멤버변수(property)의 타입이 boolean인 경우 get 대신 is 사용 가능
	//5. 외부에서 멤버변수(property)에 접근할 때는 set/get 메소드를 통해 접근
	
	private String name;
	private int kor;
	private int eng; //property 선언
	private int math; //math : int
	private int tot;
	private double avg;
	
	public Student() {
		super(); //부보클래스의 기본생성자 호출
	}

	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
//		this.tot = kor + eng + math;
//		this.avg = (tot * 100) / 3 / 100.0;
		computeTotAvg();
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
//		this.tot = kor + eng + math;
//		this.avg = (tot * 100) / 3 / 100.0;
		computeTotAvg();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot + ", avg="
				+ avg + "]";
	}

	//eng, math, tot, avg : setter, getter 정의(실습)
	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
//		this.tot = kor + eng + math;
//		this.avg = (tot * 100) / 3 / 100.0;
		computeTotAvg();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
//		this.tot = kor + eng + math;
//		this.avg = (tot * 100) / 3 / 100.0;
		computeTotAvg();
	}

	public int getTot() {
		return tot;
	}

//	public void setTot(int tot) {
//		this.tot = tot;
//	}

	public double getAvg() {
		return avg;
	}

//	public void setAvg(double avg) {
//		this.avg = avg;
//	}
	
	public void computeTotAvg() {
		this.tot = kor + eng + math;
		this.avg = (tot * 100) / 3 / 100.0;
	}
	
}
