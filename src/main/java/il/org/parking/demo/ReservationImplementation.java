package il.org.parking.demo;

import il.org.parking.*;

public class ReservationImplementation implements Reservation{
  
  User buyer;
  User seller;
  double price;
  int duration;
  DateTime startTime;
  public ReservationImplementation(User buyer, User seller, double price, int duration, DateTime startTime) {
    this.buyer = buyer;
    this.seller = seller;
    this.price = price;
    this.duration = duration;
    this.startTime = startTime;
  }

  
}
