package Extra8;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Av: Marcus Lund
 * 911118-1153
 */

public class String2intArray
{
	
	public static void main(String[] args){
		for(int x : str2ia("   55, 6 , 5,4 ,65,6 ,6 ,4 , 4, 44                           ,                  4")){
			System.out.print(x + " ");
		}
	}

	public static int[] str2ia (String s) throws IllegalArgumentException{
		// Splits the string into an array of "(String)ints".
		String[] ints = s.split(",");
		// How many numbers does the string contains?
		int numberOfNumbers = 0;
		for(char x : s.toCharArray()){
			if(x == ',')
			{
				numberOfNumbers++;
			}
		}
		
		// If the number if ints is greater than the amount of "(String)ints", there is one ',' to much or less than it should be.
		if(numberOfNumbers >= ints.length){
			ThrowError();
		}
		
		// For every (String)int in the Array, remove the white space.
		for(int i=0; i<ints.length;i++){
			ints[i] = ints[i].replaceAll(" ", "");
			// If the length of an "(String)int" is 0, throw an error.
			if(ints[i].length() == 0){
				ThrowError();
			}
		}
		
		// Now using Integer.pareseInt, we create an Array of Integers witch is returned to main method.
		int[] intNrArray = new int[ints.length];
		for(int i = 0; i < intNrArray.length; i++){
			intNrArray[i] = Integer.parseInt(ints[i]);
			System.out.println(intNrArray[i]);
		}
		
		// Return the numbers
		return intNrArray;
	}
	
	/*
	 * Throws an new Exception error.
	 */
	private static void ThrowError(){
		throw new IllegalArgumentException();
	}
}
