<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>영화 예매</title>
	<style>
	
	</style>
   	<script src="https://code.jQuery.com/jquery-3.3.1.min.js"></script>	
	<script>
		var seatHtml;
		
		var rowList = new Array();
		var colList = new Array();
		var cnt = 0;
		$(function(){
/* 			<c:forEach items="${rowName}" var="item">
				rowList[cnt] = '${item}'
				cnt++;
			</c:forEach>
			cnt = 0;
			<c:forEach items="${colNum}" var="item">
				colList[cnt] = '${item}'
				cnt++;
			</c:forEach> */
			<c:forEach items="${map }" var="item">
				rowList[cnt] = '${item.key}'
				colList[cnt] = '${item.value }'
				cnt++;
			</c:forEach>
			for (var i=0; i<${mapSize}; i++){
				console.log("row: "+ rowList[i]+ " 리스트 담기 성공이셈");
				console.log("col: "+ colList[i]+ " 리스트 담기 성공이셈");
			};
			
			var seatHtml = "<table>";
			for (var row=0; row<${mapSize}; row++) {
				seatHtml += "<tr>";
				for (var col=0; col<colList[row]; col++) {
					seatHtml += "<td>";
					seatHtml += ""+ rowList[row]+ (col+1);
					seatHtml += "</td>";
				}
					
				seatHtml += "</tr>";
			}
			seatHtml += "</table>";
			
			$("#showSeats").click(function(){
				$("#seats").html(seatHtml);
			});
			
			
		});
		
	</script>
</head>
<body>
<%-- 받아온 맵 사이즈는: ${ mapSize } <br>
받아온 rowName은: ${ rowName } <br>
받아온 colNum은: ${ colNum[0] } <br>
받아온 rowName은: ${ rowName[1] } <br>
받아온 colNum은: ${ colNum[1] } <br>
받아온 rowName은: ${ rowName[2] } <br>
받아온 colNum은: ${ colNum[2] } <br> --%>

<input type="button" name="seats" id="showSeats" value="좌석보기"/>
<div id="seats">
</div>
</body>
</html>