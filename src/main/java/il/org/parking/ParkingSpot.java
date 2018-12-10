package il.org.parking;

public interface ParkingSpot {
  // to be expanded
  public Integer getId();
  
  public Availability getAvailability();
  
  public void subtractAvailability(Availability availability);
}
