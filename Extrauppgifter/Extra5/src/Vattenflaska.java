package Extra2;

/**
 * Den här classen beskriver en vvattenflaska som kan tömas och fyllas.
 * @author Marcus Lund
 * amuulo-4@student.ltu.se
 * D0010E
 * 2015-02-01
 *
 */

public class Vattenflaska {
	
	/*
	 * Detta är klassen vattenflaska som innehåller tre globala parametrar så att samtliga metoder kan nyttja dessa.
	 * Classen innehåller också några metoder för att modifiera och skriva ut förändringarna.
	 */

	private static String ägare = "";
	private static int kapacitet = 0;
	private static int innehåll = 0;

	public Vattenflaska(String ägare, int kapacitet) {
		
		/*
		 * Construktorn som ansvarar för att samtliga objekt initieras.
		 */
		
		this.ägare = ägare;
		this.kapacitet = kapacitet;
		System.out.println("New object created! Ägaren är '" + ägare + "' med kapactiteten " + kapacitet + ".\n");

	}

	public static int innehåll() {
		
		/*
		 * Returnerar inehållet i flaskan.
		 */
		
		return innehåll;
	}
	
	public static int kapacitet() {
		
		/*
		 * Returnerar kapaciteten av flaskan.
		 */
		
		return kapacitet;
	}

	public static int fyllPå (int mängd) {
		
		/*
		 * Denna metod tillhandahåller funktionaliteten att öka volymen i flaskan.
		 */
		
		if (mängd + innehåll > kapacitet) {
			return innehåll = kapacitet;
		} else {
			return innehåll = innehåll + mängd;
		}
	}

	public static int tömUt(int mängd) {
		
		/*
		 * Likt "fyllPå" så kan metoden "tömUt" minska volymen i flasken.
		 */
		
		if (mängd >= innehåll) {
			return innehåll = 0;
		} else {
			return innehåll = innehåll - mängd;
		}
	}
	
	public String toString() {
		
		/*
		 * Denna metod genererar en sträng som kan skrivas ut med status om vilken ägaren är, innehållet och flaskans kapacitet.
		 */
		
		return ägare + "´s flaska kan innehålla max " + kapacitet + " och innehåller nu " + innehåll + " ml.";
	}
	
	public static void main (String[] args) {
		
		/*
		 * Main metoden används enbart för att testa funktionen av classen.
		 */
		
		Vattenflaska t = new Vattenflaska("Marcus", 1000);
		System.out.println(t.toString());
		t.fyllPå(1200);
		System.out.println(t.toString());
		t.tömUt(850);
		System.out.println(t.toString());
		t.tömUt(50);
		System.out.println(t.toString());
		t.fyllPå(9000);
		System.out.println(t.toString());
		t.tömUt(500000);
		System.out.println(t.toString());
	}
}