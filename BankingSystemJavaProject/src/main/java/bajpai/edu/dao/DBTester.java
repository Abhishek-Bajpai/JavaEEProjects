/**
 * 
 */
package bajpai.edu.dao;

import java.util.ArrayList;

import bajpai.edu.beans.AccountInfo;
import bajpai.edu.beans.TransactionInfo;

/**
 * @author Abhishek Bajpai
 *
 */
public class DBTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		CustomerInfo customer = new CustomerInfo("Shiva Shambu", "1111-11-11", "shiva@shambhu.god", "1 Kailasha Marg, Mt Kailash", "BamBamBhole");
		CustomerInfoImpl customerInfoImpl = new CustomerInfoImpl();
		customerInfoImpl.registerCustomer(customer, null);
		*/

		/*
		AccountInfoImpl accountInfoImpl = new AccountInfoImpl();
		ArrayList<AccountInfo> listOfAccountsAccountInfos =  accountInfoImpl.fetchCustomerAccounts("shiva@shambhu.god");
		for(AccountInfo acc:listOfAccountsAccountInfos) {
			System.out.println(acc);
		}
	   */
		//1501508599
	
		//TransactionInfoImpl.createTxnRecord(1601705599, "", "credit", 124000, 7524000);
		
		TransactionInfoImpl txnInfoImpl = new TransactionInfoImpl();
		ArrayList<TransactionInfo> listOfTxns = txnInfoImpl.fetchTxnHistory("1601705599");
		
		for(TransactionInfo txnInfo: listOfTxns) {
			System.out.println(txnInfo);
		}
		
		
		
	}

}
