<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jQuery.com/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		var price = 9000 * ${sessionScope.seatLength};
		$("#price h3").text(price+ " 원 ");
		
		var receipt = "<html>";
		receipt += "<body>";
		receipt += "<h3>No.${sessionScope.ticketNo }</h3>";
		receipt += "-------------------------<br/>";
		receipt += "<h4>${sessionScope.movie }</h4>";
		receipt += "<h4>${sessionScope.theaterName } ${sessionScope.selTime }</h4>";
		receipt += "<h4>${sessionScope.seatList }</h4>"
		receipt += "<h4>"+price+" 원 </h4>";
		receipt += "</body>";
		receipt += "</html>";
	    var myWindow = window.open("", "MsgWindow", "toolbar=yes,scrollbars=yes,resizable=no,top=200,left=500,width=250px,height=300px");
	    myWindow.document.write(receipt);
	});
</script>
<style>
	ul { list-style: none; width: 200px; }
</style>
</head>
<body>
	<h1>예매가 완료되었습니다</h1>
	<h3>다음에 또 이용 부탁드립니다</h3>
	<hr>
	<h4>예매 내역</h3>
	<ul>
		<li><h3>No.${sessionScope.ticketNo }</h3></li>
		<li><h3>영화: ${sessionScope.movie }</h3></li>
		<li><h3>${sessionScope.theaterName } ${sessionScope.selTime }</h3></li>
		<li><h3 align="right">${sessionScope.seatList }</h3></li>
		<hr>
		<li id="price"><h3 align="right"></h3></li>
	</ul>
	<form action="MovieMain2.jsp">
		<input type="submit" value="메인으로">
	</form>
	<div id="hidden"></div>
</body>
</html>