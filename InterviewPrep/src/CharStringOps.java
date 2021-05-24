import java.util.Stack;

public class CharStringOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isValid("{([])}"));
		
	}

	/**
	 * 
	 * @param str = {([]})
	 * @return
	 */
	public static boolean isValid(String str) {
		Stack<Character> x = new Stack();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
				x.push(str.charAt(i));
			else {
				if (x.isEmpty())
					return false;
				switch (str.charAt(i)) {
					case '}':
						if (x.pop() == '{')
							continue;
						else
							return false;
					case ')':
						if (x.pop() == '(')
							continue;
						else
							return false;
					case ']':
						if (x.pop() == '[')
							continue;
						else
							return false;
				}
			}
		}
		if (x.isEmpty())
			return true;

		return false;
		
	}
}
