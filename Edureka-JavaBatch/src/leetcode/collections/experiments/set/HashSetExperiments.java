package leetcode.collections.experiments.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetExperiments {

	public static void main(String[] args) {
		String[] arrStrings = {"John", "Jack", "Bob", "Ram", "Vinay", null, "Arjun", "Ashish" , "Sandy", "Ram", null};
		
		Set<String> playerSet= new HashSet<>();
		System.out.println("HashSet Size - "+ playerSet.size() + " : HashSet Capacity -  " + playerSet.capacity());

		
		playerSet.addAll(Arrays.asList(arrStrings));
		System.out.println("Array length - " + arrStrings.length);
		System.out.println(playerSet);
		System.out.println("HashSet length - " + playerSet.size() + "\n" + playerSet);
		playerSet.add(null);
		System.out.println("HashSet length - " + playerSet.size() + "\n" + playerSet);

		
	}

}
