package ca.ece.ubc.cpen221.mp5.statlearning;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;

public class FeatureFunction implements MP5Function{
    
    private String feature;
    
    public FeatureFunction(String feature){
        this.feature = feature;
    }
    
    public String getFeature(){
        return feature;
    }

    @Override
    public double f(Restaurant yelpRestaurant, RestaurantDB db) {
        // TODO Auto-generated method stub
        return 0;
    }

}
