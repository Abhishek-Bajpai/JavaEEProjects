package module3.assignment;

import java.util.Scanner;

public class OperateAccount {

	public static void main(String[] args) {
		final double SB_ACC_MIN_OPENING_BALANCE = 5000.00;
		final double CURR_ACC_MIN_OPENING_BALANCE = 500.00;
				
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Which kind of Acc you would like to open:\n1. SB Account(Monthly Interest Deposited.. Minimum opening deposit $5000)\n2. Curent Account (Minimum opening deposit $500)\n\nEnter your choice : ");
		byte accType = scanner.nextByte();
		Account account = null;
		
		switch(accType) {
			case 1:
				System.out.println("Pls enter your name here (One Word only: ");
				String sbAccName = scanner.next();			
				System.out.println("How much money you would like to deposit today : " );
				double sbDepositAmount = scanner.nextDouble();
				if(sbDepositAmount < SB_ACC_MIN_OPENING_BALANCE) {
					System.out.println("Initial Deposit limit for this account NOT met .. Pls come back with required money. Good bye !! ");
					System.exit(0);
				}
				
				account = new SBAccount((long) Math.random(), sbAccName, sbDepositAmount);
				System.out.println(account.accNumber + " " + account.accName +" " + account.amount );
				System.out.println("Time for monthly interest deposit!! Depositing ......");
				account.depositMonthlyInterest();
				System.out.println("Checking your balance now ... ");
				System.out.println(account.accNumber + " " + account.accName +" " + account.amount );
				break;
			case 2:
				System.out.println("Pls enter your name here (One Word only: ");
				String currAccName = scanner.next();			
				System.out.println("How much money you would like to deposit today : " );
				double currDepositAmount = scanner.nextDouble();
				if(currDepositAmount < CURR_ACC_MIN_OPENING_BALANCE) {
					System.out.println("Initial Deposit limit for this account NOT met .. Pls come back with required money. Good bye !! ");
					System.exit(0);
				}
				account = new CurrentAccount((long) Math.random(), currAccName, currDepositAmount);
				System.out.println(account.accName+ " " + account.accName +" " + account.amount );
			default:
			
		}
		
		System.out.println("What would you like to do now :  \n1. Deposit More $$$ \n2. Withdraw $$$ \n3. Exit");
		byte chooseOp = scanner.nextByte();
		switch (chooseOp) {
		case 1:
			System.out.println("How much money you would like to deposit today : " );
			double depositAmount = scanner.nextDouble();
			account.deposit(depositAmount);
			System.out.println("Here is your updated acc information.. ");
 			System.out.println(account.accNumber+ " " + account.accName +" " + account.amount );			
			break;
		case 2:
			System.out.println("How much money you would like to WITHDRAW : " );
			double withdrawAmount = scanner.nextDouble();
			account.withdraw(withdrawAmount);
			System.out.println("Here is your updated acc information.. ");
 			System.out.println(account.accNumber+ " " + account.accName +" " + account.amount );			
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Here is your updated acc information.. ");
 			System.out.println(account.accName+ " " + account.accName +" " + account.amount );
		}
				
					
	}

}
