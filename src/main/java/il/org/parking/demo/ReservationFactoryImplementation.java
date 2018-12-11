package il.org.parking.demo;

import il.org.parking.*;

public class ReservationFactoryImplementation implements ReservationFactory{

  @Override public Reservation create(User buyer, User seller, double price, int duration, DateTime startTime) {
    return new ReservationImplementation(buyer, seller, price, duration, startTime);
  }
}
