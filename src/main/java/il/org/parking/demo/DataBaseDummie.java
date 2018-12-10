package il.org.parking.demo;

import java.util.*;

import il.org.parking.*;

public class DataBaseDummie implements DataBase{
  
  Map<Integer, User> users = new HashMap<>();
  Map<Integer, ParkingSpot> parkingSpots = new HashMap<>();

  @Override public User getUser(Integer id) {
    return users.get(id);
  }

  @Override public ParkingSpot getParkingSpot(Integer id) {
    // TODO Auto-generated method stub
    return parkingSpots.get(id);
  }

  @Override public void add(User b) {
    users.put(b.getId(), b);
    
  }

  @Override public void add(ParkingSpot s) {
    parkingSpots.put(s.getId(), s);
    
  }

  @Override public void removeUser(Integer id) {
    users.remove(id);
    
  }

  @Override public void removeParkingSpot(Integer id) {
    parkingSpots.remove(id);
    
  }

  @Override public void update(Integer id, User s) {
    users.put(id, s);
    
  }

  @Override public void update(Integer id, ParkingSpot s) {
    parkingSpots.put(id, s);
    
  }
}
