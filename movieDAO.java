package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class movieDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	private static final String URL = "jdbc:oracle:thin:@203.236.209.182:1521:xe";
	private static final String USER = "PROJECT1";
	private static final String PASSWORD = "project";
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
	}

	public ArrayList<String> idList() {
		ArrayList list = new ArrayList();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "SELECT MEMBERID FROM MEMBER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null ) { rs.close(); }
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return list;
	}
	
	
	public void insertSignUp(String id, String name, String password) {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "INSERT INTO MEMBER(MEMBERID, NAME, PASSWORD) VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if (rs != null ) { rs.close(); }
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public boolean logIn(String id, String password) {
		boolean check = false;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ? AND PASSWORD = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(!rs.getString(1).equals("")) {
					check = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (conn != null) { conn.close(); }
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	public HashMap<String, Integer> cntSeat(String theater) {
		HashMap map = new HashMap();
		int cntRow = 0;
		char row = 65;
		//상영관 입력받아서 제출
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "SELECT COUNT(SEATROW) FROM SEAT WHERE NAME=? AND SEATCOLUMN='1'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, theater);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cntRow = rs.getInt(1);
			}
			
			sql = "SELECT COUNT(SEATCOLUMN) FROM SEAT WHERE NAME=? AND SEATROW=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, theater);
			String rowName;
			for (int i=65; i<(65+cntRow); i++) {
				row = (char) i;
				rowName = String.valueOf(row);
				pstmt.setString(2, rowName);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String cntCol = rs.getString(1);
					map.put(rowName, Integer.parseInt(cntCol));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (conn != null) { conn.close(); }
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	public HashMap<String, ArrayList<String>> mvNothName(String movie){
		HashMap map = new HashMap();
		ArrayList<String> thList = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "SELECT M.MOVIENO, TH.NAME FROM MOVIE M, THEATER TH WHERE MOVIENAME = ? AND M.MOVIENO = TH.MOVIENO";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				thList.add(rs.getString(2));
				map.put(rs.getString(1), thList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (conn != null) { conn.close(); }
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	};
	
	public ArrayList<String> bookedSeat(String bookingDate, String timeNo) {
		ArrayList<String> list = new ArrayList();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = " SELECT S.SEATROW, S.SEATCOLUMN FROM BOOKING_SEAT BS, SEAT S "
					+ " WHERE BS.SEATNO = S.SEATNO "
					+ " AND BS.TIMENO = ? "
					+ " AND TO_CHAR(BS.BOOKING_DATE, 'YYYY/MM/DD') = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, timeNo);
			pstmt.setString(2, bookingDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String seat = rs.getString(1)+ rs.getString(2);
				list.add(seat);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (conn != null) { conn.close(); }
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
