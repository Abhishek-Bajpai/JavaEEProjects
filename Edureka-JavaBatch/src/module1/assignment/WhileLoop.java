package module1.assignment;

import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.StackConsumer;

public class WhileLoop {

	public static void main(String[] args) {

		/**
		 while..loop
			 Write a program to print 10 even numbers and 10 odd numbers.
			 Write a programto find factorial of a number.
			 Write a program to generate tables of 10.
			 Write a programto add the digits of a number.
			 Write a program to reverse the digits of a number.
			 Write a program to generate 10 Fibonacci numbers.
		 */

		//			 Write a program to print 10 even numbers and 10 odd numbers.
		System.out.println("\n\n<<<<<<<< Odd Even Program using while loop >>>>>>>> ");
		int x=1;
		while(x<=20) {
			if(x%2 == 0)
				System.out.println("Even Number - " + x);
			else {
				System.out.println("\tOdd Number - " + x);
			}
		x++;
		}
		
		//			 Write a programto find factorial of a number.
		System.out.println("\n\n<<<<<<<< Factorial Program using While loop >>>>>>>>>>");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Pls input a number here and find out its factorial - ");
		int num= scanner.nextInt();
		int factorial=1;
		while(num>=1) {
			factorial = factorial * num;
			num--;
		}
		System.out.println(factorial);
		
		//			 Write a program to generate tables of 10.
		System.out.println("\n\n<<<<<<<< Table of 10 uaing while loop >>>>>>>>>");
		int i=1;
		while(i <= 10) {
			System.out.println("10 * " + i+ " = " + 10 * i);
			i++;
		}
		
		//			 Write a program to add the digits of a number.
		System.out.println("\n\n<<<<<<<<< Add digits of a number >>>>>>>>>>>> ");
		System.out.println("Pls enter a number - ");
		num = scanner.nextInt();
		int sum=0;
		
		while (num!=0) {
 			 sum =sum+ num%10;
 			 num=num/10;
		}
		System.out.println("Sum of all the digits of given number is : " + sum);
		
		//			 Write a program to reverse the digits of a number.
		System.out.println("Pls enter another number here - " );
		int noToReverseDigits = scanner.nextInt();
		
		while(noToReverseDigits !=0) {
			System.out.print(noToReverseDigits%10);
			noToReverseDigits = noToReverseDigits/10;	
		}
		
		//			 Write a program to generate 10 Fibonacci numbers.
		int i1=1, n1=0, n2=1;
		
		while(i1<=10) {
			System.out.print( n1+ " ");
			int sumOfPreviousTwoNos = n1+n2;
			n1=n2;
			n2=sumOfPreviousTwoNos;
			++i1;
		}
	}

}
