package il.org.parkingweb.database.sql;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import il.org.parkingweb.availability.*;
import il.org.parkingweb.database.*;
import il.org.parkingweb.location.*;
import il.org.parkingweb.parkingspot.*;

@SuppressWarnings("static-method") public class HibernateParkingSpotsTest {
  
  private static ParkingSpots spots;
  
  @BeforeClass public static void setUpBeforeClass() {
    spots = new HibernateParkingSpotsFactory().open();
  }

  @Test public void mainTest() {
    Location l = new Location(34.4565789, 33.5546782);
    Availability a = new Availability(10, 20);
    ParkingSpot ps = new ParkingSpot(l, a);
    spots.add(ps);
    
    Optional<ParkingSpot> ops = spots.get(ps.getId());
    assertEquals(ps.getId(), ops.get().getId());
    assertEquals(ps.getAvailability().from, ops.get().getAvailability().from);
    assertEquals(ps.getAvailability().to, ops.get().getAvailability().to);
    assertEquals(ps.getLocation().latitude, ops.get().getLocation().latitude, 0.01);
    assertEquals(ps.getLocation().longitude, ops.get().getLocation().longitude, 0.01);
  }

  
}
