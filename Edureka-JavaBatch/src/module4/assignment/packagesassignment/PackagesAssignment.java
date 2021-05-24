package module4.assignment.packagesassignment;

public class PackagesAssignment {
/**
 Write a program to define 
 functions for subtract, multiply, divide, 
 factorial and reversing the digits of a number in a package, 
 import this class in another package and 
 use all the methods defined in the primary package
*/

	public int substract(int a, int b) {
		return (a-b);
	}
	
	public int multiply(int a, int b) {
		return (a*b);
	}
	
	public int divide(int a, int b) {
		return (a/b);
	}
	
	public int factorial(int a) {
		int factorialNo=1;
		for(int i=1; i<=a; i++) {
			factorialNo = factorialNo*i;
		}
		return factorialNo;
 	}	
	
	public String reverseDigits(int a) {
		String reversedNumString = "";
		for(;a!=0;) {
			//System.out.print(a%10);
			reversedNumString = reversedNumString + a%10;
			a=a/10;
		}
		return reversedNumString;	
	}
}
