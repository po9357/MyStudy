<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.db.*" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>
<body>
<% 
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String URL = "jdbc:oracle:thin:@203.236.209.182:1521:xe";
String USER = "PROJECT1";
String PASSWORD = "project";
String DRIVER = "oracle.jdbc.OracleDriver";


request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8;");
String theaterName = request.getParameter("theaterName");
String movieNo = request.getParameter("movieNo");
movieDAO dao = new movieDAO();
try {
	conn = DriverManager.getConnection(URL);
	
	String sql = " SELECT STARTTIME, ENDTIME FROM TIME T, MOVIE M, THEATER TH " + 
			" WHERE M.MOVIENO = TH.MOVIENO " + 
			" AND TH.THEATERNO = T.THEATERNO " + 
			" AND M.MOVIENO = ? " + 
			" AND TH.NAME = ? ";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, movieNo);
	pstmt.setString(2, theaterName);
	rs = pstmt.executeQuery();
	while (rs.next()) {
		
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





//session.removeAttribute("movieNo");
//session.removeAttribute("theaterName");
//session.setAttribute("movieNo", movieNo);
//session.setAttribute("theaterName", theaterName);

JSONObject sendObject = new JSONObject();
//JSONArray jArr = new JSONArray();
sendObject.put("movieNo", movieNo);
sendObject.put("theaterName", theaterName);
sendObject.put("msg", "감사합니다");
//String jsonSt = sendObject.toJSONString();
//response.getWriter().print(jsonSt);
//ArrayList<String> list = new ArrayList<>();
int cnt = 1;
//sendObject.put("time", list);
//sendObject.put("map", map);
//jArr.add(sendObject);
//String jArrStr = jArr.toJSONString();
//sendObject.put("timeMap", map);
String str = sendObject.toJSONString();
response.getWriter().print(str);


%> 

</body>
</html>