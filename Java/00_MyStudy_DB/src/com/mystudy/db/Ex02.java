package com.mystudy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex02 {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	Ex02() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void selectDB(String id) {
		try {
			sql = "SELECT KOR, ENG, MATH FROM STUDENT WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			int kor;
			int eng;
			int math;
			int tot;
			double avg;
//			while (rs.next()) {
			rs.next();
				kor = rs.getInt("KOR");
				eng = rs.getInt("ENG");
				math = rs.getInt("MATH");
				
				tot = kor + eng + math;
				avg = (tot * 100)/ 3 /100.0;
				
				sql = "UPDATE STUDENT SET TOT = ?, AVG = ? WHERE ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, tot);
				pstmt.setDouble(2, avg);
				pstmt.setString(3, id);
				int result = pstmt.executeUpdate();
				System.out.println("수정 데이터 건수 : "+ result);
//			}
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
	public static void main(String[] args) {
		Ex02 ex = new Ex02();
		ex.selectDB("2018001");
	}
	
}
