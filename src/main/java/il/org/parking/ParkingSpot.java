package il.org.parking;

/** This interface describes a parking space
 * @version 1.0
 * @author Addir Abasker */
public interface ParkingSpot {
  
  /** This method is used to inform the user of some identifier of the parking spot.
   * @return Integer - an number of the parking spot.
   * */
  Integer getId();
  
  /** This method is used to inform the user about the seller of the parking spot.
   * @return User - the user representing the seller of the parking spot. 
   * */
  User getSeller();
  
  /** This method is used to inform the user of the price of the parking spot.
   * @return Price which contains information about the price of the parking
   *         spot. 
   **/
  double getPrice();
  
  /** This method is used to inform the user of the location of the parking spot.
   * @return Location which contains information about the current location of the
   *         parking spot. 
   **/
  Location getLocation();

  /** This method is used to inform the user of the availability of the parking
   * spot.
   * @return Availability which contains information about the availability of the
   *         parking spot. 
   **/
  Availability getAvailability();
  
  /** This method is used to update the location of the parking spot to a new one.
   * @param Location an new location instead of the current location.
   **/
  void updateLocation(Location newLocation);
  
  /** This method is used to update the price of the parking spot to a new price.
   * @param double a new price instead of the current price.
   **/
  void updatePrice(double newPrice);

  /** This method is used to add rent times to the parking spot.
   * @param Availability a new time slot to add.
   **/
  void addAvailability(Availability other);
  
  /** This method is used to remove rent times to the parking spot.
   * @param Availability the new time slot to remove.
   **/
  void decreaseAvailability(Availability other);
}
