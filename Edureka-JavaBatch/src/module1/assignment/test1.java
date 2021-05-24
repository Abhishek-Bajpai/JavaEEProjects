package module1.assignment;

class base{  
		base() 
		{  System.out.println("In the base class..");
		  test(); 
		} 

		void test() 
		{  System.out.println("in the test function...");
		  base b1 = new base();
		 }
		}  

class derived extends base{
	public derived() {
		// TODO Auto-generated constructor stub
		System.out.println("Hello ,, ");
	}
}
		public class test1 
		{ 
			static {
				System.out.println("Hello");
			}
		public static void main (String args[]) 
		{    
		derived derived = (derived) new base();     
		}   
		}