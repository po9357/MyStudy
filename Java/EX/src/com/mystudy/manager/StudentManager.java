package com.mystudy.manager;

import java.util.ArrayList;

public class StudentManager {
	private ArrayList<StudentVO> list;
//StudentVO(String id, String name, int kor, int eng, int math)
	
	StudentManager() {
		list = new ArrayList<>();
	}
	
	StudentManager(ArrayList<StudentVO> list) {
		this.list = list;
	}

	public StudentVO selectOne(String id) {
		StudentVO result = null;
		//list�� �ִ� ����Ÿ�� ���޹��� id�� ������ �̸��� ����Ÿ�� ������ ����
		//������ null ����
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				return list.get(i);
			}
		}
		
		return result;
	}
	public StudentVO selectOne(StudentVO vo) {
		StudentVO result = null;
		//list�� �ִ� ����Ÿ�� ���޹��� vo�� id�� ������ �̸��� ����Ÿ�� ������ ����
		//������ null ����
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(vo.getId())) {
				return list.get(i);
			}
		}
		return result;
	}
	
	public ArrayList<StudentVO> selectAll() {		//ing
		ArrayList<StudentVO> result = null;
		//��ü ����Ÿ�� ���� ó��
		result = list;
		return result;
	}
	
	public int insert(StudentVO vo) {
		int result = 0;
		//���޹��� vo�� id�� list�� ������ list�� �߰�(1 ����)
		//���޹��� vo�� id�� list�� ������ "�̹� �����ϴ� ����Ÿ" ���(0 ����)
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(vo.getId())) {
				System.out.println("�̹� �����ϴ� ������ �Դϴ�.");
			} else {
				list.add(vo);
				result = 1;
			}
		}
		
		return result;
	}
	
	public void insert1(StudentVO vo) {
		list.add(vo);
	}
	public int update(StudentVO vo) {
		int result = 0;
		//���޹��� vo�� id�� list�� ������ ����ó��(1 ����)
		//	(Ű���� id�� �����ϰ� ��� �����͸� ����ó��)
		//���޹��� vo�� id�� list�� ������ "����Ÿ ����" ���(0 ����)
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(vo.getId())) {
				list.get(i).setAvg(vo.getAvg());
				list.get(i).setEng(vo.getEng());
				list.get(i).setKor(vo.getKor());
				list.get(i).setMath(vo.getMath());
				list.get(i).setName(vo.getName());
				list.get(i).setTot(vo.getTot());
				result = 1;
			} else {
				System.out.println("������ ����");
			}
		}
		
		return result;
	}
	public int delete(StudentVO vo) {
		int result = 0;
		//���޹��� vo�� id�� list�� ������ ����ó��(������ 1 ����, ���н� 0����)
		//���޹��� vo�� id�� list�� ������ "����Ÿ ����" ���(0 ����)
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(vo.getId())) {
				list.remove(i);
				result = 1;
			} else {
				System.out.println("������ ����");
			}
			
		}
		
		return result;
	}
	public int delete(String id) {
		int result = 0;
		//���޹��� id�� list�� ������ ����ó��(������ 1 ����, ���н� 0����)
		//���޹��� id�� list�� ������ "����Ÿ ����" ���(0 ����)
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				list.remove(id);
				result = 1;
			} else {
				System.out.println("������ ����");
			}
		}
		
		return result;
	}
	
	public void displayAll() {
		//list�� �ִ� ����Ÿ�� ��ü ȭ�� ���
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName()+ "\t"+ list.get(i).getKor()+ "\t"+ list.get(i).getEng()
					+ "\t"+ list.get(i).getMath()+ "\t"+ list.get(i).getTot()+ "\t"+ list.get(i).getAvg());
		}
	}
	public void displayOne(StudentVO vo) {
		//list�� �ִ� ����Ÿ �� vo�� name�� ��ġ�ϴ� ����Ÿ ȭ�� ���
		//������ "����Ÿ ����" ȭ�� ���
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getName().equals(vo.getName())) {
				System.out.println(list.get(i).getName()+ "\t"+ list.get(i).getKor()+ "\t"+ list.get(i).getEng()
						+ "\t"+ list.get(i).getMath()+ "\t"+ list.get(i).getTot()+ "\t"+ list.get(i).getAvg());
			} else {
				System.out.println("������ ����");
			}
		}
	}
	public void displayOne(String id) {
		//list�� �ִ� ����Ÿ �� id�� ��ġ�ϴ� ����Ÿ ȭ�� ���
		//������ "����Ÿ ����" ȭ�� ���
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				System.out.println(list.get(i).getName()+ "\t"+ list.get(i).getKor()+ "\t"+ list.get(i).getEng()
						+ "\t"+ list.get(i).getMath()+ "\t"+ list.get(i).getTot()+ "\t"+ list.get(i).getAvg());
			} else {
				System.out.println("������ ����");
			}
		}
	}
	
	public void printSungjuk() {
		//list�� �ִ� ����Ÿ ��ü�� ��Ŀ� ���� ȭ�鿡 ���
		//����     ����    ����    ����     ����     ���
		//------------------------------
		//ȫ�浿  100  90   80   270   90.0
		//.....
		System.out.println("-------------------------------------------");
		System.out.println("����\t����\t����\t����\t����\t���");
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName()+ "\t"+ list.get(i).getKor()+ "\t"+ list.get(i).getEng()
					+ "\t"+ list.get(i).getMath()+ "\t"+ list.get(i).getTot()+ "\t"+ list.get(i).getAvg());
		}
		System.out.println("-------------------------------------------");
	}
}
