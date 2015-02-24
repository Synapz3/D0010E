package lab4;

/**
 * Created by Marcus Lund on 2015-02-17.
 */

import lab4.client.GomokuClient;
import lab4.data.GomokuGameState;
import lab4.gui.GomokuGUI;

/**
 * THe main method creates two Game Objects which is used to play one another
 */
public class GomokuMain {
    public static void main(String[] args) {

        if (args.length == 0) {
            args = new String[] {"4000", "4001"};
        }

        GomokuClient gomokuClient = new GomokuClient(Integer.parseInt(args[0]));
        GomokuGameState gomokuGameState = new GomokuGameState(gomokuClient);
        GomokuGUI GUI = new GomokuGUI(gomokuGameState, gomokuClient);

        GomokuClient gomokuClient2 = new GomokuClient(Integer.parseInt(args[1]));
        GomokuGameState gomokuGameState2 = new GomokuGameState(gomokuClient2);
        GomokuGUI GUI2 = new GomokuGUI(gomokuGameState2, gomokuClient2);
    }
}
