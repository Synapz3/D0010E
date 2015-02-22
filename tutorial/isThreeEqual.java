package tutorial;

public class isThreeEqual {

	public static void main(String[] args) {
		System.out.println(isThreeequal(1, 2, 3));
	}
	static boolean isThreeequal(int a, int b, int c) {
		if (a == b && b == c) {
			return true;
		} else {
			return false;
		}
	}
}
