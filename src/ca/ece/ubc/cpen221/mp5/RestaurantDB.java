package ca.ece.ubc.cpen221.mp5;

import java.util.HashMap;
import java.util.HashSet;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
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

    private Map<Restaurant, HashSet<Review>> restaurantMap;
    private Map<User, HashSet<Review>> userMap;

    public RestaurantDB(String restaurantsJSONfilename,
            String reviewsJSONfilename, String usersJSONfilename) {

        restaurantMap = new HashMap<Restaurant, HashSet<Review>>();
        userMap = new HashMap<User, HashSet<Review>>();

        String line = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(restaurantsJSONfilename));
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(addRestaurant(line));
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(usersJSONfilename));
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(addUser(line));
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(reviewsJSONfilename));
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(addReview(line));
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<Restaurant> query(String queryString) {
        // TODO: Implement this method
        // this function needs to be threadsafe
        // Write specs, etc.

        // this method only handles grammatical queries
        return null;
    }

    /**
     * returns a random review for the specified restaurant.
     * 
     * this method is threadsafe: while it's being checked whether or not the
     * restaurant is in the database, the set of restaurants is locked. once
     * it's been established that the restaurant is in the database, the
     * restaurant and its associated reviews are locked.
     * 
     * @param restaurantName
     *            a restaurant. Must be in the database, must have at least one
     *            review.
     * @return a random review of the specified restaurant.
     */
    public Review randomReview(String restaurantName) {
        Restaurant specifiedRestaurant = null;

        synchronized (restaurantMap) {
            for (Entry<Restaurant, HashSet<Review>> entry : restaurantMap
                    .entrySet()) {
                if (entry.getKey() != null
                        && entry.getKey().getName().equals(restaurantName)) {
                    specifiedRestaurant = entry.getKey();
                    break;
                }
            }
        }

        if (specifiedRestaurant == null)
            return null;

        synchronized (specifiedRestaurant) {
            synchronized (restaurantMap.get(specifiedRestaurant)) {
                int size = restaurantMap.get(specifiedRestaurant).size();
                int rand = new Random().nextInt(size);
                int i = 0;
                for (Review rev : restaurantMap.get(specifiedRestaurant)) {
                    if (i == rand)
                        return rev;
                    i++;
                }
            }
        }
        return null;
    }

    /**
     * returns the restaurant in the database with the matching businessId
     * 
     * @param businessId
     *            the ID of a restaurant. Must correspond to a restaurant in the
     *            database.
     * @return a restaurant with a business ID which matches businessId.
     */
    public Restaurant getRestaurant(String businessId) {
        synchronized (restaurantMap) {
            for (Entry<Restaurant, HashSet<Review>> entry : restaurantMap
                    .entrySet()) {
                if (entry.getKey() != null
                        && entry.getKey().getBusinessId().equals(businessId)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    /**
     * adds the restaurant specified by restaurantDetails to the database.
     * requires that restaurantDetails is properly formatted and the specified
     * restaurant isn't already in the database.
     * 
     * this is threadsafe: restaurantMap is the lock. Reviews cannot be added
     * while this operation is running (although users can). Ideally, other
     * restaurants would be able to be added simultaneously, but I can't figure
     * out how to do that.
     * 
     * @param restaurantDetails
     *            a JSON-formatted string describing a restaurant
     * @return a JSON-formatted string describing the result of the attempt to
     *         add the restaurant
     */
    private String addRestaurant(String restaurantDetails) {
        synchronized (restaurantMap) {
            try {
                Restaurant toAdd = new Restaurant(restaurantDetails); // TODO: refine this check
                if (restaurantMap.containsKey(toAdd))
                    return "\"message\": \"the restaurant is already in the database.\"";
                else {
                    HashSet<Review> emptySet = new HashSet<Review>();
                    restaurantMap.put(toAdd, emptySet);
                    return "\"message\": \"the restaurant was successfully added.\"";
                }
            } catch (Exception e) { // this is meant to catch badly-formed
                                    // restaurantDetails
                return "\"message\": \"the restaurant is incorrectly formatted or otherwise invalid.\"";
            }
        }
    }

    /**
     * adds the user specified by restaurantDetails to the database. requires
     * that userDetails is properly formatted and the specified user isn't
     * already in the database.
     * 
     * this is threadsafe: userMap is the lock. Reviews cannot be added while
     * this operation is running (although restaurants can). Ideally, other
     * users would be able to be added simultaneously, but I can't figure out
     * how to do that.
     * 
     * @param userDetails
     *            a JSON-formatted string describing a user
     * @return a JSON-formatted string describing the result of the attempt to
     *         add the user
     */
    private String addUser(String userDetails) {
        synchronized (userMap) {
            try {
                User toAdd = new User(userDetails);
                if (userMap.containsKey(toAdd)) // TODO: refine this check
                    return "\"message\": \"the user is already in the database.\"";
                else {
                    HashSet<Review> emptySet = new HashSet<Review>();
                    userMap.put(toAdd, emptySet);
                    return "\"message\": \"the user was successfully added.\"";
                }
            } catch (Exception e) { // this is meant to catch badly-formed
                                    // userDetails
                return "\"message\": \"the user is incorrectly formatted or otherwise invalid.\"";
            }
        }
    }

    /**
     * adds the review specified by reviewDetails to the database. requires that
     * the review isn't already in the database, and that the user who wrote the
     * review and the restaurant the review is about are in the database.
     * 
     * this is threadsafe. There are four stages which require safety: first,
     * the restaurant associated with the review is searched for. In this step,
     * restaurantMap is locked: no changes can be made to the map while it is
     * being searched. Second, the user associated with the review is searched
     * for. In this step, userMap is locked: no changes can be made to the map
     * while it is being searched. Third, the review is added to the restaurant:
     * the locks required are the restaurant and its set of reviews. Finally,
     * the review is added to the user: the locks required are the user and
     * their set of reviews.
     * 
     * @param reviewDetails
     *            a JSON-formatted string describing a review
     * @return JSON-formatted string describing the result of the attempt to add
     *         the review
     */
    private String addReview(String reviewDetails) {
        Review toAdd = new Review(reviewDetails);

        String userId = toAdd.getUserId();
        String businessId = toAdd.getBusinessId();

        User reviewUser = null;
        HashSet<Review> userReviews = null;

        Restaurant reviewRestaurant = null;
        HashSet<Review> restaurantReviews = null;

        synchronized (restaurantMap) {
            for (Entry<Restaurant, HashSet<Review>> entry : restaurantMap
                    .entrySet()) {
                if (entry.getKey() != null
                        && entry.getKey().getBusinessId().equals(businessId)) {
                    reviewRestaurant = entry.getKey();
                    restaurantReviews = entry.getValue();
                    if (restaurantReviews.contains(toAdd))
                        return "\"message\": \"this review already exists in the database.\"";
                    break;
                }
            }
        }
        if (reviewRestaurant == null)
            return "\"message\": \"the restaurant this review is about is not in the database.\"";

        synchronized (userMap) {
            for (Entry<User, HashSet<Review>> entry : userMap.entrySet()) {
                if (entry.getKey() != null
                        && entry.getKey().getUserId().equals(userId)) {
                    reviewUser = entry.getKey();
                    userReviews = entry.getValue();
                    if (userReviews.contains(toAdd))
                        return "\"message\": \"this review already exists in the database.\"";
                    break;
                }
            }
        }
        if (reviewUser == null)
            return "\"message\": \"the user who wrote this review is not in the database.\"";

        synchronized (reviewRestaurant) {
            synchronized (restaurantMap.get(reviewRestaurant)) {
                restaurantReviews.add(toAdd);
                restaurantMap.remove(reviewRestaurant);
                reviewRestaurant.addReview(toAdd);
                restaurantMap.put(reviewRestaurant, restaurantReviews);
            }
        }

        synchronized (reviewUser) {
            synchronized (userMap.get(reviewUser)) {
                userReviews.add(toAdd);
                userMap.remove(reviewUser);
                reviewUser.addReview(toAdd);
                userMap.put(reviewUser, userReviews);
            }
        }
        return "\"message\": \"the review was added successfully.\"";
    }
}