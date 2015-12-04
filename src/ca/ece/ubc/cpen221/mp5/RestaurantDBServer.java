package ca.ece.ubc.cpen221.mp5;

import java.util.Queue;
import java.util.Set;

// TODO: Implement a server that will instantiate a database, 
// process queries concurrently, etc.

public class RestaurantDBServer {
    
    private RestaurantDB database;
    private Queue<String> queryQueue;
    
    /**
     * Constructor
     * 
     * @param port
     * @param restaurants
     * @param reviews
     * @param users
     */
    
	public RestaurantDBServer(int port, String restaurants, String reviews, String useres) {
		// TODO: See the problem statement for what the arguments are.
		// TODO: Rename the arguments suitably.
	    
	    // call restaurantDB and create a database
	    
	    // queries get shoved into a queue (linked list?) by producers
	    // queries are removed and processed one-by-one by consumers
	    //     a command query cannot be running while a request query is running
	    // the number of producers and consumers are constants
	    // 
	}
	
	private String toJSON(Set<Restaurant> restaurants){
        return null;
	}
}
