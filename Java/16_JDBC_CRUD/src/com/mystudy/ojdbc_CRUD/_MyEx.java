package com.mystudy.ojdbc_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class _MyEx {
	public static void main(String[] args) {
		StudentCRUD.driver();
	}
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	_MyEx() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		} catch (ClassNotFoundException e) {
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
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
			if(rs.next()) {
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
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stus;
	}
	public void updateTotAvg() {
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			
			String sql = "";
			sql = "SELECT ID, KOR, ENG, MATH FROM STUDENT";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			String id;
			int kor;
			int eng;
			int math;
			int tot;
			double avg;
			while (rs.next()) {
				id = rs.getString("ID");
				kor = rs.getInt("KOR");
				eng = rs.getInt("ENG");
				math = rs.getInt("MATH");
				tot = kor + eng + math;
				avg = tot*100 / 3/ 100.0;
				
				sql = "UPDATE STUDENT SET TOT = ?, AVG = ? WHERE ID = ?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, tot);
				pst.setDouble(2, avg);
				pst.setString(3, id);
				
				pst.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//StudentVO 데이터를 받아서 수정
	public void updateVo(StudentVO vo) {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			
			String sql;
			sql = "UPDATE FROM STUDENT SET NAME = ?, KOR = ?, ENG = ?, MATH = ? WHERE ID = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getName());
			pst.setInt(2, vo.getKor());
			pst.setInt(3, vo.getEng());
			pst.setInt(4, vo.getMath());
			pst.setString(5, vo.getId());
			
			int result = pst.executeUpdate();
			System.out.println("데이터 수정 건수 : "+ result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//id값 받아서 삭제
	public void deleteId(String id) {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			
			String sql;
			sql = "DELETE FROM STUDENT WHERE ID = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//이름 값 받아서 삭제
	public void deleteName(String name) {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			
			String sql;
			sql = "DELETE FROM STUDENT WHERE NAME IN ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			
			int result = pst.executeUpdate();
			System.out.println("삭제된 데이터 건수 : "+ result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//StudentVO 데이터를 받아서 삭제
	public void deleteVo(StudentVO vo) {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "mystudy", "mystudypw");
			String sql;
			sql = "DELETE FROM STUDENT WHERE ID = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			
			int result = pst.executeUpdate();
			System.out.println("삭제된 데이터 건수 : "+ result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
