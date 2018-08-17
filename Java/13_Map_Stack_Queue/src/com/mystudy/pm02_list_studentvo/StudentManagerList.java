package com.mystudy.pm02_list_studentvo;

import java.util.ArrayList;

public class StudentManagerList {
	private ArrayList<StudentVO> score = new ArrayList<>();
	static final String TITLE = "�̸�\t����\t����\t����\t����\t���";
	static final String LINE = "-----------------------"
				+ "------------------------------";
	void inputBasicData() {
		score.add(new StudentVO("ȫ�浿", 100,90,81));
		score.add(new StudentVO("������", 90,90,90));
		score.add(new StudentVO("ȫ�淡", 80,80,80));
	}
	
	void inputData(StudentVO vo) {
		score.add(vo);
	}
	void inputData(String name, int kor, int eng, int math) {
		score.add(new StudentVO(name, kor, eng, math));
	}
	
	//[�����ǽ�] ���޹��� VO�� name�� 
	//score ��Ͽ� �ִ� VO�� name�� ���� ����Ÿ ���� 					//��
	boolean deleteData(StudentVO vo) {
		//StudentVO Ÿ���� ���� ���޹޾� score ��Ͽ��� ����
		boolean result = false;
		for (int i = 0; i < score.size(); i++) {
			if (vo.getName() == score.get(i).getName()) {
				score.remove(score.get(i));
				result = true;
			}
		}
		return result;
	}
	
	//[�����ǽ�] �̸��� �޾Ƽ� ���� �̸��� ��ü ����					//��
	boolean deleteData(String name) {
		//�̸��� ���޹޾� score ���� ���� ó��
		boolean result = false;
		for (int i = 0; i < score.size(); i++) {
			if (name == score.get(i).getName()) {
				score.remove(score.get(i));
				result = true;
			}
		}
		return result;
	}
	
	//[�����ǽ�] ���޹��� VO�� name�� 
	//score ��Ͽ� �ִ� VO�� name�� ���� ����Ÿ ����					//��
	boolean updateData(StudentVO vo) {
		//1.�̸��� ���޹޾� score ���� ã��
		//2.ã������ ���޹��� VO�� ����,����,������� score���� ã�� VO�� ����
		boolean result = false;
		System.out.println("�Է� ���� �� : "+ vo);
		for (int i = 0; i < score.size(); i++) {
			if (vo.getName() == score.get(i).getName()) {
				score.remove(score.get(i));
				score.add(vo);
				result = true;
			}
		}
		
		return result;
	}
	
	
	//[�����ǽ�]
	StudentVO getData(String name) {					//��
		StudentVO result = new StudentVO();
		
		//���޹��� �̸��� ������ �ִ� StudentVO ��ü ã��
		for (int i = 0; i < score.size(); i++) {
			if (name == score.get(i).getName()) {
				System.out.println(score.get(i));
				result = score.get(i);
			}
		}
		return result;
	}
	
	//[�����ǽ�]���� �̻��� ��� ��� ��ȸ
	ArrayList<StudentVO> getData(double avg) {			//��
		ArrayList<StudentVO> result = new ArrayList<StudentVO>();
		
		//list�� �ִ� ����Ÿ���� ���޹��� ��հ�(avg) �̻��� ����Ÿ ã�Ƽ�
		//result�� ��Ƽ� ����
		for (int i = 0; i < score.size(); i++) {
			if (score.get(i).getAvg() >= avg) {
				System.out.println(score.get(i));
				result.add(score.get(i));
			}
		}
		return result;
	}
	
	//��ü ����Ÿ ���(Ÿ��Ʋ ��¾��� ����Ÿ��)
	void printDataAll() {
		//score �ʵ忡 ����ִ� ����Ÿ�� ���
		for (StudentVO vo : score) {
			printDataOne(vo, "\t");
		}
	}
	
	//�ϳ��� ����Ÿ�� ���(VO�� ��±�����)
	void printDataOne(StudentVO vo, String delim) {
		if (vo == null) return;
		System.out.print(vo.getName());
		System.out.print(delim + vo.getKor());
		System.out.print(delim + vo.getEng());
		System.out.print(delim + vo.getMath());
		System.out.print(delim + vo.getTot());
		System.out.print(delim + vo.getAvg());
		System.out.println();
	}
	void printTitle() {
		System.out.println(TITLE);
		System.out.println(LINE);
	}
	void printScore() {
		printTitle();
		printDataAll();
		
		
	}
}
