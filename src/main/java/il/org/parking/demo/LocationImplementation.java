package il.org.parking.demo;

import il.org.parking.*;

public class LocationImplementation implements Location{
  private double x;
  private double y;
  
  

  public LocationImplementation(double x, double y) {
    this.x = x;
    this.y = y;
  }



  @Override public double calcDist(Location other) {
   if(!(other instanceof LocationImplementation)) {
     throw new IllegalArgumentException("Location must be of type LocationImplementation");
   }
   LocationImplementation other_loc = (LocationImplementation)other;
   return Math.sqrt(Math.pow(this.x - other_loc.x, 2.0) + Math.pow(this.y - other_loc.y, 2.0));
  }
}
