<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>영화 예매</title>
	<style>
        * {
            margin: 0; padding: 0;
        }
        #outter {
            border: 1px solid black;
            height: 500px;
            width: 80%;
            margin: auto;
        }
        #outter>div {
            border: 1px solid red;
            float: left;
        }
        
        #div1 {
            margin-left: 1%;
            width: 30%;
            height: 100%;
        }
        #div2 {
            width: 30%;
            height: 100%;
        }
        #div3 {
            width: 38%;
            height: 100%;
        }
        ul {
        	list-style: none;
        }
        button {
         	width: 100px; height: 50px;
        	font-size: 1.2em;
        	border-radius: 40%;
        	background-color: #888;
        	border: none; */
			width:100px;
			background-color: #f8585b;
			border-radius: 10px;
			border: none;
			color:#fff;
			padding: 15px 0;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 15px;
			margin: 4px;
			cursor: pointer;
        }
	</style>
    <script src="https://code.jQuery.com/jquery-3.3.1.min.js"></script>
    <script>
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1;
        var yyyy = today.getFullYear();
        $(function(){
        	var movieNo;
        	var thName = [];
        	var cnt = 0;
            $("#dateLi>li:first>button").html(yyyy+"/"+mm+"/"+dd).prop("value", yyyy+"/"+mm+"/"+dd);
            $("#dateLi>li:eq(1)>button").html(yyyy+"/"+mm+"/"+(dd+1)).prop("value", yyyy+"/"+mm+"/"+(dd+1));
            $("#dateLi>li:eq(2)>button").html(yyyy+"/"+mm+"/"+(dd+2)).prop("value", yyyy+"/"+mm+"/"+(dd+2));
            $("#dateLi>li:eq(3)>button").html(yyyy+"/"+mm+"/"+(dd+3)).prop("value", yyyy+"/"+mm+"/"+(dd+3));
            $("#dateLi>li:last>button").html(yyyy+"/"+mm+"/"+(dd+4)).prop("value", yyyy+"/"+mm+"/"+(dd+4));

			console.log('${sessionScope.theater}');
			<c:forEach items="${sessionScope.theater}" var="item">
				movieNo = '${item.key}';
				<c:forEach items="${item.value}" var="thN">
					thName[cnt] = '${thN}';
					cnt++;
				</c:forEach>
			</c:forEach>
			cnt = 0;
			/* for (var i=0; i<thName.length; i++){
				console.log(movieNo);
				console.log(thName[i]);
			} */
			
			$("#dateLi>li>button").click(function(){
				var bookingDate = $(this).val();
				console.log(bookingDate);
				<%-- <% session.setAttribute("bookingDate", "%>bookingDate<%"); %>
				console.log(${sessionScope.bookingDate}); --%>
				
				var selTh = "<ul id='thLi'>"
				for (var i=0; i<thName.length; i++){
				selTh += "<li><button>";
				selTh += thName[i]				
				selTh += "</button></li><br>";
				}
				selTh += "</ul>";
				$("#div2").html(selTh);
				
			});
			
			
			
			
        });
    </script>
</head>
<body>
    <header>

    </header>
    <div id="outter">
        <div id="div1">
            <ul id="dateLi">
                <li><button></button></li><br>
                <li><button></button></li><br>
                <li><button></button></li><br>
                <li><button></button></li><br>
                <li><button></button></li>
            </ul>
        </div>
        <div id="div2">
asdljkfjsakl;d;ksdjfl
        </div>
        <div id="div3">
ㅣㅏㅓㅁㄴ오리;ㅏㄴ멍리ㅏㅓㅁㄴ이ㅏ;러
        </div>
    </div>
</body>
</html>