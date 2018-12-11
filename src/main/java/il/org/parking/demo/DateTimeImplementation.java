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

  @Override public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((time == null) ? 0 : time.hashCode());
    return result;
  }

  @Override public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DateTimeImplementation other = (DateTimeImplementation) obj;
    if (time == null) {
      if (other.time != null)
        return false;
    } else if (!time.equals(other.time))
      return false;
    return true;
  }
  
  
  
}
