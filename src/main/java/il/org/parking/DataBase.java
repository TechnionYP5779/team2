package il.org.parking;

import java.util.*;

import il.org.parking.exceptions.*;

public interface DataBase {
  
  User getUser(Integer id);

  ParkingSpot getParkingSpot(Integer id) throws ParkingSpotNotInSystem;
  
  List<ParkingSpot> getAllParkingSpot();
  
  List<Reservation> getAllReservations();

  void add(User b);

  void add(ParkingSpot s);
  
  void add(Integer userId, Integer hisParkingSpot);
  
  void add(Reservation s);

  void removeUser(Integer id);

  void removeParkingSpot(Integer id);

  void update(User s);

  void update(ParkingSpot s) throws ParkingSpotNotInSystem;
  
  
}
