package il.org.parking.demo;

import java.util.*;

import il.org.parking.*;

public class ParkingDemo {
  private DataBase db;
  
  public ParkingDemo(DataBase db) {
    this.db = db;
  }
  
  public void addUser(Integer id, String name, String contact_info) {
    User user = new UserImplementation(id, name, contact_info, db);
    db.add(user);
  }
  
  public void sell(Integer userId, ParkingSpot parkingSpot) {
    db.add(parkingSpot);
    db.add(userId, parkingSpot.getId());
  }
  
  public List<ParkingSpot> viewAllParkingSpots(){
    
    return null;
    
  }
}
