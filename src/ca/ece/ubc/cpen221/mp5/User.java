package ca.ece.ubc.cpen221.mp5;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// TODO: Use this class to represent a Yelp user.
// State the rep invariant and abs

/*
 * rep:
 * 
 * type must be "user" cool must be [0, infty) useful must be [0, infty) funny
 * must be [0, infty) reviewCount must be [0, infty) averageStars must be [0,5]
 * and more
 */
public class User {

    private String url;
    private int cool;
    private int useful;
    private int funny;
    private int reviewCount;
    private String type;
    private String userId;
    private String name;
    private double averageStars;

    public User(String user) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(user);

            JSONObject jsonObject = (JSONObject) obj;

            this.url = (String) jsonObject.get("url");

            String votes = (String) jsonObject.get("votes");
            JSONParser voteParser = new JSONParser();
            try {
                Object votesObj = voteParser.parse(votes);
                JSONObject votesJsonObject = (JSONObject) votesObj;

                this.cool = (int) votesJsonObject.get("cool");
                this.useful = (int) votesJsonObject.get("useful");
                this.funny = (int) votesJsonObject.get("funny");
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.reviewCount = (int) jsonObject.get("review_count");
            this.type = (String) jsonObject.get("type");
            this.userId = (String) jsonObject.get("user_id");
            this.name = (String) jsonObject.get("name");
            this.averageStars = (double) jsonObject.get("average_stars");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!repCheck(this)) /* TODO throw some exception */;
    }

    private boolean repCheck(User user) {
        if (user.type != "user")
            return false;
        else if (user.cool < 0)
            return false;
        else if (user.funny < 0)
            return false;
        else if (user.useful < 0)
            return false;
        else if (user.reviewCount < 0)
            return false;
        else if (user.averageStars > 5 || user.averageStars < 0)
            return false;
        else
            return true;
    }

    @Override
    /**
     * @return a JSON formatted String representing the User
     */
    public String toString() {
        return "{ \"url\": " + url + ", \"votes\": {\"cool\": " + cool
                + ", \"useful\": " + useful + ", \"funny\": " + funny + "},"
                + ", \"review_count\": " + reviewCount + ", \"type\": " + type
                + ", \"user_id\": " + userId + ". \"name\": " + name
                + ", \"average_stars\": " + averageStars + "}";
    }

    /**
     * mutates the specified User such that a new review is added; averageStars
     * is adjusted to take the new review into account, and cool, useful, and
     * funny are appropriately incremented.
     * 
     * @param review
     *            the Review to be added
     */
    public void addReview(Review review) {
        double oldAverageStars = this.averageStars;
        int oldCount = this.reviewCount;
        this.reviewCount += 1;
        this.averageStars = (oldAverageStars * oldCount + review.getStars())
                / this.reviewCount;
        this.cool += review.getCool();
        this.funny += review.getFunny();
        this.useful += review.getUseful();
    }

    public String getUrl() {
        return url;
    }

    public int getCool() {
        return cool;
    }

    public int getUseful() {
        return useful;
    }

    public int getFunny() {
        return funny;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public String getType() {
        return type;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public double getAverageStars() {
        return averageStars;
    }
}
