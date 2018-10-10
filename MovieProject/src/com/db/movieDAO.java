package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
	
	public ArrayList<String> seatNoList (ArrayList<String> seatList, String theaterName){
		ArrayList<String> list = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "SELECT SEATNO FROM SEAT "
					+ " WHERE SEATROW = ? "
					+ " AND SEATCOLUMN = ? "
					+ " AND NAME = ? ";
			
			ArrayList<String> rowArr = new ArrayList<>();
			ArrayList<String> colArr = new ArrayList<>();
			for (int i=0; i<seatList.size(); i++) {
				rowArr.add(String.valueOf(seatList.get(i).charAt(0)));
				colArr.add(String.valueOf(seatList.get(i).charAt(1)));
			}
			
			pstmt = conn.prepareStatement(sql);
			
			for (int i=0; i<rowArr.size(); i++) {
				pstmt.setString(1, rowArr.get(i));
				pstmt.setString(2, colArr.get(i));
				pstmt.setString(3, theaterName);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					list.add(rs.getString(1));
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
		
		
		
		return list;
	}
	
	public void insBooking_seat(String bookingDate, String timeNo, ArrayList<String> seatNoList) {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "INSERT INTO BOOKING_SEAT VALUES "
					+ " ( TO_DATE(?), ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			
			for (int i=0; i<seatNoList.size(); i++) {
				pstmt.setString(1, bookingDate);
				pstmt.setString(2, timeNo);
				pstmt.setString(3, seatNoList.get(i));
				pstmt.executeUpdate();
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
	}
	
	public String selThNo(String movieNo, String theaterName) {
		String theaterNo = "";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "SELECT THEATERNO FROM THEATER TH, MOVIE M "
					+ " WHERE M.MOVIENO = TH.MOVIENO "
					+ " AND M.MOVIENO = ? "
					+ " AND TH.NAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieNo);
			pstmt.setString(2, theaterName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				theaterNo = rs.getString(1);
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
		return theaterNo;
	}
	
	public String insTicket(String theaterNo, ArrayList<String> seatNoList, String movieNo, String memberId, String timeNo, String bookingDate, int price) {
		String ticketNo = "";
		ArrayList<String> TkNoList = new ArrayList<String>();
		Random ran = new Random();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String ticNo = "";
			String sql = "";
			String ranNo = "";
			sql = "SELECT TICKETINGNO FROM TICKETING";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TkNoList.add(rs.getString(1));
			}
			
			sql = "INSERT INTO TICKETING (TICKETINGNO, THEATERNO, SEATNO, MOVIENO, MEMBERID, TIMENO, PRICE, DATENO) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYY/MM/DD'))";
			pstmt = conn.prepareStatement(sql);
			for (int i=0; i<seatNoList.size(); i++) {
			Outter:
				while (true) {
					ranNo = String.valueOf(ran.nextInt(9999999));
					for (int j=0; j<TkNoList.size(); j++) {
						if (!TkNoList.get(j).equals(ranNo)) {
							break Outter;
						}
					}
				}
				pstmt.setString(1, ranNo);
				pstmt.setString(2, theaterNo);
				pstmt.setString(3, seatNoList.get(i));
				pstmt.setString(4, movieNo);
				pstmt.setString(5, memberId);
				pstmt.setString(6, timeNo);
				pstmt.setInt(7, price);
				pstmt.setString(8, bookingDate);
				pstmt.executeUpdate();
			}
			ticketNo = ranNo;
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
		
		return ticketNo;
	}
	
	public void insBank(String payType, int price) {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "INSERT INTO BANK(PAYTYPE, PRICE) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, payType);
			pstmt.setInt(2, price);
			pstmt.executeUpdate();
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
		
	}
	
}
