<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.db.*" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	/* timeNo:timeNo
   	movieNo:movieNo
   	ThName:selThName
   	bookingDate:bookingDate */
   	String timeNo = request.getParameter("timeNo");
	String movieNo = request.getParameter("movieNo");
	String ThName = request.getParameter("ThName");
	String bookingDate = request.getParameter("bookingDate");
   	movieDAO dao = new movieDAO();
   	
   	ArrayList<String> rowName = new ArrayList<>();
   	ArrayList colNum = new ArrayList();
   	ArrayList<String> bookedSeat = new ArrayList<>();
   	bookedSeat = dao.bookedSeat(bookingDate, timeNo);
   	
	HashMap<String, Integer> map = dao.cntSeat(ThName);
	Iterator<String> ite = map.keySet().iterator();
	while(ite.hasNext()){
		String key = ite.next();
		rowName.add(key);
		colNum.add(map.get(key));
	}
	
	String str = "<table id='seatLi'>";
	for (int i=0; i<rowName.size(); i++) {
		str += "<tr>";
		str += "<th>"+ rowName.get(i)+ "</th>";
		for(int j=0; j<rowName.size(); j++) {
			String seatName = rowName.get(i)+(j+1);
			
			if (bookedSeat.size() == 0){
				str += "<td><button class='seatClass' value='"+rowName.get(i)+(j+1)+"'>"+ (j+1)+ "</button></td>";
			} else {
				boolean check = false;
				for (int k=0; k<bookedSeat.size(); k++){
					if (seatName.equalsIgnoreCase(bookedSeat.get(k))) {
						check = true;
						break;
					}
				}
				if (check) {
					str += "<td><button class='seatClass' value='booked'>"+ (j+1)+ "</button></td>";
				} else {
					str += "<td><button class='seatClass' value='"+rowName.get(i)+(j+1)+"'>"+ (j+1)+ "</button></td>";
				}
			}
			
		}
		str += "</tr>";
	}
	str += "</table>";
	str += "<button>예매하기</button>";
	response.getWriter().println(str);
%>