package Extra2;

/**
 * Den h�r classen beskriver en vvattenflaska som kan t�mas och fyllas.
 * @author Marcus Lund
 * amuulo-4@student.ltu.se
 * D0010E
 * 2015-02-01
 *
 */

public class Vattenflaska {
	
	/*
	 * Detta �r klassen vattenflaska som inneh�ller tre globala parametrar s� att samtliga metoder kan nyttja dessa.
	 * Classen inneh�ller ocks� n�gra metoder f�r att modifiera och skriva ut f�r�ndringarna.
	 */

	private static String �gare = "";
	private static int kapacitet = 0;
	private static int inneh�ll = 0;

	public Vattenflaska(String �gare, int kapacitet) {
		
		/*
		 * Construktorn som ansvarar f�r att samtliga objekt initieras.
		 */
		
		this.�gare = �gare;
		this.kapacitet = kapacitet;
		System.out.println("New object created! �garen �r '" + �gare + "' med kapactiteten " + kapacitet + ".\n");

	}

	public static int inneh�ll() {
		
		/*
		 * Returnerar ineh�llet i flaskan.
		 */
		
		return inneh�ll;
	}
	
	public static int kapacitet() {
		
		/*
		 * Returnerar kapaciteten av flaskan.
		 */
		
		return kapacitet;
	}

	public static int fyllP� (int m�ngd) {
		
		/*
		 * Denna metod tillhandah�ller funktionaliteten att �ka volymen i flaskan.
		 */
		
		if (m�ngd + inneh�ll > kapacitet) {
			return inneh�ll = kapacitet;
		} else {
			return inneh�ll = inneh�ll + m�ngd;
		}
	}

	public static int t�mUt(int m�ngd) {
		
		/*
		 * Likt "fyllP�" s� kan metoden "t�mUt" minska volymen i flasken.
		 */
		
		if (m�ngd >= inneh�ll) {
			return inneh�ll = 0;
		} else {
			return inneh�ll = inneh�ll - m�ngd;
		}
	}
	
	public String toString() {
		
		/*
		 * Denna metod genererar en str�ng som kan skrivas ut med status om vilken �garen �r, inneh�llet och flaskans kapacitet.
		 */
		
		return �gare + "�s flaska kan inneh�lla max " + kapacitet + " och inneh�ller nu " + inneh�ll + " ml.";
	}
	
	public static void main (String[] args) {
		
		/*
		 * Main metoden anv�nds enbart f�r att testa funktionen av classen.
		 */
		
		Vattenflaska t = new Vattenflaska("Marcus", 1000);
		System.out.println(t.toString());
		t.fyllP�(1200);
		System.out.println(t.toString());
		t.t�mUt(850);
		System.out.println(t.toString());
		t.t�mUt(50);
		System.out.println(t.toString());
		t.fyllP�(9000);
		System.out.println(t.toString());
		t.t�mUt(500000);
		System.out.println(t.toString());
	}
}