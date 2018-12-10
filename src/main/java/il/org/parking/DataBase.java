package il.org.parking;

public interface DataBase {
  
  User getBuyer(Integer id);

  ParkingSpot getParkingSpot(Integer id);

  void add(User b);

  void add(ParkingSpot s);

  void removeBuyer(Integer id);

  void removeSeller(Integer id);

  void removeParkingSpot(Integer id);

  void update(Integer id, User s);

  void update(Integer id, ParkingSpot s);
}
