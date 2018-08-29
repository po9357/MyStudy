package com.mystudy.ojdbc_CRUD;

import java.util.ArrayList;

public class StudentCRUDTest {

	public static void main(String[] args) {
		StudentCRUD crud = new StudentCRUD();
		crud.dispDataOne("2018001");
		crud.selectId("2018001");
		StudentVO vo = crud.selectId("2018002");
		System.out.println(vo);
		
		System.out.println("--------------------------");
		vo = crud.selectId("2018111");
		if (vo == null) {
			System.out.println("데이터 없음");
		} else {
			System.out.println(vo.toString());
		}
		crud.selectAll();
		System.out.println("--------------------------");
		// 전체 데이터 조회
		ArrayList<StudentVO> list	= crud.selectAll();
		for (StudentVO stu : list) {
			crud.dispDataOne(stu.getId());
		}
		
		System.out.println("-------- 입력처리 테스트 --------");
		//데이터 입력 테스트					입력처리 끝(PK설정 때문에 주석처리 안하면 오류남(중복 데이터))
		crud.insertData("2018010", "홍길동10", 100, 90, 80, 0, 0);
		crud.dispDataOne("2018010");
//		crud.insertData("2018004", "배고파", 100, 100, 100, 0, 0);
//		crud.insertData(new StudentVO("2018011", "홍길동11", 100, 90, 81, 0, 0));
		
		System.out.println("-------- 수정처리 테스트 --------");
		StudentVO updVO = new StudentVO("2018012", "홍길동-12", 95, 90, 81);
		crud.updateData(updVO);
		crud.dispDataOne("2018012");
		
		System.out.println("-------- 삭제처리 테스트 --------");
		crud.deleteData("2018010");
		crud.dispDataOne("2018010");
		
		System.out.println("-------- 합계, 평균 입력 --------");
		crud.updateTotAvg("2018004");
	}

}
