package module3.assignment;

public abstract class Account {
//Account number, name and amount
	
	long accNumber;
	String accName;
	double amount;
	
	
	public abstract void depositMonthlyInterest();
	public void deposit(double amount) {
		this.amount = this.amount+ amount;
	}
	public void withdraw(double amount) {
		if(this.amount > amount)
			this.amount = this.amount - amount;
		else {
			System.out.println("Insufficient Funds ! ! ");
		}
	}
	
	
}
