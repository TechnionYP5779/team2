package il.org.parking;

/**
 * This interface represent a geographic location
 * @version 1.0
 * @author Tal Porat
 */
public interface Location {

  /**
   * This method is used to calculate the distance between two Location objects
   * @param other This is the second Location object
   * @return Double This returns the distance between the two Location objects
   */
    Double calcDist (Location other);
}
