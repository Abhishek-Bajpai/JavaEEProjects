/**
 * 
 */
package bajpai.edu.beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Abhishek Bajpai
 *
 */
/*
	 CREATE TABLE bank.accountinfo 
		(
			accnumber NUMBER PRIMARY KEY ,
			acctype varchar2(20), 
			emailid varchar2(25),CONSTRAINT  FK_customerEmailLogin FOREIGN KEY(emailid) REFERENCES  bank.customerinfo(emailid),
			currentbal NUMBER
		);
 */
public class AccountInfo implements Serializable{

	private int accNumber;
	private String accType;
	private String emailID;
	private String currAccBalance;
	
	ArrayList<TransactionInfo> listOfTransactionsForThisAccount;
	
	
	public ArrayList<TransactionInfo> getListOfTransactionsForThisAccount() {
		return listOfTransactionsForThisAccount;
	}

	public void setListOfTransactionsForThisAccount(ArrayList<TransactionInfo> listOfTransactionsForThisAccount) {
		this.listOfTransactionsForThisAccount = listOfTransactionsForThisAccount;
	}

	public AccountInfo(int accNumber, String accType, String emailID, String curreBal) {
		this.accNumber = accNumber;
		this.accType = accType;
		this.emailID = emailID;
		this.currAccBalance = curreBal;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getCurrAccBalance() {
		return currAccBalance;
	}

	public void setCurrAccBal(String curreBal) {
		this.currAccBalance = curreBal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accNumber;
		result = prime * result + ((accType == null) ? 0 : accType.hashCode());
		result = prime * result + ((currAccBalance == null) ? 0 : currAccBalance.hashCode());
		result = prime * result + ((emailID == null) ? 0 : emailID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountInfo other = (AccountInfo) obj;
		if (accNumber != other.accNumber)
			return false;
		if (accType == null) {
			if (other.accType != null)
				return false;
		} else if (!accType.equals(other.accType))
			return false;
		if (currAccBalance == null) {
			if (other.currAccBalance != null)
				return false;
		} else if (!currAccBalance.equals(other.currAccBalance))
			return false;
		if (emailID == null) {
			if (other.emailID != null)
				return false;
		} else if (!emailID.equals(other.emailID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountInfo [accNumber=" + accNumber + ", accType=" + accType + ", emailID=" + emailID + ", curreBal="
				+ currAccBalance + "]";
	}
	
	
	
	
	
}
