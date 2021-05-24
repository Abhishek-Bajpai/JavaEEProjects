package module1.assignment;

import java.util.Scanner;

public class AssignmentTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] idArr = new int[5];
		String[] nameArrString = new String[5];
		//int[] salaryArr = new int[5];
		double[] salaryArr = new double[5];

		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			System.out.print("Enter your employee ID : ");
			idArr[i] = scanner.nextInt();
			System.out.print("Enter your name : ");
			nameArrString[i]= scanner.next();
			System.out.print("Enter your salary : ");
			salaryArr[i]= scanner.nextDouble(); 
		}
		System.out.println("***************** Question Statement 1 ***************************");
		System.out.println(idArr.toString() + "\n" + nameArrString.toString() + "\n" + salaryArr.toString());
		display(idArr, nameArrString, salaryArr);
		System.out.println("***************** Question Statement 2 ***************************");
		display(idArr, nameArrString);
		System.out.println("***************** Question Statement 3 ***************************");
		System.out.println("Enter a name to search record in the database - ");
		String searchNameString = scanner.next();
		display(searchNameString, idArr, nameArrString, salaryArr);
		scanner.close();
		
	}
	
	private static void display(String name, int[] idArr, String[] nameArrString, double[] salaryArr) {
		for(int i=0; i<5; i++) {
			if(name.equalsIgnoreCase(nameArrString[i])) {
				System.out.println("|---------------------|");
				System.out.println("| ID |  Name | Salary |");
				System.out.println("|---------------------|");
				System.out.println("| " + idArr[i] + " | " + nameArrString[i]+ "   |   " + salaryArr[i]+ " |");
				break;
			}
		}
					
	}

	private static void display(int[] id, String[] name, double[] salaryArr) {
		System.out.println("|---------------------|");
		System.out.println("| ID |  Name | Salary |");
		for(int i=0; i<5; i++) {
			System.out.println("|---------------------|");
			System.out.println("| " + id[i] + " | " + name[i]+ "   |   " + salaryArr[i]+ " |");
		}
			System.out.println("|---------------------|");				
	}

	private static void display(int[] id, String[] name) {
		System.out.println("|------------|");
		System.out.println("| ID |  Name |");
		for(int i=0; i<5; i++) {
			System.out.println("|------------|");
			System.out.println("|  " + id[i] + " | " + name[i]+ "  |" );
		}
			System.out.println("|------------|");				
	}
	
	
}
