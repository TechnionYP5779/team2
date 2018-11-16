package il.org.spartan.utils;

import java.util.*;

public class Range {
  public int from;
  public int to;

  public Range() {
    from = Integer.MIN_VALUE;
    to = Integer.MAX_VALUE - 1;
  }

  public Range from(final int param) {
    from = param;
    return this;
  }

  public Range to(final int param) {
    to = param - 1;
    return this;
  }

  @SuppressWarnings("boxing") public Integer from() {
    return from == Integer.MIN_VALUE ? null : from;
  }

  public boolean includes(final int param) {
    return param >= from && param <= to;
  }

  public Iterator<Integer> numbers() {
    return new Iterator<Integer>() {
      int current = from;

      @Override @SuppressWarnings("boxing") public Integer next() {
        return ++current;
      }

      @Override public boolean hasNext() {
        return current < to;
      }
    };
  }

  @SuppressWarnings("hiding") public Range intersect(final Range r) {
    final int $ = Math.max(from, r.from), to = Math.min(this.to, r.to) + 1;
    return $ >= to ? null : new Range().from($).to(to);
  }
}
