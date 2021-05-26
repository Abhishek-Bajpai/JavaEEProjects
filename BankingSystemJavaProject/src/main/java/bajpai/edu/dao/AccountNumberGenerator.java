/**
 * 
 */
package bajpai.edu.dao;

import java.util.Random;

/**
 * @author Abhishek Bajpai
 *
 */
public class AccountNumberGenerator {
 	    public static synchronized int nextAccountNumber(){
	    	return new Random().nextInt(2147483640);
	    }   
}
