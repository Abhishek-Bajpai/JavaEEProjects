import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
public class StreamDemo {

public static void main(String[] args){

		/*
		 * Stream<Integer> myStream = Stream.of(1,2,3,4,5,6,7,8,9); myStream.forEach(
		 * i-> System.out.println(i));
		 */
		 	
		
		
		  List<Integer> list = Arrays.asList(11, 20, 3, 5 ,6, 42);
		  //System.out.println(list.stream().filter(i -> i>10).mapToInt(i->i).sum());
		  System.out.println(list.stream().filter(i -> i>10).sorted().forEach(i -> i));
		 


}

}	