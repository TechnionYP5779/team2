package il.org.parking.demo;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

import il.org.parking.*;
import il.org.parking.exceptions.*;

import static fluent.ly.box.*;
/**
 * 
 * @author OGluc
 *Commands:
 *
 *addUser [id] [name] [mail]
 *
 *sell [parkingspot_id] [seller_id] [price] [x coordinate] [y coordinate] ([start_time],[end_time])+
 *
 *updatePS [parkingspot_id] [newPrice] [new x coordinate] [new y coordinate] ([new start_time],[new end_time])+
 *
 *buy [buyer_id] [parkingspot_id] [start_time],[end_time]
 *
 *viewAll
 *
 *viewByRadius [x coordinate] [y coordinate] [radius]
 *
 *reservations
 *
 */
public class ConsoleDemo {
  
  private ReservationFactory reservationFactory = new ReservationFactoryImplementation();
  private ParkingDemo demo = new ParkingDemo(new DataBaseDummie(), reservationFactory);
  
  private static String getParkingSpotString(ParkingSpot ps) {
    String $ = "seller id = "+ps.getSeller().getId() + " (parking spot id = " + ps.getId() + "):\n";
    $ += "price = "+ps.getPrice()+" coordinates = "+ps.getLocation().toString()+"\n";
    $ += "Available time slots:\n";
    Availability av = ps.getAvailability();
    for (int ¢ = 0; ¢ < av.getNumberOfIntervals(); ++¢)
      $ += "[" + av.getSlots(¢).getStart().getTime() + " " + av.getSlots(¢).getEnd().getTime() + "]\n";
    return $ + "\n";
  }

  private static String getTimeSlotsString(List<ParkingSpot> list) {
    return list.stream().map(ps -> getParkingSpotString(ps)).collect(Collectors.joining(""));
  }
  
  
  private static void printHistory(List<Reservation> list) {
    list.stream().forEach(r -> System.out.println(r));
  }
  
  private void history() {
    printHistory(demo.getAllReservations());
  }
  
  private void addUser(String[] input) {
    Integer id = Integer.parseInt(input[1]);
    String name = input[2];
    String contact_info = input[3];
    demo.addUser(id, name, contact_info);
    
    System.out.println("User added!");
  }
  
  private void buy(String[] input) throws ParkingSpotNotInSystem {
    Integer buyer_id = Integer.parseInt(input[1]);
    Integer ps_id = Integer.parseInt(input[2]);
    String availabilityStr = input[3];
    Integer start = Integer.parseInt(availabilityStr.split(",")[0]);
    Integer end = Integer.parseInt(availabilityStr.split(",")[1]);
    
    List<SlotImplementation> $ = new ArrayList<>();
    $.add(new SlotImplementation(new DateTimeImplementation(start), new DateTimeImplementation(end)));
    Availability availability = new AvailabilityImplementation($);
    demo.buy(buyer_id, ps_id, availability);
    
    System.out.println(buyer_id+" bought the slot!");
  }
  private void updateParkingSpot(String[] input) throws ParkingSpotNotInSystem {
    Integer ps_id = Integer.parseInt(input[1]);
    Double new_price = Double.parseDouble(input[2]);
    Double new_x = Double.parseDouble(input[3]);
    Double new_y = Double.parseDouble(input[4]);
    
    
    List<SlotImplementation> slots = new ArrayList<>();
    
    
    for(int i = 5; i< input.length; i++) {
      String availabilityStr = input[i];
      Integer start = Integer.parseInt(availabilityStr.split(",")[0]);
      Integer end = Integer.parseInt(availabilityStr.split(",")[1]);
      slots.add(new SlotImplementation(new DateTimeImplementation(start), new DateTimeImplementation(end)));
    }
    
    Availability availability = new AvailabilityImplementation(slots);
    Location new_location = new LocationImplementation(new_x, new_y);
    User seller = demo.getParkingSpot(ps_id).getSeller();
    ParkingSpot parkingSpot = new ParkingSpotImplementation(ps_id, availability, seller, new_price, new_location);
    demo.updateParkingSpot(parkingSpot);
    
    System.out.println(seller.getName()+" updated the parking spot!");
  }
  
  private void sell(String[] input) {
    Integer ps_id = Integer.parseInt(input[1]);
    Integer seller_id = Integer.parseInt(input[2]);
    Double price = Double.parseDouble(input[3]);
    Double x = Double.parseDouble(input[4]);
    Double y = Double.parseDouble(input[5]);
    
    
    List<SlotImplementation> slots = new ArrayList<>();
    
    
    for(int i = 6; i<input.length; i++) {
      String availabilityStr = input[i];
      Integer start = Integer.parseInt(availabilityStr.split(",")[0]);
      Integer end = Integer.parseInt(availabilityStr.split(",")[1]);
      slots.add(new SlotImplementation(new DateTimeImplementation(start), new DateTimeImplementation(end)));
    }
    
    Availability availability = new AvailabilityImplementation(slots);
    Location location = new LocationImplementation(x, y);
    User seller = demo.getUser(seller_id);
    ParkingSpot parkingSpot = new ParkingSpotImplementation(ps_id, availability, seller, price, location);
    demo.sell(parkingSpot);
    
    System.out.println(seller.getName()+" put the parking spot to sale!");
  }
  
  private void viewAll() {
    System.out.println(getTimeSlotsString(demo.viewAllParkingSpots()));
  }
  
  
  private void viewByRadius(String[] input) {
    
    Double x = Double.parseDouble(input[1]);
    Double y = Double.parseDouble(input[2]);
    Double radius = Double.parseDouble(input[3]);
    
    Location location = new LocationImplementation(x, y);
    System.out.println(getTimeSlotsString(demo.viewParkingSpotsFromLocation(location, radius)));
  }
  
  public void run(){
    Scanner reader = new Scanner(System.in);
    
    while(true) {
      try {
      String input = reader.nextLine();
      String[] input_arr = input.split(" ");
      
      switch (input_arr.length) {
        case 1:
          if(input_arr[0].equals("viewAll")) viewAll();
          else if(input_arr[0].equals("reservations")) history();
          else System.out.println("invalid command");
          break;
        case 4:
          if(input_arr[0].equals("addUser")) addUser(input_arr);
          else if(input_arr[0].equals("buy")) buy(input_arr);
          else if(input_arr[0].equals("viewByRadius")) viewByRadius(input_arr);
          else System.out.println("invalid command");
          break;
        default:
          if(input_arr.length>=7 && input_arr[0].equals("sell")) sell(input_arr);
          else if(input_arr.length>=6 && input_arr[0].equals("updatePS")) updateParkingSpot(input_arr);
          else System.out.println("invalid command");
          break;
      }
      }
      catch (Exception e) {
        System.out.println("Oh oh! " + e.getClass().getSimpleName() + " was thrown... try again!"); 
        e.printStackTrace();
      }
      
    }
  }
  
  @Test
  public void wrapper(){
    run();
    
  }
}
