package module4.assignment.threadassignment;

public class TableGeneratorThreadFromThread extends Thread{
	
// Write a program to print tables of 5 by creating a new thread and 
// display 20 even numbers as a task of main thread


	
	@Override
 	public void run() {
		for(int i=1;i<=10;i++)
		System.out.println("5 * " + i+ " = " + (5*i));
	}


}
