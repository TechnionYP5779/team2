package parkingLot;

public interface User {
  Integer getId();
  
  String getName();
  
  String getContactInfo();
  
  void update(User updatedUser);
}
