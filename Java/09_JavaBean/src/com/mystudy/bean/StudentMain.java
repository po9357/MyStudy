package com.mystudy.bean;

public class StudentMain {

	public static void main(String[] args) {
		//�ڹٺ� ����ϱ�
		Student stu = new Student("ȫ�浿", 100, 90, 80);
		System.out.println(stu);
		System.out.println(stu.getName());
		
		//���� ���ϰ� ����
		int tot = stu.getKor() + stu.getEng() + stu.getMath();
		//stu.setTot(stu.getKor() + stu.getEng() + stu.getMath());
//		stu.setTot(tot);
		System.out.println(stu);
		
		//��� �� ���ϰ� ����
		double avg = (tot * 100) / 3 / 100.0;
//		stu.setAvg(avg);
		System.out.println(stu);
		
		//�������� 80 -> 81 ����
		stu.setMath(81);
		System.out.println("���� 80->81 ������: " + stu);
		
		//����, ��� ����
//		stu.setTot(stu.getKor() + stu.getEng() + stu.getMath());
//		stu.setAvg((stu.getTot() * 100) / 3 / 100.0);
		
//		stu.setTot(300);
//		stu.setAvg(100);
		System.out.println("����, ��� ������: " + stu);
		
		Student stu2 = new Student("�̼���", 100, 90, 81);
		stu2.setMath(89);
		System.out.println(stu2);
		
		
		System.out.println("-----------------------------------");
		System.out.println(stu2);
		Student st = new Student();
		System.out.println(st);
	}
	

}
