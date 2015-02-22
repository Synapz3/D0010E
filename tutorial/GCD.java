package tutorial;

public class GCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		gcd(123,311);

	}
	static void gcd(int a, int b) {
		int c;
		do {
			c = a % b;
			a = b;
			b = c;
		} while (c != 0);
		System.out.println(a);
	}

}
