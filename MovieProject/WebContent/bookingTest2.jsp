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
            /* border: 1px solid black; */
            height: 800px;
            width: 80%;
            margin: auto;
            margin-top: 100px;
        }
        #outter>div {
            /* border: 1px solid red; */
            float: left;
        }
        
        #div1 {
            margin-left: 2%;
            width: 18%;
            height: 100%;
        }
        #div2 {
        	width: 18%;
        	height: 100%;
        }
        #blank {
        	width: 18%;
        	height: 100%;
        }
        #div3 {
        	width: 18%;
        	height: 100%;
        }
        #div4 {
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
        img {
        	width: 400px;
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
       	var timeNo;
       	var img;
		var rowList = new Array();
		var colList = new Array();
		var cnt = 0;
       	
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
			
			<c:forEach items="${map }" var="item">
				rowList[cnt] = '${item.key}'
				colList[cnt] = '${item.value }'
				cnt++;
			</c:forEach>
			for (var i=0; i<${mapSize}; i++){
				console.log("row: "+ rowList[i]+ " 리스트 담기 성공이셈");
				console.log("col: "+ colList[i]+ " 리스트 담기 성공이셈");
			}
			
			
			
			img = "images/"+ movieNo+".jpg";
			
			$("img").prop("src", img);
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
            $("#backToTime").css("display", "none");
            
            /* 상영관 선택 리스트 */
			selTh = "<ul class='thLi' id='thBtn'>"
			for (var i=0; i<thName.length; i++){
			selTh += "<li><button value="+ thName[i] +">";
			selTh += thName[i]				
			selTh += "</button></li><br>";
			}
			selTh += "</ul>";
			$("#div2").prepend(selTh);
			$("#thBtn").css("display", "none");
			
			
	        $("#div2").css("display", "none");
	        $("#div3").css("display", "none");
	        $("#div4").css("display", "block");
			
            
			$("#dateLi>li>button").click(function(){
				var selDate;
				bookingDate = $(this).val();
				console.log(bookingDate);
				selDate =  "<button id='selectedDate' class='thLi' style='background-color: yellowgreen'>"+ bookingDate+ "</button>";
				selDate += "<button id='selectedTh' style='background-color: yellowgreen'></button>";
				selDate += "<button id='selectedTime' style='background-color: yellowgreen'></button>";
				$("#blank").css("display", "none");
				$("#div1").prepend(selDate);
				$("#div2").css("display", "block");
				$("#selectedTh").css("display", "none");
				$("#selectedTime").css("display", "none");
				$("#dateLi").css("display", "none");
	           	$("#backToDate").css("display", "block");
	           	$("#thBtn").css("display", "block");
			});
            
            $("#thBtn>li>button").click(function(){
            	$("#selectedTh").css("display", "block");
            	$("#selectedTh").text($(this).val());
            	$("#div2").css("display", "none");
            	$("#div3").css("display", "block");
            	
            	$("#backToDate").css("display", "none");
            	$("#backToTh").css("display", "block");
            	console.log($(this).val());
            	selThName = $(this).val();
            	console.log("고른 상영관은: "+ selThName);
            	console.log("고른 영화번호: "+ movieNo);
            	
	            $.ajax({ 
	          	  url:'get2.jsp', 
	                type:'get',
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
	                	
	                	$("#div3").css("display", "block");
	                	$("#div3").html(data);
	                	/* var obj = JSON.parse(data); */
	                	/* eval
	                	JSON.parse */
			            $("#timeLi>li>button").click(function(){
			            	var selTime = $(this).text();
			            	$("#backToTime").css("display", "block");
			            	$("#backToTh").css("display", "none");
			            	$("#selectedTime").text(selTime);
			            	$("#selectedTime").css("display", "block");
			            	$("#div3").css("display", "none");
			            	timNo = $(this).val();
			            	console.log($(this).val());
			            	console.log($(this).text());
			            	$("#blank").css("display", "block");
			            	
			            	$.ajax({
			            		
			            		
			            		
			            		
			            		
			            	});
			            	
			            	
			            });
	                	
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
            	$("#div2").css("display", "none");
				$("#dateLi").css("display", "block");
				$("#selectedDate").css("display", "none");
				$("#blank").css("display", "block");
            });
            
            $("#backToTh").click(function(){
	            $("#div2").css("display", "block");
	            $(this).css("display", "none");
	            $("#backToDate").css("display", "block");
	            $("#div3").css("display", "none");
	            $("#selectedTh").css("display", "none");
            });
        		
        	$("#backToTime").click(function(){
        		$(this).css("display", "none");
        		$("#backToTh").css("display", "inline-block");
        		$("#div3").css("display", "block");
        		$("#selectedTime").css("display", "none");
        		$("img").css("display", "block");
        		$("#blank").css("display", "none");
        	});
        	
        	
        	
        	
        	
        	
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
	            <button id='backToTime'>Back</button>
            </div>
        </div>
		<div id="blank"></div>
		<div id="div2">
		
		</div>
        <div id="div3">
        
        </div>
		<div id="div4">
			<img src=""><br/>
		</div>
    </div>
</body>
</html>