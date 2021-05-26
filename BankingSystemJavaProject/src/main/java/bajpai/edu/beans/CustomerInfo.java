/**
 * 
 */
package bajpai.edu.beans;

import java.util.ArrayList;

/**
 * @author Abhishek Bajpai
 *
 */

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
public class CustomerInfo {

	private String fullName;
	private String dateOfBirth;
	private String emailId;
	private String address;
	private String password;
	
	private ArrayList<AccountInfo> arrayListOfAccountsForThisCustomer;
	
	
	public ArrayList<AccountInfo> getArrayListOfAccountsForThisCustomer() {
		return arrayListOfAccountsForThisCustomer;
	}

	public void setArrayListOfAccountsForThisCustomer(ArrayList<AccountInfo> arrayListOfAccountsForThisCustomer) {
		this.arrayListOfAccountsForThisCustomer = arrayListOfAccountsForThisCustomer;
	}

	public CustomerInfo(String fullName, String dateOfBirth, String emailId, String address) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		CustomerInfo other = (CustomerInfo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerInfo [fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId
				+ ", address=" + address +"]";
	}
	
	
	
	
	
	
}
