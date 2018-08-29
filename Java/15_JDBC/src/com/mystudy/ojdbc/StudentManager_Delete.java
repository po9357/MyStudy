package com.mystudy.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Delete {

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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			System.out.println(">> DB 연결 성공");
		} catch (SQLException e) {
			System.out.println("[예외] DB 연결 실패");
			e.printStackTrace();
		}
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "";
			sql = "DELETE STUDENT WHERE ID = 2018003";
			int result = stmt.executeUpdate(sql);
			System.out.println(">> Delete 성공 \n삭제건수 : "+ result);
			
		} catch (SQLException e) {
			System.out.println("[예외] Query문 실행 실패");
			e.printStackTrace();
		}
		
		try {
			stmt.close();
			System.out.println(">> Statement 객체 Close 성공");
		} catch (SQLException e) {
			System.out.println("[예외] Statement 객체 Close 실패");
			e.printStackTrace();
		}
		try {
			System.out.println(">> Connections 객체 Close 성공");
			conn.close();
		} catch (SQLException e) {
			System.out.println("[예외] Connection 객체 Close 성공");
			e.printStackTrace();
		}
		
		
	}

}
