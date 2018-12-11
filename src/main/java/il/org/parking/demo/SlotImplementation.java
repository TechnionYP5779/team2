package il.org.parking.demo;

import il.org.parking.*;

class SlotImplementation implements Slot{
  public DateTime start;
  public DateTime end;
  
  public SlotImplementation(DateTime start, DateTime end) {
    this.start = start;
    this.end = end;
  }
  

  @Override public String toString() {
    return "Slot [start=" + start + ", end=" + end + "]";
  }


  @Override public DateTime getStart() {
    return start;
  }


  @Override public DateTime getEnd() {
    return end;
  }
  
  
  
}