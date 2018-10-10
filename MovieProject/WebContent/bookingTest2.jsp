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
        html, body { width: 100%; height: 100%; }
        
        #outter {
            background-color: #f5f5dc;
            /* border: 1px solid black; */
            height: 100%;
            width: 80%;
            margin: auto;
        }
        #outter>div {
            /* border: 1px solid red; */
            float: left;
            height: 90%;
            width: 18%;
            margin-top: 80px;
        }
        
        #div1 {
            margin-left: 2%;
            width: 18%;
        }
        #div2 {
        	width: 18%;
        }
        #blank {
        	width: 18%;
        }
        #div3 {
        	width: 18%;
        }
        #div4 {
            width: 60%;
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
        #seatLi {
        	display: block;
        }
        .seatClass {
        	background-color: #999;
        }
	</style>
    <script src="https://code.jQuery.com/jquery-3.3.1.min.js"></script>
    <script>
    /* 
    	timeNo 시간 넘버
       	movieNo 영화넘버
       	selThName 상영관 이름
       	bookingDate 예매 날짜 (yyyy/mm/dd)
    	selTime 선택한 시작시간 ~ 끝시간
    */
        var today = new Date();
        var dd;
    	if (today.getDate() < 10){
    		dd = '0'+ today.getDate();
    	}else {
    		dd = today.getDate();
    	}
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
		var seatList = [];
       	var selTime;
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
			/*			
			<c:forEach items="${map }" var="item">
				rowList[cnt] = '${item.key}'
				colList[cnt] = '${item.value }'
				cnt++;
			</c:forEach>
			for (var i=0; i<${mapSize}; i++){
				console.log("row: "+ rowList[i]+ " 리스트 담기 성공이셈");
				console.log("col: "+ colList[i]+ " 리스트 담기 성공이셈");
			} */
			
			
			
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
	                async: false,
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
			            	selTime = $(this).text();
			            	$("#backToTime").css("display", "block");
			            	$("#backToTh").css("display", "none");
			            	$("#selectedTime").text(selTime);
			            	$("#selectedTime").css("display", "block");
			            	$("#div3").css("display", "none");
			            	timeNo = $(this).val();
			            	console.log($(this).val());
			            	console.log($(this).text());
			            	$("#blank").css("display", "block");
			            	
			            	$.ajax({
			            		url:'get.jsp', 
				                type:'get',
				                async: false,
				                data: {
				                	timeNo:$(this).val(),
				                   	movieNo:movieNo,
				                   	ThName:selThName,
				                   	bookingDate:bookingDate
				                },
				                success : function(data){
				                	/* $("#blank").css("display", "none"); */
				                	/* $("#div4").css("display", "none"); */
				                	console.log(data);
				                	$("#div4").html(data);
				                	
				                	
				                	
				                	
				                	$(".seatClass").css("width", "30px").css("height", "40px");
				                	$(".seatClass[value=booked]").css("background-color", "red");
				                	
				                	$(".seatClass").click(function(){	// 좌석 선택했을 때
				                		var val = $(this).val();
				                		if ($(this).css("background-color") == 'rgb(154, 205, 50)'){
					                		$(this).css("background-color", "#999");
					                		for (var i=0; i<seatList.length; i++) {
					                			if (seatList[i] == val){
					                				seatList.splice(i,1);
					                			}
					                		}
				                		} else if (seatList.length == 5) {
				                			alert("최대 5자리까지 예약할 수 있습니다.");
				                		} else if (val == 'booked') {
				                			alert("이미 예약된 자리입니다. 다른 좌석을 선택해주세요");
				                		} else if ($(this).css("background-color") == 'rgb(153, 153, 153)'){
						                		$(this).css("background-color", "yellowgreen");
						                		seatList.push(val);
				                		}
				                		for (var i=0; i<seatList.length; i++){
				                			console.log(seatList[i]);
				                		}
				                	});
				                	
				                	$("#bookingBtn").click(function(){
				                		var yesNo = confirm("예매를 진행하시겠습니까?");
				                		if (yesNo){
				                			if (seatList.length == 0){
				                				alert("예매하실 좌석을 선택해 주세요");
				                			} else {
						                		var formStr = "<form action='toPay' name='bookingFrm'>";
						                		formStr += "<input type='hidden' name='movieNo' value='"+movieNo+"'>";
						                		formStr += "<input type='hidden' name='timeNo' value='"+timeNo+"'>";
						                		formStr += "<input type='hidden' name='bookingDate' value='"+bookingDate+"'>";
						                		formStr += "<input type='hidden' name='theaterName' value='"+selThName+"'>";
						                		formStr += "<input type='hidden' name='seatLength' value='"+seatList.length+"'>";
						                		for (var i=0; i<seatList.length; i++){
							                		formStr += "<input type='hidden' name='seat"+i+"' value='"+seatList[i]+"'>";
						                		}
						                		formStr += "<input type='hidden' name='selTime' value='"+selTime+"'>";
						                		formStr += "</form>";
						                		$("#div4").append(formStr);
						                		document.bookingFrm.submit();
				                			}
				                		}
				                	});
				                },
				                error : function(){
				                	console.log("좌석 ajax 실패");
				                }
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
        		$("#div4").css("display", "block");
        		$("#div4").html("<img src='"+img+"'><br/>");
        		$("#blank").css("display", "none");
        		$("#blank").html("");
        		
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