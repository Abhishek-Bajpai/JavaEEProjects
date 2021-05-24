package module3.assignment;

final class SBAccount extends Account{

	public SBAccount(long accNo, String accName, double amount) {
		// TODO Auto-generated constructor stub
		super.accNumber = accNo;
		super.accName = accName;
		super.amount = amount;
		
	}

	@Override
	public String toString() {
		return "SBAccount []";
	}

	// SB account is 4% interest to be paid per month
	@Override
	public void depositMonthlyInterest() {
		super.amount = super.amount +  (super.amount * 4)/100;
		
	}
	
}
