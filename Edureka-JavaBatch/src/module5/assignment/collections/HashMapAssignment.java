package module5.assignment.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;



public class HashMapAssignment {

	public static void main(String[] args) {
	// Write a program to write 5 employee records using HashMap and display them
		
		Map<Integer, Employee> myMap = new HashMap<Integer, Employee>();
		myMap.put(1001, new Employee(101, "Abhishek", 1231456, 5555));
		myMap.put(1002, new Employee(102, "Kelly", 5245624, 1545));
		myMap.put(1003, new Employee(103, "Cindy", 5478226, 4455));
		myMap.put(1004, new Employee(104, "Hansini", 3245625, 8945));
		myMap.put(1005, new Employee(105, "Ragini", 653456, 2255));

	
		
		Iterator<Entry<Integer, Employee>> itrIterator = myMap.entrySet().iterator();
		while(itrIterator.hasNext()) {
			System.out.println(itrIterator.next());
		}
	 
		
	}

}
