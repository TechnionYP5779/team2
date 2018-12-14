package il.org.parkingweb.database;

import java.util.*;

import il.org.parkingweb.location.*;
import il.org.parkingweb.parkingspot.*;

public interface ParkingSpots {

  void add(ParkingSpot ps);
  
  void remove(Long id);
    
  Optional<ParkingSpot> get(Long id);
  
  List<ParkingSpot> getParkingSpotIn(Location location, double range);

}
