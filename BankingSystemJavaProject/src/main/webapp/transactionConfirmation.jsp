<%@page import="bajpai.edu.beans.CustomerInfo"%>
<%@page import="bajpai.edu.beans.AccountInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bajpai.edu.dao.TransactionInfoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%="Transaction processed" %>
<%

int accNumber = Integer.parseInt(request.getParameter("accounts"));
int amount = Integer.parseInt(request.getParameter("amount"));
String typeOfOperation = request.getParameter("txnChoice");
String currAccBalance=null;
String typeOfAcc=null; 

ArrayList<AccountInfo> listOfAccountsAccountInfos = (ArrayList<AccountInfo>) request.getSession().getAttribute("accounts");
for(AccountInfo acc:listOfAccountsAccountInfos){
	if(acc.getAccNumber() == accNumber){
		currAccBalance = acc.getCurrAccBalance();
		typeOfAcc = acc.getAccType();
	}
}

System.out.println(accNumber + "\n\t" + typeOfOperation + "\n\t\t" + amount + "\n\t\t\t" + currAccBalance);
%>
<%=accNumber + " - " + amount + " - " + typeOfOperation + " - " + currAccBalance %>

<%
TransactionInfoImpl transactionInfoImpl = new TransactionInfoImpl();
//Create TXN record
long confirmationNo = transactionInfoImpl.createTxnRecord(accNumber, typeOfAcc , typeOfOperation, amount, Integer.parseInt(currAccBalance));

//Update cache with latest balance for account
CustomerInfo customer = (CustomerInfo) request.getSession().getAttribute("customer");
String emailID = customer.getEmailId();		
ArrayList<AccountInfo> arrayListOfAccountsForThisCustomer = transactionInfoImpl.fetchCustomerAccounts(emailID);
customer.setArrayListOfAccountsForThisCustomer(arrayListOfAccountsForThisCustomer);
request.setAttribute("accounts", arrayListOfAccountsForThisCustomer);

java.io.PrintWriter writer = response.getWriter();
writer.println("<h1>Transaction processed.. Pls note transaction id for future reference - " + confirmationNo);

RequestDispatcher dispatcher = request.getRequestDispatcher("processLogin.jsp");
dispatcher.include(request, response);
%>


</body>
</html>