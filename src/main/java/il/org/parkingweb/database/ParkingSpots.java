package il.org.parkingweb.database;

import java.util.*;

import il.org.parkingweb.location.*;
import il.org.parkingweb.parkingspot.*;

public interface ParkingSpots {
  void add(int id, ParkingSpot ps);
  
  void remove(int id);
  
  void update(int id, ParkingSpot ps);
  
  ParkingSpot get(int id);
  
  List<ParkingSpot> getParkingSpotIn(Location location, double range);
}
