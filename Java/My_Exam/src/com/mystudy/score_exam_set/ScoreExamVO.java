package com.mystudy.score_exam_set;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ScoreExamVO {
	String name;
	int kor;
	int eng;
	int math;
	int tot;
	double avg;
	
	public ScoreExamVO(){
		this.name = "ȫ�浿";
		this.kor = 0;
		this.eng = 0;
		this.math = 0;
		getTot();
		getAvg();
	}
	
	public ScoreExamVO(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		getTot();
		getAvg();
	}
	
	public void addList(ScoreExamVO sev, List list) {
		list.add(sev.name);
		list.add(sev.kor);
		list.add(sev.eng);
		list.add(sev.math);
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
		getTot();
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
		getTot();
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
		getTot();
	}
	public int getTot() {
		return tot = kor + eng + math;
	}
	
	public void compute(ArrayList list) {
		tot = kor+eng+math;
		avg = (tot*100) / 3 / 100.0;
	}
	
	public double getAvg() {
		return avg = (tot*100) / 3 / 100.0;
	}
	
	@Override
	public String toString() {
		return "ScoreExamVO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot
				+ ", avg=" + avg + "]";
	}
	
	public void printData(List list){
		
		System.out.print(list.get(0)+ "\t"+ list.get(1)+ "\t"+ list.get(2)+ "\t"+ list.get(3)+ "\t"+ getTot()+ "\t"+ getAvg());
		System.out.println();
	}
	
	public void printDataa(List list){
			System.out.print(list.get(0) + "\t"+ list.get(1)+ "\t"+ list.get(2)+ "\t"+ list.get(3)+ "\t"+list.get(4) + "\t"+ list.get(5)
			);
			System.out.println();
	}
	
	public void findName(String name, ArrayList[] list) {
		ScoreExamVO sev = new ScoreExamVO();
		for (int i=0; i<5; i++) {
			if (list[i].contains(name)) {
				sev.printDataa(list[i]);
			}
		}
	}
	
	public void findAvg(double avg, ArrayList[] list) {
		ScoreExamVO sev = new ScoreExamVO();
		for (int i=0; i<5; i++) {
			if ((double)list[i].get(5) >= avg) {
				sev.printDataa(list[i]);
			}
		}
	}
	
	public void addTotAvg(ArrayList[] list) {
		int a;
		int b;
		int c;
		for (int i=0; i<list.length; i++) {
			a = (int) list[i].get(1);
			b = (int) list[i].get(2);
			c = (int) list[i].get(3);
			this.tot = a+b+c;
			list[i].add(tot);
			this.avg = (tot*100) / 3 / 100.0;
			list[i].add(avg);
		}
		
	}
}
