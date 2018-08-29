package com.mystudy.ojdbc3_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentManager_Select {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "";
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			
			sql = "SELECT * FROM STUDENT WHERE NAME LIKE ?";
			pstmt = conn.prepareStatement(sql);
			
			// ?(바인드 변수)에 값 대입
			String name = "홍길동";
			// pstmt.setString(1, "홍길동");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String str;
				str = rs.getString(1) + "\t";
				str += rs.getString(2) + "\t";
				str += rs.getInt(3) + "\t";
				str += rs.getInt(4) + "\t";
				str += rs.getInt(5) + "\t";
				str += rs.getInt(6) + "\t";
				str += rs.getDouble(7) + "";
				System.out.println(str);
			}
			
			// PreparedStatement문 실행
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

}
