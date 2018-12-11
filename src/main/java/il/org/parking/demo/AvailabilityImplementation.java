package il.org.parking.demo;

import java.util.*;

import il.org.parking.*;

// TODO: change from using SlotImplementation to using Slot
public class AvailabilityImplementation implements Availability {
  List<SlotImplementation> slots = new ArrayList<>();

  public AvailabilityImplementation(List<SlotImplementation> slots) {
    this.slots = slots;
  }

  @Override public Boolean isAvailable(DateTime time) {
    for (SlotImplementation s : slots) {
      if (time.isBetween(s.start, s.end)) {
        return true;
      }
    }
    return false;
  }

  @Override public Boolean isAvailable(DateTime start, DateTime end) {
    for (SlotImplementation s : slots) {
      if (start.isBetween(s.start, s.end) && end.isBetween(s.start, s.end)) {
        return true;
      }
    }
    return false;
  }

  @Override public Availability intersection(Availability other) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override public Availability subtraction(DateTime start, DateTime end) {
    List<SlotImplementation> newSlots = new ArrayList<>();
    for (SlotImplementation s : slots) {
      if (start.isBetween(s.start, s.end)) {
        newSlots.add(new SlotImplementation(s.start, start));
        if (end.isBetween(start, s.end)) {
          newSlots.add(new SlotImplementation(end, s.end));
        }
      } else if (s.getStart().isBetween(start, end)) {
        if (end.isBetween(s.getStart(), s.getEnd())) {
          newSlots.add(new SlotImplementation(end, s.getEnd()));
        }
      } else {
        newSlots.add(s);
      }
    }
    return new AvailabilityImplementation(newSlots);
  }

  @Override public Availability subtraction(Availability other) {
    Availability newAvailability = this;
    for (int i = 0; i < other.getNumberOfIntervals(); i++) {
      Slot s = other.getSlots(i);
      newAvailability = newAvailability.subtraction(s.getStart(), s.getEnd());
    }
    return newAvailability;
  }

  @Override public Integer getDuration() {
    Integer total_time = 0;
    for (SlotImplementation s : slots) {
      total_time += s.start.getTimeFrom(s.end);
    }
    return total_time;
  }

  @Override public Boolean doesContaines(Availability other) {
    return (other.subtraction(this).getDuration() == 0);
  }

  @Override public Integer getNumberOfIntervals() {
    return slots.size();
  }

  @Override public DateTime getStartTime() {
    return slots.get(0).start;
  }

  @Override public String toString() {
    return "AvailabilityImplementation [slots=" + slots + "]";
  }

  @Override public Slot getSlots(int index) {
    return slots.get(index);
  }
}
