/**
 * 
 */
package bajpai.edu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import bajpai.edu.beans.AccountInfo;
import bajpai.edu.beans.CustomerInfo;
import bajpai.edu.beans.TransactionInfo;
import bajpai.edu.crypto.HashSaltingPassword;

/**
 * @author Abhishek Bajpai
 *
 */
public class CustomerInfoImpl extends BankingSystemDBOps {

/*
		CREATE TABLE bank.customerinfo 
		(
		fullname varchar2(60),
		dateofbirth DATE, 
		emailid varchar2(25) PRIMARY key,
		address varchar2(150), 
		password varchar2(90)
		);

 */
		@Override
	public void registerCustomer(CustomerInfo customer, String accType, String password) {

		Connection connection = BankingSystemDBOps.getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			connection.setAutoCommit(false); 
 		//insert into customerinfo values('Shiva Shambu, TO_DATE('1111-11-11','YYYY-MM-DD')','shiva@shambhu.god',1 Kailasha Marg, Mt Kailash',170BACABB894654023B80BA4FCD0200E50C5CAA403C4659AC8528182170EAB6A)
//Insert customer record			
			String customerSqlStmt = "insert into customerinfo values(" + "'"+customer.getFullName() + "', TO_DATE('"+ customer.getDateOfBirth() +"','YYYY-MM-DD'),'" 
					+ customer.getEmailId() + "','" + customer.getAddress() + "','" + HashSaltingPassword.hashPassword(password)+ "')";

 			System.out.println("\t" + customerSqlStmt);
 			
			/*
			 * AtomicInteger seq = new AtomicInteger(); int accNumber =
			 * seq.incrementAndGet(); System.out.println("Generated Acc No is - " +
			 * accNumber);
			 */
 			
//Insert account record 			
 			int generatedAccNum = AccountNumberGenerator.nextAccountNumber();
 			System.out.println("Generated Account Number is - " + generatedAccNum);
 			AccountInfo account=new AccountInfo(generatedAccNum, accType, customer.getEmailId(), "100");
 			String accountSqlStmt = "insert into accountinfo values(" + generatedAccNum +", '"+ account.getAccType() + "','"+account.getEmailID() +"','"+account.getCurrAccBalance() + "')";
 			System.out.println("\t" + accountSqlStmt);

//Insert Transaction Record
 			AtomicInteger seqTxn = new AtomicInteger();
 			long txnID= System.currentTimeMillis();
 			
 			Date date = new Date(); 
 			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
 			System.out.println(formatter.format(date));
 			
 			System.out.println("Generated txnId No is - " + txnID);
 			//TransactionInfo transactionInfo = new TransactionInfo(txnID, generatedAccNum, customerSqlStmt, accNumber, accountSqlStmt);
 			String txnSqlStmt = "insert into transactioninfo values(" + txnID +", "+ generatedAccNum + ", TO_DATE('" + formatter.format(date) + "','DD-MM-YYYY HH24:MI:SS'),"+account.getCurrAccBalance() + ",'"+ "credit" +"')";
 			System.out.println("\t" + txnSqlStmt);
 			
 			
 			statement.addBatch(customerSqlStmt);
 			statement.addBatch(accountSqlStmt);
 			statement.addBatch(txnSqlStmt);
 			
 			statement.executeBatch();
 			//statement.executeUpdate(customerSqlStmt);
			System.out.println("Record Inserted for " + customer + "...!!! ");
			
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
		

	@Override
	public ArrayList<TransactionInfo> fetchTxnHistory(String accNum) {
		Connection connection = BankingSystemDBOps.getConnection();
		Statement statement;
		ArrayList<TransactionInfo> listOfTxns = new ArrayList<>();
		
		try {
			statement = connection.createStatement();
//Insert Transaction Record
 			String txnSqlStmt = "select * from transactioninfo where accnumber="+accNum;
 			System.out.println("\t" + txnSqlStmt);
 			ResultSet resultSet = statement.executeQuery(txnSqlStmt); 

//fetch account data 			
 			//statement.executeUpdate(customerSqlStmt);
 			
 			TransactionInfo txnInfo=null;
 			while(resultSet.next()) {
 				long txnId = resultSet.getLong("TXNID");
 				int accNo = resultSet.getInt("ACCNUMBER");
 				String dtTmOps = resultSet.getString("DATETIMEOFOPERATION");
 				int amount = resultSet.getInt("AMOUNTINVOLVED");
 				String typeOfOp = resultSet.getString("TYPEOFOPERATION");


 				txnInfo=new TransactionInfo(txnId,accNo,dtTmOps,amount,typeOfOp);
 				listOfTxns.add(txnInfo);
 			}
 			System.out.println("All Txns Retrieved from database for accountNumber - "  + accNum);
			System.out.println("----------------------------------------------------------------------------------");
 			
 			System.out.println("No of Txns found = " + listOfTxns.size());
 		} catch (SQLException e) {
			e.printStackTrace();
		}
			return listOfTxns;				
	
				
		
	}

	@Override
	public int debitMoney(AccountInfo account, int howMuchMoney) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int creditMoney(AccountInfo account, int howMuchMoney) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void createAccount(AccountInfo accountInfo) {
		// TODO Auto-generated method stub
		
	}



	@Override
	void registerUser(CustomerInfo customer) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public CustomerInfo loginToCustomerAccount(String emailID, String pwd) {
		Connection connection = BankingSystemDBOps.getConnection();
		Statement statement;
		
		CustomerInfo customerInfo=null;
		
		try {
			statement = connection.createStatement();

			String customerSqlStmt = "select * from customerinfo where emailid='"+emailID+"' and password='"+ HashSaltingPassword.hashPassword(pwd)+ "'";
 			System.out.println("\t" + customerSqlStmt);
 			
 			ResultSet resultSet = statement.executeQuery(customerSqlStmt);
 			
 			if(resultSet.next()) {
 				String fullName = resultSet.getString("FULLNAME");
 				String dOB= resultSet.getString("DATEOFBIRTH");
 				String email = resultSet.getString("EMAILID");
 				String address = resultSet.getString("ADDRESS");
 				customerInfo=new CustomerInfo(fullName, dOB, email, address);
 				
  				System.out.println("Retrieved from database - \n\t"  + customerInfo);
 				System.out.println("----------------------------------------------------------------------------------");
 				ArrayList<AccountInfo>listOfCustomerAccounts =  fetchCustomerAccounts(email);
 				if(null!=listOfCustomerAccounts && listOfCustomerAccounts.size()>0) {
 					customerInfo.setArrayListOfAccountsForThisCustomer(listOfCustomerAccounts);
 				}
 			}else {
 				System.out.println("Record NOT Found  ...!!!");	
 			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerInfo;
	}



	@Override
	ArrayList<AccountInfo> fetchCustomerAccounts(String emailID) {
		Connection connection = BankingSystemDBOps.getConnection();
		ArrayList<AccountInfo> listOfUserAccounts = new ArrayList<>();

		
	Statement statement;
	try {
		statement = connection.createStatement();

		String fetchAccSqlStmt = "select * from accountinfo where emailid = '" + emailID + "'" ;

			System.out.println("\t" + fetchAccSqlStmt);
			ResultSet resultSet = statement.executeQuery(fetchAccSqlStmt);

//fetch account data 			
			//statement.executeUpdate(customerSqlStmt);
			
			AccountInfo accountInfo=null;
			while(resultSet.next()) {
				int accNum = resultSet.getInt("ACCNUMBER");
				String accType = resultSet.getString("ACCTYPE");
				String currBal = resultSet.getString("CURRENTBAL");
				String email = resultSet.getString("EMAILID");


				accountInfo=new AccountInfo(accNum, accType, email, currBal);
				System.out.println("Retrieved from database - "  + accountInfo);
				System.out.println("----------------------------------------------------------------------------------");
				
				ArrayList<TransactionInfo> listOfTxnsForThisAcc = fetchTxnHistory(String.valueOf(accNum));
				if(null!=listOfTxnsForThisAcc && listOfTxnsForThisAcc.size() > 0) {
					accountInfo.setListOfTransactionsForThisAccount(listOfTxnsForThisAcc);
				}
				listOfUserAccounts.add(accountInfo);
			}
			
			System.out.println("ALERT ALERT ALERT ... No of accounts found = " + listOfUserAccounts.size());
		} catch (SQLException e) {
		e.printStackTrace();
	}
		return listOfUserAccounts;			
			
	
	}

}
