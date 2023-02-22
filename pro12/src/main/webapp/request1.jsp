<%@ page language="java" contentType="text/html; charset=UTF-8" import="javax.servlet.RequestDispatcher"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("name","조도운");
	request.setAttribute("address","경기도 수원시 영통구");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<%
	RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
	dispatch.forward(request,response);
%>


</body>
</html>