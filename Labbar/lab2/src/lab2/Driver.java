package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

//EVERYTHING IS AWSOME!! AND IT LOOKS GREAT!
public class Driver {

	//Creat the rooms
	Room room1;
	Room room2;
	Room room3;
	Room room4;
	Room room5;
	Room room6;
	Room room7;
	Room room8;
	Room room9;
	
    public void run() {
    	//NOTE YOU HAVE TO PLACE BEFORE YOU CONNECT TWO ROOMS
    	
    	//Initiates the rooms
    	room1 = new Room(100, 100, Color.red);
    	room2 = new Room(100, 100, Color.pink);
    	room3 = new Room(50, 36, Color.gray);
    	room4 = new Room(100, 100, Color.BLUE);
    	room5 = new Room(100, 100, new Color(76,179,12));
    	room6 = new Room(50, 36, new Color(28,123,232));
    	room7 = new Room(100, 100, new Color(232,178,28));
    	room8 = new Room(100, 100, Color.lightGray);
    	room9 = new Room(50, 36, Color.magenta);
    	
    	//Creates the level
    	Level map = new Level();
    	
    	//Places the rooms in the level.
        map.place(room1, 0, 0);
        map.place(room2, 100, 100);
        map.place(room3, 0, 120);
        map.place(room4, 200, 200);
        map.place(room5, 500, 350);
        map.place(room6, 350, 120);
        map.place(room7, 600, 0);
        map.place(room8, 600, 150);
        map.place(room9, 0, 400);
        
        //Sets the spawnpoint
        map.firstLocation(room1);
        
        
        //Defines the connections between the rooms
        room1.connectNorthTo(room9);
        room1.connectSouthTo(room2);
        room1.connectEastTo(room1);
    	room1.connectWestTo(room1);
    	
    	room2.connectSouthTo(room1);
    	room2.connectNorthTo(room3);
    	room2.connectEastTo(room6);
    	
    	room3.connectNorthTo(room1);
    	room3.connectEastTo(room2);
    	
    	room4.connectNorthTo(room9);
       	room4.connectWestTo(room8);
       	room4.connectEastTo(room7);
       	
       	room5.connectEastTo(room5);
       	room5.connectSouthTo(room4);
       	room5.connectWestTo(room9);
       	room5.connectNorthTo(room5);
       	
       	room6.connectNorthTo(room5);
       	room6.connectWestTo(room2);
       	
       	room7.connectWestTo(room1);
        room7.connectNorthTo(room9);
    	room7.connectSouthTo(room6);
    	room7.connectEastTo(room3);
    	
    	room8.connectNorthTo(room5);
    	room8.connectEastTo(room3);
    	room8.connectSouthTo(room1);
    	
    	room9.connectSouthTo(room1);
    	room9.connectEastTo(room5);
    	room9.connectWestTo(room7);
        
    	//Creates GUI and names it
        LevelGUI gui = new LevelGUI(map,"GET HIGH EVERY DAY");
    }

}