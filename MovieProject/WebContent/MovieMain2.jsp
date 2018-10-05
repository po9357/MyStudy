<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    
    <script src="https://code.jQuery.com/jquery-3.3.1.min.js"></script>
    <style>
        .mySlides {display:none;}
        #img {
            margin: auto;
            width: 50%;
            /* border: 1px solid red; */
        }
        img {
            margin: auto;
            height: 550px;
            text-align: center;
        }
        .w3-content.w3-display-container {
            border: 1px solid black;
        }
        #login {
            width: 250px; height: 250px;
            /* border: 1px solid black; */
            float: right;
        }
    </style>
    <script>
        $(function(){
            $("#signup").click(function(){
                location.href="./signup.jsp";
            });
        });
    </script>
</head>
<body>
       
<h2 class="w3-center">상영중인 영화</h2>

<div class="w3-content w3-display-container">
    <div id="img">
        <a href="./밀양.jsp">
            <img class="mySlides" src="images/밀양.jpg">
        </a>
        <a href="./뷰티인사이드.jsp">
            <img class="mySlides" src="images/뷰티인사이드.jpg">
        </a>
        <a href="./어벤져스.jsp">
            <img class="mySlides" src="images/어벤져스.jpg">
        </a>
    </div>
  <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
  <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
  <div id="login">
    <form action="/login">
    	<p>
    		<b>${ sessionScope.Id }</b>님 환영합니다!
    <!-- id님 환영합니다! -->
    	</p>
        <p>
            <input type="button" id="logout" value="로그아웃">
        </p>
    </form>
    </div>
</div>



<script>
    var slideIndex = 1;
    showDivs(slideIndex);
    
    function plusDivs(n) {
        showDivs(slideIndex += n);
    };
    function showDivs(n) {
        var i;
        var x = document.getElementsByClassName("mySlides");
        if (n > x.length) {slideIndex = 1}    
        if (n < 1) {slideIndex = x.length}
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";  
        }
        x[slideIndex-1].style.display = "block";  
    };

    var autoslide = setInterval(function(){
        plusDivs(1);
    }, 2000);

    $("#img").mouseover(function(){
        clearInterval(autoslide);
    });
    $("#img").mouseout(function(){
        autoslide = setInterval(function(){
        plusDivs(1);
    }, 2000);
    });
            
</script>


</body>
</html>