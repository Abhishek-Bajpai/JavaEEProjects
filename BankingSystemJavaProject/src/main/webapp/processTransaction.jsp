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
//writer.println("<h1>" + request.getSession().getAttribute("customer") + "</h1>");
//writer.println("<h2>" + request.getSession().getAttribute("accounts") + "</h2>");

 
ArrayList<AccountInfo> listOfAccountsAccountInfos = (ArrayList<AccountInfo>) request.getSession().getAttribute("accounts");

writer.println("<div text-align: center><h1>Perform a transaction</h1></div>");
writer.println("<form action='"+ "transactionConfirmation.jsp"+"'method='"+"'post"+"'>");
writer.println("<div><label class='"+"focus-input100'"+ "for='"+"accounts'"+">Choose Account to Operate on :</label>");
writer.println("<select class='select' name='accounts' id='accounts'>");
for(AccountInfo acc: listOfAccountsAccountInfos){
//	if(acc.getAccType().equalsIgnoreCase("savings") || acc.getAccType().equalsIgnoreCase("checkin"))
	   //writer.println("<option name='accNum'>" + acc.getAccType() + " - "+ acc.getAccNumber() + "</option>");
	writer.println("<option name='accNum'>" + acc.getAccNumber() + "</option>");
}

writer.println("</select></div><br/>");

writer.println("<div><div><label>Enter Amount :  </label><input type='"+"text' "+ "name='"+"amount'" + "></div>");

writer.println("<p>What would you like to do with this money</p>");
writer.println("<div><input type='"+"radio'"+ "id='"+"debit'"+ "name='"+"txnChoice'"+" value='"+"debit'");
writer.println("<label for='" +"debit'" + ">Withdraw</label></div>");
writer.println("<div><input type='"+"radio'"+ "id='"+"credit'"+ "name='"+"txnChoice'"+" value='"+"credit'");
writer.println("<label for='" +"credit'" + ">Deposit</label></div></div><br/><br/>");

writer.println("<div><button>Submit</button></div></form>");		

%>
</body>
</html>