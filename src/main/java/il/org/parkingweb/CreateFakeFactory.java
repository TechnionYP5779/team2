package il.org.parkingweb;


import java.util.*;

import il.org.parkingweb.database.*;
import il.org.parkingweb.location.*;
import il.org.parkingweb.parkingspot.*;

public class CreateFakeFactory {
  
  static ParkingSpots db = new ParkingSpots() {
    
    Map<Long, ParkingSpot> psMap = new HashMap<>();
    
    @Override public void remove(Long id) {
      psMap.remove(id);
    }
    
    @Override public List<ParkingSpot> getParkingSpotIn(Location location, double range) {
      List<ParkingSpot> l = new ArrayList<>();
      
      addDefaults(l);
      
      for (ParkingSpot ps : psMap.values()) {
        
        double dist = Math.sqrt((location.latitude) - ps.getLocation().latitude) *
            ((location.latitude) - ps.getLocation().latitude)
            + ((location.longitude) - ps.getLocation().longitude) *
          ((location.longitude) - ps.getLocation().longitude);
        
        if(dist <= range) {
          l.add(ps);
        }
        
      }
      
      return l;
    }
    
    @Override public Optional<ParkingSpot> get(Long id) {
      return Optional.of(psMap.get(id));
    }
    
    @Override public void add(ParkingSpot ps) {
     
      psMap.put(ps.getId(), ps);
    }
  };
  
  static ParkingSpotsFactory factory = () -> db;
  
  public static void addDefaults(List<ParkingSpot> list) {
    ParkingSpot ps1 = new ParkingSpot();
    ps1.setLocation(new Location(32.778885, 35.018709));
    ParkingSpot ps2 = new ParkingSpot();
    ps2.setLocation(new Location(32.777044, 35.019463));
    ParkingSpot ps3 = new ParkingSpot();
    ps3.setLocation(new Location(32.776124, 35.020654));
    ParkingSpot ps4 = new ParkingSpot();
    ps4.setLocation(new Location(32.776124, 35.021654));
    ParkingSpot ps5 = new ParkingSpot();
    ps5.setLocation(new Location(32.777721, 35.024044));
    ParkingSpot ps6 = new ParkingSpot();
    ps6.setLocation(new Location(32.778384, 35.023347));
    ParkingSpot ps7 = new ParkingSpot();
    ps7.setLocation(new Location(32.779642, 35.022440));
    ParkingSpot ps8 = new ParkingSpot();
    ps8.setLocation(new Location(32.779966, 35.024715));
    
    list.add(ps1);
    list.add(ps2);
    list.add(ps3);
    list.add(ps4);
    list.add(ps5);
    list.add(ps6);
    list.add(ps7);
    list.add(ps8);
  }
  
  public static ParkingSpotsFactory create() {
    return factory;
    
  }
}
