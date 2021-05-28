<%@page import="bajpai.edu.dao.AccountInfoImpl"%>
<%@page import="bajpai.edu.beans.CustomerInfo"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bajpai.edu.beans.AccountInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 <%
System.out.println(request.getSession().getAttribute("customer"));
System.out.println(request.getSession().getAttribute("accounts"));

java.io.PrintWriter writer = response.getWriter();

CustomerInfo customer = (CustomerInfo) request.getSession().getAttribute("customer");
//writer.println((CustomerInfo) request.getSession().getAttribute("customer"));

//writer.println("<h1>" + request.getSession().getAttribute("customer") + "</h1>");
//writer.println("<h2>" + request.getSession().getAttribute("accounts") + "</h2>");


ArrayList<AccountInfo> listOfAccountsAccountInfos = (ArrayList<AccountInfo>) request.getSession().getAttribute("accounts");
ArrayList<String> accTypeList=  new ArrayList<>();
accTypeList.add("SAVINGS");
accTypeList.add("CHECKIN");
accTypeList.add("CREDIT");
accTypeList.add("LOAN");


writer.println("<div text-align: center><h1>Add a new account for : "+ customer.getFullName() +"</h1></div>");
writer.println("<form action='"+ "addNewAccount.jsp"+"'method='"+"'post"+"'>");
writer.println("<div><label class='"+"focus-input100'"+ "for='"+"accounts'"+">Choose Account type (available) :</label>");
writer.println("<select class='select' name='accType' id='accType'>");
for(String accType: accTypeList){
 	writer.println("<option name='accType'>" + accType + "</option>");
}

writer.println("</select></div><br/>");
writer.println("<div><div><label>Enter Amount :  </label><input type='"+"text' "+ "name='"+"amount'" + "></div>");

writer.println("<div><button>Submit</button></div></form>");		

AccountInfo newAcc = new AccountInfo();
newAcc.setEmailID(customer.getEmailId());
newAcc.setAccType(request.getParameter("accType"));
newAcc.setCurrAccBal(request.getParameter("amount"));


AccountInfoImpl accountInfoImpl = new AccountInfoImpl();
boolean status = accountInfoImpl.createAccount(newAcc);
if(status){
	customer.getArrayListOfAccountsForThisCustomer().add(newAcc);
	request.setAttribute("customer", customer);
	listOfAccountsAccountInfos.add(newAcc);
	request.setAttribute("accounts", customer);
}




String backtoPerformTxn ="<form action="+"'processLogin.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Back</button></div></form>"; 
writer.println("<br><br>"+backtoPerformTxn);		


%>
</body>
</html>