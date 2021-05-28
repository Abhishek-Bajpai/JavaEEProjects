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

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V6</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>

<br><br><br>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
			<br><br><br>
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
 	writer.println("<h3> Profile Information </h3><br/>");
	writer.println("<table style='border:10px;margin-top:10px; margin-left:10px;'><tr><th>&emsp;  Customer Name  </th><th>&emsp;  Date Of Birth  </th><th>&emsp;  EmailID / UserID  </th><th>&emsp;  Address  </th></tr>");
	writer.println("<tr><td>&emsp;"+ customer.getFullName()+"&emsp;</td><td>&emsp;"+ customer.getDateOfBirth()+"&emsp;</td><td>&emsp;"+customer.getEmailId()+"&emsp;</td><td>&emsp;"+ customer.getAddress()+"&emsp;</td></tr></table><br/><br/>");
	
	//writer.println("<h2>"+ customer + "</h2>");
    ArrayList<AccountInfo> listOfAccountsAccountInfos =  customer.getArrayListOfAccountsForThisCustomer();
	//AccountInfoImpl accountInfoImpl = new AccountInfoImpl();
	//ArrayList<AccountInfo> listOfAccountsAccountInfos =  accountInfoImpl.fetchCustomerAccounts(email);
	request.getSession().setAttribute("accounts", listOfAccountsAccountInfos);
	
	writer.println("<h4> Account Information </h4><br/>");

	writer.println("<table style='border:10px;margin-top:10px; margin-left:10px;'><tr><th>&emsp;  Account Number&emsp;  </th><th>&emsp;  Account Type&emsp;  </th><th>&emsp;  Current Balance&emsp;  </th></tr>");
	for(AccountInfo acc:listOfAccountsAccountInfos) {
		System.out.println(acc);
		writer.println("<tr><td>&emsp;  "+ acc.getAccNumber()+"&emsp;  </td><td>&emsp;  "+acc.getAccType()+"&emsp;  </td><td>&emsp;  "+acc.getCurrAccBalance()+"&emsp;  </td></tr>");
	}
	writer.println("</table><br/><br/>");
	String perfTxn = "<form action="+"'processTransaction.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Perform Transaction</button></div></form>";
	String txnHist = "<form action="+"'testTxnHistory.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Transaction History</button></div></form>";
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
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>