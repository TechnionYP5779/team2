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

  public List<ParkingSpot> viewAllParkingSpots() {
    return db.getAllParkingSpot();
  }

  public void buy(Integer parkingSpotId, Availability userAvailability) {
    ParkingSpot parkingSpot = db.getParkingSpot(parkingSpotId);
    if (parkingSpot == null) {
      throw new NoSuchElementException("no such parking spot id");
    }
    Availability parkingSpotAvailability = parkingSpot.getAvailability();
    if (parkingSpotAvailability.doesContaines(userAvailability).booleanValue()) {
      parkingSpot.subtractAvailability(userAvailability);
    }
    db.update(parkingSpotId, parkingSpot);
  }
}
