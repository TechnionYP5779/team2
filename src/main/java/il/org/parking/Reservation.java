package il.org.parking;

public interface Reservation {
  
  /** Gets the buyer of this reservation.
   * @return User that represents the buyer */
  User getBuyer();

  /** Gets the seller of this reservation.
   * @return User that represents the seller */
  User getSeller();
  
  /** Gets the price of this reservation.
   * @return Price that represents the price */
  Price getPrice(); 
  
  /** Gets the duration of this reservation.
   * @return integer that represents the duration in minutes */
  int getDuration();
  
  /** Gets the starting time of this reservation.
   * @return DateTime that represents the starting time */
  DateTime getStartTime();
  
  /** Gets the id of this reservation.
   * @return integer that represents the id */
  int getId();
}
