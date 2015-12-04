package ca.ece.ubc.cpen221.mp5;

// TODO: Use this class to represent a Yelp review.
//State the rep invariant and abs

/* 
* rep:
* 
* type must be "review"
* coolVotes must be [0, infty)
* usefulVotes must be [0, infty)
* funnyVotes must be [0, infty)
* stars must be [0,5]
* and more
*/

public class Review {
    
    private String type;
    private String businessId;
    private int coolVotes;
    private int usefulVotes;
    private int funnyVotes;
    private String reviewId;
    private String text;
    private double stars;
    private String userId;
    private String date;
    
    public Review(){    
    }

}
