package module1.assignment;

import java.util.Scanner;


public class DoWhile {

	public static void main(String[] args) {

		/**
		 do while..loop
			 Write a program to print 10 even numbers and 10 odd numbers.
			 Write a program to find factorial of a number.
			 Write a program to generate tables of 10.
			 Write a program to add the digits of a number.
			 Write a program to reverse the digits of a number.
			 Write a program to generate 10 Fibonacci numbers.
		 */
	//			 Write a program to print 10 even numbers and 10 odd numbers.
		
		int i=1;
		do {
			if(i%2==0) {
				System.out.println("Even no - " + i);
			}else {
			    System.out.println("Odd no - " + i);
			}
			i++;
		}while(i<=20);
		
	
	
	//			 Write a program to find factorial of a number.

	Scanner scanner=new Scanner(System.in);
	System.out.println("Pls enter a no to find out its factorial - ");
	int input= scanner.nextInt();
	int factorial = 1, x=1;

	do {
		factorial = factorial*x;
		x++;
	}while(x <= input);
	System.out.println("Factorial of the given number is - " + factorial);
	
	//			 Write a program to generate tables of 10.
	i=1;
	do {
		System.out.println("10 * "+ i +" = " + 10*i);
		i++;
	}while(i<=10);
	
	//	 Write a program to add the digits of a number.

	System.out.println("Enter a number - ");
	int num=scanner.nextInt();
    int sum=0;
	
	do{
		sum = sum+ num%10;
		num=num/10;			
	}while(num!=0);
	System.out.println("Sum of all the digits in the given number is - " + sum);
	
	//			 Write a program to reverse the digits of a number.
	System.out.println("Pls enter a number here - ");
	int numToReverse=scanner.nextInt();
	//int storedNum = numToReverse;

	//Write a program to reverse the digits of a number
	do {
		System.out.print(numToReverse%10);
		numToReverse=numToReverse/10;			
	}while(numToReverse!=0);
	
//	 Write a program to generate 10 Fibonacci numbers.
	int n1=0, n2=1, i1=1;
	do {
		System.out.print( n1+ " ");
		int sumOfPreviousTwoNos = n1+n2;
		n1=n2;
		n2=sumOfPreviousTwoNos;	
		i1++;
	}while(i1<=10);

}

}



