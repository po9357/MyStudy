package com.mystudy.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Update {
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외] 드라이버 로딩 실패");
			e.printStackTrace();
		}
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
											  , "mystudy", "mystudypw");
			System.out.println(">> DB연결 성골");
		} catch (SQLException e) {
			System.out.println("[예외] DB연결 실패(Connection fail)");
			e.printStackTrace();
		}
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			
			String sql = "";
			sql = " UPDATE STUDENT SET KOR = 98, ENG = 88, MATH = 77 WHERE ID = '2018003'";	
			
			int result = stmt.executeUpdate(sql);
			System.out.println(">> Update 성공 \n수정건수 : "+ result);
		} catch (SQLException e1) {
			System.out.println("[예외] Query문 실행 실패 ");
			e1.printStackTrace();
		}
		
		
		// 객체 생성 순서 역순으로 닫기
		try {
			stmt.close();
			System.out.println(">> Statement 객체 close 성공");
		} catch (SQLException e) {
			System.out.println("[예외] Statement 객체 close 실패");
		}
		try {
			conn.close();
			System.out.println(">> Connection 객체 close 성공");
		} catch (SQLException e) {
			System.out.println("[예외] Connection 객체 close 실패");
		}
		
		
		
		
	}
	
}
