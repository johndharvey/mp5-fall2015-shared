package ca.ece.ubc.cpen221.mp5;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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

    private Review randomReview(String restaurantName) {
        return null;
    }

    private Restaurant getRestaurant(String businessId) {
        return null;
    }

    /**
     * adds the restaurant specified by restaurantDetails to the database.
     * requires that restaurantDetails is properly formatted and the specified
     * restaurant isn't already in the database.
     * 
     * this isn't currently threadsafe. In order to make it threadsafe, we'll
     * have to make sure that if restaurants are being added, users and
     * restaurants being added are the only other activities happening
     * 
     * @param restaurantDetails
     *            a JSON-formatted string describing a restaurant
     * @return a JSON-formatted string describing the result of the attempt to
     *         add the restaurant
     */
    private String addRestaurant(String restaurantDetails) {
        try {
            Restaurant toAdd = new Restaurant(restaurantDetails);
            // TODO: refine this check
            if (restaurantMap.containsKey(toAdd))
                return "\"message\": \"the restaurant is already in the database.\"";
            else {
                restaurantMap.put(toAdd, Collections.emptySet());
                return "\"message\": \"the restaurant was successfully added.\"";
            }
        } catch (Exception e) { // this is meant to catch badly-formed
                                // restaurantDetails
            return "\"message\": \"the restaurant is incorrectly formatted or otherwise invalid.\"";
        }
    }

    /**
     * adds the user specified by restaurantDetails to the database. requires
     * that userDetails is properly formatted and the specified user isn't
     * already in the database.
     * 
     * this isn't currently threadsafe. In order to make it threadsafe, we'll
     * have to make sure that if users are being added, users and restaurants
     * being added are the only other activities happening
     * 
     * @param userDetails
     *            a JSON-formatted string describing a user
     * @return a JSON-formatted string describing the result of the attempt to
     *         add the user
     */
    private String addUser(String userDetails) {
        try {
            User toAdd = new User(userDetails);
            if (userMap.containsKey(toAdd)) // TODO: refine this check
                return "\"message\": \"the user is already in the database.\"";
            else {

                userMap.put(toAdd, Collections.emptySet());
                return "\"message\": \"the user was successfully added.\"";
            }
        } catch (Exception e) { // this is meant to catch badly-formed
                                // userDetails
            return "\"message\": \"the user is incorrectly formatted or otherwise invalid.\"";
        }
    }

    /**
     * adds the review specified by reviewDetails to the database. requires that
     * the review isn't already in the database, and that the user who wrote the
     * review and the restaurant the review is about are in the database.
     * 
     * * this isn't currently threadsafe. In order to make it threadsafe, we'll
     * have to make sure that only one review is being added to a user at a time
     * and that users and restaurants aren't being added to the database
     * 
     * @param reviewDetails
     *            a JSON-formatted string describing a review
     * @returna JSON-formatted string describing the result of the attempt to
     *          add the review
     */
    private String addReview(String reviewDetails) {
        Review toAdd = new Review(reviewDetails);

        String userId = toAdd.getUserId();
        String businessId = toAdd.getBusinessId();

        User reviewUser = null;
        Set<Review> userReviews = null;

        for (Map.Entry<User, Set<Review>> entry : userMap.entrySet()) {
            if (entry.getKey() != null
                    && entry.getKey().getUserId() == userId) {
                reviewUser = entry.getKey();
                userReviews = entry.getValue();
                if (userReviews.contains(toAdd))
                    return "\"message\": \"this review already exists in the database.\"";
                break;
            }
        }
        if (reviewUser == null)
            return "\"message\": \"the user who wrote this review is not in the database.\"";

        Restaurant reviewRestaurant = null;
        Set<Review> restaurantReviews = null;

        for (Map.Entry<Restaurant, Set<Review>> entry : restaurantMap
                .entrySet()) {
            if (entry.getKey() != null
                    && entry.getKey().getBusinessId() == businessId) {
                reviewRestaurant = entry.getKey();
                restaurantReviews = entry.getValue();
                if (restaurantReviews.contains(toAdd))
                    return "\"message\": \"this review already exists in the database.\"";
                break;
            }
        }
        if (reviewRestaurant == null)
            return "\"message\": \"the restaurant this review is about is not in the database.\"";

        userReviews.add(toAdd);
        userMap.remove(reviewUser);
        reviewUser.addReview(toAdd);
        userMap.put(reviewUser, userReviews);

        restaurantReviews.add(toAdd);
        restaurantMap.remove(reviewRestaurant);
        reviewRestaurant.addReview(toAdd);
        restaurantMap.put(reviewRestaurant, restaurantReviews);

        return "\"message\": \"the restaurant this review is about is not in the database.\"";
    }
}