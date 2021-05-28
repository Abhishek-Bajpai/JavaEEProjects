<%@page import="javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar"%>
<%@page import="bajpai.edu.beans.TransactionInfo"%>
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
 
 <%
 String str=(String) request.getParameter("accounts");
 String numberOnly= str.replaceAll("[^0-9]", "");
 System.out.println(">>>>> Acc Num extracted : " + numberOnly);
 
 int accNumber = Integer.parseInt(numberOnly);
 
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
writer.println("<h4>Transaction processed, details below for your future reference</h4>");

TransactionInfo txnInfo = transactionInfoImpl.fetchTxnHistory(confirmationNo);
		
writer.println("<table border=1><tr><th> Transaction ID </th><th> Account No </th><th> Date / Time </th><th> Amount </th><th> Operation </th></tr>");
writer.println("<tr><td>"+txnInfo.getTxnID()+"</td><td>"+txnInfo.getAccNumber()+"</td><td>"+ txnInfo.getDateTimeOfOperation() +"</td><td>"+ txnInfo.getAmountInvolved()+"</td><td>"+txnInfo.getTypeOfOperation()+"</td></tr></table>");
		
String backtoPerformTxn ="<form action="+"'processLogin.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Back</button></div></form>"; 
writer.println("<br><br>"+backtoPerformTxn);

/* RequestDispatcher dispatcher = request.getRequestDispatcher("processLogin.jsp");
dispatcher.include(request, response); */
%>


</body>
</html>