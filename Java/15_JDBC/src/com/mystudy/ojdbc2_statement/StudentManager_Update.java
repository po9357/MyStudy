package com.mystudy.ojdbc2_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Update {

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
			int kor = 100;
			int eng = 100;
			int math = 100;
			sql = "Update STUDENT SET KOR = "+ kor 
					             + ", ENG = "+ eng
					             + ", MATH = "+ math
					        + " WHERE ID = '"+ id+ "'";
			System.out.println("sql : "+ sql);
			int result = stmt.executeUpdate(sql);
			System.out.println("데이터 수정 건수 : "+ result);
			
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
