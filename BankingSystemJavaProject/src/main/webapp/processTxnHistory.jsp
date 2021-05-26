<%@page import="bajpai.edu.beans.AccountInfo"%>
<%@page import="bajpai.edu.beans.CustomerInfo"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="bajpai.edu.beans.TransactionInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
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
<%="Show Transaction History here"  %>
<%

request.getParameter("");
TransactionInfoImpl txnInfoImpl = new TransactionInfoImpl();

CustomerInfo customer = (CustomerInfo) request.getSession().getAttribute("customer");
ArrayList<AccountInfo> listOfAccountsAccountInfos = (ArrayList<AccountInfo>) request.getSession().getAttribute("accounts");

PrintWriter writer = response.getWriter();
String typeOfTxn=""; 

ArrayList<AccountInfo> listOfAccounts = customer.getArrayListOfAccountsForThisCustomer();

for(AccountInfo acc:listOfAccounts){
	ArrayList<TransactionInfo> listOfTxns = txnInfoImpl.fetchTxnHistory(String.valueOf(acc.getAccNumber()));
	int totalCredit=0, totalDebit=0;

 	
	writer.println("<h2> Transaction Records For : "+ acc.getAccType() + " : " + acc.getAccNumber() +"</h2>");

	writer.println("<table border=1><tr><th>Account Number</th><td>"+ acc.getAccNumber() +"</td></tr>");
	writer.println("<tr><th>Current Account Balance </th><td>"+ acc.getCurrAccBalance()+"</td></tr>");
	writer.println("<tr><th>Current Account Type </th><td>"+ acc.getAccType()+"</td></tr></table><br/><br/>");
	
	writer.println("<table border=1><tr><th> Index </th><th> Transaction ID </th><th> Date / Time </th><th> Amount </th><th> Transaction Performed </th></tr>");
	int index=1;
	for(TransactionInfo txnInfo: listOfTxns) {
		if(txnInfo.getTypeOfOperation().equalsIgnoreCase("credit")){
			typeOfTxn = "Deposit";
			totalCredit = totalCredit+txnInfo.getAmountInvolved();
		}else{
			typeOfTxn = "Withdrawl";
			totalDebit = totalDebit + txnInfo.getAmountInvolved();
		}
		writer.println("<tr><td>"+ index +"</td><td>"+txnInfo.getTxnID()+"</td><td>"+txnInfo.getDateTimeOfOperation()+"</td><td>"+txnInfo.getAmountInvolved()+"</td><td>"+typeOfTxn+"</td></tr>");
		index++;
	}
	writer.println("</table><br/><br/>");
	writer.println("----------------------------------------------------");
	writer.println("Total Deposited  : " + totalCredit  + "<br/><br/>");
	writer.println("----------------------------------------------------");
	writer.println("Total Withdrawls : " + totalDebit   + "<br/><br/>");
	writer.println("----------------------------------------------------");
	writer.println("Account Balance  : " + (totalCredit - totalDebit)   + "<br/><br/>");
 	//writer.println("----------------------------------------------------");	
}
 

//ArrayList<TransactionInfo> listOfTxns = txnInfoImpl.fetchTxnHistory("1501508599");
//PrintWriter writer = response.getWriter();





%>
</body>
</html>