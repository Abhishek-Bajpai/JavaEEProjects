package module4.assignment.interfaceassignment;

import java.util.Scanner;

public class OperatorClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Enter 3 numbers to insert into the queue..");
		int x = scanner.nextInt();
		MyQueueClass myQueueClass = new MyQueueClass();
		myQueueClass.insert (x);
		
		x = scanner.nextInt();
		myQueueClass.insert (x);
		
		x = scanner.nextInt();
		myQueueClass.insert (x);

		System.out.println("Queue contains : ");
		myQueueClass.display();
		
		System.out.println("Deleting 1 element from the queue..");
		int y = myQueueClass.delete();
		System.out.println("Deleted element is "+y);
		
		System.out.println("Queue Contains..");
		myQueueClass.display();
		
		scanner.close();
		}
	
	

}
