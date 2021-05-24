package leetcode.collections.experiments.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ArrayListExperiments {

	public static void main(String[] args) {
		
	String[] cricPlayerStrings = {"M S Dhoni", "Virat Kohli", "Ravindra Jadeja", "Sanju Samson", "Risabh Pant", "Jaspreeet Boomrah" , "Kuldeep Yadav"};
	
	List<String> listOfPlayers = new ArrayList<>();
	listOfPlayers.addAll(Arrays.asList(cricPlayerStrings));

	String[] morePlayers = {"Ajinkye Rahane" , "Manoj Pandey" , "George Matthew" , "Ajinkye Rahane","David Brown"};
	listOfPlayers.addAll(Arrays.asList(morePlayers));
		
	System.out.println("Reading list using for..each loop ..... ");
		for(String player: listOfPlayers) {
			System.out.print("(" + player + ") ");
/*			
 			if(player.equals("Sanju Samson"));
			{
				listOfPlayers.remove(player); 	//will throw ConcurrentModificationException
			} 
*/
		}
	

	//Iterate through using Iterator (Forward Direction)  
	System.out.println("\n\nReading list using Iterator (FORWARD) ..... ");
	Iterator<String> itrPlayersIterator = listOfPlayers.iterator();
	while (itrPlayersIterator.hasNext()) {
		String player = itrPlayersIterator.next();
		if(player.equals("Sanju Samson")) {
			System.out.println("Removing " + player + "...");
			 itrPlayersIterator.remove(); 
		}
		System.out.print(player + " > ");
	}

	//Iterate through using Iterator (Backward Direction)
	System.out.println("\n\nReading list using ListIterator (REVERSE) ..... ");
	ListIterator<String> listItrIterator = listOfPlayers.listIterator(listOfPlayers.size());
	while (listItrIterator.hasPrevious()) {
		String lString = listItrIterator.previous();
		System.out.print(lString + " < ");
		
	}

	java.util.Collections.sort(listOfPlayers); //NPE here 
	System.out.println("\n\n*** Sorted ArrayList ***\n" + listOfPlayers);
	
	// Enumerate through using Enumeration
	System.out.println("\n\nReading list using Enumeration ..... ");
	Enumeration<String> enumPlayersEnumeration = Collections.enumeration(listOfPlayers);
	while (enumPlayersEnumeration.hasMoreElements()) {
		String enumPlayer = (String) enumPlayersEnumeration.nextElement();
		System.out.print(enumPlayer + " ~ ");
		
	}
	
	//Get thread safe list by using~ Collections.synchronizedList
	listOfPlayers = Collections.synchronizedList(listOfPlayers);
	System.out.println("\n\nReading SYNCHRONIZED list (THREAD Safe)..... ");
	System.out.println(listOfPlayers);
	
	
	}

}
