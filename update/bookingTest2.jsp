<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.db.*" %>
<%@ page import="org.json.simple.JSONObject" %>
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
            margin-left: 5%;
            width: 30%;
            height: 100%;
        }
        #div3 {
            width: 60%;
            height: 100%;
        }
        ul {
        	list-style: none;
        	display: block;
        }
        button {
         	width: 100px; height: 50px;
        	font-size: 1.2em;
        	border-radius: 40%;
        	background-color: #888;
        	border: none;
			background-color: #f8585b;
			border-radius: 10px;
			border: none;
			color:#fff;
			padding: 15px 0;
			text-align: center;
			text-decoration: none;
			display: block;
			font-size: 15px;
			margin: 4px;
			cursor: pointer;
        }
        #backDiv > button {
        	background-color: #777;
        	width: 50px;
        	display: block;
        	/* display: none; */
        }
        #dateLi {
        	display: block;
        }
        
        
	</style>
    <script src="https://code.jQuery.com/jquery-3.3.1.min.js"></script>
    <script>
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1;
        var yyyy = today.getFullYear();
        var bookingDate;
       	var movieNo;
       	var thName = [];
       	var selThName;
       	var cnt = 0;
       	var selDate;
       	var selTh;
       	var startTime = [];
       	var endTime = [];
        	
        $(function(){
			console.log('${sessionScope.theater}');
			<c:forEach items="${sessionScope.theater}" var="item">
				movieNo = '${item.key}';
				<c:forEach items="${item.value}" var="thN">
					thName[cnt] = '${thN}';
					cnt++;
				</c:forEach>
			</c:forEach>
			cnt = 0;
			
			/* 날짜 선택 리스트 */
       		selDate = "<ul id='dateLi'>";
			selDate += "<li><button value="+ yyyy +"/"+mm+"/"+dd+">"+ yyyy+"/"+mm+"/"+dd +"</button></li><br>";
			selDate += "<li><button value="+ yyyy +"/"+mm+"/"+(dd+1)+">"+ yyyy+"/"+mm+"/"+(dd+1) +"</button></li><br>";
			selDate += "<li><button value="+ yyyy +"/"+mm+"/"+(dd+2)+">"+ yyyy+"/"+mm+"/"+(dd+2) +"</button></li><br>";
			selDate += "<li><button value="+ yyyy +"/"+mm+"/"+(dd+3)+">"+ yyyy+"/"+mm+"/"+(dd+3) +"</button></li><br>";
			selDate += "<li><button value="+ yyyy +"/"+mm+"/"+(dd+4)+">"+ yyyy+"/"+mm+"/"+(dd+4) +"</button></li>";
			selDate += "</ul>";
           	$("#div1").prepend(selDate);
            $("#backToDate").css("display", "none");
            $("#backToTh").css("display", "none");
            
            /* 상영관 선택 리스트 */
			selTh = "<ul class='thLi' id='thBtn'>"
			for (var i=0; i<thName.length; i++){
			selTh += "<li><button value="+ thName[i] +">";
			selTh += thName[i]				
			selTh += "</button></li><br>";
			}
			selTh += "</ul>";
			$("#div1").prepend(selTh);
			$("#thBtn").css("display", "none");
			
            
			$("#dateLi>li>button").click(function(){
				var selDate;
				bookingDate = $(this).val();
				console.log(bookingDate);
				selDate = "<button class='thLi' style='background-color: yellowgreen'>"+ bookingDate+ "</button>";
				$("#thBtn").prepend(selDate);
				
				$("#dateLi").css("display", "none");
	           	$("#backToDate").css("display", "block");
	           	$("#thBtn").css("display", "block");
			});
            
            $("#thBtn>li>button").click(function(){
            	$("#backToDate").css("display", "none");
            	$("#backToTh").css("display", "block");
            	console.log($(this).val());
            	selThName = $(this).val();
            	console.log("고른 상영관은: "+ selThName);
            	console.log("고른 영화번호: "+ movieNo);
            	var timeMap;
	            $.ajax({ 
	          	  url:'./ajaxtest', 
	                type:'post',
	                /* async: false, */
	                /* dataType: 'json', */ 
	                data: {
		                	movieNo:movieNo,
	                	theaterName:selThName
	                },
	                 success : function(data){
	                	console.log("성공");
/* 	                	console.log(data.movieNo);
	                	console.log(data.theaterName);
	                	console.log(data.timeMap); */
	                	console.log(data);
	                	/* var obj = JSON.parse(data); */
	                	/* eval
	                	JSON.parse */
	                	
	                 }, 
	                  error : function(){ 
	                	console.log("실패");
	                   } 
            	});
/* 	            cnt = 0;
				<c:forEach items="${sessionScope.sesMap}" var="item">
					startTime[cnt] = '${item.key}';
					endTime[cnt] = '${item.value}';
					cnt++;
				</c:forEach>
	            for (var i=0; i<startTime.length; i++) {
	            	console.log(startTime[i]+ " ~ "+ endTime[i])
	            } */
            });
            
            $("#backToDate").click(function(){
	            $(this).css("display", "none");
				$("#dateLi").css("display", "inline-block");
	            $(".thLi").css("display", "none");
            });
            $("#backToTh").click(function(){
            	
            });
        		
        	
/*             $("#dateLi>li:first>button").html(yyyy+"/"+mm+"/"+dd).prop("value", yyyy+"/"+mm+"/"+dd);
            $("#dateLi>li:eq(1)>button").html(yyyy+"/"+mm+"/"+(dd+1)).prop("value", yyyy+"/"+mm+"/"+(dd+1));
            $("#dateLi>li:eq(2)>button").html(yyyy+"/"+mm+"/"+(dd+2)).prop("value", yyyy+"/"+mm+"/"+(dd+2));
            $("#dateLi>li:eq(3)>button").html(yyyy+"/"+mm+"/"+(dd+3)).prop("value", yyyy+"/"+mm+"/"+(dd+3));
            $("#dateLi>li:last>button").html(yyyy+"/"+mm+"/"+(dd+4)).prop("value", yyyy+"/"+mm+"/"+(dd+4)); */

/*             document.write("<form action=\"ranking\" id=score method=POST>");
            document.write("<input type=hidden name=name value="+ name+ ">");
            document.write("<input type=hidden name=score value="+ count+ ">");
            document.write("</form>");
            var frm = document.getElementById("score");
            frm.submit(); 
            */
        });
        
        
        
    </script>
</head>
<body>
    <header>

    </header>
    <div id="outter">
        <div id="div1">
<!--             <ul id="dateLi">
                <li><button></button></li><br>
                <li><button></button></li><br>
                <li><button></button></li><br>
                <li><button></button></li><br>
                <li><button></button></li> 
            </ul> -->
            <div id='backDiv'>
	            <button id='backToDate'>Back</button>
	            <button id='backToTh'>Back</button>
            </div>
            
        </div>

        <div id="div3">
ㅣㅏㅓㅁㄴ오리;ㅏㄴ멍리ㅏㅓㅁㄴ이ㅏ;러
        </div>
    </div>
</body>
</html>