
package lab4.data;

import java.util.Observable;
import java.util.Observer;
import lab4.client.GomokuClient;


/**
 * Represents the state of a game at any given time
 */
public class GomokuGameState extends Observable implements Observer{

    // Game variables
    private final int DEFAULT_SIZE = 15;
    private GameGrid gameGrid;

    //Possible game states
    private final int NOT_STARTED = 4;

    private int currentState = 4;
    private final int MY_TURN = 0;
    private final int OTHER_TURN = 1;
    private final int FINISHED = 2;

    private GomokuClient client;
    private String message;

    /**
     * The constructor of the GomokuGameState. It takes a client as an argument
     *
     * @param gc The client used to communicate with the other player
     */
    public GomokuGameState(GomokuClient gc){
        client = gc;
        client.addObserver(this);
        gc.setGameState(this);
        currentState = NOT_STARTED;
        gameGrid = new GameGrid(DEFAULT_SIZE);
    }


    /**
     * Returns the message string
     *
     * @return the message string
     */
    public String getMessageString(){
        return message;
    }

    /**
     * Returns the game grid
     *
     * @return the game grid
     */
    public GameGrid getGameGrid(){
        return gameGrid;
    }

    /**
     * The move method takes an x and y position and checks if it is the player´s turn. If it is, try to move to that location and update the the GUI through observers
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void move(int x, int y){
        if (currentState == MY_TURN) {
            message = "Opponents´s move.";
            if (gameGrid.move(x, y, gameGrid.ME)){
               if (gameGrid.isWinner(gameGrid.ME)) {
                   message = "Well played! You Win!";
                   currentState = FINISHED;
                   client.sendMoveMessage(x, y);
                } else {
                   client.sendMoveMessage(x, y);
                   currentState = OTHER_TURN;
               }
            } else {
                message = "The move could not be made.";
            }
        } else if ((currentState == FINISHED) ||(currentState == NOT_STARTED)) {
            message = "No active session, start a new game!!";
        } else {
            message = "It is not your turn yet.";
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Starts a new game with the current client and sets the correct "currentState"
     */
    public void newGame(){
        gameGrid.clearGrid();
        currentState = OTHER_TURN;
        message = "A new game started, wait your turn.";
        client.sendNewGameMessage();
        setChanged();
        notifyObservers();
    }

    /**
     * Other player has requested a new game, so the
     * game state is changed accordingly
     */
    public void receivedNewGame(){
        gameGrid.clearGrid();
        currentState = MY_TURN;
        message = "New game, your turn.";
        setChanged();
        notifyObservers();
    }

    /**
     * The connection to the other player is lost,
     * so the game is interrupted
     */
    public void otherGuyLeft(){
        gameGrid.clearGrid();
        currentState = NOT_STARTED;
        message = "Your opponent left the game.";
        setChanged();
        notifyObservers();
    }

    /**
     * The player disconnects from the client. Displays an appropriate message
     */
    public void disconnect(){

        gameGrid.clearGrid();
        currentState = NOT_STARTED;
        message = "You left the game!";
        client.disconnect();
        setChanged();
        notifyObservers();
    }

    /**
     * The player receives a move from the other player and updates the "curreentState" and displays the piece placed on the grid
     *
     * @param x The x coordinate of the move
     * @param y The y coordinate of the move
     */
    public void receivedMove(int x, int y){
        gameGrid.move(x, y, gameGrid.OTHER);
        currentState = MY_TURN;
        message = "Your move";
        if (gameGrid.isWinner(gameGrid.OTHER)) {
            message = "Opponent is the winner!";
            currentState = FINISHED;
            }
        setChanged();
        notifyObservers();
    }

    /**
     * An update method which updates the connection status between the players
     * (Provided with the code)
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg) {

        switch(client.getConnectionStatus()){
            case GomokuClient.CLIENT:
                message = "Game started, it is your turn!";
                currentState = MY_TURN;
                setChanged();
                notifyObservers();
                break;
            case GomokuClient.SERVER:
                message = "Game started, waiting for other player...";
                currentState = OTHER_TURN;
                setChanged();
                notifyObservers();
                break;
        }
        setChanged();
        notifyObservers();
    }
}