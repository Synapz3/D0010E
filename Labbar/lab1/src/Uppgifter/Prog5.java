package Uppgifter;

/*
 * Av: Marcus Lund
 * 911118-1153
 * 2015-01-23
 */

public class Prog5 {

	public static void main(String[] args) {
		
		/*
		 * The main method checks how many arguments the program gets.
		 * It loops through a set of two input datas and uses them.
		 */
		

		for (int q = 1; q <= 50; q += 1) {
			double p = Double.parseDouble((args[0]));
			System.out.println("Rec_raise_eff: " + p + " to the power of " + q + " is " + rec_raise_eff(p, q) + ". It takes " + counter + " laps."); // Calls and prints the result of rec_raise_eff(); function
			counter = 0;
			System.out.println("Rec_raise:     " + p + " to the power of " + q + " is " + rec_raise(p, q) + ". It takes " + counter + " laps. \n"); // Calls and prints the result of rec_raise(); function
			counter = 0; // Resets the value of the counter.
		
		}
	}
	
	static int counter = 0;

	static public double rec_raise(double a, int b) {
		
		/*
		 * This method is slower than the second one, and takes a long time to run depending on the value of k.
		 */
		
		if (b==0) {
			return 1.0;
		} else {
			counter += 1;
			return a * rec_raise (a, b-1);
		}
	}
	
	public static double rec_raise_eff(double a, int b) {
		
		/*
		 * This method is more efficient than the first one. It checks if the value is even or not and does calculations depending on the input value.
		 */
		
		if (b == 0) {
			return 1.0;
		} else if (b % 2 == 0) {
			counter += 1;
			double i = rec_raise_eff(a, (int)Math.floor((b/2)));
			return i * i;
		} else {
			counter += 1;
			double i = rec_raise_eff(a, (int)Math.floor((b/2)));
			return a * i * i;
		}
	}

}
