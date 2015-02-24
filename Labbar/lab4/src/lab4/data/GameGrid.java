package lab4.data;

import java.util.Observable;

/**
 * The class file which holds the constructor and methods for the gameGrid
 */
public class GameGrid extends Observable {


    public static final int EMPTY = 0;
    public static final int ME = 1;
    public static final int OTHER = 2;
    private int[][] gameGrid;
    private static final int INROW = 5;


    /**
     * The constructor takes an argument (size) witch will be the size of the grid system and creates the object gameGrid
     *
     * @param size The width/height of the game grid
     */
    public GameGrid(int size) {
        int[][] gameGrid = new int[size][size];
        for (int[] x : gameGrid) {
            for (int y : x) {
                y = 0;
            }
        }
        this.gameGrid = gameGrid;
    }

    /**
     * Reads a location of the grid and returns the value for that position (ME, EMPTY or CLIENT)
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @return the value of the specified location
     */
    public int getLocation(int x, int y) {
        int z = gameGrid[x][y];
        if (z == ME) {
            return ME;
        } else if (z == OTHER) {
            return OTHER;
        } else {
            return EMPTY;
        }
    }

    /**
     * Returns the size of the grid
     *
     * @return the grid size
     */
    public int getSize() {
        return gameGrid.length;
    }

    /**
     * If the requested position is EMPTY, assign the position to the player and return true
     *
     * @param x      the x position
     * @param y      the y position
     * @param player
     * @return true if the insertion worked, false otherwise
     */
    public boolean move(int x, int y, int player) {
        if (getLocation(x, y) == EMPTY) {
            gameGrid[x][y] = player;
            setChanged();
            notifyObservers();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Clears the grid. Default value = 0 (EMPTY)
     */
    public void clearGrid() {
        for (int x = 0; x < gameGrid.length; x++) {
            for (int y = 0; y < gameGrid.length; y++) {
                gameGrid[x][y] = EMPTY;
            }

        }
        setChanged();
        notifyObservers();
    }

    /**
     * Check if a player has 5 in row horizontally, vertically or in a straight line diagonally.
     *
     * @param player the player to check for
     * @return true if player has 5 in row, false otherwise
     */
    public boolean isWinner(int player) {
        if (isWinner_RIGHT_DOWN(player)) {
            return true;
        }

        if (isWinner_RIGHT_UP(player)) {
            return true;
        }

        if (isWinner_Vertical(player)){
            return true;
        }

        if (isWinner_Horizontal(player)){
            return true;
        }

        return false;
    }

    /**
     * Helpmethod to isWinner. To keep things clean.
     *
     * @param player
     * @return true if player has 5 in row, false otherwise
     */
    private boolean isWinner_Vertical(int player) {

        int counter = 0;
        for (int x = 0; x < gameGrid.length; x++){
            for (int y = 0; y < gameGrid.length; y++){
                if (getLocation(x,y) == player) {
                   counter++;
                    if (counter == INROW){
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }
    return false;
    }

    /**
     * Helpmethod to isWinner. To keep things clean.
     *
     * @param player
     * @return true if player has 5 in row, false otherwise
     */
    private boolean isWinner_Horizontal(int player) {

        int counter = 0;
        for (int y = 0; y < gameGrid.length; y++) {
            for (int x = 0; x < gameGrid.length; x++) {
                if (getLocation(x, y) == player) {
                    counter++;
                    if (counter == INROW) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    /**
     * Helpmethod to isWinner. To keep things clean.
     *
     * @param player
     * @return true if player has 5 in row, false otherwise
     */
    private boolean isWinner_RIGHT_DOWN(int player){

        int counter = 0;
        for (int x = 0; x < gameGrid.length; x++) {
            for (int y = 0; y < gameGrid.length; y++) {

                for (int c = x, u = y; c < gameGrid.length && u < gameGrid.length; c++, u++) {
                    if (getLocation(c, u) == player) {
                        counter++;
                        if (counter >= INROW) {
                            return true;
                        }
                    } else {
                        counter = 0;
                    }
                }
                counter = 0;
            }
            counter = 0;
        }
        return false;
    }

    /**
     * Helpmethod to isWinner. To keep things clean.
     *
     * @param player
     * @return true if player has 5 in row, false otherwise
     */
    private boolean isWinner_RIGHT_UP(int player){

        int counter = 0;
        for (int x = 1; x < gameGrid.length; x++) {
            for (int y = 0; y < gameGrid.length; y++) {

                for (int c = x, u = y; c > 0 && u < gameGrid.length; c--, u++) {
                    if (getLocation(c, u) == player) {
                        counter++;
                        if (counter >= INROW) {
                            return true;
                        }
                    } else {
                        counter = 0;
                    }
                }
                counter = 0;
            }
            counter = 0;
        }
        return false;
    }
}
