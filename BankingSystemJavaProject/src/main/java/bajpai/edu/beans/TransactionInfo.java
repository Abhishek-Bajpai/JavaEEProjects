/**
 * 
 */
package bajpai.edu.beans;

/**
 * @author Abhishek Bajpai
 *
 */
/*
	CREATE TABLE bank.transactioninfo 
		(
			txnid number,
			accnumber NUMBER, 
			CONSTRAINT  FK_accnofortxnlog FOREIGN KEY(accnumber) REFERENCES bank.accountinfo(accnumber),
			datetimeofoperation DATE,
			amountinvolved NUMBER,
			typeofoperation varchar2(10)
		);
 */
public class TransactionInfo {

	private long txnID;
	private int accNumber;
	private String dateTimeOfOperation;
	private int amountInvolved;
	private String typeOfOperation;  // DEBIT or CREDIT
	
	
	public TransactionInfo(long txnID, int accNumber, String dateTimeOfOperation, int amountInvolved,
			String typeOfOperation) {
		super();
		this.txnID = txnID;
		this.accNumber = accNumber;
		this.dateTimeOfOperation = dateTimeOfOperation;
		this.amountInvolved = amountInvolved;
		this.typeOfOperation = typeOfOperation;
	}


	public long getTxnID() {
		return txnID;
	}


	public void setTxnID(int txnID) {
		this.txnID = txnID;
	}


	public int getAccNumber() {
		return accNumber;
	}


	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}


	public String getDateTimeOfOperation() {
		return dateTimeOfOperation;
	}


	public void setDateTimeOfOperation(String dateTimeOfOperation) {
		this.dateTimeOfOperation = dateTimeOfOperation;
	}


	public int getAmountInvolved() {
		return amountInvolved;
	}


	public void setAmountInvolved(int amountInvolved) {
		this.amountInvolved = amountInvolved;
	}


	public String getTypeOfOperation() {
		return typeOfOperation;
	}


	public void setTypeOfOperation(String typeOfOperation) {
		this.typeOfOperation = typeOfOperation;
	}





	 


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accNumber;
		result = prime * result + amountInvolved;
		result = prime * result + ((dateTimeOfOperation == null) ? 0 : dateTimeOfOperation.hashCode());
		result = prime * result + (int) (txnID ^ (txnID >>> 32));
		result = prime * result + ((typeOfOperation == null) ? 0 : typeOfOperation.hashCode());
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
		TransactionInfo other = (TransactionInfo) obj;
		if (accNumber != other.accNumber)
			return false;
		if (amountInvolved != other.amountInvolved)
			return false;
		if (dateTimeOfOperation == null) {
			if (other.dateTimeOfOperation != null)
				return false;
		} else if (!dateTimeOfOperation.equals(other.dateTimeOfOperation))
			return false;
		if (txnID != other.txnID)
			return false;
		if (typeOfOperation == null) {
			if (other.typeOfOperation != null)
				return false;
		} else if (!typeOfOperation.equals(other.typeOfOperation))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TransactionInfo [txnID=" + txnID + ", accNumber=" + accNumber + ", dateTimeOfOperation="
				+ dateTimeOfOperation + ", amountInvolved=" + amountInvolved + ", typeOfOperation=" + typeOfOperation
				+ "]";
	}
	
	
	
}
