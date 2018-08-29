package com.mystudy.ojdbc_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentCRUD {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	StudentCRUD() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void driver() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void closeConnStmtRs(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void closeConnStmtRs(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//SELECT : ID
	public void dispDataOne(String id) { 
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			
			String sql = "";
			sql = "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG FROM STUDENT "
					+ "WHERE ID = ?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, id);
			
			rs = pst.executeQuery();
			
			if (rs.next()) {
				String str = "";
				str += rs.getString(1) + "\t";
				str += rs.getString("NAME") + "\t";
				str += rs.getInt("KOR") + "\t";
				str += rs.getInt("ENG") + "\t";
				str += rs.getInt("MATH") + "\t";
				str += rs.getInt("TOT") + "\t";
				str += rs.getDouble("AVG");
				System.out.println(str);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst, rs);
		}
		
	}
	
	public StudentVO selectId(String id) {
		StudentVO stu = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			
			String sql = "";
			sql = "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG FROM STUDENT "
					+ "WHERE ID = ?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, id);
			
			rs = pst.executeQuery();
			
			if (rs.next()) {
				stu = new StudentVO(id, rs.getString("NAME"), rs.getInt("KOR")
						              , rs.getInt("ENG"), rs.getInt("MATH")
						              , rs.getInt("TOT"), rs.getDouble("AVG"));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst, rs);
		}
		return stu;
	}
	
	// 이름으로 조회
	public StudentVO selectName(String name) {
		StudentVO stu = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			String sql = "";
			sql = "SELECT * FROM STUDENT WHERE NAME = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				stu = new StudentVO(rs.getString("ID"), name
				           		  , rs.getInt("KOR"), rs.getInt("ENG")
				           		  , rs.getInt("MATH"), rs.getInt("TOT"), rs.getDouble("AVG"));
				System.out.println(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}
	// 전체 데이터 조회
	public ArrayList<StudentVO> selectAll() {
		ArrayList<StudentVO> stus = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			String sql = "";
			sql = "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG FROM STUDENT ";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			stus = new ArrayList<>();
			while (rs.next()) {
//				stus.add(new StudentVO(rs.getString("ID"), rs.getString("NAME")
//						          , rs.getInt("KOR"), rs.getInt("ENG"), rs.getInt("MATH")
//						          , rs.getInt("TOT"), rs.getDouble("AVG")));
				StudentVO vo = new StudentVO(rs.getString("ID"), rs.getString("NAME"), rs.getInt("KOR")
						              , rs.getInt("ENG"), rs.getInt("MATH")
						              , rs.getInt("TOT"), rs.getDouble("AVG"));
				stus.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst, rs);
		}
		return stus;
	}
	//DB에 데이터 입력
	public int insertData(String id, String name, int kor, int eng, int math, int tot, double avg) {
		int result = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182", "mystudy", "mystudypw");
			String sql = "";
			sql = "INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH, TOT, AVG) "
					        + "VALUES (?, ?, ?, ?, ?, ?, ?)"; 
			pst = conn.prepareStatement(sql);
				
			
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setInt(3, kor);
			pst.setInt(4, eng);
			pst.setInt(5, math);
			pst.setInt(6, tot);
			pst.setDouble(7, avg);
			
			result = pst.executeUpdate();
			System.out.println("INSERT 성공. \n데이터 입력 건수 : "+ result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} finally {
			closeConnStmtRs(conn, pst);
		}
		return result;
	}
	
	//StudentVO 데이터를 받아서 입력
	public int insertData(StudentVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182"
														 , "mystudy", "mystudypw");
			String sql = "";
			sql = "INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH, TOT, AVG) "
					        + "VALUES (?, ?, ?, ?, ?, ?, ?)"; 
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getName());
			pst.setInt(3, vo.getKor());
			pst.setInt(4, vo.getEng());
			pst.setInt(5, vo.getMath());
			pst.setInt(6, vo.getTot());
			pst.setDouble(7, vo.getAvg());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst);
		}
		return result;
	}
	
	//StudentVO 데이터를 받아서 수정
	public int updateData(StudentVO vo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
													, "mystudy", "mystudypw");
			String sql;
			sql = "UPDATE STUDENT SET NAME = ?, KOR = ?"
					+ ", ENG = ?, MATH = ?, TOT = ?, AVG = ? "
					+ " WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			
			int i = 0;			//중간에 변경이 일어났을 경우 수정에 용이
			pst.setString(++i, vo.getName());	//1
			pst.setInt(++i, vo.getKor());		//2
			pst.setInt(++i, vo.getEng());		//3
			pst.setInt(++i, vo.getMath());		//4
			pst.setInt(++i, vo.getTot());		//5
			pst.setDouble(++i, vo.getAvg());	//6
			pst.setString(++i, vo.getId());		//7
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst);
		}
		return result;
	}
	
	
	//id값 받아서 삭제
	public int deleteData(String id) {
		int result = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
														, "mystudy", "mystudypw");
			String sql;
			sql = "DELETE FROM STUDENT WHERE ID = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst);
		}
		return result;
	}
	//updateName : ID, NAME 값을 받아서 ID로 조회해서 NAME값 수정
	public int updateName(String id, String name) {
		int result = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
					, "mystudy", "mystudypw");
			String sql;
			sql = "UPDATE STUDENT SET NAME = ? "
					+ " WHERE ID = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst);
		}
		return result;
	}
	//updateScore : ID, KOR, ENG, MATH 값을 받아서 ID로 찾고, KOR, ENG, MATH, TOT, AVG 값 수정 (TOT, AVG 계산처리)
	public int updateScore(String id, int kor, int eng, int math) {
		int result = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
					, "mystudy", "mystudypw");
			String sql;
			sql = "UPDATE STUDENT SET KOR = ?, ENG = ?, MATH = ? "
					+ ", TOT = ?, AVG = ? WHERE ID = ?";
			pst = conn.prepareStatement(sql);
			int tot = kor + eng + math;
			double avg = tot * 100 / 3 / 100.0;
			pst.setInt(1, kor);
			pst.setInt(2, eng);
			pst.setInt(3, math);
			pst.setInt(4, tot);
			pst.setDouble(5, avg);
			pst.setString(6, id);
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst);
		}
		return result;
	}
	//updateTotAvg : ID 값을 받아서 TOT, AVG 값 수정처리
	public int updateTotAvg(String id) {
		int result = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
					, "mystudy", "mystudypw");
			String sql;
			sql = "SELECT KOR, ENG, MATH FROM STUDENT WHERE ID = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			
			rs = pst.executeQuery();
			
			int kor;
			int eng;
			int math;
			int tot;
			double avg;
			
			if (rs.next()) {
				kor = rs.getInt("KOR");
				eng = rs.getInt("ENG");
				math = rs.getInt("MATH");
				tot = kor + eng + math;
				avg = tot * 100 / 3 / 100.0;
				
				sql = "UPDATE STUDENT SET TOT = ?, AVG = ? WHERE ID = ?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, tot);
				pst.setDouble(2, avg);
				pst.setString(3, id);
				
				result = pst.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst);
		}
		return result;
	}
	
	//StudentVO 데이터를 받아서 삭제 (ID값으로)
	public int deleteData(StudentVO vo)	{
		int result = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
														, "mystudy", "mystudypw");
			String sql;
			sql = "DELETE FROM STUDENT WHERE ID = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst);
		}
		return result;
	}
	
	//이름 값 받아서 삭제
	public int deleteDataName(String name)	{
		int result = 0;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe"
														, "mystudy", "mystudypw");
			String sql;
			sql = "DELETE FROM STUDENT WHERE NAME = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnStmtRs(conn, pst);
		}
		return result;
	}

}
