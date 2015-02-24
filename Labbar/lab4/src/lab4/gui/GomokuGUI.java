package lab4.gui;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import lab4.data.GomokuGameState;
import lab4.client.GomokuClient;
import lab4.data.GameGrid;
import java.awt.*;
import javax.swing.*;

/**
 * GomokuGUI Create the layout and decide function
 */
public class GomokuGUI implements Observer {

	static int nrGUIs = 0;
    private GomokuClient client;
	private GomokuGameState gamestate;
    private JButton connectButton, newGameButton, disconnectButton;
    private JLabel messageLabel;

    /**
	 * The constructor
	 * Creates buttons and creates anonymous actionlistener for each button
     * Packs Buttons and grid in the frame in relation to each other
	 * @param g   The game state that the GUI will visualize
	 * @param c   The client that is responsible for the communication
	 */
	public GomokuGUI(GomokuGameState g, GomokuClient c){
		this.client = c;
		this.gamestate = g;
		client.addObserver(this);
		gamestate.addObserver(this);
        // Skapa ett fönster som innehåller spelet
        nrGUIs ++;
        JFrame window = new JFrame("Gomoku Game Client"+nrGUIs);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Gör fönstret till en behållare
        Container contentPane;
        contentPane = window.getContentPane();
        contentPane.setBackground(Color.WHITE);

        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        // Skapa Spelets rutor och lägg i fönstret
        GameGrid gameg = g.getGameGrid();
        gameg.clearGrid();
        final GamePanel gameGridPanel = new GamePanel(gameg);
        gameGridPanel.addMouseListener(new MouseAdapter() {  // Anon Class
            public void mouseReleased(MouseEvent e) {
                // e.getX returns x,y position at which the event occurred, relative to the component that fired the event.
                int[] result = gameGridPanel.getGridPosition(e.getX(), e.getY());
                gamestate.move(result[0], result[1]);
            }
        });

        // Skapar 3 knappar till spelet
        connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               ConnectionWindow conWin = new ConnectionWindow(client);

            }
        });

        newGameButton = new JButton("New game");
        newGameButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                gamestate.newGame();
            }
        });

        disconnectButton = new JButton("Disconnect");
        disconnectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                gamestate.disconnect();
            }
        });

        contentPane.add(gameGridPanel);
        contentPane.add(connectButton);
        contentPane.add(newGameButton);
        contentPane.add(disconnectButton);

        // Gör Disconnect och New Game obrukbara innan connection
        newGameButton.setEnabled(false);
        disconnectButton.setEnabled(false);

        // Litet meddelande
        messageLabel = new JLabel("GoooooGomoku!");
        contentPane.add(messageLabel);

        // bygg upp layouten
        // X 	                    Edge of		  object	   	distance anchors to EDGE of object.
        layout.putConstraint(SpringLayout.WEST,  gameGridPanel,     5, SpringLayout.WEST,  contentPane);
        layout.putConstraint(SpringLayout.NORTH, gameGridPanel,		5, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST,  connectButton, 	5, SpringLayout.WEST,  contentPane);
        layout.putConstraint(SpringLayout.NORTH, connectButton,		5, SpringLayout.SOUTH, gameGridPanel);

        layout.putConstraint(SpringLayout.WEST,  newGameButton, 	5, SpringLayout.EAST,  connectButton);
        layout.putConstraint(SpringLayout.NORTH, newGameButton, 	0, SpringLayout.NORTH, connectButton);

        layout.putConstraint(SpringLayout.WEST,  disconnectButton, 	5, SpringLayout.EAST,  newGameButton);
        layout.putConstraint(SpringLayout.NORTH, disconnectButton, 	0, SpringLayout.NORTH, connectButton);

        layout.putConstraint(SpringLayout.NORTH, messageLabel, 		5, SpringLayout.SOUTH, connectButton);
        layout.putConstraint(SpringLayout.WEST,  messageLabel, 		5, SpringLayout.WEST,  connectButton);

        //window.pack();
        window.setSize(500,500);
        window.setVisible(true);
	}

    /**
     * Update for the files provided.
     *
     * @param arg0
     * @param arg1
     */
	public void update(Observable arg0, Object arg1) {
		
		// Update the buttons if the connection status has changed
		if(arg0 == client){
			if(client.getConnectionStatus() == GomokuClient.UNCONNECTED){
				connectButton.setEnabled(true);
				newGameButton.setEnabled(false);
				disconnectButton.setEnabled(false);
			}else{
				connectButton.setEnabled(false);
				newGameButton.setEnabled(true);
				disconnectButton.setEnabled(true);
			}
		}
		
		// Update the status text if the gamestate has changed
		if(arg0 == gamestate){
			messageLabel.setText(gamestate.getMessageString());
		}
	}
}
