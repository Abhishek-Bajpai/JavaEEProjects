package module4.assignment.exceptionassignment;

//Write a program to demonstrate ArrayIndexOutOfBoundsException.

public class ArrayIndexOutOfBoundsExceptionDemo {

	public static void main(String[] args) {

		int x[]= {1,2,3,4,5};
		
		for(int i=0; i<=5; i++) {
			System.out.println("Value of x[i] : " + x[i]);
		}
	}

}
