/**
 * 
 */
package bajpai.edu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bajpai.edu.beans.AccountInfo;
import bajpai.edu.beans.CustomerInfo;
import bajpai.edu.beans.TransactionInfo;

/**
 * @author Abhishek Bajpai
 *
 */
public class AccountInfoImpl extends BankingSystemDBOps {

 	@Override
	public void createAccount(AccountInfo accountInfo) {
		// TODO Auto-generated method stub
		
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
