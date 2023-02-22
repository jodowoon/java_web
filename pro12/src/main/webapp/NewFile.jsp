<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type='text/javascript'>
$(document).ready(function(){
	// HelloWorld서블릿을 Get방식으로 호출
	$("#btnHelloWorldGet").bind("click", function(){
		$.ajax({            
            type : "GET",
            url : "HelloWorld.do",
            success : function(data){
                $("#inputHelloWorld").val(data);
            },
        	error : function(){
            	alert('통신실패!!');
       		},
        });
	});
	
	// HelloWorld서블릿을 Post방식으로 호출
	$("#btnHelloWorldPost").bind("click", function(){
		$.ajax({            
            type : "POST",
            url : "HelloWorld.do",
            success : function(data){
                $("#inputHelloWorld").val(data);
            },
        	error : function(){
            	alert('통신실패!!');
       		},
        });
	});	
});

</script>
</head>
<body>
<button id="btnHelloWorldGet">HelloWorld Get 호출</button>   
<button id="btnHelloWorldPost">HelloWorld Post 호출</button>   
<input type="text" id="inputHelloWorld">
</body>
</html>