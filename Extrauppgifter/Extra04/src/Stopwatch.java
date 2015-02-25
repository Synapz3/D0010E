package Extrauppgifter;

/*
 * Av: Marcus Lund
 * TCDAA
 * amuulo-4@student.ltu.se
 * D0010E
 * 2015-01-27
 */

public class Stopwatch {
	private long time;
	private long totTime = 0;
	private boolean amIrunning = false;

	public Stopwatch(){
		
		/*
		 * Detta �r en konstruktor. Den meddelar n�r ett objekt startas. 
		 */
		
		System.out.println("New object created!");
	}

	public void start(){
		
		/*
		 * Detta �r en start metod s� att objekten kan starta sina klockor.
		 */
		
		amIrunning = true;
		time = System.currentTimeMillis();
	}
	
	public boolean isStarted() {
		
		/*
		 * Denna metod returnerar true eller false berodende p� om klockan �r startad eller ej.
		 */
		
		if (amIrunning == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void stop() {
		
		/*
		 * Denna klass stoppar tillf�lligt r�knaren men tar inte bort den hittills registrerade tiden.
		 */
		
		amIrunning = false;
		totTime = (System.currentTimeMillis() - time) + totTime;
		time = System.currentTimeMillis();
	}
	
	public long time() {
		
		/*
		 * Denna metod returnerar hur l�ng tid klockan har varit aktiv.
		 */
		
		if (amIrunning == false) {
			return totTime;
		} else {
		return (System.currentTimeMillis() - time) + totTime;
		}
	}
	
	public void reset() {
		
		/*
		 * Denna metor nollst�ller klockan.
		 */
		
		time = System.currentTimeMillis();
		totTime = 0;
	}
	
	
	
	public static void main (String[] args){
		
		/*
		 * Main metoden skapar ett objekt och testar att k�ra den p� olika s�tt.
		 */
		
		double value = 0.999999d;
		
		Stopwatch t = new Stopwatch();
		
		t.start();
		
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.isStarted());
		System.out.println(t.time());
		
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.time());
		t.stop();
		
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.isStarted());
		System.out.println(t.time());
		
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.time());
		System.out.println(t.isStarted());
		t.start();
		System.out.println(t.isStarted());
		System.out.println(t.time());
		
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.time());
		t.stop();
		
		t.start();
		
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.isStarted());
		System.out.println(t.time());
		
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.time());
		t.stop();
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.isStarted());
		System.out.println(t.time());
		
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.time());
		System.out.println(t.isStarted());
		t.start();
		System.out.println(t.isStarted());
		System.out.println(t.time());
		
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.time());
		t.reset();
		while (Math.random() < value) {
			continue;
		}
		
		System.out.println(t.time());
		t.stop();
	}

}
