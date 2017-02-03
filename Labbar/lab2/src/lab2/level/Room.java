
package lab2.level;

import java.awt.Color;

//EVERYTHING IS AWSOME!! AND IT LOOKS GREAT!
public class Room {
	
	// Defines the relations to the room.	
	Room WW_connection = null;
	Room EW_connection = null;
	Room NW_connection = null;
	Room SW_connection = null;
	Room[] connections;
	// Defines the size of the room.
	int dx = 0;
	int dy = 0;
	//Defines the position on the level. This is assigned in "Level.java"
	int posX;
	int posY;
	Color colorRoom;
	// Is the room placed?
	protected boolean isPlaced = false;
	// We might add coridor color, depending on type of connection. ;)
	//Yes we did #03-02-15

	//Creates a new room 
    public Room(int dx, int dy, Color color) {
    	this.dx = dx; 
    	this.dy = dy;
    	colorRoom = color;
    	connections = new Room[4];
    }
    
    //Sets up a connection for North wall
    public void connectNorthTo(Room r) {
    	//Checks if the rooms or the connected room isn't placed
    	if(!r.isPlaced || !isPlaced)
    		return;
    	if (r == this) {
    		return;
    	}
    	NW_connection = r;
    	connections[0] = r;
    }
  //Sets up a connection for East wall
    public void connectEastTo(Room r) {
    	if(!r.isPlaced || !isPlaced)
    		return;
    	if (r == this) {
    		return;
    	}
    	EW_connection = r;
    	connections[1] = r;
    }
  //Sets up a connection for South wall
    public void connectSouthTo(Room r) {
    	if(!r.isPlaced || !isPlaced)
    		return;
    	if (r == this) {
    		return;
    	}
    	SW_connection = r;
    	connections[2] = r;
    }
  //Sets up a connection for West wall
    public void connectWestTo(Room r) {
    	if(!r.isPlaced || !isPlaced)
    		return;
    	if (r == this) {
    		return;
    	}
    	WW_connection = r;
    	connections[3] = r;
    }
    // If the room is to be placed, change the value to true.
    void placed(){
    	isPlaced = true;
    }
}