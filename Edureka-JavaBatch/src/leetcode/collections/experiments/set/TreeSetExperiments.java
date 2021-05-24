package leetcode.collections.experiments.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import module5.assignment.collections.Employee;

public class TreeSetExperiments {

	/* 
	 * TreeSet 	- Ascending sorted order by default
	 * 			- null not allowed
	 * 			- Stored objects are sorted based on objects equals and hashcode implementation  	
	 */
	public static void main(String[] args) {
		String[] arrStrings = {"John", "Jack", "Bob", "Ram", "Vinay", "Arjun", "Ashish" , "Sandy", "Ram"};
		
		Set<String> playerSet= new TreeSet<>();
		playerSet.addAll(Arrays.asList(arrStrings));
		
		System.out.println("Array length - " + arrStrings.length);
		System.out.println(playerSet);
		System.out.println("HashSet length - " + playerSet.size() + "\n" + playerSet);
		//playerSet.add(null);
		System.out.println("HashSet length - " + playerSet.size() + "\n" + playerSet);

		Employee e1 = new Employee(1, "John", 123456, 9988);
		Employee e2 = new Employee(2, "Ram", 223456, 9998);
		Employee e3 = new Employee(3, "Vinay", 323456, 9999);
		Employee e4 = new Employee(4, "Jack", 423456, 8899);
		Employee e5 = new Employee(5, "Abhishek", 555456, 29988);

		Set<Employee> empTreeSet = new TreeSet<>();
		empTreeSet.add(e1);
		empTreeSet.add(e2);
		empTreeSet.add(e3);
		empTreeSet.add(e4);
		empTreeSet.add(e5);
		
		System.out.println(empTreeSet);
		
		System.out.println(empTreeSet.size());
		Iterator<Employee> myEmpIterator = empTreeSet.iterator();
		while (myEmpIterator.hasNext()) {
			Employee employee = (Employee) myEmpIterator.next();
			System.out.println(employee);
			
		}
		
	}

}
