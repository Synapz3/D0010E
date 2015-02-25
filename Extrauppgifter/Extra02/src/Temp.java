package Extra;

/*
 * Av: Marcus Lund TCDAA 1
 * 911118-1153 2015-01-20
 */

public class Temp {

	public static void main(String[] args) {
		int f = 40;
		for (int i = f; i >= -f; i -= 5) {
			System.out.println(i+"°F is "+f2c(i)+"°C");
			
		}
	}
	public static double f2c(double f) {
			double c = (5.0/9.0) * (f-32);
			return java.lang.Math.rint(c * 10.0d) / 10.0d;
		}
	}
