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
		 * Detta är en konstruktor. Den meddelar när ett objekt startas. 
		 */
		
		System.out.println("New object created!");
	}

	public void start(){
		
		/*
		 * Detta är en start metod så att objekten kan starta sina klockor.
		 */
		
		amIrunning = true;
		time = System.currentTimeMillis();
	}
	
	public boolean isStarted() {
		
		/*
		 * Denna metod returnerar true eller false berodende på om klockan är startad eller ej.
		 */
		
		if (amIrunning == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void stop() {
		
		/*
		 * Denna klass stoppar tillfälligt räknaren men tar inte bort den hittills registrerade tiden.
		 */
		
		amIrunning = false;
		totTime = (System.currentTimeMillis() - time) + totTime;
		time = System.currentTimeMillis();
	}
	
	public long time() {
		
		/*
		 * Denna metod returnerar hur lång tid klockan har varit aktiv.
		 */
		
		if (amIrunning == false) {
			return totTime;
		} else {
		return (System.currentTimeMillis() - time) + totTime;
		}
	}
	
	public void reset() {
		
		/*
		 * Denna metor nollställer klockan.
		 */
		
		time = System.currentTimeMillis();
		totTime = 0;
	}
	
	
	
	public static void main (String[] args){
		
		/*
		 * Main metoden skapar ett objekt och testar att köra den på olika sätt.
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
