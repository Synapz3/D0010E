package tutorial;

public class reverseString {

	public static void main(String[] args) {
		System.out.println(reversestring("asd"));
	}
	static String reversestring(String s) {
		if (s.length() == 0) {
			return "";
		} else {
			return(reversestring(s.substring(1,s.length()))+s.charAt(0));
		}
	}
}
