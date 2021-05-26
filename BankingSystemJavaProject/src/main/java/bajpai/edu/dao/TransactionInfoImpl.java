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
public class TransactionInfoImpl extends BankingSystemDBOps {

	public long createTxnRecord(int accNumber, String accType, String typeOfOperation, int amount, int currAccBalance){
		Connection connection = BankingSystemDBOps.getConnection();
		Statement statement;
		long txnID= System.currentTimeMillis();
		try {
			connection.setAutoCommit(false);
			statement = connection.createStatement();
 //Insert Transaction Record
 			Date date = new Date(); 
 			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
 			System.out.println(formatter.format(date));
 			
 			System.out.println("Generated txnId No is - " + txnID);
 			//TransactionInfo transactionInfo = new TransactionInfo(txnID, generatedAccNum, customerSqlStmt, accNumber, accountSqlStmt);
 			String txnSqlStmt = "insert into transactioninfo values(" + txnID +", "+ accNumber + ", TO_DATE('" + formatter.format(date) + "','DD-MM-YYYY HH24:MI:SS'),"+amount  + ",'"+ typeOfOperation +"')";
 			System.out.println("\t" + txnSqlStmt);
 			
 			
 			
 			
 			statement.addBatch(txnSqlStmt);
 			
 			int newBalance = 0;
 			if(typeOfOperation.equalsIgnoreCase("debit")) {
 				if(amount < currAccBalance) {
 					newBalance=currAccBalance-amount;
 				}else {
 					System.out.println("Insufficient Balance... Pls try lower amount");
 					throw new Exception("InsufficientBalance");
 				}
 			}
 			if(typeOfOperation.equalsIgnoreCase("credit")) {
 				if(null!=accType && ("loan".equalsIgnoreCase(accType) || "credit".equalsIgnoreCase(accType))) {
 					newBalance=currAccBalance-amount;
 				}else { 					
 				newBalance=currAccBalance+amount;
 				}
 			}
 			
 			
 			String updateAccStmtString = "UPDATE ACCOUNTINFO set CURRENTBAL="+ newBalance +" where accnumber="+accNumber;
 			System.out.println(updateAccStmtString);
 			
 			statement.addBatch(updateAccStmtString);
 			
 			System.out.println("Updating account balance");
 			
 			statement.executeBatch();
 			System.out.println("Txn record created and Account updated with usable balance..!");
 			
 			connection.commit();
 			System.out.println("Record Inserted ... Confirmation ID is - " + txnID);
			return txnID;	

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
		
	}
 

	@Override
	public void createAccount(AccountInfo accountInfo) {
		// TODO Auto-generated method stub
		
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
	void registerUser(CustomerInfo customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void registerCustomer(CustomerInfo customerInfo, String accType, String password) {
		// TODO Auto-generated method stub
		
	}


	@Override
	CustomerInfo loginToCustomerAccount(String emailID, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountInfo> fetchCustomerAccounts(String emailID) {
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
				listOfUserAccounts.add(accountInfo);
				System.out.println("Retrieved from database - "  + accountInfo);
				System.out.println("----------------------------------------------------------------------------------");
			}
			
			System.out.println("ALERT ALERT ALERT ... No of accounts found = " + listOfUserAccounts.size());
		} catch (SQLException e) {
		e.printStackTrace();
	}
		return listOfUserAccounts;			
	}

}
