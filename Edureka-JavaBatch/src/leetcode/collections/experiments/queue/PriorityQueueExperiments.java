package leetcode.collections.experiments.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExperiments {

	public static void main(String[] args) {

		String[] arrStrings = { "John", "Jack", "Bob", "Ram", "Vinay", "Arjun", "Ashish", "Sandy" };

		priorityQueueExeriments(arrStrings);

	}

	private static void priorityQueueExeriments(String[] arrStrings) {
		System.out.println("<<<<<<<<<<<<<<<<  Priority Queue Demo >>>>>>>>>>>>>>>>>>>>");
		Queue<String> queueStr = new PriorityQueue<>();

		for (String str : arrStrings) {
			queueStr.add(str);
		}

		System.out.println("Size of Q before PEEK : " + queueStr.size());
		System.out.println(queueStr.peek()); // PEEK returns the first element from the Q
		System.out.println("Size of Q after PEEK, Before POLL : " + queueStr.size());
		System.out.println(queueStr.poll()); // POLL removes element from the Q
		System.out.println("Size of Q after POLL : " + queueStr.size());
		System.out.println(queueStr);
		queueStr.remove(); // removes the first element

		if (queueStr.contains("Ram")) {
			queueStr.remove("Ram");
			System.out.println("After removing Ram -  " + queueStr);
		}

		queueStr.clear();
		System.out.println("Polling an empty queue : ");
		System.out.println(queueStr.poll()); // poll returns null when no element found
		System.out.println("Removing from an empty queue :: ");

		try {
			System.out.println(queueStr.remove()); // remove throws NoSuchElementException when no element found
		} catch (java.util.NoSuchElementException e) {
			System.out.println("remove() did not find element to remove and threw ~NoSuchElementException");
		}
	}

}
