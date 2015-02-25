package bag;

/*
 * Av: Marcus Lund
 * TCDAA 2014
 * D0010E
 * 2015-02-08
 */

interface Weighable {
	public int weight();
}

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

public class bag<E> implements Weighable {
	
	E content;
	private boolean isEmpty = true;
	int weight = 0;
	
	public bag(){
		System.out.println("new bag!");
	}
	
	public int weight() {
		if (this.isEmpty) {
			return 0;                                                                                 
		}
		return this.weight;
	}
		  
	public void fillBagWith(E content, int weight) {
		if (!isEmpty) {
			System.out.println("The bag allready holds stuff!");
			return;
		}
		this.isEmpty = false;
		this.weight = weight;
		this.content = content;
	}
	
	public Pair<E,Integer> emptyBag() {
		int weight_reset = weight;
		E content_reset = content;
		content = null; this.weight = 0;
		this.isEmpty = true;
		return new Pair(content_reset, weight_reset);
}

	public static void main(String[] args) {		
		
		bag b1 = new bag();
		b1.fillBagWith(new Integer(11),100);
		b1.fillBagWith(new String("11ss"),100);
		System.out.println(b1.weight());
		System.out.println(b1.emptyBag());
		b1.fillBagWith(new String("11ss"),100);
		System.out.println(b1.emptyBag());
		System.out.println(b1.weight());

	}
}

