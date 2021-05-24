package leetcode.easy;

import com.sun.org.apache.regexp.internal.recompile;

public class ReverseInteger {

	/*
	 * Given a signed 32-bit integer x, return x with its digits reversed. 
	 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
	 */
	final static int MAX_VAL=2147483647;
	final static int MIN_VAL=-2147483648;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			System.out.println(reverseInteger(-2147483648));
			System.out.println(reverse(-2147483648));
		
	}

	public static int reverseInteger(int x) {

		int tenthPlaceDigit;
		int reversedNumber = 0;

		while(x != 0) {
			tenthPlaceDigit = x%10;
			x = x/10;

			if(reversedNumber > Integer.MAX_VALUE/10 || (reversedNumber == Integer.MAX_VALUE/10 && tenthPlaceDigit > 7)) 
				return 0;
			if(reversedNumber < Integer.MIN_VALUE/10 || (reversedNumber == Integer.MIN_VALUE/10 && tenthPlaceDigit < -8))
				return 0;
			
			reversedNumber = reversedNumber * 10 + tenthPlaceDigit;
		}
		
		return reversedNumber;	
		}

	
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0; //2147483647
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;  //
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
