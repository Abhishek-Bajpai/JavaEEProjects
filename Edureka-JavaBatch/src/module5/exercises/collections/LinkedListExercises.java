package module5.exercises.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExercises {

	public static void main(String[] args) {
 
		List<String> myLinkedList = new LinkedList<>();
		
		myLinkedList.add("Abhishek Bajpai");
		myLinkedList.add("Gouri Bajpai");
		myLinkedList.add("Abeer Bajpai");
		myLinkedList.add("Amiya Bajpai");
		myLinkedList.add("Everest Bajpai");
		myLinkedList.add("Abhishek Bajpai");
		myLinkedList.add("Gouri Bajpai");
		myLinkedList.add("Abeer Bajpai");
		myLinkedList.add("Amiya Bajpai");
		myLinkedList.add("Everest Bajpai");
		myLinkedList.add("Abhishek Bajpai");
		myLinkedList.add("Gouri Bajpai");
		myLinkedList.add("Abeer Bajpai");
		myLinkedList.add("Amiya Bajpai");
		myLinkedList.add("Everest Bajpai");

		//find and remove duplicates 
		
		Collections.sort(myLinkedList);		
		
		Iterator<String> strItratorIterator = myLinkedList.iterator();
		while(strItratorIterator.hasNext()) {
			System.out.println(strItratorIterator.next());
			
		}
		
	}

}
