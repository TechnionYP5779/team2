package il.org.parking.demo;

import java.util.*;
import java.util.stream.*;

import il.org.parking.*;
import il.org.parking.exceptions.*;

public class ParkingDemo {
  private DataBase db;
  private ReservationFactory reservationFactory;

  public ParkingDemo(DataBase db, ReservationFactory reservationFactory) {
    this.db = db;
    this.reservationFactory = reservationFactory;
  }

  public User addUser(Integer id, String name, String contact_info) {
    User user = new UserImplementation(id, name, contact_info, db);
    db.add(user);
    return user;
  }
  
  public User getUser(Integer id) {
    return db.getUser(id);
  }
  public ParkingSpot getParkingSpot(Integer id) throws ParkingSpotNotInSystem {
    return db.getParkingSpot(id);
  }

  public void sell(ParkingSpot parkingSpot) {
    db.add(parkingSpot);
    Integer sellerId = parkingSpot.getSeller().getId();
    db.add(sellerId, parkingSpot.getId());
  }
  public void updateParkingSpot(ParkingSpot parkingSpot) throws ParkingSpotNotInSystem {
    db.update(parkingSpot);
  }

  public List<ParkingSpot> viewAllParkingSpots() {
    return db.getAllParkingSpot();
  }
  
  public List<ParkingSpot> viewParkingSpotsFromLocation(Location l, double radius){
    return db.getAllParkingSpot().stream().filter(ps-> (ps.getLocation().calcDist(l) <= radius)).collect(Collectors.toList());
  }

  @SuppressWarnings("boxing") public void buy(Integer buyerId, Integer parkingSpotId, Availability userAvailability) throws ParkingSpotNotInSystem {
    ParkingSpot parkingSpot = db.getParkingSpot(parkingSpotId);
    if (userAvailability.getNumberOfIntervals() != 1) {
      throw new IllegalArgumentException("Availability should only have one time slot");
    }
    if (parkingSpot == null) {
      throw new NoSuchElementException("No such parking spot id");
    }
    User buyer = db.getUser(buyerId);
    if (buyer == null) {
      throw new NoSuchElementException("No such user id");
    }
    Availability parkingSpotAvailability = parkingSpot.getAvailability();
    if (parkingSpotAvailability.doesContaines(userAvailability).booleanValue()) {
      parkingSpot.subtractAvailability(userAvailability);
      Reservation reservation = reservationFactory.create(buyer, parkingSpot.getSeller(), parkingSpot.getPrice(), userAvailability.getDuration(),
          userAvailability.getStartTime());
      db.add(reservation);
    }else {
      throw new IllegalArgumentException("isnt available");
    }
    db.update(parkingSpot);
  }

  public List<Reservation> getAllReservations() {
    return db.getAllReservations();
  }
}
