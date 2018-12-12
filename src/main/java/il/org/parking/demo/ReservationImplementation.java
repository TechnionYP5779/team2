package il.org.parking.demo;

import il.org.parking.*;

public class ReservationImplementation implements Reservation{
  
  public User buyer;
  public User seller;
  public double price;
  public int duration;
  public DateTime startTime;
  public ReservationImplementation(User buyer, User seller, double price, int duration, DateTime startTime) {
    this.buyer = buyer;
    this.seller = seller;
    this.price = price;
    this.duration = duration;
    this.startTime = startTime;
  }
  @Override public String toString() {
    return "seller: "+seller.getName() +" ("+seller.getId()+")\n"+
            "buyer: "+buyer.getName() +" ("+buyer.getId()+")\n"+
            "price: "+price+"\n"+
            "start time: "+startTime+"\n"+
            "duration: "+duration+"\n\n";
    
  }
  
  

  
}
