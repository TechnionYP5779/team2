package il.org.parking;

/** This class implements the Reservation interface. 
 * @author JessicaMilgram */
public class ParkingSpotReservation implements Reservation {
  
  private User buyer;
  private User seller;
  private Price price;
  private int duration;
  private DateTime startTime;
  private int id;

  public ParkingSpotReservation(User buyerIn, User sellerIn, Price priceIn, int durationIn, DateTime startTimeIn, int idIn) {
    buyer = buyerIn;
    seller = sellerIn;
    price = priceIn;
    duration = durationIn;
    startTime = startTimeIn;
    id = idIn;
  }
  
  @Override public User getBuyer() {
    return buyer;
  }

  @Override public User getSeller() {
    return seller;
  }

  @Override public Price getPrice() {
    return price;
  }

  @Override public int getDuration() {
    return duration;
  }

  @Override public DateTime getStartTime() {
    return startTime;
  }

  @Override public int getId() {
    return id;
  }
}
