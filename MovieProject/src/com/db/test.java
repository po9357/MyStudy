package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class test {
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	private static final String URL = "jdbc:oracle:thin:@203.236.209.182:1521:xe";
	private static final String USER = "project1";
	private static final String PASSWORD = "project";
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	public static void main(String[] args) {
//		movieDAO dao = new movieDAO();
//		ArrayList list 
//		 = dao.idList();
//		System.out.println(list);
		
//		char ch = 65;
//		ch+=1;
//		ch+=1;
//		System.out.println(ch);
		
		HashMap map = new HashMap();
		int cntRow = 0;
		char row = 65;
		//상영관 입력받아서 제출
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "SELECT COUNT(SEATROW) FROM SEAT WHERE NAME=? AND SEATCOLUMN='1'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "1관");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cntRow = rs.getInt(1);
			}
			
			sql = "SELECT COUNT(SEATCOLUMN) FROM SEAT WHERE NAME=? AND SEATROW=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "1관");
			for (int i=65; i<(65+cntRow); i++) {
				row = (char) i;
				pstmt.setString(2, String.valueOf(row));
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String cntCol = rs.getString(1);
					map.put(row, cntCol);
				}
			}
			System.out.println(map);
			System.out.println(map.size());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
//		ArrayList<String> rowList = new ArrayList<>();
//		ArrayList<Integer> colList = new ArrayList<>();
//		movieDAO dao = new movieDAO();
//		map = dao.cntSeat("1관");
//		Iterator ite = map.keySet().iterator();
//		int cnt = 0;
//		while(ite.hasNext()) {
//			char rowChar = (char)ite.next();
//			String colStr = (String) map.get(rowChar);
//			
//			
//			String rowName = String.valueOf(rowChar);
//			int colNum = Integer.parseInt(colStr);
//			
//			System.out.println("Row: "+ rowName+ "\nColumn: "+ colNum);
//			rowList.add(rowName);
//			colList.add(colNum);
//		}
//		System.out.println(cnt);
		
		
		
		
		
		
		
		
		
	}

}
