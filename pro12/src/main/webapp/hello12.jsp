<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
    String name ="��ũ";
	public String getName(){ return name;}
%>
<% String age = request.getParameter("age"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�ȳ��ϼ���! <%=name%> ��!!!</h1>
	<h1>���̴� <%=age %> �Դϴ�. </h1>
</body>
</html>
