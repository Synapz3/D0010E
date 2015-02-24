package Extra13;

import java.util.Random;

/**
 * Created by Marcus Lund on 2015-02-24.
 * TCDAA
 * Bonus 13
 */
public class Shuffled <E> {

    private E[] arr;
    Random random;

    public Shuffled(E[] arr, long seed){
        this.arr = arr;
        random = new Random(seed);
    }

    public E[] next() {
        E[] newArr = arr.clone();
        for (int i = newArr.length-1; i > 0; i--){
            int k = random.nextInt(i);
            E nr1 = newArr[i];
            E nr2 = newArr[k];
            newArr[k] = nr1;
            newArr[i] = nr2;
            k--;
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Integer[] ia = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            ia[i] = array[i];
        }

        long t = System.currentTimeMillis();
        Shuffled<Integer> tal = new Shuffled<Integer>(ia, t);
        for (int i = 0; i < 1; i++){
            ia = tal.next();
            for (int x : ia) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

