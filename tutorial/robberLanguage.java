package tutorial;

public class robberLanguage {

	public static void main(String[] args) {
		System.out.println(RobberLanguage("asdf"));
	}
	
	static String RobberLanguage( String s) {
		if(s.length() == 0) {
			return "";
		} else {
			if(isConsonant(s.charAt(0))) {
				return s.charAt(0) + "o" + s.charAt(0) +
						RobberLanguage(s.substring(1, s.length()));
			} else {
				return s.charAt(0) + 
						RobberLanguage(s.substring(1, s.length()));
			}
		}
	}
	static boolean isConsonant(char c) {
		String s = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
		if(s.indexOf(c) == -1) {
			return false;
		} else {
			return true;
		}
	}
}
