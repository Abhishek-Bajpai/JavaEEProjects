package module1.assignment;

public class DataTypesAndArithmeticOps {

	/*
	 * -2^(n-1) to 2^(n-1)-1 -> -2^7 to 2^7-1 -> -128 to 127 
	 * Bytes : -128 to 127
	 * Short : -32,768 to 32767 - 2 bytes of memory 
	 * int: -2147483648 to 2147483647 - 4 bytes of memory 
	 * long : -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 
	 * float : 6 to 7 decimal digits 
	 * double : 15 decimal digits
	 */
	/*
	 * Data Type Default Value (for fields) byte 0 short 0 int 0 long 0L float 0.0f
	 * double 0.0d char '\u0000' String null (or any object) boolean false
	 */

	public static void main(String[] args) {
		byte b = 127;
		System.out.println(b);

		short s = 32767;
		System.out.println(s);

		int i = 2147483647;
		System.out.println(i);

		long l = 9223372036854775807L;
		System.out.println(l);

		float f = 1.234567898898f;
		System.out.println(f);

		double d = 1.123456789098765;
		System.out.println(d);

		char c = '\u0100';
		System.out.println(c);

		String str = "HelloWorld!!";
		System.out.println(str);

		boolean bol = false;
		System.out.println(bol);

	}
}
