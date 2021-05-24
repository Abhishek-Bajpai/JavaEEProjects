package leetcode.collections.experiments.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class DeQueueExperiments {
	public static void main(String[] args) {

		String[] arrStrings = { "John", "Jack", "Bob", "Ram", "Vinay", "Arjun", "Ashish", "Sandy" };
		dequeExperiment(arrStrings);
	}

	private static void dequeExperiment(String[] arrStrings) {
		System.out.println("<<<<<<<<<<<<<<<<  DeQueue Demo >>>>>>>>>>>>>>>>>>>>");
		Deque<String> deQueueStr = new ArrayDeque<>();
		deQueueStr.addAll(Arrays.asList(arrStrings));

		System.out.println(deQueueStr);
		deQueueStr.addFirst("Abhishek");
		deQueueStr.addLast("Gouri");
		System.out.println(deQueueStr);

		// offer methods to insert elements
		deQueueStr.offer("Everest");
		System.out.println(deQueueStr);
		deQueueStr.offerFirst("Abeer");
		System.out.println(deQueueStr);
		deQueueStr.offerLast("Amiya");
		System.out.println(deQueueStr);

		System.out.println(deQueueStr.getFirst());
		System.out.println(deQueueStr.getLast());
		System.out.println("Size of the DeQueue is ( " + deQueueStr.size() + " ) ");
		System.out.println("Peek - " + deQueueStr.peek() + ", Peek First - " + deQueueStr.peekFirst() + ", Peek Last - "
				+ deQueueStr.peekLast());

		System.out.println("Size of the DeQueue is ( " + deQueueStr.size() + " ) ");
		System.out.println("Poll- " + deQueueStr.poll() + ", Poll First - " + deQueueStr.pollFirst() + ", Poll Last - "
				+ deQueueStr.pollLast());

		System.out.println("Size of the DeQueue is ( " + deQueueStr.size() + " ) ");
		System.out.println("Pop - " + deQueueStr.pop());

		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(deQueueStr);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

		Iterator<String> dequeueIterator = deQueueStr.descendingIterator();
		while (dequeueIterator.hasNext()) {
			String string = (String) dequeueIterator.next();
			System.out.print(string + " > ");
		}

		System.out.println("\n\n");
		Iterator<String> deQItrIterator = deQueueStr.iterator();
		while (deQItrIterator.hasNext()) {
			String string = (String) deQItrIterator.next();
			System.out.print(string + " < ");
		}

	}

}
