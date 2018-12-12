package il.org.parking;

public class ParkingSpotImpl implements ParkingSpot {
  private Integer id;
  private Availability avail;
  private User seller;
  private double price;
  private Location location;
  

  public ParkingSpotImpl(Integer id, Availability availability, User seller, double price,Location location) {
    this.id = id;
    this.avail = availability;
    this.seller = seller;
    this.price = price;
    this.location = location;
  }

  @Override public Integer getId() {
    return this.id;
  }
  
  @Override public User getSeller() {
    return this.seller;
  }
  
  @Override public double getPrice() {
    return this.price;
  }
  
  @Override public Location getLocation() {
    return this.location;
  }
  
  @Override public Availability getAvailability() {
    return this.avail;
  }

  @Override public void updateLocation(Location newLocation) {
    this.location = newLocation;
  }
  
  @Override public void updatePrice(double newPrice) {
    this.price = newPrice;
  }

  @Override public void decreaseAvailability(Availability other) {
    this.avail = this.avail.subtraction(other);
  }
  
  @Override public void addAvailability(Availability other) {
    this.avail = this.avail.unification(other);
  }
  
  @Override public String toString() {
    return "ParkingSpotImplementation [id=" + id + ", availability=" + avail + ", seller=" + seller + ", price=" + price + "]";
  }
  

}
