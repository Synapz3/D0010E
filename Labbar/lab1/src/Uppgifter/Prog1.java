package Uppgifter;

/*
 * Av: Marcus Lund
 * 911118-1153
 * 2015-01-20
 */

public class Prog1 {

	public static void main(String[] args) { // main method.
		
		int arg = args.length; // If the input is ok, run the program!
		System.out.println("Number of arguments: " + arg + "\n");
		if (arg > 1) {
			for (int o = 0; o < arg; o++){
				 int a = Integer.parseInt(args[o]);
				System.out.print(String.format("The number %d gives: f1=%d, f2=%d, f4=%d, f8=%d, f16=%d, f32=%d \n",a, f1(a),f2(a),f4(a),f8(a),f16(a),f32(a))); // Prints the requested numbers of times each function executes.
			}
		} else if (arg == 1) {
			int a = Integer.parseInt(args[0]);
			System.out.print(String.format("The number %d gives: f1=%d, f2=%d, f4=%d, f8=%d, f16=%d, f32=%d",a, f1(a),f2(a),f4(a),f8(a),f16(a),f32(a))); // Prints the requested numbers of times each function executes.
		} else {
			System.out.println("There are no arguments!");
		}
		System.out.println("\n");
	}
	
	public static int f1(int a) {
		
		/*
		 * This method holds the mathematical calculatioin forms.
		 */
		
		if (a == 1) {
			return a;
		} else if (a % 2 == 0) {
			return a/2;
		} else {
			return (3 * a) +1;
		}
	}
	
	/*
	 * All methods below gives the value after a certain sets of runs.
	 */
	
	public static int f2(int a) {
		return f1(f1(a));
	}
	public static int f4(int a) {
		return f2(f2(a));
	}
	public static int f8(int a) {
		return f4(f4(a));
	}
	public static int f16(int a) {
		return f8(f8(a));
	}
	public static int f32(int a) {
		return f16(f16(a));
	}
}
