<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%
String errorMessage = (String) application.getAttribute("errorMessage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
</head>
<body>
	<div style="margin: auto; text-align: center;">
		<h1 style="color: red">TIPO DE ERROR</h1>
	</div>

	<hr>

	<div style="margin: auto; text-align: center;">
		<h3><%=errorMessage%></h3>
	</div>
	
	<div style="margin: auto; text-align: center;">
		<a href="AccesoDA.jsp"><button>Volver</button></a>
	</div>
</body>
</html>