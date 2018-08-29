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
		member = new MemberVO("1111", "pw1111", "������1", "010-1111-1111", "����");
		int cnt = dao.insertOne(member);
		System.out.println("�Է°Ǽ�: " + cnt);
		System.out.println(dao.selectOne(member));
		
		System.out.println("----- updateOne(VO) -----");
		member = new MemberVO("1111", "pw1234", "������1234", "010-1234-1234", "����1234");
		cnt = dao.updateOne(member);
		System.out.println("�����Ǽ�: " + cnt);
		System.out.println(dao.selectOne(member));
		
		System.out.println("----- deleteOne(VO) -----");
		//member = new MemberVO("1111", "pw1234", "������1234", "010-1234-1234", "����1234");
//		cnt = dao.deleteOne(member);
//		System.out.println("�����Ǽ�: " + cnt);
//		System.out.println(dao.selectOne(member));
		
		System.out.println("----- deleteOne(id) -----");
		//member = new MemberVO("1111", "pw1234", "������1234", "010-1234-1234", "����1234");
		cnt = dao.deleteOne("1111");
		System.out.println("�����Ǽ�: " + cnt);
		System.out.println(dao.selectOne(member));
		
		System.out.println("----- id, password üũ1 -----");
		boolean loginOk = dao.checkIdPassword("hong", "1234A");
		if (loginOk) {
			System.out.println(">>> �α��� ����! ȸ���� �ݰ����ϴ�.");
		} else {
			System.out.println(">>> �α��� ����! ���̵�/��ȣ Ȯ���ϼ���.");
		}
		
		loginOk = dao.checkIdPassword2("hong", "1234A");
		if (loginOk) {
			System.out.println(">>>2 �α��� ����! ȸ���� �ݰ����ϴ�.");
		} else {
			System.out.println(">>>2 �α��� ����! ���̵�/��ȣ Ȯ���ϼ���.");
		}
		
		
		

	}

}
