<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	session.setAttribute("name","조도운");
	//application.setAttribute("address", "경기도 수원시");
	session.setAttribute("address","경기 수원시 "); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> 이름과 주소를 저장합니다.</h1>
	<a href=appTest2.jsp> 두번째 jsp 파일 호출하기 </a>
</body>
</html>

