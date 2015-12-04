package ca.ece.ubc.cpen221.mp5;

// TODO: Use this class to represent a Yelp user.
//State the rep invariant and abs

/* 
* rep:
* 
* type must be "user"
* coolVotes must be [0, infty)
* usefulVotes must be [0, infty)
* funnyVotes must be [0, infty)
* reviewCount must be [0, infty) and must be equal to the number of reviews in the database with 
* averageStars must be [0,5]
* and more
*/
public class User {
    
    private String url;
    private int coolVotes;
    private int usefulVotes;
    private int funnyVotes;
    private int reviewCount;
    private String type;
    private String userId;
    private String name;
    private double averageStars;

    public User(){
    }
}
