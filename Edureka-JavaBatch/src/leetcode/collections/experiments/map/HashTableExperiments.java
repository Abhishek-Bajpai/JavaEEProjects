package leetcode.collections.experiments.map;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashTableExperiments {
	public static void main(String[] args) {
		
		Map<String, Float> bankAccTable = new Hashtable<>() ;
		
		bankAccTable.put("Abhishek", 99999.99f);
		bankAccTable.put("Gouri", 199999.99f);
		bankAccTable.put("Abeer", 299999.99f);
		bankAccTable.put("Amiya", 399999.99f);
		bankAccTable.put("Everest", 499999.99f);
		
		bankAccTable.put("Rahul", 399999.99f);
		bankAccTable.put("Raja", 499999.99f);
		bankAccTable.put("Ram", 399999.99f);
		bankAccTable.put("Romeo", 499999.99f);
		//bankMap.put(null, null);
		
		System.out.println(bankAccTable);
		
		for(String key: bankAccTable.keySet()) {
			System.out.println(key + " : " + key.hashCode() + " : " + bankAccTable.get(key).hashCode());
			/*
			 * if(key.startsWith("R")) { bankMap.remove(key); }
			 */
		}
		
		
		Set<Map.Entry<String, Float>> bankmapEntrySet = bankAccTable.entrySet();
		Iterator<Map.Entry<String, Float>> bankmapIterator = bankmapEntrySet.iterator();
		while (bankmapIterator.hasNext()) {
			Map.Entry<java.lang.String, java.lang.Float> entry = (Map.Entry<java.lang.String, java.lang.Float>) bankmapIterator
					.next();
			if(entry.getKey().startsWith("R")) {
				bankmapIterator.remove();
			}
		}
		System.out.println(bankAccTable);	
	}

}
