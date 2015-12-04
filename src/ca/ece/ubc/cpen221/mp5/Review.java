package ca.ece.ubc.cpen221.mp5;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// TODO: Use this class to represent a Yelp review.
// State the rep invariant and abs

/*
 * rep: - type must be "review" - coolVotes must be [0, infty) - usefulVotes
 * must be [0, infty) - funnyVotes must be [0, infty) - stars must be [0,5] -
 * TODO finish the rep invariant
 */

public class Review {

    private String type;
    private String businessId;
    private int cool;
    private int useful;
    private int funny;
    private String reviewId;
    private String text;
    private double stars;
    private String userId;
    private String date;

    public Review(String review) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(review);

            JSONObject jsonObject = (JSONObject) obj;

            this.type = (String) jsonObject.get("type");
            this.businessId = (String) jsonObject.get("business_id");
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
            this.reviewId = (String) jsonObject.get("review_id");
            this.text = (String) jsonObject.get("text");
            this.stars = (double) jsonObject.get("stars");
            this.userId = (String) jsonObject.get("user_id");
            this.date = (String) jsonObject.get("date");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!repCheck(this)) /* TODO throw some exception */;
    }

    private boolean repCheck(Review review) {
        if (review.type != "review")
            return false;
        else if (cool < 0)
            return false;
        else if (funny < 0)
            return false;
        else if (useful < 0)
            return false;
        else if (review.stars > 5 || review.stars < 0)
            return false;
        else
            return true;
    }

    @Override
    /**
     * @return a JSON formatted String representing the Restaurant
     */
    public String toString() {
        return "{ \"type\": " + type + ", \"business_id\": " + businessId
                + ", \"votes\": {\"cool\": " + cool + ", \"useful\": " + useful
                + ", \"funny\": " + funny + "}," + ", \"review_id\": "
                + reviewId + ", \"text\": " + text + ", \"stars\": " + stars
                + ", \"user_id\": " + userId + ", \"date\": " + date + "}";
    }

    public String getType() {
        return type;
    }

    public String getBusinessId() {
        return businessId;
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

    public String getReviewId() {
        return reviewId;
    }

    public String getText() {
        return text;
    }

    public double getStars() {
        return stars;
    }

    public String getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    
}
