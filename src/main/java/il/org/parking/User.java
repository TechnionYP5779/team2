package il.org.parking;

public interface User {
  /**
   * 
   * @return sser id
   */
  Integer getId();
  
  /**
   * 
   * @return user name
   */
  String getName();
  
  /**
   * 
   * @return user contact info
   */
  String getContactInfo();
  
  /**
   * 
   * @param updatedUser - new user information to this update user
   */
  void update(User updatedUser);
}
