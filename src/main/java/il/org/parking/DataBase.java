package il.org.parking;

public interface DataBase {
  
  User getUser(Integer id);

  ParkingSpot getParkingSpot(Integer id);

  void add(User b);

  void add(ParkingSpot s);
  
  void add(Integer userId, Integer hisParkingSpot);

  void removeUser(Integer id);

  void removeParkingSpot(Integer id);

  void update(Integer id, User s);

  void update(Integer id, ParkingSpot s);
  
}
