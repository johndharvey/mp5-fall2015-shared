package ca.ece.ubc.cpen221.mp5;

// TODO: Use this class to represent a restaurant.
// State the rep invariant and abs

/* 
 * rep:
 * type must be "restaurant"
 * longitude must be [-180, 180]
 * latitude must be [-90, 90]
 * stars must be [0,5]
 * reviewCount must be [0, infty)
 * price must be [0, 5]
 * and more
 */

public class Restaurant {
    
    private boolean open;
    private String url; // should we use URL?
    private double longtitude; // acceptable values
    private String[] nhoods;
    private String businessId;
    private String name;
    private String[] categories; 
    private String state; // TODO standardize state naming scheme
    private String type; //TODO acceptable types
    private double stars; // TODO this should be bounded
    private String city; 
    private String fullAddress;
    private int reviewCount; // must be geq 0
    private String photoUrl; // should we use URL?
    private String[] schools; 
    private double latitude;
    private int price; // acceptable values
    
    public Restaurant(){
        
    }
}
