package com.mystudy.ojdbc2_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Select {

	public static void main(String[] args) {
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
											  , "mystudy", "mystudypw");
			stmt = conn.createStatement();
			
			String sql = "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG FROM STUDENT "
					+ "ORDER BY ID";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String str = "";
				str = rs.getString(1) + "\t";
				str += rs.getString(2) + "\t";
				str += rs.getInt(3) + "\t";
				str += rs.getInt(4) + "\t";
				str += rs.getInt(5) + "\t";
				str += rs.getInt(6) + "\t";
				str += rs.getDouble(7);
				
				System.out.println(str);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("[예외] 드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("[예외] DB 연결 실패");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
