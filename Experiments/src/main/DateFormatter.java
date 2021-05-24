package main;

/*Given a date string in the format Day Month Year, where:
Day is in the set {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", …, "29th", "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the inclusive range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:
YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.
For example:
1st Mar 1984 → 1984-03-01
2nd Feb 2013 → 2013-02-02
4th Apr 1900 → 1900-04-04
*/

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class DateFormatter {
//1st Mar 1984

	public static void main(String[] args) {

		String date = "4th Sep 1900";

		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("Jan", "01");
		ht.put("Feb", "02");
		ht.put("Mar", "03");
		ht.put("Apr", "04");
		ht.put("May", "05");
		ht.put("Jun", "06");
		ht.put("Jul", "07");
		ht.put("Aug", "08");
		ht.put("Sep", "09");
		ht.put("Oct", "10");
		ht.put("Nov", "11");
		ht.put("Dec", "12");

		// System.out.println(ht.get("Mar"));

		ArrayList<String> al = new ArrayList<String>();

		StringBuffer sb = new StringBuffer();

		
		
		StringTokenizer st = new StringTokenizer(date, " ");
		while (st.hasMoreTokens()) {
			al.add(st.nextToken());
		}

		String odate = al.get(0);
		String newDate = "";
		if (odate.length() == 3) {
			newDate = "0" + odate.charAt(0);
		} else {
			newDate = odate.substring(0, 2);
		}

		System.out.println(al.get(2) + "-" + ht.get(al.get(1)) + "-" + newDate);

	}

}