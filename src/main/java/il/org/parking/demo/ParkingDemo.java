package il.org.parking.demo;

import java.util.*;

import il.org.parking.*;

public class ParkingDemo {
  private DataBase db;
  private ReservationFactory reservationFactory;

  public ParkingDemo(DataBase db, ReservationFactory reservationFactory) {
    this.db = db;
    this.reservationFactory = reservationFactory;
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

  @SuppressWarnings("boxing") public void buy(Integer buyerId,Integer parkingSpotId, Availability userAvailability) {
    ParkingSpot parkingSpot = db.getParkingSpot(parkingSpotId);
    
    if(userAvailability.getNumberOfIntervals() != 1) {
      throw new IllegalArgumentException("Availability should only have one time slot");
    }
    
    if (parkingSpot == null) {
      throw new NoSuchElementException("no such parking spot id");
    }
    
    User buyer = db.getUser(buyerId);
    if (buyer == null) {
      throw new NoSuchElementException("no such user id");
    }
    
    
    Availability parkingSpotAvailability = parkingSpot.getAvailability();
    if (parkingSpotAvailability.doesContaines(userAvailability).booleanValue()) {
      parkingSpot.subtractAvailability(userAvailability);
      Reservation reservation = reservationFactory.create(buyer, parkingSpot.getSeller(), parkingSpot.getPrice(),
          userAvailability.getDuration(), userAvailability.getStartTime());
      db.add(reservation);
    }
    db.update(parkingSpotId, parkingSpot);
  }
  
  public List<Reservation> getAllReservations(){
    return db.getAllReservations();
  }
 
}
