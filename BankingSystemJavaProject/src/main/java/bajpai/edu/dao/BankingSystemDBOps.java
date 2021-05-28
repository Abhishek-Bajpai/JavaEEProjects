/**
 * 
 */
package bajpai.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import bajpai.edu.beans.AccountInfo;
import bajpai.edu.beans.CustomerInfo;
import bajpai.edu.beans.TransactionInfo;

/**
 * @author Abhishek Bajpai
 *
 */
public abstract class BankingSystemDBOps {

	
	static	final String connectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
	static	final String dbUser = "bank";
	static	final String dbUserPwdString = "secret";
	
	String inputString = null;
	
	private Connection connection=null;

//	Adding getConnection so it can be closed by the calling program once DB processing is done
	public Connection getConnection() {
	 	if(connection == null) {
	 		try {
				connection = DriverManager.getConnection(connectionURL, dbUser, dbUserPwdString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}
		return connection;
	}
	
	abstract void registerUser(CustomerInfo customer);
	abstract boolean createAccount(AccountInfo accountInfo);
	
	abstract CustomerInfo loginToCustomerAccount(String emailID, String pwd);
	abstract ArrayList<AccountInfo> fetchCustomerAccounts(String emailID);

	abstract ArrayList<TransactionInfo> fetchTxnHistory(String accNum);
	abstract int debitMoney(AccountInfo account, int howMuchMoney);
	abstract int creditMoney(AccountInfo account, int howMuchMoney);

	abstract void registerCustomer(CustomerInfo customerInfo, String accType, String password);
}
