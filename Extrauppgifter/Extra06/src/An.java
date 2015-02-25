package An;

/*
 * Av: Marcus Lund
 * TCDAA
 * 2015-02-04
 * D0010M
 */

class Pair<A, B> {
	private A left;
	private B right;
	public Pair(A a1, B a2) {
		left = a1;
		right = a2;
	}
	
	public String toString() {
		return left.toString() + " : " + right.toString();
	}
}

public class An {
	
	public static void main(String[] args) {
			System.out.println(a(4));

	}
		
	public static Pair<Integer,Integer> a(int n){
		
		int A0x = 841;
		int A0y = 1189;
		for (;n > 0; n--) {
			int x_temp = A0x;
			A0x = Math.floorDiv(A0y, 2);
			A0y = x_temp;
			
		}
		return new Pair<Integer, Integer>(A0x, A0y);
		
	}
}