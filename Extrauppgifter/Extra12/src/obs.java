package Extra12;

import java.util.ArrayList;

/**
 * Created by Marcus Lund on 2015-02-24.
 * TCDAA
 * Bonus 12
 */
public class obs {
    public static void main(String[] args) {
        betraktad b = new betraktad();
        new Observatör(1, b);

        b.agera();
    }
}

class betraktad extends MyObservable {
    public void agera() {
        System.out.println("I Betraktad.");
        setChanged(); // ja, jag har "ändrats"
        notifyObservers(); // anropa update i alla tjuvkikare
    }
}

class Observatör implements MyObserver {
    private int nr = 0;

    public Observatör(int n, MyObservable obs) {
        nr = n;
        obs.addObserver(this);
    }

    public void update(MyObservable arg0, Object arg1) { // agera på ändring
        System.out.println("Hos Observatör " + nr);
    }
}

class MyObservable {

    private ArrayList<MyObserver> array = new ArrayList<MyObserver>();
    private boolean hasChanged = false;

    public void addObserver(MyObserver o) {
        array.add(o);
    }
    protected void clearChanged() {
        hasChanged = false;
    }
    public int countObservers() {
        return array.size();
    }
    public void deleteObserver(MyObserver o) {
        array.remove(o);
    }
    public void deleteObservers() {
        array.clear();
    }
    public boolean hasChanged() {
        return hasChanged;
    }
    public void notifyObservers() {
        for (MyObserver x : array){
            x.update(this, null);
        }
    }
    public void notifyObservers(Object arg) {
        for (MyObserver x : array){
            x.update(this, arg);
        }
    }
    protected void setChanged() {
        hasChanged = true;
    }
}
interface MyObserver {
    public void update(MyObservable o, Object arg);
}
