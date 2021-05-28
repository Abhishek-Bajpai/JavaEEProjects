<%@page import="bajpai.edu.beans.AccountInfo"%>
<%@page import="bajpai.edu.beans.CustomerInfo"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="bajpai.edu.beans.TransactionInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@page import="bajpai.edu.dao.TransactionInfoImpl"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V6</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
	form { margin: 0 auto; }

select, input
{
	padding:5px;
	font-size:20px;
}
select.textIndent
{
	text-indent:1.5px;
}
select.paddingOffset
{
	padding-left:25px;
}
input.paddingOffset
{
	padding-left:25px;
}
	</style>
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
	
	<div class="limiter" >
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
 
 <%

TransactionInfoImpl txnInfoImpl = new TransactionInfoImpl();

CustomerInfo customer = (CustomerInfo) request.getSession().getAttribute("customer");
ArrayList<AccountInfo> listOfAccountsAccountInfos = (ArrayList<AccountInfo>) request.getSession().getAttribute("accounts");

PrintWriter writer = response.getWriter();
String typeOfTxn=""; 

ArrayList<AccountInfo> listOfAccounts = customer.getArrayListOfAccountsForThisCustomer();

//trying new code --better presentation

writer.println("<form action='"+ "testTxnHistory.jsp"+"'method='"+"'post"+"'>");
writer.println("<table><tr><td><label class='"+"focus-input100'"+ "for='"+"accounts'"+"><br><br>Choose Account to get transaction records</label></td></tr><br><br>&emsp;");
writer.println("<select class='select' dir='rt1' style='"+"width:200px;-webkit-appearance: none;"+"' name='accounts' id='accounts'>");
for(AccountInfo acc: listOfAccountsAccountInfos){
	writer.println("<option name='accNum'>" + acc.getAccNumber() + "</option>");
}
writer.println("</select>");
writer.println("<br><br><tr><td><div class='"+"container-login100-form-btn"+"'><button class='"+"login100-form-btn"+"'>Submit</button></div></div></td></tr></table></form><br>");		

//writer.println("<h1>"+request.getParameter("accounts")+"</h1>");
String selectedAccForHistory = request.getParameter("accounts");
AccountInfo selectedAcc=null;

for(AccountInfo acc:listOfAccounts){
	if(acc.getAccNumber()== Integer.parseInt(selectedAccForHistory)){
		selectedAcc = acc;
	}
}
ArrayList<TransactionInfo> listOfTxns = txnInfoImpl.fetchTxnHistory(String.valueOf(selectedAccForHistory));
int totalCredit=0, totalDebit=0;

	
writer.println("<h4> Transaction Records For : </h4><br>");

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