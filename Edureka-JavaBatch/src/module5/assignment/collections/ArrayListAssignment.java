package module5.assignment.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListAssignment {

	public static void main(String[] args) {
		//	Write a program to insert 1 to 10 numbers in ArrayList and display them
		
		//insert
		List<Byte> listOfNosBytes = new ArrayList<>();
		for(int i=1; i<=10; i++)
			listOfNosBytes.add((byte) i);
		
		//display
		for(byte b:listOfNosBytes)
			System.out.print(b + " ");
		
	}

}
