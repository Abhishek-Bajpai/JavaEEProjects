
public class IntOps {

	public static void main(String[] args) {

	}
	
	
	
	public static boolean isPalindrome(int x) {

		String str = String.valueOf(x);   //Converts int to String
		int start = 0;
		int end = str.length() - 1;
		while (start < end) {
			if (str.charAt(start++) != str.charAt(end--))
				return false;
		}
		return true;

	}
	
	/*
	 * public boolean isPalindrome(int x, int ) { if (x<0 || (x!=0 && x%10==0))
	 * return false; int rev = 0; while (x>rev){ rev = rev*10 + x%10; x = x/10; }
	 * return (x==rev || x==rev/10); }
	 */

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
       if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
       if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int[] reverseArray(int[] x) {
    	int[] reversed = new int[x.length];
    	for(int i=x.length-1, j=0; i>=0 ; i--,j++) {
    		reversed[j]=x[i];
    	}
    	
    	return reversed;
    }
    
    public static char[] resverseString(char[] input) {
    	char[] result=new char[input.length];
    	
    	for(int i=input.length-1, j=0; i>=0; i--, j++) {
    		result[j] = input[i];
    	}
    	return result;
    }
 
    public static boolean isPalindrome(String input) {
    	
    	char[] myCharArray = input.toCharArray();
    	boolean isPalindrom = true;
    	
    	for(int i=0, j=myCharArray.length-1; i<=myCharArray.length-1 ;i++, j--) {
    		if(! (myCharArray[i]==myCharArray[j])) {
    			isPalindrom = false;
    		}
    	}
    		
    	return isPalindrom;
    	
    }
    
    
    public static int[] intToArray(int n) {
    	
    	int j = 0;
    	int len = Integer.toString(n).length();
    	int[] arr = new int[len];
    	while(n!=0)
    	{
    		arr[len-j-1] = n%10;
    		n=n/10;
    		j++;
    	}
    	return arr;
    	
    	
    }
}

