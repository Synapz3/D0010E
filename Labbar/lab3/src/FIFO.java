// Imports the necessary S#HIT.
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;


/*
 * Av: Marcus Lund
 * 911118-1153
 * D0010E
 * LAB 3
 */


/*
 * This is the class FIFO. It is a First-In-First-Out list.
 */
public class FIFO implements Queue{
	
	/*
	 * Defines local variables
	 */
	private Vector<Object> list = new Vector<Object>();
	private int maxValue = 0;
		
	/*
	 * Add method to ad an object and saves the biggest amount (value) of the Vector.
	 */
	@Override	
	public void add(Object arg0) {
		// TODO Auto-generated method stub
		list.add(arg0);
		if (maxValue < list.size()) {
			maxValue = list.size();
		}
	}

	/*
	 * This method returns the first object of the Vector. 
	 */
	@Override
	public Object first() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (list.isEmpty()) { 
			throw new NoSuchElementException(); 
		}
		else { 
			return list.firstElement(); 
		}
	}

	/*
	 * The method "isEmpty" returns a boolean (true or false) if the Vector "list" is empty.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	/*
	 * The method maxSize returns the maximum value of the length ever achieved by the Vector. 
	 */
	@Override
	public int maxSize() {
		// TODO Auto-generated method stub
		return maxValue;
	}

	/*
	 * This method removes the first object in the Vector "list" and move every value one step down. If the slot is empty an exception is thrown.
	 */
	@Override
	public void removeFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (!(list.isEmpty())) { 
			list.removeElementAt(0);

		} else {
			throw new NoSuchElementException();
		}
	}

	/*
	 * Returns the size of the FIFO list. 
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}
	
	/*
	 * The method "equals" returns true only and ONLY if the requirements are met. 
	 * It uses the "get" method defined above to return the list of the object f. Basically means if (list.equals(f.list));.
	 * If the requirements are NOT met, return false. 
	 */
	public boolean equals(Object f) {
		if (f instanceof FIFO){
			if (list.size() == ((FIFO)f).list.size()){
				for (int i = 0; i < size(); i++) {

					Object a = this.list.get(i);
					Object b = ((FIFO)f).list.get(i);
								
					if ((a == null) && (b != null)){
						return false;
					}
					if ((a != null) && (b == null)){
						return false;
					}
					if (a == null && b == null){
						continue;
					}
					if (!(a.equals(b))){
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	/*
	 * The shadowed method "toString" is defined in such a way that it is returning a sting of "Queue:" followed by the element of each object in the queue. 
	 */
	public String toString() {
		String r = "Queue: ";
		for (int i = 0; i < list.size(); i++){
			r += "(" + String.valueOf(list.elementAt(i)) + ") ";
		}
		return r;
	}
	
}

/*
 * This class is a GraphIO. It checks if everything is OK and adds the nodes and edges.
 */
class GraphIO{
	
	/*
	 * This is the method that checks errors that might need an IOException and adds the nodes and edges to g.
	 */
	static public void readFile(Graph g, String filename) throws IOException{
		
		/*
		 * Using a Try-Catch method in case an IOException occurs.
		 */
	    try {
	    	
	    	/*
	    	 * Variables, scanner and an array.
	    	 */
	    	int import_MAX;
	    	File file = new File("ml");
	        Scanner scanner = new Scanner(file);
	        //import_MAX is the number of rows to be defined as Nodes, the rest are edges.
	    	import_MAX = Integer.parseInt(scanner.nextLine());
	    	System.out.println(import_MAX);
	        String line;
	        String[] splitList;
	        
	        /*
	         * While the number of rows (currently red) is less than the number of nodes, this loop will read every line to be defined as a Node.
	         */
    	    for (int i = 0; i < import_MAX; i++){

    	    	line = scanner.nextLine();
    	    	splitList = line.split(" ");
    	    	if (!(splitList.length == 3)) {
    	    		throw new RuntimeException();
    	    	}
    	    	int id = Integer.parseInt(splitList[0]);
    	    	int x = Integer.parseInt(splitList[1]);
    	    	int y = Integer.parseInt(splitList[2]);
    	    	g.addNode(id, x, y);
    	    }
    	    
    	    /*
    	     * When all the Nodes are red, the Edges will be defined. This continues for the remainder of lines to be red.
    	     */
	        while (scanner.hasNextLine()) {
	        	line = scanner.nextLine();
    	    	splitList = line.split(" ");
    	    	if (!(splitList.length == 3)) {
    	    		throw new RuntimeException();
    	    	}
    	    	int id2 = Integer.parseInt(splitList[0]);
    	    	int x2 = Integer.parseInt(splitList[1]);
    	    	int y2 = Integer.parseInt(splitList[2]);
    	    	g.addEdge(id2, x2, y2);
	    	    }
	        // Closes the file after all the lines been red.
	        scanner.close();
	        /*
	         * If any IOException occurs, throw a new IOException.
	         */
	    } catch (IOException e) {
	        throw new IOException(e);
	    }
	}
	// Done and done! Exiting the program! 
	//Until next time! :D
}
