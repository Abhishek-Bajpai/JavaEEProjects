package leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {

	public static void main(String[] args) {
		// Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number
		
		int[] nums = {3,2,1};
		System.out.println(thirdMax(nums));

		
		// My sol		
		System.out.println("<<<<< Arrays.sort >>>>>>");
		Arrays.sort(nums);
		System.out.println(nums[0]);
		
		//Set based
		System.out.println("<<<< Set/HashSet >>> " + thirdMaxN(nums));

	}
	
	public static int thirdMaxN(int[] nums) {       
	    Set<Integer> maximums = new HashSet<Integer>();
	    for (int num : nums) {
	        maximums.add(num);
	        if (maximums.size() > 3) {
	            maximums.remove(Collections.min(maximums));
	        }
	    }
	    if (maximums.size() == 3) {
	        return Collections.min(maximums);
	    }
	    return Collections.max(maximums);
	}

	private static int thirdMaxNum(int[] nums) {

		int maxNum=0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(nums[i]> nums[j] )
					maxNum = nums[i];
			}
		}	
		
		System.out.println("Max Num : " + maxNum);
		return maxNum;
	}

	public static int thirdMax(int[] a) {
        int n = a.length, i = 0;
        int x = a[i++], y, z;
        while (i < n && a[i] == x)
            i++;
        if (i == n)
            return x;
        y = a[i++];
        while (i < n && (a[i] == x || a[i] == y))
            i++;
        if (i == n)
            return Math.max(x, y);
        z = a[i];

        int min = Math.min(x, Math.min(y, z));
        int max = Math.max(x, Math.max(y, z));
        int mid = getMid(x, y, z);

        i = 3;
        while (i < n) {
            x = a[i];
            if (x > max) {
                min = mid;
                mid = max;
                max = x;
            } else if (x > mid && x < max) {
                min = mid;
                mid = x;
            } else if (x > min && x < mid) {
                min = x;
            }
            i++;
        }
        return min;
    }

	private static int getMid(int x, int y, int z) {
	    if (x > y && x < z || x < y && x > z)
	        return x;
	    if (y > x && y < z || y < x && y > z)
	        return y;
	    return z;
	}

}
