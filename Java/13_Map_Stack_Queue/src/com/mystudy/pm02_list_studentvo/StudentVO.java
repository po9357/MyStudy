package com.mystudy.pm02_list_studentvo;

//��(Bean) ��ü �����
//VO(Value Object) : ���� �����ϱ� ���� Ŭ����(��ü)
//DTO(Data Transfer Object) : ���� ���� �����ϱ� ���� ��ü
//StudentVO, StudentDTO, StudentVo, StudentDto ...
public class StudentVO {
	private String name;	//�̸�
	private int kor;		//���� ����
	private int eng;		//���� ����
	private int math;		//���� ����
	private int tot;		//����
	private double avg;		//���
	
	//������ ����, ����, ���� ������ �Է¹޴� ������ (tot, avg �ڵ����)
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

	//��� �ʵ�(�������)�� setter, getter �ۼ�
	//(����, ����, ���� ������ �ٲ�� tot, avg �ڵ� ���� �ǵ��� ó��)
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

	//toString() �������̵�
	@Override
	public String toString() {
		return "StudentVO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot
				+ ", avg=" + avg + "]";
	}
	
	//tot, avg ����ϴ� �޼ҵ� �ۼ�
	public void calcTotAvg() {
		this.tot = kor + eng + math;
		this.avg = (tot * 100) / 3 / 100.0;
	}
	
	//printData �޼ҵ� �߰�
	///(�̸�\t����\t����\t...)
	public void printData () {
		System.out.println(this.name+"\t"+this.kor+"\t"+this.eng+"\t"+this.math+"\t"+this.tot+"\t"+this.avg);
	}
	
	
	
}
