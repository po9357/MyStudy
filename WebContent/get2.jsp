<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.db.*" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
		String movieNo = request.getParameter("movieNo");
		String theaterName = request.getParameter("theaterName");
		String result = "";
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "PROJECT1", "project");
		String sql = "SELECT STARTTIME, ENDTIME, T.TIMENO FROM TIME T, MOVIE M, THEATER TH " 
				     + " WHERE M.MOVIENO = TH.MOVIENO "
				     + " AND TH.THEATERNO = T.THEATERNO "
				     + " AND M.MOVIENO = ? "
				     + " AND TH.NAME = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, movieNo);
		pstmt.setString(2, theaterName);
		rs = pstmt.executeQuery();
		
		String str = "<ul id='timeLi'>";
		while (rs.next()) {
			String timeNo = rs.getString(3);
			result = rs.getString(1) + " ~ " + rs.getString(2);
			str += "<li><button value="+ timeNo+ ">";
			str += result;
			str += "</button></li><br>";
		}
		str += "</ul>";
		response.getWriter().println(str);
	} catch (Exception e) {
		System.out.println(e);
	}
%>