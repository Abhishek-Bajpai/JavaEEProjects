<%@page import="bajpai.edu.beans.CustomerInfo"%>
<%@page import="bajpai.edu.dao.CustomerInfoImpl"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Registration Form</title>
</head>
<body>
	<%
String name = request.getParameter("name");
String birthDate = request.getParameter("bday");
String address = request.getParameter("address");
String email= request.getParameter("emailid");
String accType = request.getParameter("accounts");
String pwd = request.getParameter("pass");



CustomerInfo customerInfo = new CustomerInfo(name, birthDate, email, address);
CustomerInfoImpl customerInfoImpl = new CustomerInfoImpl();
customerInfoImpl.registerCustomer(customerInfo, accType, pwd);

PrintWriter writer = response.getWriter();
//writer.println("<h1>Account created successfully, You may login now.. <h1>");
System.out.println("<h4>"+ customerInfo + "</h4>");

//writer.println("<h2>"+ customerInfo + "</h2>");
RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
dispatcher.include(request, response);
%>

</body>
</html>