package il.org.spartan.utils;

import java.util.*;

public class Range {
  public int from;
  public int to;

  public Range() {
    this.from = Integer.MIN_VALUE;
    this.to = Integer.MAX_VALUE - 1;
  }

  public Range from(final int ¢) {
    this.from = ¢;
    return this;
  }

  public Range to(final int ¢) {
    this.to = ¢ - 1;
    return this;
  }

  @SuppressWarnings("boxing") public Integer from() {
    return from == Integer.MIN_VALUE ? null : this.from;
  }

  public boolean includes(final int ¢) {
    return ¢ >= this.from && ¢ <= this.to;
  }

  /** [[SuppressWarningsSpartan]] */
  public Iterator<Integer> numbers() {
    final int iteratorTo = this.to;
    final int iteratorFrom = this.from;
    return new Iterator<Integer>() {
      int current = iteratorFrom;

      @Override @SuppressWarnings("boxing") public Integer next() {
        return ++current;
      }

      @Override public boolean hasNext() {
        return current < iteratorTo;
      }
    };
  }

  @SuppressWarnings("hiding") public Range intersect(final Range r) {
    final int from = Math.max(this.from, r.from);
    final int to = Math.min(this.to, r.to) + 1;
    return from >= to ? null : new Range().from(from).to(to);
  }
}
