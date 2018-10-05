<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@ page import="com.db.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <style>
        #span1 {
            font-size: 0.8em;
            color: red;
        }
        #idspan1{
            font-size: 0.8em;
            color: red;
        }
        #idspan2{
            font-size: 0.9em;
            color: green;
            display:none;
        }
        #span2 {
            font-size: 0.9em;
            color: green;
            display:none;
        }
        body {
            margin: auto;
            margin-top: 50px;
            width: 80%
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    
    <script>
    	<% 
			movieDAO dao = new movieDAO();
			ArrayList<String> list = dao.idList();
    	%>
    	var idList = [];
    	
    	<% for (int i = 0; i < list.size(); i++){
    	   %>
    	   idList[<%= i %>] = '<%= list.get(i) %>'<%; 
    	  } %>
        $(function(){
/* 	        for (var i=0; i<idList.length; i++){
		       	alert(idList[i]);
	        }; */
            var pw1;
            var pw2;
            var check = false;
            var idCheck = false;
            
            $("#id").on("change keyup paste", function(){
            	console.log($("#id").val());
            	for (var i = 0; i < idList.length; i++){
	            	if ($("#id").val() == idList[i]){
	            		$("#idspan1").css("display", "inline");
	            		$("#idspan2").css("display", "none");
	            		idCheck = false;
	            		break;
	            	} else if ($("#id").val() == ""){
	            		$("#idspan1").css("display", "inline");
	            		$("#idspan2").css("display", "none");
	            		idCheck = false;
	            	} else {
	            		$("#idspan1").css("display", "none");
	            		$("#idspan2").css("display", "inline");
	            		idCheck = true;
	            	}
            		
            	}
            });
            
            $("#id, #password, #name, #password2").bind("keyup",function(){
            	re = /[\]\[\}\{\'\;\"\:\.\,\/\?\>\<\` ~!@\#$%^&*\()\-=+_']/gi;
    			var temp=$("#id").val();
    			if(re.test(temp)){ //특수문자가 포함되면 삭제하여 값으로 다시셋팅
    			$("#id").val(temp.replace(re,"")); } 
   			});
            
            $("#password").on("change keyup paste", function(){
                console.log(password.value);
                pw1 = password.value;
                if (pw1 == pw2){
                    $("#span1").css("display", "none");
                    $("#span2").css("display", "inline");
                    check = true;
                }else {
                    $("#span1").css("display", "inline");
                    $("#span2").css("display", "none");
                    check = false;
                }
            });
            
            
            
            $("#password2").on("change keyup paste", function(){
                console.log(password2.value);
                pw2 = password2.value;
                if (pw1 == pw2){
                    $("#span1").css("display", "none");
                    $("#span2").css("display", "inline");
                    check = true;
                }else {
                    $("#span1").css("display", "inline");
                    $("#span2").css("display", "none"); 
                    check = false;
                }
            });

            document.frm1.onsubmit = function(){
                var frm1 = document.frm1;
                if (frm1.id.value == "") {
                    alert('아이디를 입력해주세요');
                    return false;
                } else
                if (frm1.name.value == "") {
                    alert('이름을 입력해주세요');
                    return false;
                } else
                if (frm1.password == ""){
                    alert('비밀번호를 입력해주세요');
                    return false;
                } else
                if (check == false){
                    alert('비밀번호를 확인해주세요');
                    return false;
                } else
                if (idCheck == false){
                	alert('중복된 아이디입니다');
                    return false;
                } else {
                	alert("회원가입이 완료되었습니다. 다시 로그인해주세요.");
                }
                
            };
        });
	</script>
</head>
<body>
    <h1>회원가입</h1>
    <hr>
    <div>
        <form action="/MovieProject/signup" name="frm1" method="post">
            <p>
                <label for="id">아이디: </label><br>
                <input type="text" name="id" id="id">
                <span id="idspan1">중복된 id입니다.</span><span id="idspan2">사용할 수 있는 id입니다.</span>
            </p>
            <p>
                <label for="name">이름: </label><br>
                <input type="text" name="name" id="name">
            </p>
            <p>
                <label for="password">비밀번호: </label><br>
                <input type="password" name="password" id="password" value="">
            </p>
            <p>
                <label for="password2">비밀번호 확인: </label><br>
                <input type="password" name="password2" id="password2" value=""> 
                <span id="span1">불일치</span><span id="span2">일치</span>
            </p>
            <p>
                <input type="submit" value="가입">
            </p>
        </form>
    </div>


</body>
</html>