package Uppgifter;

/*
 * Av: Marcus Lund
 * 911118-1153
 * 2015-01-23
 */

public class Prog3 {
	
	public static void main(String[] args) {
		
		int arg = args.length; // If the input is ok, run the program!
		arg(arg);
		if (arg >= 1) {
			for (int o = 0; o < arg; o++){
					iter_life_length(Integer.parseInt(args[o]));
					rec_print(Integer.parseInt(args[o]));
			}
		} else {
			no_input();	
		}
	}
	
	public static void iter_life_length(int a) {
		
		/*
		 * This method prints the life length of a value.
		 */
		
		int counter = 0;
		int u = a;
		while (a > 1) {
			counter += 1;
			a = Prog1.f1(a);
		}
		System.out.print(String.format("The life length of %d is %d.\n", u, counter));
	}
	
	
	public static int rec_life_length(int a) {
		
		/*
		 * This recursive method returnes the life length of a value.
		 */
		
		if ( a == 1) {
			return 0;
		} else {
			return 1 + rec_life_length(Prog1.f1(a));
		}
	}
	
	public static void rec_print(int a){
		
		/*
		 * Prints the life length of the recursive method.
		 */
		
		System.out.println(String.format("The life length of %d is %d.\n", a, rec_life_length(a)));
	}
	
	public static void no_input() {
		
		/*
		 * If String[] args is empty, print a message.
		 */
		
		System.out.println("There are no input!");
	}
	
	public static void arg(int arg) {
		System.out.println("Number of arguments: " + arg + "\n");
	}
	
}
