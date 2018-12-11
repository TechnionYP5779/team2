package il.org.parking.demo;

import java.time.*;

import il.org.parking.*;

public class DateTimeImplementation implements DateTime{
  
  Integer time;
  
  

  public DateTimeImplementation(Integer time) {
    this.time = time;
  }

  @Override public LocalDateTime getDate() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public Boolean isBetween(DateTime start, DateTime finish) {
    return (start.getTime() <= time && time <= finish.getTime());
  }

  @Override public Integer getTimeFrom(DateTime later) {
    return later.getTime() - time;
  }

  @Override public Integer getTime() {
    return time;
  }

  @Override public String toString() {
    return "DateTimeImplementation [time=" + time + "]";
  }
  
  
}
