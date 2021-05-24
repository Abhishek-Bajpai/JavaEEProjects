package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters. Calculate the minimum number of swaps necessary to make a string balanced.
Input  : []][][
Output : 2
First swap: Position 3 and 4
[][]][
Second swap: Position 5 and 6
[][][]

Input  : [[][]]
Output : 0
String is already balanced.
*/

//Calculate the minimum number of swaps necessary to make a string balanced. Eg: Calculate=1 the=1

public class Test {

	public static void main(String[] args) {

		String str = "[]][][";
		System.out.println(swapCount(str));
		
		str="[[][]]";
		System.out.println(swapCount(str));
		
		
		str = "Calculate the minimum number of swaps necessary to make a string balanced." ;
		countWordsUsingStream(str);
		
		   /*
			* Immutable List 
			* Method -1 
			*/	
			List x= Arrays.asList(new String[] {"Hello", "World"});
			System.out.println( x.size());
//			x.add("Hello");
//			x.add("World!!");
			x.forEach(e -> System.out.println(e));
			/*
			* Immutable List 
			* Method -2 Use Collections 
			*/	
			
			List<String> xList = Collections.EMPTY_LIST;
			System.out.println("Collections list size is - " + xList.size());
//			xList.add("Test");
//			xList.add("Center");
			xList.forEach(e -> System.out.println(e));
		
			
	}
	
	static int swapCount(String str) {
		char[] chars= str.toCharArray();
		
		int countLeft=0, countRight=0; 
		
		int swap=0, imbalance=0;
		
		for(int i=0; i< chars.length; i++) {
			if(chars[i] == '[')
			{
				countLeft++;
				if(imbalance > 0) {
					swap += imbalance;
					imbalance--;
				}
				
			}else if(chars[i] == ']') {
				countRight++;
				imbalance = (countRight - countLeft);
			}
		}
		
		return swap;
		
	}

	
	static void countWordsUsingStream(String str) {
		
		String[] words = str.split(" "); //The \\W+ will match all non-alphabetic characters occurring one or more times. 
		for(String word: words) {
			System.out.println(word);
		}
		
		List<String> wordsList = new ArrayList<String>();
		Collections.addAll(wordsList, words);
		
		Map<String, Integer> frequencyMap = new HashMap<>();

		wordsList.forEach(word ->
		        frequencyMap.merge(word, 1, (v, newV) -> v + newV)
		);

		System.out.println(frequencyMap);
		
	}
	
}
