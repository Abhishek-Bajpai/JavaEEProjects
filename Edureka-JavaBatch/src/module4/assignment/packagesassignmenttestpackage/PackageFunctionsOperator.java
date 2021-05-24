package module4.assignment.packagesassignmenttestpackage;

import module4.assignment.packagesassignment.PackagesAssignment;

public class PackageFunctionsOperator {
	
	public static void main(String[] args) {
		PackagesAssignment pkgAssignment = new PackagesAssignment();
		
		System.out.println(pkgAssignment.substract(500, 200));
		System.out.println(pkgAssignment.multiply(12,  40));
		System.out.println(pkgAssignment.divide(300, 6));
		System.out.println(pkgAssignment.factorial(5));
		System.out.println(pkgAssignment.reverseDigits(12345));
		
		
	}

}
