D0010E Objektorienterad programmering och design, Lp 3, V15

package l03.helicopter;

public class Helicopter {
	private String callSign = "";
	private long rtX = 0L, rtY = 0L;
	private double distanceFlown = 0.0d;
	boolean on = false;

	public Helicopter(String name) {
		callSign = name;
	}

	public void flyTo(long x, long y) {
		double dx = Math.abs(x - rtX);
		double dy = Math.abs(y - rtY);
		distanceFlown += 
			Math.sqrt(dx * dx + dy * dy);
		rtX = x;
		rtY = y;
	}

	public String callSign() {
		return callSign;
	}
	
	public long getX() {
		return rtX;
	}

	public long getY() {
		return rtY;
	}

	public double distanceFlown() {
		return distanceFlown;
	}
	
	public void turnOn() {
		on = true;	
	}
	
	public void turnoff() {
		on = false;
	}
	
	public boolean lightIsOn() {
		return on;
	}
}