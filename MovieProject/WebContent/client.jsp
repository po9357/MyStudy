<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html> 
<head> 
    <meta charset="utf-8">
<script src="http://code.jquery.com/jquery-1.12.1.js"></script> 
<script> 
$(function(){ 
	var movieNo = "0004";
	var theaterName = "4관";
	var id = "admin";
    $('#id01').on('click',function(){ 
      $.ajax({ 
    	  url:'get2.jsp', 
          type:'get',
          data: {
        	  movieNo:movieNo,
        	  theaterName:theaterName
          },
           success : function(data){
        	   console.log($("data").find("time").text());
        	   console.log("성공");
        	   console.log(data);
           }, 
            error : function(){ 
            	console.log("실패");
             } 
      }); 
    }); 

}); 
</script> 
<meta charset="EUC-KR"> 
<title>데이터 전송하기</title> 
</head> 
<body> 
<button id="id01"> DB 데이터 보기</button><br/> 
이름: <input type="text" id="name1" ><br/> 
나이: <input type="text" id="age1"><br/> 
월급: <input type="text" id="salary1"><br/> 
<button id="id02"> DB로 전송</button><br/> 

</body> 
</html>