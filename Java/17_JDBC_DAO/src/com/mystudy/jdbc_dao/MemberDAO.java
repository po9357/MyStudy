package com.mystudy.jdbc_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO : Data Access Object / Database Access Object
// 데이터베이스와 연결해서 CRUD를 구현하는 클래스
public class MemberDAO {
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@203.236.209.182:1521:xe";
	private final String USER = "mystudy";
	private final String PASSWORD = "mystudypw";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public MemberDAO() {
		try {
			Class.forName(DRIVER);
			System.out.println(">> 오라클 JDBC 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] 드라이버 로딩 실패");
		}
	}	
	
	public void closeConnPstmtRs(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//SELECT : 테이블에 있는 데이터 전체 조회 : ArrayList<MemberVO>
	public ArrayList<MemberVO> selectAll() {
		ArrayList<MemberVO> list = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql;
			sql = "SELECT ID, NAME, PASSWORD, PHONE, ADDRESS FROM MEMBER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while (rs.next()) {
				MemberVO vo = new MemberVO(rs.getString("ID"), rs.getString("NAME")
										, rs.getString("PASSWORD"), rs.getString("PHONE")
										, rs.getString("ADDRESS"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} closeConnPstmtRs(conn, pstmt, rs);
		
		return list;
	}
	
	//SELECT : 하나의 데이터 조회(ID) : MemberVO
	public MemberVO selectOne(String id) {
		MemberVO vo = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql;
			sql = "SELECT ID, NAME, PASSWORD, PHONE, ADDRESS FROM MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO(rs.getString("ID"), rs.getString("NAME")
						, rs.getString("PASSWORD"), rs.getString("PHONE")
						, rs.getString("ADDRESS"));
				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} closeConnPstmtRs(conn, pstmt, rs);
		return vo;
	}
	
	//SELECT : 하나의 데이터 조회(VO) : MemberVO
	public MemberVO selectOne(MemberVO vo) {
		MemberVO mvo = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql;
			sql = "SELECT ID, NAME, PASSWORD, PHONE, ADDRESS FROM MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO(rs.getString("ID"), rs.getString("NAME")
						, rs.getString("PASSWORD"), rs.getString("PHONE")
						, rs.getString("ADDRESS"));
				System.out.println(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} closeConnPstmtRs(conn, pstmt, rs);
		return vo;
	}
	//INSERT : VO 객체를 받아서 입력
	public int insertOne(MemberVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql;
			sql = "INSERT INTO MEMBER (ID, NAME, PASSWORD, PHONE, ADDRESS) "
					+ " VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getAddress());
			result = pstmt.executeUpdate();
			System.out.println("데이터 입력 성공. ("+ result+ "건)");
		} catch (SQLException e) {
			e.printStackTrace();
		} closeConnPstmtRs(conn, pstmt, rs);
		return result;
	}
	
	//UPDATE : vo 객체를 받아서 수정
	public int updateOne(MemberVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql;
			sql = "UPDATE MEMBER SET NAME = ?, PASSWORD = ?"
					+ ", PHONE = ?, ADDRESS = ? WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			pstmt.setString(++i, vo.getName());
			pstmt.setString(++i, vo.getPassword());
			pstmt.setString(++i, vo.getPhone());
			pstmt.setString(++i, vo.getAddress());
			pstmt.setString(++i, vo.getId());
			result = pstmt.executeUpdate();
			System.out.println("데이터 수정 성공. ("+ result+ "건)");
		} catch (SQLException e) {
			e.printStackTrace();
		} closeConnPstmtRs(conn, pstmt, rs);
		return result;
	}
	
	//DELETE : vo 객체를 받아서 삭제
	public int deleteOne(MemberVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql;
			sql = "DELETE FROM MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			result = pstmt.executeUpdate();
			System.out.println("데이터 삭제 성공. ("+ result+ "건)");
		} catch (SQLException e) {
			e.printStackTrace();
		} closeConnPstmtRs(conn, pstmt, rs);
		return result;
	}
	
	//DELETE : ID 받아서 삭제
	public int deleteOne(String id) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql;
			sql = "DELETE FROM MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			System.out.println("데이터 삭제 성공. ("+ result+ "건)");
		} catch (SQLException e) {
			e.printStackTrace();
		} closeConnPstmtRs(conn, pstmt, rs);
		return result;
	}
	
	//로그인 처리 : ID, PASSWORD 값을 받아서 동일한 데이터 있으면 true, 없으면 false
	//boolean checkIdPassword(id, password) 
	public boolean checkIdPassword(String id, String pw) {
		boolean result = false;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql;
			sql = "SELECT ID, PASSWORD FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} closeConnPstmtRs(conn, pstmt, rs);
		return result;
	}
	
}
