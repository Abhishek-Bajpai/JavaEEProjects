package leetcode.collections.experiments.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HashMapExperiments {

	
	public static void main(String[] args) {
		
		HashMap<String, Float> bankMap = new HashMap<>() ;
		
		System.out.println(bankMap.size() );
	
		
		bankMap.put("Abhishek", 99999.99f);
		bankMap.put("Gouri", 199999.99f);
		bankMap.put("Abeer", 299999.99f);
		bankMap.put("Amiya", 399999.99f);
		bankMap.put("Everest", 499999.99f);
		
		bankMap.put("Rahul", 399999.99f);
		bankMap.put("Raja", 499999.99f);
		bankMap.put("Ram", 399999.99f);
		bankMap.put("Romeo", 499999.99f);
		bankMap.put(null, 1111.22f);
		
		System.out.println(bankMap);
	
		for(String key: bankMap.keySet()) {
			System.out.println(key + " : " + key.hashCode() + " : " + bankMap.get(key).hashCode());
			/*
			 * if(key.startsWith("R")) { bankMap.remove(key); }
			 */
		}
		System.out.println(bankMap);
		
		
		Set<Map.Entry<String, Float>> bankmapEntrySet = bankMap.entrySet();
		Iterator<Map.Entry<String, Float>> bankmapIterator = bankmapEntrySet.iterator();
		while (bankmapIterator.hasNext()) {
			Map.Entry<java.lang.String, java.lang.Float> entry = (Map.Entry<java.lang.String, java.lang.Float>) bankmapIterator
					.next();
			if(entry.getKey().startsWith("R")) {
				bankmapIterator.remove();
			}
		}
		System.out.println(bankMap);
		
	}
}
