package il.org.parking.demo;

import il.org.parking.*;

public class ParkingSpotImplementation implements ParkingSpot {
  private Integer id;
  private Availability availability;
  private User seller;
  private double price;
  
  

  public ParkingSpotImplementation(Integer id, Availability availability, User seller, double price) {
    this.id = id;
    this.availability = availability;
    this.seller = seller;
    this.price = price;
  }

  @Override public Integer getId() {
    return this.id;
  }

  @Override public Availability getAvailability() {
    return this.availability;
  }

  @Override public void subtractAvailability(Availability otherAvailability) {
    this.availability = this.availability.subtraction(otherAvailability);
  }

  @Override public User getSeller() {
    return this.seller;
  }

  @Override public double getPrice() {
    return this.price;
  }

  @Override public String toString() {
    return "ParkingSpotImplementation [id=" + id + ", availability=" + availability + ", seller=" + seller + ", price=" + price + "]";
  }

  
  
}
