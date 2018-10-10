<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="https://code.jQuery.com/jquery-3.3.1.min.js"></script>
    <script>
    	console.log(${sessionScope.seatNoList});
    	console.log(${sessionScope.movieNo});
    	console.log(${sessionScope.seatNoList}.length);
    	$(function(){
    		var peopleNum = ${sessionScope.seatLength };
    		var price = 9000 * peopleNum;
    		$("img").prop("src", "images/"+${sessionScope.movieNo}+".jpg");
    		var price = 9000 * ${sessionScope.seatLength};
    		$("#price>h3").text(price+" 원 ");
    		
    		$("input").click(function(){
    			$(".priceInp").prop("value", price);
    			console.log(price);
    			console.log($("#inp1").val());
    			console.log($("#inp2").val());
    			$("#priceInp").prop("value", price);
    			var pay = $(this).val();
    			var check = confirm(pay+ "를 하시겠습니까?");
    			if (check == false){
    				return false;
    			}
    		});
    		
    	});
    </script>
    <style>
    	h1 { text-align: center; }
    	html, body { width: 100%; height: 100%; }
    	body { margin: 0; padding: 0; }
    	#outter {
    		width: 80%; height: 100%;
    		/* border: 1px solid black; */
    		margin: auto;
    	}
    	#outter div { float: left; }
    	#inner {
    		position: absolute;
    		/* border: 1px solid red; */
    		width: 250px; height: 100%;
    		margin-left: 10%;"WebContent/뷰티인사이드.jsp"
    	}
    	#imgDiv {
    		position: relative;
    		width: 500px; height: 100%;
    		left: 400px; top: 0;
    		/* border: 1px solid green; */
    	}
    	#btnDiv {
	    	width: 200px;
	    	position: relative;
	    	left: 50px; top: 50px;
    	}
    	button {
    		float: left;
        	width: 70px; height: 40px;
        	font-size: 1.2em;
        	border-radius: 40%;
			background-color: rgb(30, 30, 30);
			border-radius: 10px;
			border: none;
			color:#fff;
			padding: 15px 0;
			text-align: center;
			text-decoration: none;
			display: block;
			font-size: 13px;
			margin: 4px;
			cursor: pointer;
			line-height: 10px;
    	}
    	input {
    	float: left;
        	width: 70px; height: 40px;
        	font-size: 1.2em;
        	border-radius: 40%;
			background-color: rgb(30, 30, 30);
			border-radius: 10px;
			border: none;
			color:#fff;
			padding: 15px 0;
			text-align: center;
			text-decoration: none;
			display: block;
			font-size: 13px;
			margin: 4px;
			cursor: pointer;
			line-height: 10px;
    	}
    	img { width: 400px; margin-left: 50px; margin-top: 50px; }
    	ul { list-style: none; margin-top: 150px; }
    </style>
</head>
<body>
<h1>결제</h1>
<hr>
<div id="outter">
	<div id="inner">
<%-- 		선택한 영화: ${sessionScope.movie }
		선택한 시간: ${sessionScope.selTime }
		선택한 좌석: ${sessionScope.theaterName } 
				${sessionScope.seatList }
		가격: 9000 * ${sessionScope.seatNoList }.length --%>
		<ul>
			<li><h3>${sessionScope.movie }</h3></li>
			<li><h3>${sessionScope.theaterName } ${sessionScope.selTime }</h3></li>
			<li><h3>${sessionScope.seatList }</h3></li>
			<hr>
			<li>9000 * ${sessionScope.seatLength }</li>
			<li id="price"><h3 align="right"></h3></li>
		</ul>
		<div id="btnDiv">
		<form action="PrintTicket">
			<input type="hidden" name="pay" value="card">
			<input type="hidden" id="inp1" class="priceInp" name="price" value="">
			<input type="submit" value="카드 결제">
		</form>
		<form action="PrintTicket">
			<input type="hidden" name="pay" value="cash">
			<input type="hidden" id="inp2" class="priceInp" name="price" value="">
			<input type="submit" value="현금 결제">
		</form>
		</div>
	</div>
	<div id="imgDiv">
		<img src="">
	</div>
</div>
</body>
</html>