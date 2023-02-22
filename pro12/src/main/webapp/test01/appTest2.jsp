<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
	String name =(String)session.getAttribute("name");
	String address = (String)session.getAttribute("address");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>이름은 <%=name %></h1>
	<h1>주소는 <%=address %></h1>
</body>
</html>



