package ca.ece.ubc.cpen221.mp5;

import java.util.Map;
import java.util.Set;

// TODO: This class represents the Restaurant Database.
// Define the internal representation and
// state the rep invariant and the abstraction function.

public class RestaurantDB {

    /**
     * Create a database from the Yelp dataset given the names of three files:
     * <ul>
     * <li>One that contains data about the restaurants;</li>
     * <li>One that contains reviews of the restaurants;</li>
     * <li>One that contains information about the users that submitted reviews.
     * </li>
     * </ul>
     * The files contain data in JSON format.
     * 
     * @param restaurantJSONfilename
     *            the filename for the restaurant data
     * @param reviewsJSONfilename
     *            the filename for the reviews
     * @param usersJSONfilename
     *            the filename for the users
     */
    
    private Map<Restaurant, Set<Review>> restaurantMap;
    private Map<User, Set<Review>> userMap;
    
    public RestaurantDB(String restaurantJSONfilename,
            String reviewsJSONfilename, String usersJSONfilename) {
        // TODO: Implement this method
        // It's multithreaded
    }

    public Set<Restaurant> query(String queryString) {
        // TODO: Implement this method
        // this function needs to be threadsafe
        // Write specs, etc.
        
        // this method only handles grammatical queries
        return null;
    }
    
    private Review randomReview(String restaurantName){
        return null;
    }
    private Restaurant getRestaurant(String businessId){
        return null;
    }
    
    private String addRestaurant(String restaurantDetails){
        return null;
    }
    
    private String addUser(String userDetails){
        return null;  
    }

    private String addReview(String reviewDetails){
        return null;  
    }
}