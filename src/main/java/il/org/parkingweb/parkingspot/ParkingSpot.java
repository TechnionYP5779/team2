package il.org.parkingweb.parkingspot;

import javax.persistence.*;

import il.org.parkingweb.availability.*;
import il.org.parkingweb.location.*;

@Entity @Table(name = "ParkingSpots") public class ParkingSpot {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  private double latitude;
  private double longitude;
  
  private int availbleFrom;
  private int availbleTo;
  
  public ParkingSpot() {
    
  }
  
  public ParkingSpot(Location l, Availability a) {
    setLocation(l);
    setAvailability(a);
  }
  
  public Long getId() {
    return id;
  }
  
  /**
   * @return the location
   */
  public Location getLocation() {
    return new Location(latitude, longitude);
  }

  /**
   * @param l the location to set
   */
  public void setLocation(Location l) {
    latitude = l.latitude;
    longitude = l.longitude;
  }
  
  /**
   * @return the availability
   */
  public Availability getAvailability() {
    return new Availability(availbleFrom, availbleTo);
  }

  /**
   * @param a the availability to set
   */
  public void setAvailability(Availability a) {
    this.availbleFrom = a.from;
    this.availbleTo = a.to;
  }
}
