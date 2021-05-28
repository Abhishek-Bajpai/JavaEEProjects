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

import bajpai.edu.beans.AccountInfo;
import bajpai.edu.beans.CustomerInfo;
import bajpai.edu.beans.TransactionInfo;

/**
 * @author Abhishek Bajpai
 *
 */
public class TransactionInfoImpl extends BankingSystemDBOps {

	public long createTxnRecord(int accNumber, String accType, String typeOfOperation, int amount, int currAccBalance){
		ConnectionFactory connectionFactory=new ConnectionFactory();	
		Connection connection = connectionFactory.getConnection();
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
 			
//ToDo here
 			int newBalance = getCurrentAccBalance(amount, currAccBalance, typeOfOperation, accType);
 			
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
		}finally {
			try {
				//useless code below.. to avoid removing catch
				connection.getAutoCommit();
				//connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
		
	}
 
	public static int getCurrentAccBalance(int txnAmount, int currentBalance, String txnType, String accType) throws Exception{
			int newBalance = 0;
			
			switch (txnType) {
				case "credit":  
					//credit to checkin and savings account results in amount added to it
					if(accType.equalsIgnoreCase("checkin") || accType.equalsIgnoreCase("savings")) 
					{	
						newBalance = currentBalance + txnAmount;
						return newBalance;
						
					}else if(accType.equalsIgnoreCase("credit") || accType.equalsIgnoreCase("loan")) //credit to creditcard and loan accounts result in amount reduced from the balance
					{
						newBalance = currentBalance - txnAmount;
						return newBalance;
					}
					break;
				case "debit": 
					//debit from checkin and savings account results in amount taken out of it
					if(accType.equalsIgnoreCase("checkin") || accType.equalsIgnoreCase("savings")) {
						if(txnAmount < currentBalance) {
							newBalance = currentBalance - txnAmount;
							return newBalance;
							
						}else {
							System.out.println("Insufficient balance exception here... You could try lower amount");
							return currentBalance;
						}
					}else if(accType.equalsIgnoreCase("credit") || accType.equalsIgnoreCase("loan")) {
							System.out.println("These Accounts NOT elligible for withdrawls.. you could be charged 24.99% interest on withdrawls from these accounts..!! ");	
							return currentBalance;
					}
					break;
				default:
					System.out.println("Unhandled condition.. !! ");
					break;
			}			
			
			return newBalance;
	}

	@Override
	public boolean createAccount(AccountInfo accountInfo) {
		return false;
		// TODO Auto-generated method stub
		
	}

	public TransactionInfo fetchTxnHistory(long txnID) {
		ConnectionFactory connectionFactory=new ConnectionFactory();	
		Connection connection = connectionFactory.getConnection();
		Statement statement;
		TransactionInfo txnInfo=null;

		try {
			statement = connection.createStatement();

			String txnSqlStmt = "select * from transactioninfo where TXNID="+txnID;
 			System.out.println("\t" + txnSqlStmt);
 			ResultSet resultSet = statement.executeQuery(txnSqlStmt);

 			if(resultSet.next()) {
 				long txnId = resultSet.getLong("TXNID");
 				int accNo = resultSet.getInt("ACCNUMBER");
 				String dtTmOps = resultSet.getString("DATETIMEOFOPERATION");
 				int amount = resultSet.getInt("AMOUNTINVOLVED");
 				String typeOfOp = resultSet.getString("TYPEOFOPERATION");
 				txnInfo=new TransactionInfo(txnId,accNo,dtTmOps,amount,typeOfOp);
  			}

 			
 		} catch (SQLException e) {
			e.printStackTrace();
		}
			return txnInfo;		
	}
	
//Txn records between provided dates	
	public ArrayList<TransactionInfo> fetchTxnHistory(String accNum, String fromDate, String toDate) {
		ConnectionFactory connectionFactory=new ConnectionFactory();	
		Connection connection = connectionFactory.getConnection();
		Statement statement;
		ArrayList<TransactionInfo> listOfTxns = new ArrayList<>();
		
		try {
			statement = connection.createStatement();
//Insert Transaction Record
			
//			select * from transactioninfo where accnumber=1501508599 and trunc(DATETIMEOFOPERATION) between to_date('2021-05-25', 'yyyy-mm-dd') and to_date('2021-05-26', 'yyyy-mm-dd') ;
			String txnSqlStmt = "";
			
			if(fromDate.isEmpty() || toDate.isEmpty()) {
				System.out.println("Date range not provided completely.. fetching all txns for this accNo");
				 txnSqlStmt = "select * from transactioninfo where accnumber="+accNum;
			}else {
 			     txnSqlStmt = "select * from transactioninfo where accnumber="+accNum + " and trunc(DATETIMEOFOPERATION) between TO_DATE('"+ fromDate +"' , " + "'yyyy-mm-dd') and TO_DATE('" + toDate +"' , " + "'yyyy-mm-dd')";
			}
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
	public ArrayList<TransactionInfo> fetchTxnHistory(String accNum) {
		ConnectionFactory connectionFactory=new ConnectionFactory();	
		Connection connection = connectionFactory.getConnection();
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
		ConnectionFactory connectionFactory=new ConnectionFactory();	
		Connection connection = connectionFactory.getConnection();
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
