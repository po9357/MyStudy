package com.mystudy.am;

public class Ex02_method_overloading {
	public static void main(String[] args) {
		//�޼ҵ� �����ε�
		//���� : ������ �޼ҵ���� ����ؼ� ���� �ٸ� ����� ����
		//1. �ϳ��� Ŭ���� ������ ������ �޼ҵ� ������ ����
		//2. �Ķ����(parameter)�� Ÿ��, ����, ������ �޸��ؼ� �ۼ�
		//	- �޼ҵ��� ����Ÿ���� ����
		//�޼ҵ� �����ε��� Ŭ���� ������ �޼ҵ带 �ߺ�����
		String name = "ȫ�浿";
//		int kor = 100, eng = 90, math = 80;
		int kor = 100;
		int eng = 90;
		int math = 81;
		int tot = kor + eng + math;
		double avg = (tot * 100) / 3 / 100.0;
		//double avg = (int)((tot * 100) / 3.0) / 100.0;
		
		System.out.println(avg);
		
		System.out.println("--- �޼ҵ� ȣ��(����) ---");
		displayData(name, avg, tot);	//String, double, int
		displayData(name, tot, avg);	//String, int, double
		
		//��ü ����
		//static�� ���� �ʾ� Ŭ���� ��ü ���� �� ���
		Ex02_method_overloading mo = new Ex02_method_overloading();
		mo.displayData(name, avg);
		displayData(avg);
		displayData(name);
		displayData(tot);
		displayData(kor, eng, math);
	}
	
	static void displayData(String name, double avg, int tot) {
		System.out.println("1. �̸� : "+ name+ ", ���� : "+ tot +", ��� : "+ avg);
	}
	
	static void displayData(String name, int tot, double avg) {
		System.out.println("2. �̸� : "+ name+ ", ���� : "+ tot +", ��� : "+ avg);
	}
	
	void displayData(String name, double avg) {
		System.out.println("3. �̸� : "+ name +", ��� : "+ avg);
	}
	
	//��հ��� �޾Ƽ� ���
	static void displayData(double avg) {
		System.out.println("4. ��� : "+ avg);
	}
	//�̸��� �޾Ƽ� ���
	static void displayData(String name) {
		System.out.println("5. �̸� : "+ name);
	}
	//������ �޾Ƽ� ���
	static void displayData(int tot) {
		System.out.println("6. ���� : "+ tot);
	}
	//����, ����, ���� ������ �޾Ƽ� ���
	static void displayData(int kor, int eng, int math) {
		System.out.println("7. ���� : "+ kor+ ", ���� : "+ eng +", ���� : "+ math);
	}
	
}
