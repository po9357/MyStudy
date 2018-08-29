package com.mystudy.ojdbc2_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Insert {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
											  , "mystudy", "mystudypw");
			
			stmt = conn.createStatement();
			
			String sql = "";
			String id = "2018005";
			String name = "홍경래";
			int kor = 100;
			int eng = 90;
			int math = 80;
			sql = "INSERT INTO STUDENT(ID, NAME, KOR, ENG, MATH)"
					+ " VALUES ('"+ id+ "', '"+ name
					             + "', "+ kor+ ", "
					             + eng+ ", "+ math+ ")";
			System.out.println("sql : "+ sql);
			int result = stmt.executeUpdate(sql);
			System.out.println("데이터 입력 건수 : "+ result);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
