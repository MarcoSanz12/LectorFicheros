<%@page import="xml.XMLReader"%>
<%@page import="xml.pojo.Film"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% ArrayList <Film> films = XMLReader.xmlReader(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XML Reader</title>
</head>
<body>
<div style="margin: auto; text-align: center;">
<h1>PELICULAS</h1>
</div>

<table border="1" style="margin: auto;">
<tr style="font-weight: bold;background-color: #D8FFFD ">
<td>TITULO</td>
<td>DURACIÓN</td>
<td>GÉNERO</td>
<td>DIRECTOR</td>
<td>OBRA DESTACADA DEL DIRECTOR</td>
<td>ESTUDIO</td>
<td>AÑO</td>
</tr>
<% for(Film f : films){ %>
<tr style="background-color: #FFFFE2;">
<td><%=f.getTitle()%></td>
<td><%=f.getRunTime() %></td>
<td><%=f.getGenre() %></td>
<td><%=f.getDirector() %></td>
<td><%=f.getFamousFilm() %></td>
<td><%=f.getStudio()%></td>
<td><%=f.getYear()%></td>
</tr>

<%} %>
</table>
<br>
<div style="margin: auto; text-align: center;">
XML utilizado : <a href="https://gist.github.com/Abhishek249/6356baab2a5abb5008b6f836b78522cf">https://gist.github.com/Abhishek249/6356baab2a5abb5008b6f836b78522cf</a>
</div>

</body>
</html>