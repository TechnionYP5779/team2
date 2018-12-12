package il.org.parking;

/**
 * This interface describes a parking space
 * @version 1.0
 * @author Addir Abasker
 */
public interface ParkingSpot {
  
  /**
   * This method is used to inform the user of the location of the 
   * parking spot.
   * @return Location which contains information about the current 
   *         location of the parking spot.
   */
  Location getLocation();
  
  /**
   * This method is used to inform the user of the price of the 
   * parking spot.
   * @return Price which contains information about the price 
   *         of the parking spot.
   */
  Price getPrice();
  
  /**
   * This method is used to inform the user of the availability of 
   * the parking spot.
   * @return Availability which contains information about the 
   *         availability of the parking spot.
   */
  Availability getAvailability();
}
