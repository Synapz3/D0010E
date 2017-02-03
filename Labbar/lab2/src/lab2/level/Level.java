
package lab2.level;

import java.util.ArrayList;
import java.util.Observable;
import java.awt.Rectangle;


//EVERYTHING IS AWSOME!! AND IT LOOKS GREAT!
public class Level extends Observable {
    //We create a list to keep track of all the rooms
	public ArrayList<Room> rooms;
	private Room spawn;
	protected Room currentRoom;

    static enum directions{
    	up,down,left,right;
    }

    //Plces the a room in the level
    public boolean place(Room r, int x, int y) {
        //Creates a rectangle for the room, this is used in overlap check
    	Rectangle tmp_rect = new Rectangle(x,y,r.dx,r.dy);

        //Is the ArrayList empty?
    	if (rooms == null){
    		rooms = new ArrayList<Room>();
    	}
        //Is the room outside the map?
    	if (x < 0 || y < 0){
    		return false;
    	}
        //Check for overlap
    	for (Room room: rooms)
    	{
    		Rectangle tmp_rect2 = new Rectangle(room.posX,room.posY,room.dx,room.dy);
    		if(tmp_rect.intersects(tmp_rect2)){
    			return false;
    		}
    	}

        //Places the room
    	r.posX = x;
    	r.posY = y;
    	rooms.add(r);
        //Sets the room as placed
    	r.placed();
    	return true;
    }
    //Sets the spawn
    public void firstLocation(Room r) {
    	spawn = r;
    	currentRoom = spawn;
    }
    //Functions that are called to move the "player"
    public void moveRight(){
    	changeRoom(directions.right);
    }
    public void moveLeft(){
    	changeRoom(directions.left);
    }
    public void moveUp(){
    	changeRoom(directions.up);
    }
    public void moveDown(){ changeRoom(directions.down);}

    //Changes the current room if the current room has
    //a connection in the direction pressed
    private void changeRoom(directions d)
    {
    	switch(d){
    	case up:
    		if(currentRoom.NW_connection != null){
    			currentRoom = currentRoom.NW_connection;
    			setChanged();
    			notifyObservers();
    		}
    		break;
    	case down:
    		if(currentRoom.SW_connection != null){
    			currentRoom = currentRoom.SW_connection;
    			setChanged();
    			notifyObservers();
    		}
    		break;
    	case left:
    		if(currentRoom.WW_connection != null){
    			currentRoom = currentRoom.WW_connection;
    			setChanged();
    			notifyObservers();
    		}
    		break;
    	case right:
    		if(currentRoom.EW_connection != null){
    			currentRoom = currentRoom.EW_connection;
    			setChanged();
    			notifyObservers();
    		}
    		break;
    	}
    }
 

}