
package lab2.level;

//inports the nessesary S#it...
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


//EVERYTHING IS AWSOME!! AND IT LOOKS GREAT!
public class LevelGUI implements Observer {
    private Level lv;
    private Display d;
    private RoomToDraw rooms[];
    private int ScreenResX = 0;
    private int ScreenResY = 0;
    public LevelGUI(Level level, String name) {
    	
        this.lv = level;
        rooms = new RoomToDraw[lv.rooms.size()];
        
        //Setting the size of the display acording to the size of the level
        //We do this by checking for the greatest x and y amongst the rooms
        for(int i = 0;i<rooms.length;i++){
        	rooms[i] = new RoomToDraw(lv.rooms.get(i),i);
        	if(lv.rooms.get(i).posX+lv.rooms.get(i).dx > ScreenResX){
        		ScreenResX = lv.rooms.get(i).posX+lv.rooms.get(i).dx;
        	}
        	if(lv.rooms.get(i).posY+lv.rooms.get(i).dy > ScreenResY){
        		ScreenResY = lv.rooms.get(i).posY+lv.rooms.get(i).dy;
        	}
        }
        
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO: You should change 200 to a value
        // depending on the size of the level
        d = new Display(lv,ScreenResX,ScreenResY);

        frame.getContentPane().add(d);
        frame.pack();
        frame.setLocation(0,0);
        frame.setVisible(true);
        
        lv.addObserver(this);
    }

    //Update is called when buttons are pressed
    public void update(Observable arg0, Object arg1) {
    	d.repaint();
    }
    private class Display extends JPanel {

    	//Creates a new Display for the window
        public Display(Level fp, int x, int y) {
            addKeyListener(new Listener());

            setBackground(Color.GREEN);
            setPreferredSize(new Dimension(x+20,y+20));
            setFocusable(true);
        }



        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            //Draws every room including passegase
            for (RoomToDraw room : rooms){
            	room.Draw(g);
            }
            
            //Draws the player as a cube
            g.setColor(Color.green);
            g.fillRect(lv.currentRoom.posX+lv.currentRoom.dx/2-10, lv.currentRoom.posY+lv.currentRoom.dy/2-10, 20, 20);
            g.setColor(Color.black);
            g.drawRect(lv.currentRoom.posX+lv.currentRoom.dx/2-10, lv.currentRoom.posY+lv.currentRoom.dy/2-10, 20, 20);
        }
        
        //Our listener that checks for buttonpresses on the aswd keys
        private class Listener implements KeyListener{
            public void keyPressed(KeyEvent arg0) {
            	if (arg0.getKeyCode() == KeyEvent.VK_W) {
            		lv.moveUp();
            	} else if (arg0.getKeyCode() == KeyEvent.VK_S ) {
            		lv.moveDown();
            	} else if (arg0.getKeyCode() == KeyEvent.VK_A) {
            		lv.moveLeft();
            	} else if (arg0.getKeyCode() == KeyEvent.VK_D) {
            		lv.moveRight();
            	}
            }

            public void keyReleased(KeyEvent arg0) {

            }

