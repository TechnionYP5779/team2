package il.org.parking;
import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class ReservationTest {
  
  @Test public void buyerTest() {
    UserImplementation buyer = new UserImplementation(box(1), "Jess", "info", null);
    UserImplementation seller = new UserImplementation(box(2), "Guy", "info", null);
    ParkingPrice price = new ParkingPrice(box(1.0));
    Moment time = new Moment();
    ParkingSpotReservation psr = new ParkingSpotReservation(buyer, seller, price, 5, time, 1);
    azzert.that(psr.getBuyer().getName(), is("Jess"));
    azzert.that(psr.getBuyer().getId(), is(1));
  }
  
  @Test public void sellerTest() {
    UserImplementation buyer = new UserImplementation(box(1), "Jess", "info", null);
    UserImplementation seller = new UserImplementation(box(2), "Guy", "info", null);
    ParkingPrice price = new ParkingPrice(box(1.0));
    Moment time = new Moment();
    ParkingSpotReservation psr = new ParkingSpotReservation(buyer, seller, price, 5, time, 1);
    azzert.that(psr.getSeller().getName(), is("Guy"));
    azzert.that(psr.getSeller().getId(), is(2));
  }
    
  @Test public void priceTest() {
    UserImplementation buyer = new UserImplementation(box(1), "Jess", "info", null);
    UserImplementation seller = new UserImplementation(box(2), "Guy", "info", null);
    ParkingPrice price = new ParkingPrice(box(1.0));
    Moment time = new Moment();
    ParkingSpotReservation psr = new ParkingSpotReservation(buyer, seller, price, 5, time, 1);
    azzert.that(psr.getPrice().getCost(), is(1.0));
  }
  
  @Test public void durationTest() {
    UserImplementation buyer = new UserImplementation(box(1), "Jess", "info", null);
    UserImplementation seller = new UserImplementation(box(2), "Guy", "info", null);
    ParkingPrice price = new ParkingPrice(box(1.0));
    Moment time = new Moment();
    ParkingSpotReservation psr = new ParkingSpotReservation(buyer, seller, price, 5, time, 1);
    azzert.that(psr.getDuration(), is(5));
  }
  
  @Test public void startTImeTest() {
    UserImplementation buyer = new UserImplementation(box(1), "Jess", "info", null);
    UserImplementation seller = new UserImplementation(box(2), "Guy", "info", null);
    ParkingPrice price = new ParkingPrice(box(1.0));
    Moment time = new Moment();
    ParkingSpotReservation psr = new ParkingSpotReservation(buyer, seller, price, 5, time, 1);
    azzert.that(psr.getStartTime(), is(time));
  }
  
  @Test public void idTest() {
    UserImplementation buyer = new UserImplementation(box(1), "Jess", "info", null);
    UserImplementation seller = new UserImplementation(box(2), "Guy", "info", null);
    ParkingPrice price = new ParkingPrice(box(1.0));
    Moment time = new Moment();
    ParkingSpotReservation psr = new ParkingSpotReservation(buyer, seller, price, 5, time, 1);
    azzert.that(psr.getId(), is(1));
  }
}
