package Uppgifter;

/*
 * Av: Marcus Lund
 * 911118-1153
 * 2015-01-23
 */

public class Prog2 {

	public static void main(String[] args) {
		
		/*
		 * The main method checks how many arguments the program gets.
		 * It loops through a set of two input datas and uses them.
		 */
		
		int t = args.length;
		if (args.length % 2 != 0) {
			message();
		} else {
			for (int o = 0; o < t; o +=2) {
				int p = Integer.parseInt(args[o]);
				int q = Integer.parseInt(args[o+1]);
				iterate_f(p,q);
			}
		}
		
	}
	
	public static void iterate_f(int a, int b) {
		
		/*
		 * This method prints what value a start value reaches when going througt f1 a defined numver of times.
		 */
		int g = a;
		for (int d = 0; d < b; d++) {
			a = Prog1.f1(a);
		}
		System.out.println(String.format("The number %d gives the number %d when looping %d times.", g, a, b));
	}
	public static void message() {
		System.out.println("The data input is uneven!");
	}
}
