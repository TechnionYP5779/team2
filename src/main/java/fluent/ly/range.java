package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import java.util.*;

public class range {
  protected int from = Integer.MIN_VALUE;
  protected int to = Integer.MAX_VALUE;
  protected int jumpBy = 1;
  protected boolean infinite = true;
  protected boolean empty;
  
  protected range(){
    empty = true;
  }
  
  /* a class for representing an iteration over range */
  abstract class RangeIterator<T extends RangeIterator<T>> implements Iterable<Integer> {
    @Override public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {
        int currentNumber = from;

        // the range has next iff it is infinite or the current number is not yet "to"
        @Override public boolean hasNext() {
          return infinite || currentNumber < to;
        }

        // the next number is the current one plus the step we do (jumpBy)
        @Override public Integer next() {
          if (!hasNext())
            throw new NoSuchElementException();
          final int $ = currentNumber;
          currentNumber += jumpBy;
          return box($);
        }
      };
    }

    // an abstract method for returning the current object
    abstract T selfObject();

    public boolean includes(final int x) {
      return from <= x && to > x;
    }

    public boolean isInfinite() {
      return infinite;
    }

    public boolean isEmpty() {
      return empty;
    }

    public PerformedTo intersect(final PerformedTo t) {
      final int $ = unbox(cantBeNull(t.from())), to2 = t.to();
      return to <= $ || to2 <= from ? new range().new PerformedTo() : range.from(Math.max(from, $)).to(Math.min(to, to2));
    }

    public PerformedTo intersect(final PerformedFrom ¢) {
      final int $ = ¢.from();
      return to > $ ? range.from($).to(to) : new range().new PerformedTo();
    }
  }

  /* a class for representing a range that the method to() has NOT already been
   * operated on it */
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
      return infinite ? null : box(to);
    }
  }

  /* a class for representing a range that the method to() has already been
   * operated on it */
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
      return infinite ? null : box(from);
    }

    public int to() {
      return to;
    }

    @Override PerformedTo selfObject() {
      return this;
    }
  }

  // statically create an infinite range with range.from($)
  public static PerformedFrom from(final int fromParam) {
    return new range() {
      {
        from = fromParam;
        empty = false;
        infinite = true;
      }
    }.new PerformedFrom();
  }

  // statically create an infinite range with range.to($)
  public static PerformedTo to(final int toParam) {
    return new range() {
      {
        jumpBy = -1; // down
        to = toParam;
        empty = false;
        infinite = true;
      }
    }.new PerformedTo();
  }

  public static PerformedTo numbers = range.from(Integer.MIN_VALUE).to(Integer.MAX_VALUE);
}
