<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 넘겨받은 파라미터 값으로 DB 테이블에 입력 처리 --%>
<%
	//전달받은 파라미터(id) 값 가져오기
	String id = request.getParameter("id");
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "mystudy";
		String password = "mystudypw";
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		
		String sql = "DELETE FROM MEMBER2 WHERE ID = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		
		int result = stmt.executeUpdate(); //SQL 실행
		response.sendRedirect("selectAll.jsp");

	} catch (Exception e) {
		response.sendRedirect("error.jsp"); //예외처리 페이지로 이동
		e.printStackTrace();
	} finally {
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			
		}
		System.out.println("conn.isClosed : " + conn.isClosed());
	}
%>