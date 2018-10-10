<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="https://code.jQuery.com/jquery-3.3.1.min.js"></script>
    <style>
        .prev {
            /* border: 1px black solid; */
            text-align: center;
        }
        iframe {
            width: 80%;
            height: 450px;
        }
        .description, .btn {
            margin: auto;
            width: 80%;
        }
        .btn>input {
            float: right;
            border: 1px solid black;
        }
        hr{
            width: 80%;
        }
    </style>
    <script>
        $(function(){
            $("#back").click(function(){
                history.back();
            });
            
            $("#booking").click(function(){
            	<% session.removeAttribute("movie"); %>
	            <% session.setAttribute("movie", "밀양"); %>
				alert('${sessionScope.movie}');            	
            });
        });
    </script>
</head>
<body>
    <p class="prev">
        <iframe src="https://www.youtube.com/embed/yFt-i-LTXpo" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
    </p>
    <hr>
    <div class="description">
        설명
    </div>
    <footer>
        <div class="btn">
            <input type="button" value="뒤로가기" id="back">
            <form action="./booking">
	            <input type="submit" value="예매하기" id="booking">
            </form>
        </div>
    </footer>
        
</body>
</html>