package tutorial;

public class IsPrime {

	public static void main(String[] args) {
		System.out.println(Isprime(9999991));
	}
	static boolean Isprime(int a) {
		int i = 2;
		while(i <= Math.sqrt(a)) {
			if (a % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}
}
