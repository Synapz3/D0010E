package lab4.gui;

import lab4.data.GameGrid;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 * A panel providing a graphical view of the game board
 */
public class GamePanel extends JPanel implements Observer{

	static int UNIT_SIZE = 20;
	private GameGrid grid;
	
	/**
	 * The constructor takes an argument "grid"
	 * 
	 * @param grid The grid that is to be displayed
	 */
	public GamePanel(GameGrid grid){
		this.grid = grid;
		grid.addObserver(this);
		Dimension d = new Dimension(grid.getSize()*UNIT_SIZE+1, grid.getSize()*UNIT_SIZE+1);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.setBackground(Color.lightGray);
	}

	/**
	 * Returns a grid position given pixel coordinates
	 * of the panel
	 * 
	 * @param x the x coordinates
	 * @param y the y coordinates
	 * @return an integer array containing the [x, y] grid position
	 */
	public int[] getGridPosition(int x, int y){
        int[] gridPosition = new int[2];
        gridPosition[0] = x/UNIT_SIZE;
        gridPosition[1] = y/UNIT_SIZE;

        return gridPosition;
    }

    /**
     *    Updates and repaint the grid with given moves
     */
	public void update(Observable arg0, Object arg1) {
        this.repaint();
	}

    /**
     * Paints the grid with black lines
     * Paints Ovals to show given moves
     * @param g
     */
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int gridSize = grid.getSize();

        //Draws lines ;)
        for ( int x = 0; x <= (gridSize * UNIT_SIZE); x = x + UNIT_SIZE) {
            g.drawLine(x, 0, x, UNIT_SIZE * gridSize);
        }
        for( int y = 0; y <= (gridSize * UNIT_SIZE); y = y + UNIT_SIZE){
            g.drawLine(0, y, (gridSize * UNIT_SIZE), y);
        }

        for (int x = 0; x < gridSize; x++){
            for(int y = 0; y < gridSize; y++){
                int GridLoc = grid.getLocation(x,y);

                //Paints the ME and CLIENT OVAL
                if(GridLoc == GameGrid.ME) {
                    g.setColor(Color.white);
                    g.fillOval(x * UNIT_SIZE, y * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                }

                if(GridLoc == GameGrid.OTHER) {
                    g.setColor(Color.black);
                    g.fillOval(x * UNIT_SIZE, y * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                }

                //Paints the border to ME and CLIENT
                if(GridLoc == GameGrid.ME) {
                    g.setColor(Color.black);
                    g.drawOval(x*UNIT_SIZE, y*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                }
                if(GridLoc == GameGrid.OTHER) {
                    g.setColor(Color.white);
                    g.drawOval(x*UNIT_SIZE, y*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                }
            }
        }
	}

}
