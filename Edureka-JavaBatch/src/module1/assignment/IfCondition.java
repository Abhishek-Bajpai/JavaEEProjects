package module1.assignment;

import java.util.Scanner;

public class IfCondition {

	public static void main(String[] args) {
 
		//Check Age
		Scanner scanner = new Scanner(System.in);
		System.out.print("Pls enter your age : ");
		byte age= (byte) scanner.nextInt();
		if(age < 18) {
			System.out.println(" You Area NOT elligible to vote yet !! Pls visit in another "  + (18 - age) + " yrs");
			
		}else {
			System.out.println("Congratulations!! You became elligible " + (age -18) + " yrs ago");
		}
		
		// Write a program to check if the number is positive or negative.
		// Extend the previous program to check whether the given number is positive, zero or negative.(Hint: use if-else conditions)
		System.out.print("Pls enter any number here -> ");
		int i = scanner.nextInt();
		if( i>0 ) {
			System.out.println("You entered a +ve number, stay POSITIVE :) ");
		}else if(i<0) {
			System.out.println("You entered a -ve numver, pls TRY to be POSITIVE");
		}else {
			System.out.println("Your input was either not intelligible or ZERO");
		}
		
		// Write a program to find largest of two numbers
		System.out.print("Pls enter a number for x = ");
		int x= scanner.nextInt();
		System.out.print("Pls enter a number for y = ");
		int y= scanner.nextInt();
		
		if(x > y) {
			System.out.println("x is bigger than y");
		}else if( x < y){
			System.out.println("y is bigger than x");
		}else if(x==y) {
			System.out.println("x and y both are equal numbers ");
		}else {
			System.out.println("Unintelligible input :( ");
		}
	
		// Write a program to check given number is even or odd.(Hint: use % operator)
		System.out.print("Pls enter another number here - ");
		int z=scanner.nextInt();
		if(z%2==0) {
			System.out.println("You entered an EVEN number");
		}else {
			System.out.println("You entered an ODD number");
		}
		
	}

}
