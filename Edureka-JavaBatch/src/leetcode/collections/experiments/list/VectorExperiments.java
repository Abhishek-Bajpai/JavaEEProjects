package leetcode.collections.experiments.list;

import java.util.Arrays;
import java.util.ListIterator;
import java.util.Vector;

public class VectorExperiments {

	public static void main(String[] args) {
		String[] cricPlayerStrings = {"M S Dhoni", "Virat Kohli", "Ravindra Jadeja", "Sanju Samson", "Risabh Pant", "Jaspreeet Boomrah" , "Kuldeep Yadav"};

		Vector<String> playersVector = new Vector<>();
		System.out.println("Vector Size - "+ playersVector.size() + " : Vector Capacity -  " + playersVector.capacity());

		playersVector.addAll(Arrays.asList(cricPlayerStrings));
		System.out.println("Vector Size - "+ playersVector.size() + " : Vector Capacity -  " + playersVector.capacity());

		String[] morePlayers = {"Ajinkye Rahane" , "Manoj Pandey" , "George Matthew" };
		//String[] morePlayers = {"Ajinkye Rahane" , "Manoj Pandey" , "George Matthew" , "Ajinkye Rahane","David Brown"};
		//playersVector.insertElementAt("Sachin Tendulkar", 2);
		playersVector.addAll(Arrays.asList(morePlayers));
		System.out.println("Vector Size - "+ playersVector.size() + " : Vector Capacity -  " + playersVector.capacity());
		
		playersVector.insertElementAt("Sachin Tendulkar", 2);
		System.out.println("Vector Size - "+ playersVector.size() + " : Vector Capacity -  " + playersVector.capacity());

		System.out.println(playersVector);
		System.out.println(playersVector.subList(0, 3));
		
		ListIterator<String> listIterator= playersVector.listIterator(3);
		while (listIterator.hasNext()) {
			String string = (String) listIterator.next();
			System.out.print("( "+string + " ), ");
			
		}

		System.out.println("\n\n Vector Size - "+ playersVector.size() + " : Vector Capacity -  " + playersVector.capacity());
		
	} 

}
