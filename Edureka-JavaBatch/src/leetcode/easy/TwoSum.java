package leetcode.easy;

public class TwoSum {

	public static void main(String[] args) {
		// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
		// You may assume that each input would have exactly one solution, and you may not use the same element twice.
		int[] nums=new int[] {1,3,4,2};
		int target = 6;
		for(int x:twoSum(nums, target)) {
			System.out.print((x + " "));
		}
	}


/**
 * 
 * @param nums
 * @param target
 * @return
 * 
 * LeetCode acceptance status - ACCEPTED 
 * Runtime: 41 ms, faster than 6.43% of Java online submissions for Two Sum.
 * Memory Usage: 39.2 MB, less than 31.00% of Java online submissions for Two Sum.
 */
	public static int[] twoSum(int[] nums, int target) {
        int[] result = null;
		for(int i=0; i<nums.length; i++) {
			for(int j=nums.length-1; j >0; j--) {
				System.out.println(i + ":" + nums[i] + " " + j +":" + nums[j]);
				if(!(i==j) && nums[i]+ nums[j]== target) {
					//System.out.println(i + " " + j);
					result = new int[] {i, j};
					return result;
				}
			}
		}
		return result;
	}
}
