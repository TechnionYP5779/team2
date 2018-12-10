package il.org.parking;

public interface ReservationFactory {
  Reservation create(User buyer, User seller, double price,int duration, DateTime startTime);
}
