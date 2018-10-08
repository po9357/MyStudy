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
		String result = "";
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@203.236.209.182:1521:xe", "PROJECT1", "project");
		String sql = "SELECT * FROM MEMBER";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		String str = "";
		while (rs.next()) {
			result = rs.getString(1);
		str += "<anything>";
		str += "<time>";
		str += result;
		str += "</time>";
		str += "</anything>";
		}
		
		response.getWriter().println(str);
	} catch (Exception e) {
		System.out.println(e);
	}
%>