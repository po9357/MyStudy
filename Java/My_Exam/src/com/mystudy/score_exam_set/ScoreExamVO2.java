package com.mystudy.score_exam_set;

public class ScoreExamVO2 {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public ScoreExamVO2() {
		this.name = "길동이";
		this.kor = 0;
		this.eng = 0;
		this.math = 0;
	}
	
	public ScoreExamVO2 (String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		getTot();
		getAvg();
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTot() {
		tot = kor + eng + math;
		return tot;
	}
	
	public double getAvg() {
		avg = (tot * 100) / 3 / 100.0;
		return avg;
	}

	@Override
	public String toString() {
		return "ScoreExamVO2 [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot
				+ ", avg=" + avg + "]";
	}
	
	public void printDataAll (ScoreExamVO2 vo) {
		System.out.println(vo.getName()+ "\t"+ vo.getKor()+ "\t" +vo.getEng()+ "\t" +vo.getMath()+ "\t" +vo.getTot()+ "\t" +vo.getAvg());
	}
	
	public void printDataSet () {
		System.out.println(getName()+ "\t"+ getKor()+ "\t" +getEng()+ "\t" +getMath()+ "\t" +getTot()+ "\t" +getAvg());
	}
	
	
}