            public void keyTyped(KeyEvent event) {

            }
        }

    }
    public class RoomToDraw{
    	// Creates a room to be drawn.
    	private JLabel Labels[];
    	private String number;
    	private Rectangle Rects[];
    	private Room room;
    	
    	//Creates an extended version of each room with numbers and rectangles assigned to 
    	//represent the pathway
    	RoomToDraw(Room r, int i){
    		
    		number = String.valueOf(i+1); // the boxnumber + 1 to get the boxes to count 1,2,3,4.....
    		Labels = new JLabel[4]; //Creates an array for the door numbers
    		Rects = new Rectangle[4];	//Creates an array of rectangles for the "doors"
    		room = r; //a room
    		
    		//If the connection exists draw rectangle and destination
    		//For the North connection
    		if(room.NW_connection != null){
    			Rects[0] = new Rectangle(room.posX+room.dx/2-5,room.posY,10,10);
            	Labels[0] = new JLabel(String.valueOf(lv.rooms.indexOf(room.NW_connection)+1));
            	Labels[0].setFont(new Font("Verdana",1,20));
            	Labels[0].setLocation(Rects[0].x+Rects[0].width/2-2, Rects[0].y+Rects[0].height/2+4);
            	
            }
    		//For the South connection
            if(room.SW_connection != null){
            	
            	Rects[2] = new Rectangle(room.posX+room.dx/2-5, room.posY+room.dy-11,10,10);
            	Labels[2] = new JLabel(String.valueOf(lv.rooms.indexOf(room.SW_connection)+1));
            	Labels[2].setFont(new Font("Verdana",1,20));
            	Labels[2].setLocation(Rects[2].x+Rects[2].width/2-2, Rects[2].y+Rects[2].height/2+4);
            	
            }
          //For the East connection
            if(room.EW_connection != null){
            	Rects[1] = new Rectangle(room.posX+room.dx-11, room.posY+room.dy/2-5,10,10);
            	Labels[1] = new JLabel(String.valueOf(lv.rooms.indexOf(room.EW_connection)+1));
            	Labels[1].setFont(new Font("Verdana",1,20));
            	Labels[1].setLocation(Rects[1].x+Rects[1].width/2-2, Rects[1].y+Rects[1].height/2+4);
            	
            }
          //For the West connection
            if(room.WW_connection != null){
            	Rects[3] = new Rectangle(room.posX,room.posY+room.dy/2-5,10,10);
            	Labels[3] = new JLabel(String.valueOf(lv.rooms.indexOf(room.WW_connection)+1));
            	Labels[3].setFont(new Font("Verdana",1,20));
            	Labels[3].setLocation(Rects[3].x+Rects[3].width/2-2, Rects[3].y+Rects[3].height/2+4);
            	
            }
    		
    	}
    	void Draw(Graphics g){
    		//Drawing the room
    		g.setColor(room.colorRoom);
            g.fillRect(room.posX, room.posY, room.dx, room.dy);
            
            //Drawing the boxes for the connections
            for (int i=0;i<Rects.length;i++){
            	// If the connection is oneWay we will only draw one line.
            	boolean oneWay = true;
            	if(Rects[i] == null)
            		continue;
            	switch (i){
            		case 0:
            			g.setColor(room.NW_connection.colorRoom);
            			//Checks if the connected room has a connection back to this room
            			for (Room r: room.NW_connection.connections){
            				if(r == room)
            					oneWay = false;
            			}	
            			break;
            		case 1:
            			g.setColor(room.EW_connection.colorRoom);
            			for (Room r: room.EW_connection.connections){
            				if(r == room)
            					oneWay = false;
            			}
            			break;
            		case 2:
            			g.setColor(room.SW_connection.colorRoom);
            			for (Room r: room.SW_connection.connections){
            				if(r == room)
            					oneWay = false;
            			}
            			break;
            		case 3:
            			g.setColor(room.WW_connection.colorRoom);
            			for (Room r: room.WW_connection.connections){
            				if(r == room)
            					oneWay = false;
            			}
            			break;
            	}
            	//Draws the connection boxes
            	g.fillRect(Rects[i].x, Rects[i].y, Rects[i].width, Rects[i].height);
            	g.setColor(Color.black);
            	g.drawRect(Rects[i].x, Rects[i].y, Rects[i].width, Rects[i].height);
            	//Draws one line if oneway connection, otherwise two lines will be drawn
            	if (oneWay){
            		g.setColor(Color.white);
            		g.drawRect(Rects[i].x, Rects[i].y, Rects[i].width/10, Rects[i].height);
            	}
            	else{
            		g.setColor(Color.white);
            		g.drawRect(Rects[i].x, Rects[i].y, Rects[i].width/10, Rects[i].height);
            		g.drawRect(Rects[i].x+Rects[i].width, Rects[i].y, Rects[i].width/10, Rects[i].height);
            	}
            	
            }
            
            //Drawing the number for for each room
            Font font = new Font("TimesRoman",Font.PLAIN,20);
            g.setFont(font);
            FontMetrics font_m = g.getFontMetrics();
            g.setColor(Color.BLACK);
            g.drawString(number,room.posX+room.dx/2-font_m.stringWidth(number)/2, room.posY+(room.dy/2)+(font_m.getHeight()/4)); //Split by 4 for some reason....
            
            //Drawing the numbers for each connection box
            g.setColor(Color.WHITE); 
            font = new Font("TimesRoman",Font.PLAIN,10);
            g.setFont(font);
            for(int i=0;i<Labels.length;i++){
            	if (Labels[i] == null){
            		continue;
            	}
            	g.drawString(Labels[i].getText(), Labels[i].getX(), Labels[i].getY());
            }
    	}
    }
    
}
