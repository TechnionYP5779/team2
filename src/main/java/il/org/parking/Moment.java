package il.org.parking;

import java.time.*;

/** This class implements the DateTime interface. It stores a moment in time as
 * a private field.
 * @author DorKabareti */
public class Moment implements DateTime {
  private LocalDateTime savedMoment;

  /** The empty constructor stores the current moment */
  public Moment() {
    this.savedMoment = LocalDateTime.now();
  }

  /** @param date a LocalDate object that represents a date (day, month, year)
   * @param time a LocalTime object that represents a time (at least hour and a
   *             minute) */
  public Moment(LocalDate date, LocalTime time) {
    this.savedMoment = LocalDateTime.of(date, time);
  }

  /** This constructor gets 5 parameters that represents a moment in time, creates
   * a LocalDateTime objects and stores it in the current instance.
   * @param year
   * @param month
   * @param dayOfMonth
   * @param hour
   * @param minute */
  public Moment(int year, Month month, int dayOfMonth, int hour, int minute) {
    this.savedMoment = LocalDateTime.of(LocalDate.of(year, month, dayOfMonth), LocalTime.of(hour, minute));
  }

  /** get the saved LocalDateTime
   * @return the moment saved in the instance of the current Moment object */
  @Override public LocalDateTime getDate() {
    return savedMoment;
  }
}
