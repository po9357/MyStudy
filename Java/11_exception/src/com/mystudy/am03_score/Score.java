package com.mystudy.am03_score;

class ScoreVO {
	//필드(속성)
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	//생성자
	public ScoreVO() {}
	public ScoreVO(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		tot();
		avg();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		tot();
		avg();
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		if (kor < 0 || kor > 100) {
			System.out.println("[예외 발생] 점수 범위 벗어남(0 ~ 100)");
			return;
		}
		this.kor = kor;
		tot();
		avg();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) throws ScoreOutOfValueException{
		if (eng < 0 || eng > 100) {
			//예외 발생 시키기
			throw new ScoreOutOfValueException();
		}
		this.eng = eng;
		tot();
		avg();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		tot();
		avg();
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
	
	public int tot() {
		int tot = kor + eng + math;
		
		return this.tot = tot;
	}
	public double avg() {
		double avg = (tot*100) / 3 / 100.0;
		return this.avg = avg;
	}
	
	@Override
	public String toString() {
		return "ScoreVO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot + ", avg="
				+ avg + "]";
	}
	
	//기능(메소드)
	
}
