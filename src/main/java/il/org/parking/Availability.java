package il.org.parking;

import java.util.*;

/**
 * This interface describes a list of DateTime intervals
 * @version 1.0
 * @author Tal Porat
 */
public interface Availability {
  
  /**
   * This method is used to check whether a DateTime is included in
   * one of the intervals of the Availability object
   * @param time This is the a DateTime parameter that we want to check
   * @return Boolean This returns true if time is included in
   *         one of the intervals and false otherwise.
   */
  Boolean isAvailable(DateTime time);
  
  /**
   * This method creates a new Availability object that its intervals 
   * are the intersection of the Availability object intervals and the other
   * Availability object intervals
   * @param other This is the other Availability
   * @return Availability This is the new Availability that was created
   */
  Availability intersection(Availability other);
  
  /**
   * This method creates a new Availability object that its intervals 
   * are the subtraction of the Availability object intervals and the other
   * Availability object intervals
   * @param other This is the other Availability
   * @return Availability This is the new Availability that was created
   */
  Availability subtraction(Availability other);
  
  /**
   * This method is used to get the total duration of all the intervals
   * @return Integer This is the value of the total duration
   */
  Boolean isAvailable(DateTime start, DateTime end);
  
  Integer getDuration();
  
  Boolean doesContaines(Availability other);
  
  Integer getNumberOfIntervals();
  
  DateTime getStartTime();

  Availability subtraction(DateTime start, DateTime end);
  
  Slot getSlots(int index);
}
