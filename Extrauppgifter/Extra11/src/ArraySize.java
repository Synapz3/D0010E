package ArraySize;

/**
 * Created by Marcus Lund on 2015-02-23.
 * TCDAA
 * Extrauppgift 10
 */



public class ArraySize {

    public static void main (String[] args){
        int[][][][] b = { // b är en 4D-array med de 10 testfallen
                null,
                { { {} } },
                { { {} }, { {} } },
                { null, null },
                { { null }, { null }, { null } },
                { { { 1, 2, 3 } } },
                { { { 1, 2, 3 }, { 1, 2, 3 } } },
                { { { 1, 2, 3 }, {}, { 1, 2, 3 }, null } },
                { { { 1, 2, 3 } }, {}, { { 1, 2, 3 } }, null },
                { { { 1 }, {}, { 2 }, { 3, 4 } }, {}, null,
                        { { 5, 6 }, {}, { 7 } } } };
        for (int i = 0; i < b.length; i++) {
            System.out.println("" + i + " : " + arraySize(b[i]));
        }
    }

    public static int arraySize(int[][][] a){
        int counter = 0;
        if (a == null) {
            return 0;
        }
        for (int x = 0; x < a.length; x++){
            if (a[x] == null){
                continue;
            }
            for (int y = 0; y <a[x].length; y++) {
                if (a[x][y] == null){
                    continue;
                }
                for (int z = 0; z < a[x][y].length; z++){
                        counter++;
                }
            }
        }
        return counter;
    }
}
