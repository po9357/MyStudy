package com.mystudy.jdbc_dao;

import java.util.ArrayList;

public class MemberDAOTest {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		
		for (int i = 0; i < dao.selectAll().size(); i++) {
			System.out.println(dao.selectAll().get(i));
		}
		
		dao.selectOne("hong6");
		
		System.out.println("---------- 데이터 입력 테스트 ----------");
		dao.insertOne(new MemberVO("h7", "홍7", "4321", "7405", "제주"));	
		dao.selectOne("h7");
		
		System.out.println("---------- 데이터 수정 테스트 ----------");
		dao.updateOne(new MemberVO("h7", "7홍", "1346", "3001", "통영"));
		dao.selectOne("h7");
		
		System.out.println("---------- 데이터 삭제 테스트 ----------");
		dao.deleteOne("h7");
		dao.selectOne("h7");
	}

}
