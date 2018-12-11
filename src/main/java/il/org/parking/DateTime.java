package il.org.parking;

import java.time.*;

/** This interface represents a certain moment, namely a date and a time
 * @version 1.1
 * @author Dor Kabareti */
public interface DateTime {
  /** This method is used to return the stored date in the DateTime object
   * @return LocalDateTime, which is the java LocalDateTime object that is stored
   *         in the current object */
  LocalDateTime getDate();

  /** @return the day of the month saved in the object */
  int getDayOfMonth();

  /** @return the month saved in the object */
  Month getMonth();

  /** @return the year saved in the object */
  int getYear();

  /** @return the minute saved in the object */
  int getMinute();

  /** @return the hour saved in the object */
  int getHour();
}
