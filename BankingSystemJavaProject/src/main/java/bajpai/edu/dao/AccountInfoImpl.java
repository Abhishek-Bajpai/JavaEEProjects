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

/**
 * @author Abhishek Bajpai
 *
 */
public class AccountInfoImpl extends BankingSystemDBOps {

 	@Override
	public boolean createAccount(AccountInfo account) {
		ConnectionFactory connectionFactory=new ConnectionFactory();	
		Connection connection = connectionFactory.getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			connection.setAutoCommit(false); 

//Insert account record 			
 			int generatedAccNum = AccountNumberGenerator.nextAccountNumber();
 			System.out.println("Generated Account Number is - " + generatedAccNum);
 			//AccountInfo account=new AccountInfo(generatedAccNum, accountInfo.getAccType(), accountInfo.getEmailID(), accountInfo.getCurrAccBalance());
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


 			statement.addBatch(accountSqlStmt);
 			statement.addBatch(txnSqlStmt);
 			
 			statement.executeBatch();
 			//statement.executeUpdate(customerSqlStmt);
			System.out.println("Records Inserted for " + account.getEmailID() + "...!!! ");
			
			connection.commit();
			return true;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;		
	}

	@Override
	public ArrayList<TransactionInfo> fetchTxnHistory(String accNum) {
		return null;
		// TODO Auto-generated method stub
		
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
