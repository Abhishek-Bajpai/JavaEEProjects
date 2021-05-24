package module2.assignment;

import java.util.Scanner;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// dimensions (l,w) of many folding /shipping boxes inventory
		int[][] listOfBoxes=new int[5][5];
		int length, width;
		
		for(int i=0; i<5; i++) {
			System.out.println("Pls enter dimensions for box number = " + i);
			//rows (we have inventory of 5 boxes here
			for(int j=0; j<2; j++) {
				//columns ..we have length and width for each box
				System.out.print("measurement = ");
				length=scanner.nextInt();
				listOfBoxes[i][j] = length;
			}
		}
		

		for(int i=0; i<5; i++) {
			System.out.println("Dimensions of box number = " + i);
			//rows (we have inventory of 5 boxes here
			for(int j=0; j<2; j++) {
				//columns ..we have length and width for each box
				System.out.print(" " + listOfBoxes[i][j]+ " | " );
			}
			System.out.println("\n");
		}		
		
		
	}

}
