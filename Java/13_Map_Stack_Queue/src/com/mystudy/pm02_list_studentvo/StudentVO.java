package com.mystudy.pm02_list_studentvo;

//빈(Bean) 객체 만들기
//VO(Value Object) : 값을 저장하기 위한 클래스(객체)
//DTO(Data Transfer Object) : 값을 서로 전달하기 위한 객체
//StudentVO, StudentDTO, StudentVo, StudentDto ...
public class StudentVO {
	private String name;	//이름
	private int kor;		//국어 점수
	private int eng;		//영어 점수
	private int math;		//수학 점수
	private int tot;		//총점
	private double avg;		//평균
	
	//생성자 국어, 영어, 수학 점수를 입력받는 생성자 (tot, avg 자동계산)
	public StudentVO(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		calcTotAvg();
	}

	public StudentVO() {
		// TODO Auto-generated constructor stub
	}

	//모든 필드(멤버변수)의 setter, getter 작성
	//(국어, 영어, 수학 점수가 바뀌면 tot, avg 자동 수정 되도록 처리)
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
		calcTotAvg();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		calcTotAvg();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		calcTotAvg();
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

	//toString() 오버라이딩
	@Override
	public String toString() {
		return "StudentVO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot
				+ ", avg=" + avg + "]";
	}
	
	//tot, avg 계산하는 메소드 작성
	public void calcTotAvg() {
		this.tot = kor + eng + math;
		this.avg = (tot * 100) / 3 / 100.0;
	}
	
	//printData 메소드 추가
	///(이름\t국어\t영어\t...)
	public void printData () {
		System.out.println(this.name+"\t"+this.kor+"\t"+this.eng+"\t"+this.math+"\t"+this.tot+"\t"+this.avg);
	}
	
	
	
}
