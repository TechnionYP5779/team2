package il.org.parking.demo;

import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;
import org.junit.rules.*;
import il.org.parking.*;

public class ParkingDemoTest {
  private ParkingDemo demo;
  private User seller123;
  private User seller666;

  @Before public void setup() {
    ReservationFactory rf = new ReservationFactoryImplementation();
    this.demo = new ParkingDemo(new DataBaseDummie(), rf);
    this.seller123 = demo.addUser(123, "honey-boo", "poo@honey.com");
    this.seller666 = demo.addUser(666, "goerge", "yo@bae.com");
    demo.addUser(456, "buybuybuy!", "i_have@money.com");
    demo.addUser(999, "poor-man", "i_dont_have@money.com");
    List<SlotImplementation> slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(130), new DateTimeImplementation(200)));
    Availability availability = new AvailabilityImplementation(slots);
    Location location = new LocationImplementation(10.0, 10.0);
    ParkingSpot parkingSpot = new ParkingSpotImplementation(777, availability, seller123, 33.5, location);
    demo.sell(parkingSpot);
    slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(300), new DateTimeImplementation(500)));
    slots.add(new SlotImplementation(new DateTimeImplementation(700), new DateTimeImplementation(750)));
    availability = new AvailabilityImplementation(slots);
    location = new LocationImplementation(100.0, 100.0);
    parkingSpot = new ParkingSpotImplementation(888, availability, seller666, 330.3, location);
    demo.sell(parkingSpot);
    slots = new ArrayList<>();
    slots.add(new SlotImplementation(new DateTimeImplementation(1000), new DateTimeImplementation(1500)));
    slots.add(new SlotImplementation(new DateTimeImplementation(1700), new DateTimeImplementation(1750)));
    availability = new AvailabilityImplementation(slots);
    location = new LocationImplementation(15.5, 10.9);
    parkingSpot = new ParkingSpotImplementation(999, availability, seller666, 3308.3, location);
    demo.sell(parkingSpot);
  }

  private static String getParkingSpotString(ParkingSpot ps) {
    String $ = ps.getSeller().getId() + "(" + ps.getId() + "):\n";
    Availability av = ps.getAvailability();
    for (int ¢ = 0; ¢ < av.getNumberOfIntervals(); ++¢)
      $ += "[" + av.getSlots(¢).getStart().getTime() + " " + av.getSlots(¢).getEnd().getTime() + "]\n";
    return $ + "\n";
  }

  private static String getTimeSlotsString(List<ParkingSpot> list) {
    return list.stream().map(ps -> getParkingSpotString(ps)).collect(Collectors.joining(""));
  }

  @Test public void testSellSpot() {
    String expected = "666(999):\n[1000 1500]\n[1700 1750]\n\n666(888):\n[300 500]\n[700 750]\n\n123(777):\n[130 200]\n\n";
    assertEquals(expected, getTimeSlotsString(demo.viewAllParkingSpots()));
  }

  private static Availability buildBuyAvailability(Integer start, Integer end) {
    List<SlotImplementation> $ = new ArrayList<>();
    $.add(new SlotImplementation(new DateTimeImplementation(start), new DateTimeImplementation(end)));
    return new AvailabilityImplementation($);
  }

  @Test public void testBuySpot() {
    Availability buy_availability = buildBuyAvailability(140, 160);
    demo.buy(456, 777, buy_availability);
    String expected = "666(999):\n[1000 1500]\n[1700 1750]\n\n666(888):\n[300 500]\n[700 750]\n\n123(777):\n[130 140]\n[160 200]\n\n";
    assertEquals(expected, getTimeSlotsString(demo.viewAllParkingSpots()));
  }

  @Rule public ExpectedException expectedEx = ExpectedException.none();

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
    Availability buy_availability = buildBuyAvailability(140, 160);
    demo.buy(100, 777, buy_availability);
  }

  @Test public void testBuySpot4() {
    expectedEx.expect(NoSuchElementException.class);
    expectedEx.expectMessage("No such parking spot id");
    Availability buy_availability = buildBuyAvailability(140, 160);
    demo.buy(456, 0, buy_availability);
  }

  @Test public void testBuySpot5() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("isnt available");
    Availability buy_availability = buildBuyAvailability(2000, 2160);
    demo.buy(456, 777, buy_availability);
  }

  @Test public void testBuySpot6() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("isnt available");
    Availability buy_availability = buildBuyAvailability(140, 201);
    demo.buy(456, 777, buy_availability);
  }

  @Test public void testBuySpot7() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("isnt available");
    Availability buy_availability = buildBuyAvailability(135, 201);
    demo.buy(456, 777, buy_availability);
  }

  @Test public void testBuySpot8() {
    Availability buy_availability = buildBuyAvailability(135, 200);
    demo.buy(456, 777, buy_availability);
    String expected = "666(999):\n[1000 1500]\n[1700 1750]\n\n666(888):\n[300 500]\n[700 750]\n\n123(777):\n[130 135]\n\n";
    assertEquals(expected, getTimeSlotsString(demo.viewAllParkingSpots()));
  }

  @Test public void testBuySpot9() {
    Availability buy_availability = buildBuyAvailability(130, 190);
    demo.buy(456, 777, buy_availability);
    String expected = "666(999):\n[1000 1500]\n[1700 1750]\n\n666(888):\n[300 500]\n[700 750]\n\n123(777):\n[190 200]\n\n";
    assertEquals(expected, getTimeSlotsString(demo.viewAllParkingSpots()));
  }

  @Test public void testBuySpot10() {
    Availability buy_availability = buildBuyAvailability(130, 200);
    demo.buy(456, 777, buy_availability);
    String expected = "666(999):\n[1000 1500]\n[1700 1750]\n\n666(888):\n[300 500]\n[700 750]\n\n123(777):\n\n";
    assertEquals(expected, getTimeSlotsString(demo.viewAllParkingSpots()));
  }

  @Test public void testViewFromLocation() {
    String expected = "666(999):\n[1000 1500]\n[1700 1750]\n\n666(888):\n[300 500]\n[700 750]\n\n123(777):\n[130 200]\n\n";
    LocationImplementation loc = new LocationImplementation(5.0, 7.0);
    assertEquals(expected, getTimeSlotsString(demo.viewParkingSpotsFromLocation(loc, 200)));
  }

  @Test public void testViewFromLocation2() {
    LocationImplementation loc = new LocationImplementation(5.0, 7.0);
    assertEquals("", getTimeSlotsString(demo.viewParkingSpotsFromLocation(loc, 0.1)));
  }

  @Test public void testViewFromLocation3() {
    String expected = "666(999):\n[1000 1500]\n[1700 1750]\n\n123(777):\n[130 200]\n\n";
    LocationImplementation loc = new LocationImplementation(5.0, 7.0);
    assertEquals(expected, getTimeSlotsString(demo.viewParkingSpotsFromLocation(loc, 20.0)));
  }
}
