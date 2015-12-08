package ca.ece.ubc.cpen221.mp5.statlearning;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;

public class LinearRegressionFunction implements MP5Function{
    
    private double r_squared;
    private double a;
    private double b;
    
    /**
     * Returns a linear regression function, of the form:
     * y = a + b*x
     * That has an R-Squared value of r_squared
     * 
     * @param a the y-intercept
     * @param b the slope
     * @param r_squared the R-Squared value
     */
    public LinearRegressionFunction(double a, double b, double r_squared){
        this.a = a;
        this.b = b;
        this.r_squared = r_squared;
    }
    
    /**
     * Returns the y-intercept of the linear regression function.
     * @return the y-intercept
     */
    public double getA(){
        return a;
    }
    
    /**
     * Returns the slope of the linear regression function.
     * @return the slope
     */
    public double getB(){
        return b;
    }
    
    /**
     * Returns the R-Squared value of the linear regression function.
     * @return R-Squared
     */
    public double getRSquared(){
        return r_squared;
    }

    @Override
    public double f(Restaurant yelpRestaurant, RestaurantDB db) {
        return 0;
    }
    
    

}
