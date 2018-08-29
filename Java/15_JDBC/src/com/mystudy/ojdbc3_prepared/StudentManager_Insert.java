package com.mystudy.ojdbc3_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentManager_Insert {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182", "mystudy", "mystudypw");
			String sql = "";
			sql = "INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH) "
					        + "VALUES (?, ?, ?, ?, ?)"; 
			pstmt = conn.prepareStatement(sql);
				
			String id = "2018006";
			String name = "강감찬";
			int kor = 100;
			int eng = 88;
			int math = 77;
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, math);
			
			int result = pstmt.executeUpdate();
			System.out.println("Update 성공. \n데이터 수정 건수 : "+ result);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
	}

}
