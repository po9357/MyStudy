package com.mystudy.jdbc_dao;

import java.util.ArrayList;

public class MemberDAOTest {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.selectAll();
		for (MemberVO mvo : list) {
			System.out.println(mvo);
		}
		
		System.out.println("----- selectOne(id) -----");
		MemberVO mvo = dao.selectOne("hong");
		System.out.println(mvo.toString());
		System.out.println(mvo);
		
		System.out.println("----- selectOne(VO) -----");
		MemberVO member = new MemberVO("hong4", "", "", "","");
		mvo = dao.selectOne(member);
		System.out.println(mvo);
		
		System.out.println("----- insertOne(VO) -----");
		//new MemberVO(id, password, name, phone, address)
		member = new MemberVO("1111", "pw1111", "김유신1", "010-1111-1111", "서울");
		int cnt = dao.insertOne(member);
		System.out.println("입력건수: " + cnt);
		System.out.println(dao.selectOne(member));
		
		

	}

}
