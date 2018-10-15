<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "error2.jsp" %> %>
    
<%-- 넘겨받은 파라미터 값으로 DB 테이블에 입력 처리 --%>
<%
	//전달받은 파라미터(id,pwd,name,age,addr) 값 가져오기
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String addr = request.getParameter("addr");
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "mystudy";
		String password = "mystudypw";
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		
		String sql = "";
		sql += "INSERT INTO MEMBER22 ";
		sql += "       (IDX, ID, PWD, NAME, AGE, ADDR, REG) ";
		sql += "VALUES (MEMBER2_SEQ.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE) ";
		stmt = conn.prepareStatement(sql);
		int i = 1;
		stmt.setString(i++, id);
		stmt.setString(i++, pwd);
		stmt.setString(i++, name);
		stmt.setInt(i++, age);
		stmt.setString(i++, addr); //5
		
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