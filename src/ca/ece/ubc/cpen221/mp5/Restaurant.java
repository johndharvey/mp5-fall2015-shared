package ca.ece.ubc.cpen221.mp5;

import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// TODO: Use this class to represent a restaurant.
// State the rep invariant and abs

/*
 * rep: - type must be "business" - longitude must be [-180, 180] - latitude
 * must be [-90, 90] - stars must be [0,5] - reviewCount must be [0, infty) -
 * price must be [0, 5] - TODO finish the rep invariant
 */

public class Restaurant {

    private boolean open;
    private String url;
    private double longtitude;
    private String[] neighborhoods;
    private String businessId;
    private String name;
    private String[] categories;
    private String state;
    private String type;
    private double stars;
    private String city;
    private String fullAddress;
    private int reviewCount;
    private String photoUrl;
    private String[] schools;
    private double latitude;
    private int price;

    /**
     * constructor for Restaurant
     * 
     * @param restaurant
     *            a JSON-formatted String with valid Restaurant data
     */
    public Restaurant(String restaurant) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(restaurant);

            JSONObject jsonObject = (JSONObject) obj;

            this.open = (boolean) jsonObject.get("open");
            this.url = (String) jsonObject.get("url");
            this.longtitude = (double) jsonObject.get("longitude");
            this.neighborhoods = (String[]) jsonObject.get("categories");
            this.businessId = (String) jsonObject.get("business_id");
            this.name = (String) jsonObject.get("name");
            this.categories = (String[]) jsonObject.get("categories");
            this.state = (String) jsonObject.get("state");
            this.type = (String) jsonObject.get("type");
            this.stars = (double) jsonObject.get("stars");
            this.city = (String) jsonObject.get("city");
            this.fullAddress = (String) jsonObject.get("fullAddress");
            this.reviewCount = (int) jsonObject.get("reviewCount");
            this.photoUrl = (String) jsonObject.get("photo_url");
            this.schools = (String[]) jsonObject.get("schools");
            this.latitude = (double) jsonObject.get("latitude");
            this.price = (int) jsonObject.get("price");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!repCheck(this)) /* TODO throw some exception */;
    }

    private boolean repCheck(Restaurant restaurant) {
        if (restaurant.longtitude > 180 || restaurant.longtitude < 180)
            return false;
        else if (this.type != "business")
            return false;
        else if (restaurant.stars > 5 || restaurant.stars < 0)
            return false;
        else if (restaurant.reviewCount < 0)
            return false;
        else if (restaurant.price < 1 || restaurant.price > 5)
            return false;
        else
            return true;
    }

    @Override
    /**
     * @return a JSON formatted String representing the Restaurant
     */
    public String toString() {
        return "{ \"open\": " + open + ", \"url\": " + url
                + ", \"longtitude\": " + longtitude + ", \"neighborhoods\": "
                + Arrays.toString(neighborhoods) + ", \"business_id\": "
                + businessId + ", \"name\": " + name + ", \"categories\": "
                + Arrays.toString(categories) + ", \"state\": " + state
                + ", \"type\": " + type + ", \"stars\": " + stars
                + ", \"city\":" + city + ", \"fullAddress\": " + fullAddress
                + ", \"reviewCount\": " + reviewCount + ", \"photoUrl\": "
                + photoUrl + ", \"schools\": " + Arrays.toString(schools)
                + ", \"latitude\": " + latitude + ", \"price\": " + price + "}";
    }

    /**
     * mutates the specified Restaurant such that a new review is added; stars
     * is adjusted to take the new review into account, and reviewCount is
     * incremented.
     * 
     * @param review
     *            the number of stars in the review to be added
     */
    public void addReview(Review review) {
        double oldStars = this.stars;
        int oldCount = this.reviewCount;
        this.reviewCount += 1;
        this.stars = (oldStars * oldCount + review.getStars())
                / this.reviewCount;
    }

    public boolean isOpen() {
        return open;
    }

    public String getUrl() {
        return url;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public String[] getNeighborhoods() {
        return neighborhoods;
    }

    public String getBusinessId() {
        return businessId;
    }

    public String getName() {
        return name;
    }

    public String[] getCategories() {
        return categories;
    }

    public String getState() {
        return state;
    }

    public String getType() {
        return type;
    }

    public double getStars() {
        return stars;
    }

    public String getCity() {
        return city;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String[] getSchools() {
        return schools;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getPrice() {
        return price;
    }
}
