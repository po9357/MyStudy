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
		//list에 있는 데이타를 전달받은 id과 동일한 이름의 데이타가 있으면 리턴
		//없으면 null 리턴
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				return list.get(i);
			}
		}
		
		return result;
	}
	public StudentVO selectOne(StudentVO vo) {
		StudentVO result = null;
		//list에 있는 데이타를 전달받은 vo의 id와 동일한 이름의 데이타가 있으면 리턴
		//없으면 null 리턴
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(vo.getId())) {
				return list.get(i);
			}
		}
		return result;
	}
	
	public ArrayList<StudentVO> selectAll() {		//ing
		ArrayList<StudentVO> result = null;
		//전체 데이타를 리턴 처리
		result = list;
		return result;
	}
	
	public int insert(StudentVO vo) {
		int result = 0;
		//전달받은 vo의 id가 list에 없으면 list에 추가(1 리턴)
		//전달받은 vo의 id가 list에 있으면 "이미 존재하는 데이타" 출력(0 리턴)
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(vo.getId())) {
				System.out.println("이미 존재하는 데이터 입니다.");
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
		//전달받은 vo의 id가 list에 있으면 수정처리(1 리턴)
		//	(키값인 id를 제외하고 모든 데이터를 수정처리)
		//전달받은 vo의 id가 list에 없으면 "데이타 없음" 출력(0 리턴)
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
				System.out.println("데이터 없음");
			}
		}
		
		return result;
	}
	public int delete(StudentVO vo) {
		int result = 0;
		//전달받은 vo의 id가 list에 있으면 삭제처리(성공시 1 리턴, 실패시 0리턴)
		//전달받은 vo의 id가 list에 없으면 "데이타 없음" 출력(0 리턴)
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(vo.getId())) {
				list.remove(i);
				result = 1;
			} else {
				System.out.println("데이터 없음");
			}
			
		}
		
		return result;
	}
	public int delete(String id) {
		int result = 0;
		//전달받은 id가 list에 있으면 삭제처리(성공시 1 리턴, 실패시 0리턴)
		//전달받은 id가 list에 없으면 "데이타 없음" 출력(0 리턴)
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				list.remove(id);
				result = 1;
			} else {
				System.out.println("데이터 없음");
			}
		}
		
		return result;
	}
	
	public void displayAll() {
		//list에 있는 데이타를 전체 화면 출력
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName()+ "\t"+ list.get(i).getKor()+ "\t"+ list.get(i).getEng()
					+ "\t"+ list.get(i).getMath()+ "\t"+ list.get(i).getTot()+ "\t"+ list.get(i).getAvg());
		}
	}
	public void displayOne(StudentVO vo) {
		//list에 있는 데이타 중 vo의 name과 일치하는 데이타 화면 출력
		//없으면 "데이타 없음" 화면 출력
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getName().equals(vo.getName())) {
				System.out.println(list.get(i).getName()+ "\t"+ list.get(i).getKor()+ "\t"+ list.get(i).getEng()
						+ "\t"+ list.get(i).getMath()+ "\t"+ list.get(i).getTot()+ "\t"+ list.get(i).getAvg());
			} else {
				System.out.println("데이터 없음");
			}
		}
	}
	public void displayOne(String id) {
		//list에 있는 데이타 중 id와 일치하는 데이타 화면 출력
		//없으면 "데이타 없음" 화면 출력
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				System.out.println(list.get(i).getName()+ "\t"+ list.get(i).getKor()+ "\t"+ list.get(i).getEng()
						+ "\t"+ list.get(i).getMath()+ "\t"+ list.get(i).getTot()+ "\t"+ list.get(i).getAvg());
			} else {
				System.out.println("데이터 없음");
			}
		}
	}
	
	public void printSungjuk() {
		//list에 있는 데이타 전체를 양식에 맞춰 화면에 출력
		//성명     국어    영어    수학     총점     평균
		//------------------------------
		//홍길동  100  90   80   270   90.0
		//.....
		System.out.println("-------------------------------------------");
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName()+ "\t"+ list.get(i).getKor()+ "\t"+ list.get(i).getEng()
					+ "\t"+ list.get(i).getMath()+ "\t"+ list.get(i).getTot()+ "\t"+ list.get(i).getAvg());
		}
		System.out.println("-------------------------------------------");
	}
}
