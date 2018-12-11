package il.org.parking.demo;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.mockito.*;

import il.org.parking.*;
import il.org.parking.demo.AvailabilityImplementation.*;


public class ParkingDemoTest {
  
  @Test public void testSellASpot(){
    ReservationFactory rf = new ReservationFactoryImplementation();
    
    
    ParkingDemo demo = new ParkingDemo(new DataBaseDummie(), rf);
    demo.addUser(123, "honey-boo", "poo@honey.com");
    demo.addUser(456, "buybuybuy!", "i_have@money.com");
    User seller = demo.getUser(123);
    List<SlotImplementation> slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(13), new DateTimeImplementation(20)));
    Availability availability = new AvailabilityImplementation(slots);
    ParkingSpot parkingSpot = new ParkingSpotImplementation(777,availability,seller, 33.5);
    demo.sell(123, parkingSpot);
    
    demo.viewAllParkingSpots().stream().forEach(ps -> System.out.println(ps.toString()));
    
    List<SlotImplementation> slots2 = new ArrayList<>();
    slots2.add(new SlotImplementation(new DateTimeImplementation(14), new DateTimeImplementation(16)));
    Availability buy_availability = new AvailabilityImplementation(slots2);
    demo.buy(456, 777, buy_availability);
    
    demo.viewAllParkingSpots().stream().forEach(ps -> System.out.println(ps.toString()));
  }
}
