package module5.assignment;

import com.sun.javafx.collections.SortableList;
import com.sun.org.apache.bcel.internal.generic.LNEG;

public class WrapperClassAssignment {

	public static void main(String[] args) {
		//	Try all the Wrapper classes as shown for Integer in the Class
		
//Boxing
		//char - Character
		Character aCharacter = '#';
		Character bCharacter = new Character('$');
		Character cCharacter = Character.valueOf('@');
		System.out.println("char -> Character " + aCharacter + " : " + bCharacter + " : " + cCharacter);
		
		//byte - Byte : Stores whole numbers from -128 to 127
		Byte aByte = 123;
		Byte bByte = new Byte((byte) 456);
		Byte cByte = Byte.valueOf((byte) 789);
		System.out.println("byte -> Byte " + aByte + " : " + bByte + " : " + cByte);
		
		//short - Short : short(2 bytes) data type is a 16-bit signed Java primitive integer data type. Its range is -32768 to 32767 (or -215 to 215 – 1)
		Short aShort =  -32768;
		Short bShort = new Short((short) 32767);
		Short cShort = Short.valueOf((short) 32770);
		System.out.println("short -> Short " + aShort + " : " + bShort + " : " + cShort);
		
		
		//int - Integer : int(4 bytes) Stores whole numbers from -2,147,483,648 to 2,147,483,647
		Integer aInteger = -2147483648;
		Integer bInteger = new Integer(2147483647);
		Integer cInteger = Integer.valueOf(2147483645);
		System.out.println("int -> Integer " + aInteger + " : " + bInteger + " : " + cInteger);
		
		//long -> Long : long(8 bytes) Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
		Long aLong = -9223372036854775808L;
		Long bLong = new Long(9223372036854775807L);
		Long cLong = Long.valueOf(9223372036854775804L);
		System.out.println("long -> Long " + aLong + " : " + bLong + " : " + cLong );
		
		//float - Float : float(4 bytes) 3.40282347 x 1038, 1.40239846 x 10-45
		Float aFloat = 12.13f;
		Float bFloat = new Float(14.15);
		Float cFloat = Float.valueOf("18.19");
		System.out.println("float -> Float" + aFloat + " : " + bFloat + " : " + cFloat);
		
		//double - Double : double(8 bytes) 1.7976931348623157 x 10308, 4.9406564584124654 x 10-324
		Double aDouble = 7976931348623157.123456799;
		Double bDouble = 251653131.1651321651321;
		Double cDouble = Double.valueOf(53645613136431.54965135168515631);
		System.out.println("double -> Double " + aDouble + " : " + bDouble + " : " + cDouble); 
		
		//boolean - Boolean
		Boolean aBoolean = true ;
		Boolean bBoolean = new Boolean(false);
		Boolean cBoolean = Boolean.valueOf(true);
		System.out.println("boolean -> Boolean " + aBoolean + " : " + bBoolean + " : " + cBoolean);
		
		
	}

}
