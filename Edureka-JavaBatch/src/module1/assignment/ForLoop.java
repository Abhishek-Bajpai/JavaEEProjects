package module1.assignment;

import java.util.Scanner;

public class ForLoop {
	public static void main(String[] args) {
		//Write a program to print 10 even numbers and 10 odd numbers.

		for(byte b=1, evenCounter=1, oddCounter=1;b<=20;b++) {
			if(b%2==0) {
				System.out.println( "\t\t"+ evenCounter + " EVEN Number - " + b);
				evenCounter++;
			}else {
				System.out.println("\t"+ oddCounter + " ODD Number - " + b);
				oddCounter++;
			}
		}
		
		//Write a program to find factorial of a number.
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Enter a number and find its factorials - ");
		int x = inputScanner.nextInt();
		int factorial = 1;
		for(int i=1; i<=x; i++) {
			factorial = factorial*i;
		}
		
		System.out.println("Factorial of " + x + " is - " + factorial);
		
		//Write a program to generate tables of 10.
		byte tableOfTen = 10;
		
		for(byte b=1; b<=10; b++) {
			System.out.println(tableOfTen + "*" + b + " = " + (tableOfTen*b));
		}
		
		//Write a program to add the digits of a number
		System.out.println("Pls enter a number here - ");
		int num=inputScanner.nextInt();
		int storedNum = num;
		
		int sum=0;
		for(;num !=0;) {
			sum = sum+ num%10;
			num=num/10;
		}
		System.out.println("Sum of all the digits in the number entered is - " + sum);
		
		//Write a program to reverse the digits of a number
		for(;storedNum!=0;) {
			System.out.print(storedNum%10);
			storedNum=storedNum/10;
		}

		
		//Write a program to generate 10 Fibonacci numbers.
		int n1=0, n2=1;
		
		for(int i=1; i<=10; ++i) {
			System.out.print( n1+ " ");
			int sumOfPreviousTwoNos = n1+n2;
			n1=n2;
			n2=sumOfPreviousTwoNos;
		}
	}

	
	
}
	
	

