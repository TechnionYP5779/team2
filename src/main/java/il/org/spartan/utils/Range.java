package il.org.spartan.utils;

import java.util.*;

import fluent.ly.*;

public class Range {

  public int from = Integer.MIN_VALUE;
  public int to = Integer.MAX_VALUE;
  int jumpBy = 1;
  
  boolean infinite = true;
  boolean empty;
  
  static PerformedTo numbers = Range.from(Integer.MIN_VALUE).to(Integer.MAX_VALUE);
  
  /*
   * a class for representing an iteration over range
   */
  abstract class RangeIterator<T extends RangeIterator<T>> implements Iterable<Integer> {

    @Override public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {
        int currentNumber = from;

        //the range has next iff it is infinte or the current number is not yet "to"
        @Override public boolean hasNext() {
          return infinite || currentNumber < to;
        }

        //the next number is the current one plus the step we do (jumpBy)
        @Override public Integer next() {
          if (!hasNext())
            throw new NoSuchElementException();
          
          int $ = currentNumber;
          currentNumber += jumpBy;
          return box.box($);
        }
      };
    }

    //an abstract method for returning the current object
    abstract T selfObject();
    
    public boolean includes(int x) {
      return from <= x && to > x;
    }
    

    public boolean isInfinite() {
      return infinite;
    }
    
    public boolean isEmpty() {
      return empty;
    }
    
    
    @SuppressWarnings("boxing") public PerformedTo intersect(PerformedTo r) {
      Integer $ = r.from(), to2 = r.to();
      return to > $ && to2 > from ? Range.from(Math.max(from, $)).to(Math.min(to, to2)) : new Range() {
        {
          empty = true;
        }
      }.new PerformedTo();
    }
    
    @SuppressWarnings("boxing") public PerformedTo intersect(PerformedFrom ¢) {
      Integer $ = ¢.from();
      return to > $ ? Range.from($).to(to) : new Range() {
        {
          empty = true;
        }
      }.new PerformedTo();
    }
    
   
  }
  
  /*
   * a class for representing a range that the method to() has NOT already been operated on it
   */
  public class PerformedFrom extends RangeIterator<PerformedFrom> {
    
    public PerformedTo to(final int toParam) {
      to = toParam;
      infinite = false;
      return new PerformedTo();
    }
    
    @Override PerformedFrom selfObject() {
      return this;
    }
    
    public int from() {
      return from;
    }
    
    public Integer to() {
      return infinite ? null : box.box(to);
    }

    
    

  }

  
  /*
   * a class for representing a range that the method to() has already been operated on it
   */
  public class PerformedTo extends RangeIterator<PerformedTo> {
    public PerformedTo from(final int fromParam) {
      return new PerformedTo() {
        {
          from = fromParam;
          empty = infinite = false;
          jumpBy = 1;
        }
      };
    }
    
    public Integer from() {
      return infinite ? null : box.box(from);
    }
    
    public int to() {
      return to;
    }

    @Override PerformedTo selfObject() {
      return this;
    }
    
    
  }
  
  //statically create an infinite range with range.from($)
  public static PerformedFrom from(int fromParam) {
    return new Range() {
      {
        from = fromParam;
        empty = false;
        infinite = true;
      }
    }.new PerformedFrom();
  }

  
//statically create an infinite range with range.to($)
  public static PerformedTo to(int toParam) {
    return new Range() {
      {
        jumpBy = -1; //down
        to = toParam;
        empty = false;
        infinite = true;
      }
    }.new PerformedTo();
  }
}
