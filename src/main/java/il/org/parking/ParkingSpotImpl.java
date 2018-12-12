package il.org.parking;

public class ParkingSpotImpl implements ParkingSpot {
  private Location location;
  private Price price;
  private Availability avail;
  
  ParkingSpotImpl(Location l, Price p, Availability a){
    //need to call create from factory here
    location = l;
    price = p;
    avail = a;
  }
  
  @Override public Location getLocation() {
    return location;
  }

  @Override public Price getPrice() {
    return price;
  }

  @Override public Availability getAvailability() {
    return avail;
  }
  
  @Override public void updateLocation(Location newLocation) {
    location = newLocation;
  }
  
  @Override public void updatePrice(Price newPrice) {
    price.update(newPrice);
  }
  
  @Override public void addAvailability(Availability other) {
    // avail.unification(other);
    return; // need to add a function for adding to this interval
  }
  
  @Override public void decreaseAvailability(Availability other) {
    avail.subtraction(other);
  }
}
