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
     * 
     * @param location
     *            the location 
     * @return true if the query contains location, false otherwise
     */
    public boolean containsLocation(String location) {
        if (locations.contains(location))
            return true;
        else
            return false;
    }

}
