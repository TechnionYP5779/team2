package il.org.parking;

import java.util.*;

/** This class represents a user in the parking system. a user has an id, name,
 * contact info (such as phone number, mail, ...), list of parking spots he
 * rents to others, and list of parking spots he rents from other.
 * @author Omer Glick */
public interface User {
  /** @return user id */
  Integer getId();

  /** @return user name */
  String getName();

  /** @return user contact info */
  String getContactInfo();

  /** @param updatedUser new user information to this update user */
  void update(User updatedUser);

  /** @return a collection of all the parking spots the user rents FROM other
   *         users right now */
  Collection<ParkingSpot> getParkingsRentsFromOthers();

  /** @return a collection of all the parking spots the user rents TO other users
   *         right now */
  Collection<ParkingSpot> getParkingsRentsToOthers();
}
