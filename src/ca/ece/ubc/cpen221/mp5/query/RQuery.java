package ca.ece.ubc.cpen221.mp5.query;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an ADT that represents a query given to the server. It contains
 * information about the various search options the user may have submitted.
 * 
 * @author Tim
 *
 */
public class RQuery {

    private final List<String> locations;
    private final List<String> categories;
    private final List<String> names;
    private final List<Integer> ratings;
    private final List<Integer> prices;

    /**
     * Rep Invariants: Each entry of ratings and prices must be in the range
     * 1-5, inclusive.
     */

    /**
     * Generates a new RQuery object with no entries.
     */
    public RQuery() {
        locations = new ArrayList<String>();
        categories = new ArrayList<String>();
        names = new ArrayList<String>();
        ratings = new ArrayList<Integer>();
        prices = new ArrayList<Integer>();
    }

    /**
     * Adds the passed location list to the query.
     * 
     * @param locations
     *            The locations to be added to the query.
     */
    public void addLocations(List<String> locations) {
        this.locations.addAll(locations);
    }

    /**
     * Adds the passed category list to the query.
     * 
     * @param categories
     *            The categories to be added to the query.
     */
    public void addCategories(List<String> categories) {
        this.categories.addAll(categories);
    }

    /**
     * Adds the passed name list to the query.
     * 
     * @param names
     *            The names to be added to the query.
     */
    public void addNames(List<String> names) {
        this.names.addAll(names);
    }

    /**
     * Adds the passed rating list to the query.
     * 
     * @param ratings
     *            The ratings to be added to the query. Each entry must be in
     *            the range 1-5 inclusive.
     */
    public void addRatings(List<Integer> ratings) {
        this.ratings.addAll(ratings);
    }

    /**
     * Adds the passed price list to the query.
     * 
     * @param prices
     *            The prices to be added to the query. Each entry must be in the
     *            range 1-5 inclusive.
     */
    public void addPrices(List<Integer> prices) {
        this.prices.addAll(prices);
    }

    /**
     * Returns whether or not the passed location string is contained in the
     * query.
     * 
     * @param location
     *            the location to be possibly located in the query
     * @return true if the query contains location, false otherwise
     */
    public boolean containsLocation(String location) {
        if (locations.contains(location))
            return true;
        else
            return false;
    }
    
    /**
     * Returns whether or not the passed category string is contained in the
     * query.
     * 
     * @param category
     *            the category to be possibly located in the query
     * @return true if the query contains category, false otherwise
     */
    public boolean containsCategory(String category) {
        if (categories.contains(category))
            return true;
        else
            return false;
    }
    
    /**
     * Returns whether or not the passed name string is contained in the
     * query.
     * 
     * @param name
     *            the name to be possibly located in the query
     * @return true if the query contains name, false otherwise
     */
    public boolean containsName(String name) {
        if (names.contains(name))
            return true;
        else
            return false;
    }
    
    /**
     * Returns whether or not the passed rating Integer is contained in the
     * query.
     * 
     * @param rating
     *            the rating to be possibly located in the query
     * @return true if the query contains rating, false otherwise
     */
    public boolean containsRating(Integer rating) {
        if (ratings.contains(rating))
            return true;
        else
            return false;
    }
    
    /**
     * Returns whether or not the passed price Integer is contained in the
     * query.
     * 
     * @param price
     *            the price to be possibly located in the query
     * @return true if the query contains price, false otherwise
     */
    public boolean containsPrice(Integer price) {
        if (prices.contains(price))
            return true;
        else
            return false;
    }

}
