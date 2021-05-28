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
 
 <%

TransactionInfoImpl txnInfoImpl = new TransactionInfoImpl();

CustomerInfo customer = (CustomerInfo) request.getSession().getAttribute("customer");
ArrayList<AccountInfo> listOfAccountsAccountInfos = (ArrayList<AccountInfo>) request.getSession().getAttribute("accounts");

PrintWriter writer = response.getWriter();
String typeOfTxn=""; 
ArrayList<AccountInfo> listOfAccounts =null;
if(customer!=null){
listOfAccounts = customer.getArrayListOfAccountsForThisCustomer();
}

//trying new code --better presentation
writer.println("<form action='"+ "processTxnHistory.jsp"+"'method='"+"'post"+"'>");
String strHiddenInput = "<input type='"+ "hidden" + "' name='" + "selectedval" + "' id='"+"selectedval"+"'>";
writer.println(strHiddenInput);
writer.println("<div><label class='"+"focus-input100'"+ "for='"+"accounts'"+">Choose Account to get transaction records</label>");
writer.println("<select class='select' name='accounts' id='accounts' onchange='"+"changeHiddenInput(this)'"+">");
if(listOfAccounts!=null){		
for(AccountInfo acc: listOfAccountsAccountInfos){
	writer.println("<option name='accNum'>" + acc.getAccNumber() + "</option>");
}
}
writer.println("</select></div><br/>");

String fromDTlabel = "<label>Enter From Date :  </label>";
String toDTlabel   = "<label>Enter To Date :  </label>";
String fromDTBox = "<input type='"+"date' "+ "name='"+"fromDT'" + ">";
String toDTBox = "<input type='"+"date' "+ "name='"+"toDT'" + ">";

writer.println("<table border=1><th>" + fromDTlabel + "</th><td>"+ fromDTBox +"</td></tr><th>" +toDTlabel+ "</th><td>" +toDTBox+ "</td></table>");

String back ="<form action="+"'processLogin.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Back</button></div></form>"; 
writer.println("<br><br><div><button>Submit</button></div></form>"+back);		

//writer.println(back);

String fromDate = request.getParameter("fromDT");
String toDate = request.getParameter("toDT");
if(fromDate.isEmpty() || toDate.isEmpty()){
	writer.println("<h3><font face = '"+"Comic sans MS"+"' color=#FF0000"+"'>Date range not provided completely OR partially, Showing all the records since the beginning of time...</font></h3>");
}else{
 	writer.println("<h3><font face = '"+"Comic sans MS"+"' color='#009900"+"'>Showing records for dates between : "+ fromDate + " AND " + toDate +"</font></h3>");

}


//writer.println("<h1>"+request.getParameter("accounts")+"</h1>");
String selectedAccForHistory = request.getParameter("accounts");
AccountInfo selectedAcc=null;

for(AccountInfo acc:listOfAccounts){
	if(String.valueOf(acc.getAccNumber()).equalsIgnoreCase(selectedAccForHistory)){
		selectedAcc = acc;
	}
}
ArrayList<TransactionInfo> listOfTxns = txnInfoImpl.fetchTxnHistory(String.valueOf(selectedAccForHistory) , fromDate , toDate);
int totalCredit=0, totalDebit=0;

	
writer.println("<h2> Transaction Records For : "+ selectedAcc.getAccType() + " : " + selectedAccForHistory +"</h2>");

writer.println("<table border=1><tr><th>Account Number</th><td>"+ selectedAccForHistory +"</td></tr>");
writer.println("<tr><th>Current Account Balance </th><td>"+ selectedAcc.getCurrAccBalance()+"</td></tr>");
writer.println("<tr><th>Current Account Type </th><td>"+ selectedAcc.getAccType()+"</td></tr></table><br/><br/>");

writer.println("<table border=1><tr><th> Index </th><th> Transaction ID </th><th> Date / Time </th><th> Amount </th><th> Transaction Performed </th></tr>");
int index=1;
for(TransactionInfo txnInfo: listOfTxns) {
	if(txnInfo.getTypeOfOperation().equalsIgnoreCase("credit")){
		typeOfTxn = "Deposit";
		totalCredit = totalCredit+txnInfo.getAmountInvolved();
	}else{
		typeOfTxn = "Withdraw";
		totalDebit = totalDebit + txnInfo.getAmountInvolved();
	}
	writer.println("<tr><td>"+ index +"</td><td>"+txnInfo.getTxnID()+"</td><td>"+txnInfo.getDateTimeOfOperation()+"</td><td>"+txnInfo.getAmountInvolved()+"</td><td>"+typeOfTxn+"</td></tr>");
	index++;
}
writer.println("</table>");
//writer.println("----------------------------------------------------");
writer.println("<h4><font face = '"+"arial,helvetica"+"' color='#009900" +"'> Total Deposited  : " + totalCredit  + "</font></h4>");
writer.println("<h4><font face = '"+"arial,helvetica"+"' color='#FF0000" +"'> Total Withdrawl  : " + totalDebit  + "</font></h4>");

//String back ="<form action="+"'processLogin.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Back</button></div></form>"; 
String logOut = "<form action="+"'processLogout.jsp'"+ "method='"+"'post'"+"><div class=" + "'container-login100-form-btn'" + "><button class=" + "'login100-form-btn'" + ">Logout</button></div></form>";

writer.println(back);
writer.println(logOut);






%>
</body>
</html>