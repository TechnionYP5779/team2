package il.org.parking;

import java.time.*;

/** This interface represents a certain moment, namely a date and a time
 * @version 1.0
 * @author Dor Kabareti */
public interface DateTime {
  /** This method is used to return the stored date in the DateTime object
   * @return LocalDateTime, which is the java LocalDateTime object that is stored
   *         in the current object */
  LocalDateTime getDate();
}
