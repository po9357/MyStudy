<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 파라미터로 전달 받은 값 추출  --%>
<%
	String id = request.getParameter("id");
%>

<%!
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "mystudy";
	String password = "mystudypw";
%>
<%
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		String sql = "";
		sql += "SELECT IDX,ID,PWD,NAME,AGE,ADDRESS,REG ";
		sql += "  FROM MEMBER2 ";
		sql += " WHERE ID = ? ";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		rs = stmt.executeQuery();
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID검색 결과</title>
</head>
<body>
	<%--테이블 형태로 만든 메뉴 및 입력폼 삽입 --%>
	<%@ include file="start.jsp" %>
	
	<h1>ID검색 결과</h1>
	<table border="1">
	<thead>
		<tr>
			<th>번호</th><th>아이디</th><th>패스워드</th>
			<th>이름</th><th>나이</th><th>주소</th><th>날짜</th>
		</tr>
	</thead>
	<tbody>
		<%
		while (rs.next()) { %>
		<tr>
			<td><%=rs.getInt("IDX") %></td>
			<td><%=rs.getString("ID") %></td>
			<td><%=rs.getString("PWD") %></td>
			<td><%=rs.getString("NAME") %></td>
			<td><%=rs.getInt("AGE") %></td>
			<td><%=rs.getString("ADDRESS") %></td>
			<td><%=rs.getDate("REG") %></td>
		</tr>
<%
		} 
	} catch (Exception e) {
		out.println("<h2>[예외발생] 담당자에게(8888) 연락 바랍니다</h2>");
		e.printStackTrace();
%>
	</tbody>
	</table>
</body>
</html>
<%
	
	} finally {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			
		}
	}
%>