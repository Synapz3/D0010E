package tutorial;

public class triangleArea {

	public static void main(String[] args) {
		System.out.println(trianglearea(3, 4, 5));
	}
	
	static double trianglearea(double a, double b, double c) {
		/*
		 * Heronś formula:
		 * Area = sqrt(s(s-a) (s-b) (s-c),
		 * Where s = a+b+c/2 
		 */
		double s = (a + b + c) / 2;
		double area = Math.sqrt(s * (s-a) * (s-b) * (s-c));
		
		return area;
	}
}
