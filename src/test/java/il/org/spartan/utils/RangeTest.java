package il.org.spartan.utils;

import java.util.*;

// import fluent.ly.azzert;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RangeTest {
  @Test public void testInfiniteRangeInc() {
    Range r = new Range();
    r.from(2);
    azzert.assertEquals(true, r.includes(2));
    azzert.assertEquals(true, r.includes(10));
    azzert.assertEquals(true, r.includes(Integer.MAX_VALUE - 1));
    azzert.assertEquals(false, r.includes(1));
    azzert.assertEquals(false, r.includes(-7));
  }

  @Test @SuppressWarnings({ "boxing", "static-access" }) public void testStartingPoint() {
    azzert.assertEquals(2, (new Range()).from(2).from());
    azzert.assertNotEquals(8, (int) (new Range()).from(-4).from());
  }

  @Test public void testFromAndTo() {
    Range r = new Range();
    r.from(2).to(6);
    for (int ¢ = 2; ¢ <= 5; ++¢)
      azzert.assertEquals(true, r.includes(¢));
    azzert.assertEquals(false, r.includes(1));
    azzert.assertEquals(false, r.includes(6));
    azzert.assertEquals(false, r.includes(1322));
  }

  @Test public void testInfiniteRangeDec() {
    Range r = new Range();
    r.to(2);
    azzert.assertEquals(true, r.includes(1));
    azzert.assertEquals(true, r.includes(0));
    azzert.assertEquals(true, r.includes(Integer.MIN_VALUE));
    azzert.assertEquals(false, r.includes(2));
    azzert.assertEquals(false, r.includes(12313));
  }

  @Test public void testFromMinInt() {
    azzert.assertNull((new Range()).to(2).from());
  }

  @Test public void testToFrom() {
    Range r = new Range();
    r.to(2).from(-5);
    for (int ¢ = -5; ¢ <= 1; ++¢)
      azzert.assertEquals(true, r.includes(¢));
    azzert.assertEquals(false, r.includes(-6));
    azzert.assertEquals(false, r.includes(2));
    azzert.assertEquals(false, r.includes(1322));
  }

  @Test public void testNumbersFunction() {
    // finite range
    Iterator<Integer> numbers = new Range().from(3).to(10).numbers();
    int i = 4;
    for (; numbers.hasNext(); ++i)
      azzert.assertEquals(i, numbers.next());
    azzert.assertEquals(10, i);
    // infinite range
    numbers = new Range().numbers();
    azzert.assertEquals(Integer.MIN_VALUE + 1, numbers.next());
    azzert.assertEquals(Integer.MIN_VALUE + 2, numbers.next());
  }

  @Test public void testIntersectionTwoInfinite() {
    Range r = new Range().to(10).intersect(new Range().from(3));
    for (int ¢ = 3; ¢ <= 9; ++¢)
      azzert.assertEquals(true, r.includes(¢));
    azzert.assertEquals(false, r.includes(2));
    azzert.assertEquals(false, r.includes(10));
    azzert.assertEquals(false, r.includes(-3123));
  }

  @Test public void testIntersectionEmpty() {
    azzert.assertNull(new Range().to(-3).intersect(new Range().from(3)));
    azzert.assertNull(new Range().to(3).intersect(new Range().from(3)));
  }

  @Test public void testIntersectionOne() {
    Range r = new Range().to(4).intersect(new Range().from(3));
    azzert.assertEquals(true, r.includes(3));
    azzert.assertEquals(false, r.includes(2));
    azzert.assertEquals(false, r.includes(4));
  }

  @Test public void testIntersectionFull() {
    Range r = new Range().from(2).to(8).intersect(new Range().from(2).to(8));
    for (int ¢ = 2; ¢ <= 7; ++¢)
      azzert.assertEquals(true, r.includes(¢));
    azzert.assertEquals(false, r.includes(8));
    azzert.assertEquals(false, r.includes(1));
  }

  @Test public void testIntersectionIncluded() {
    Range r = new Range().from(1).to(111).intersect(new Range().from(2).to(8));
    for (int ¢ = 2; ¢ <= 7; ++¢)
      azzert.assertEquals(true, r.includes(¢));
    azzert.assertEquals(false, r.includes(8));
    azzert.assertEquals(false, r.includes(1));
  }

  @Test public void testIntersectionInfinity() {
    Range r = new Range().intersect(new Range());
    for (int ¢ = Integer.MIN_VALUE; ¢ < Integer.MAX_VALUE; ++¢)
      azzert.assertEquals(true, r.includes(¢));
  }
}
