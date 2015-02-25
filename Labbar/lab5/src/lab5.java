package tutorial;
import java.util.Scanner;

public class asdf {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		func(in.nextLine());
	}
	
	public static void func(String a) {
		for (int i = 0; i < a.length(); i++){
			int ascii = (int) a.charAt(i);
			System.out.println("ASCII: "+func2(ascii)+" har nummer: "+ascii);
		}
	}
	
	public static char func2(int a) {
		char chars = (char) a;
		return chars;
	}
}
