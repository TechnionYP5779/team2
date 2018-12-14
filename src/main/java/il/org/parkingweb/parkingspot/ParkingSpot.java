package il.org.parkingweb.parkingspot;

import javax.persistence.*;

import il.org.parkingweb.availability.*;
import il.org.parkingweb.location.*;

@Entity @Table(name = "ParkingSpots") public class ParkingSpot {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  private final Location location;
  private Availability availability;
  
  public ParkingSpot(Location l, Availability a) {
    location = l;
    setAvailability(a);
  }

  /**
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * @return the availability
   */
  public Availability getAvailability() {
    return availability;
  }

  /**
   * @param a the availability to set
   */
  public void setAvailability(Availability a) {
    this.availability = a;
  }
}
