package il.org.parking.demo;

import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;
import org.junit.rules.*;
import org.mockito.*;

import il.org.parking.*;
import il.org.parking.demo.AvailabilityImplementation.*;


public class ParkingDemoTest {
  
  private ParkingDemo demo;
  
  private User seller123;
  private User seller666;
  
  private User buyer456;
  private User buyer999;
  
  @Before public void setup() {
    
    ReservationFactory rf = new ReservationFactoryImplementation();
    
    
    this.demo = new ParkingDemo(new DataBaseDummie(), rf);
    
    this.seller123 = demo.addUser(123, "honey-boo", "poo@honey.com");
    this.seller666 = demo.addUser(666, "goerge", "yo@bae.com");
    
    this.buyer456 = demo.addUser(456, "buybuybuy!", "i_have@money.com");
    this.buyer999 = demo.addUser(999, "poor-man", "i_dont_have@money.com");
    
    List<SlotImplementation> slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(130), new DateTimeImplementation(200)));
    Availability availability = new AvailabilityImplementation(slots);
    
    ParkingSpot parkingSpot = new ParkingSpotImplementation(777,availability,seller123, 33.5);
    demo.sell(parkingSpot);
    
    
    slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(300), new DateTimeImplementation(500)));
    slots.add(new SlotImplementation(new DateTimeImplementation(700), new DateTimeImplementation(750)));
    availability = new AvailabilityImplementation(slots);
    
    parkingSpot = new ParkingSpotImplementation(888,availability,seller666, 330.3);
    demo.sell(parkingSpot);
    
    
    slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(1000), new DateTimeImplementation(1500)));
    slots.add(new SlotImplementation(new DateTimeImplementation(1700), new DateTimeImplementation(1750)));
    availability = new AvailabilityImplementation(slots);
    
    parkingSpot = new ParkingSpotImplementation(999,availability,seller666, 3308.3);
    demo.sell(parkingSpot);
    
  }
  
  private String getParkingSpotString(ParkingSpot ps) {
    String ret = "";
    ret = ps.getSeller().getId().toString()+"("+ps.getId().toString()+")"+":\n";
    Availability av = ps.getAvailability();
    for(int i=0; i<av.getNumberOfIntervals(); i++) {
      ret = ret+"["+av.getSlots(i).getStart().getTime().toString()+" "+av.getSlots(i).getEnd().getTime().toString()+"]\n";
    }
    
    return ret+"\n";
  }
  
  private String getTimeSlotsString(List<ParkingSpot> list) {
    return list.stream().map(ps->getParkingSpotString(ps)).collect( Collectors.joining( "," ) );
  }
  
  @Test public void testSellSpot(){
    
    String expected =
        "666(999):\n" + 
        "[1000 1500]\n" + 
        "[1700 1750]\n" + 
        "\n" + 
        ",666(888):\n" + 
        "[300 500]\n" + 
        "[700 750]\n" + 
        "\n" + 
        ",123(777):\n" + 
        "[130 200]\n"+
        "\n";
    
    assertEquals(expected, getTimeSlotsString(demo.viewAllParkingSpots()));
  }
  
  @Test public void testBuySpot() {
    List<SlotImplementation> slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(140), new DateTimeImplementation(160)));
    Availability buy_availability = new AvailabilityImplementation(slots);
    
    demo.buy(456, 777, buy_availability);
    
    String expected = 
        "666(999):\n" + 
        "[1000 1500]\n" + 
        "[1700 1750]\n" + 
        "\n" + 
        ",666(888):\n" + 
        "[300 500]\n" + 
        "[700 750]\n" + 
        "\n" + 
        ",123(777):\n" + 
        "[130 140]\n" + 
        "[160 200]\n" + 
        "\n";
    
    assertEquals(expected, getTimeSlotsString(demo.viewAllParkingSpots()));
  }
  
  @Rule
  public ExpectedException expectedEx = ExpectedException.none();
  
  @Test public void testBuySpot2() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Availability should only have one time slot");
    
    List<SlotImplementation> slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(140), new DateTimeImplementation(160)));
    slots.add(new SlotImplementation(new DateTimeImplementation(165), new DateTimeImplementation(170)));
    Availability buy_availability = new AvailabilityImplementation(slots);
    
    demo.buy(456, 777, buy_availability);
  }
  
  @Test public void testBuySpot3() {
    expectedEx.expect(NoSuchElementException.class);
    expectedEx.expectMessage("No such user id");
    
    List<SlotImplementation> slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(140), new DateTimeImplementation(160)));
    Availability buy_availability = new AvailabilityImplementation(slots);
    
    demo.buy(100, 777, buy_availability);
  }
  
  @Test public void testBuySpot4() {
    expectedEx.expect(NoSuchElementException.class);
    expectedEx.expectMessage("No such parking spot id");
    
    List<SlotImplementation> slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(140), new DateTimeImplementation(160)));
    Availability buy_availability = new AvailabilityImplementation(slots);
    
    demo.buy(456, 0, buy_availability);
  }
}
