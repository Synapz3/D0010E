package Uppgifter;

/*
 * Av: Marcus Lund
 * 911118-1153
 * 2015-01-23
 */

public class Prog4 {

	public static void main(String[] args) {
		
		/*
		 * The main method checks how many arguments the program gets.
		 * It loops through a set of two input data and uses them.
		 */
		
		int t = args.length;
		if (args.length % 2 != 0) {
			System.out.println("The data input is uneven!");
		} else {
			for (int o = 0; o < t; o +=2) {
				double p = Double.parseDouble((args[o]));
				int q = Integer.parseInt(args[o+1]);
				System.out.println(rec_raise_eff(p, q));
			}
		}
		

	}
	
	public static double rec_raise_eff(double a, int b) {	
		
		/*
		 * A recursive function that calculates the result of a of the power to b.
		 */
		
		if (b == 0) {
			return 1;
		} else if (b % 2 == 0) {
			double i = rec_raise_eff(a, (int)Math.floor((b/2)));
			return i * i;
		} else {
			double i = rec_raise_eff(a, (int)Math.floor((b/2)));
			return a * i * i;
		}
	}
		
}
