package module5.assignment.collections;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableAssignment {

	public static void main(String[] args) {
		// Write a program to write 5 student records into a Hashtable and display the student whose marks are the highest in the class
			
		Dictionary<Integer, Student> studentRecord = new Hashtable<>();
		
		studentRecord.put(1001, new Student (101, "Abhishek", 965));
		studentRecord.put(1002, new Student(102, "Kelly", 755));
		studentRecord.put(1003, new Student(103, "Cindy", 455));
		studentRecord.put(1004, new Student(104, "Hansini", 945));
		studentRecord.put(1005, new Student(105, "Ragini", 255));
		
		//System.out.println(studentRecord);
		Float randomStart = 1.0f;
		Integer identifyStudentWithMaxMarks = 1;
		Enumeration<Integer> enumStudentReco = studentRecord.keys();

		while(enumStudentReco.hasMoreElements()) {
			Integer currKeyInteger = enumStudentReco.nextElement();
			float totalMarks= studentRecord.get(currKeyInteger).getTotalMarks();
			if(totalMarks > randomStart) {
				randomStart = totalMarks;
				identifyStudentWithMaxMarks = currKeyInteger;
				
			}
		}
		
		System.out.println("Student with the MAXIMUM marks is ~~ ");
		System.out.println(studentRecord.get(identifyStudentWithMaxMarks));
	}

}
