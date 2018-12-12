package il.org.parking.demo;

import java.util.*;

import il.org.parking.*;

public class DataBaseDummie implements DataBase {
  Map<Integer, User> users = new HashMap<>();
  Map<Integer, ParkingSpot> parkingSpots = new HashMap<>();
  Map<Integer, List<Integer>> parkingSpotsOfUsers = new HashMap<>();
  List<Reservation> reservations = new ArrayList<>();

  @Override public User getUser(Integer id) {
    return users.get(id);
  }

  @Override public ParkingSpot getParkingSpot(Integer id) {
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

  @Override public void update(User s) {
    users.put(s.getId(), s);
  }

  @Override public void update(ParkingSpot s) {
    parkingSpots.put(s.getId(), s);
  }

  @Override public void add(Integer userId, Integer hisParkingSpot) {
    List<Integer> parkingSpotsIds = parkingSpotsOfUsers.get(userId);
    if(parkingSpotsIds == null) {
      parkingSpotsIds = new ArrayList<>();
      parkingSpotsOfUsers.put(userId, parkingSpotsIds);
    }
    
    if(!parkingSpotsIds.contains(hisParkingSpot)){
      parkingSpotsIds.add(hisParkingSpot);
    }
    
  }

  @Override public List<ParkingSpot> getAllParkingSpot() {
    return new ArrayList<>(parkingSpots.values());
  }

  @Override public List<Reservation> getAllReservations() {
   return reservations;
  }

  @Override public void add(Reservation s) {
    reservations.add(s);
    
  }
}
