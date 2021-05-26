<%@page import="bajpai.edu.beans.CustomerInfo"%>
<%@page import="bajpai.edu.dao.CustomerInfoImpl"%>
<%@page import="bajpai.edu.beans.AccountInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bajpai.edu.dao.AccountInfoImpl"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
<input type="hidden" id="refreshed" value="no">
<script type="text/javascript">

       onload=function(){
           var e=document.getElementById("refreshed");
           if(e.value=="no")e.value="yes";
           else{e.value="no";location.reload();}
       }

</script>
</script>
<body>

<%
String email= request.getParameter("username");
String pwd = request.getParameter("passcode");
PrintWriter writer = response.getWriter();

System.out.println("Info Submitted on the login page , User: " + email + ", Pwd : " + pwd );

boolean loginSuccess = false;

CustomerInfo customer = null;
CustomerInfoImpl customerInfoImpl = new CustomerInfoImpl();
if(null != email && null!=pwd)
	customer = customerInfoImpl.loginToCustomerAccount(email, pwd);

if(null!=customer || request.getAttribute("loggedinuser").equals("TRUE")){
	loginSuccess = true;
	request.setAttribute("loggedinuser", "TRUE");
	System.out.println(customer);

	request.getSession().setAttribute("customer", customer);
	
	writer.println("<h1> Profile Information </h1><br/>");
	writer.println("<table border=1><tr><th>Customer Name</th><th>Date Of Birth</th><th>EmailID/UserID</th><th>Address</th></tr>");
	writer.println("<tr><td>"+ customer.getFullName()+"</td><td>"+customer.getDateOfBirth()+"</td><td>"+customer.getEmailId()+"</td><td>"+ customer.getAddress()+"</td></tr></table><br/><br/>");
	
	//writer.println("<h2>"+ customer + "</h2>");
    ArrayList<AccountInfo> listOfAccountsAccountInfos =  customer.getArrayListOfAccountsForThisCustomer();
	//AccountInfoImpl accountInfoImpl = new AccountInfoImpl();
	//ArrayList<AccountInfo> listOfAccountsAccountInfos =  accountInfoImpl.fetchCustomerAccounts(email);
	request.getSession().setAttribute("accounts", listOfAccountsAccountInfos);
	
	writer.println("<h2> Account Information </h2><br/>");

	writer.println("<table border=1><tr><th>Account Number</th><th>Account Type</th><th>Current Balance</th></tr>");
	for(AccountInfo acc:listOfAccountsAccountInfos) {
		System.out.println(acc);
		writer.println("<tr><td>"+ acc.getAccNumber()+"</td><td>"+acc.getAccType()+"</td><td>"+acc.getCurrAccBalance()+"</td></tr>");
	}
	writer.println("</table><br/><br/>");
	String perfTxn = "<form action="+"'processTransaction.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Perform Transaction</button></div></form>";
	String txnHist = "<form action="+"'processTxnHistory.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Transaction History</button></div></form>";
	String addAcc ="<form action="+"'newaccount.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Add Another Account</button></div></form>"; 
	String logOut = "<form action="+"'processLogout.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Logout</button></div></form>";
	
	writer.println("<table><tr><td>"+perfTxn+"</td><td>"+txnHist+"</td><td>" + addAcc+"</td><td>"+ logOut+"</td><tr></table>");
/*
	writer.println(perfTxn);
	writer.println(txnHist);
	writer.println(addAcc);
	writer.println(logOut);
*/
}else{
	System.out.println("Customer Not Found !!!");
	writer.println("<h2>Customer Not Found !!!</h2>");
	request.setAttribute("loggedinuser", "FALSE");
	RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
	dispatcher.include(request, response);

}
%>
</body>
</html>