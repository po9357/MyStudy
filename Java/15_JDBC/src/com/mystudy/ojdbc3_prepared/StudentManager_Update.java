package com.mystudy.ojdbc3_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager_Update {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		// JDBC를 이용하여 STUDENT 테이블의 데이터를 수정하는 프로그램 작성
		// ID를 찾아서 삭제처리
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
													, "mystudy", "mystudypw");
			
			
			String sql = "";
			sql = "UPDATE STUDENT SET KOR = ? WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			int kor = 55;
			String id = "2018005";
			pstmt.setInt(1, kor);
			pstmt.setString(2, id);
			
			int result = pstmt.executeUpdate();
			System.out.println("데이터 수정 성공.\n수정 데이터 건수 : "+ result);
			deleteData("2018004");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteData(String id) {
		String sql = "";
		try {
			sql = "DELETE FROM STUDENT WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			System.out.println("데이터 삭제 성공.\n삭제 데이터 건수 : "+ result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
