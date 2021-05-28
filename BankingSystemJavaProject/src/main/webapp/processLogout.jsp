<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%="Processing logout" %>
<%
	request.getSession().invalidate();
	System.out.println("Logged out of session");
	
/* 	
	RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
	dispatcher.forward(request, response);
*/

	response.sendRedirect("index.html");
%>
</body>
</html>