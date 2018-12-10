package il.org.parking;

/** This interface represents a user in the system
 * @version 1.0
 * @author OmerGlick */
public interface User {
  /** @return sser id */
  Integer getId();

  /** @return user name */
  String getName();

  /** @return user contact info */
  String getContactInfo();

  /** @param updatedUser - new user information to this update user */
  void update(User updatedUser);
  
  /**
   * 
   * @param parkingSpot - the parking spot that the user want to sell
   */
  void sellParkingSpot(ParkingSpot parkingSpot);
}
