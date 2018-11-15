package il.org.spartan.utils;

import static il.org.spartan.Utils.*;
import static org.junit.Assert.assertNotEquals;

import static fluent.ly.azzert.assertEquals;
import static fluent.ly.azzert.assertNull;

import java.util.*;

// import fluent.ly.azzert;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RangeTest {
  @Test public void rangeFrom() {
    range.from(2);
  }

  @Test public void testInfiniteRangeInc() {
    final Range r = new Range();
    r.from(2);
    assert r.includes(2);
    assert r.includes(10);
    assert r.includes(Integer.MAX_VALUE - 1);
    assert !r.includes(1);
    assert !r.includes(-7);
  }

  @Test public void testStartingPoint() {
    assertEquals(2, new Range().from(2).from());
    assertNotEquals(8, fluent.ly.unbox.it(cantBeNull(new Range().from(-4).from())));
  }

  @Test public void testFromAndTo() {
    final Range r = new Range();
    r.from(2).to(6);
    for (int ¢ = 2; ¢ <= 5; ++¢)
      assert r.includes(¢);
    assert !r.includes(1);
    assert !r.includes(6);
    assert !r.includes(1322);
  }

  @Test public void testInfiniteRangeDec() {
    final Range r = new Range();
    r.to(2);
    assert r.includes(1);
    assert r.includes(0);
    assert r.includes(Integer.MIN_VALUE);
    assert !r.includes(2);
    assert !r.includes(12313);
  }

  @Test public void testFromMinInt() {
    assertNull(new Range().to(2).from());
  }

  @Test public void testToFrom() {
    final Range r = new Range();
    r.to(2).from(-5);
    for (int ¢ = -5; ¢ <= 1; ++¢)
      assert r.includes(¢);
    assert !r.includes(-6);
    assert !r.includes(2);
    assert !r.includes(1322);
  }

  @Test public void testNumbersFunction() {
    // finite range
    Iterator<Integer> numbers = new Range().from(3).to(10).numbers();
    int i = 4;
    for (; numbers.hasNext(); ++i)
      assertEquals(i, numbers.next());
    assertEquals(10, i);
    // infinite range
    numbers = new Range().numbers();
    assertEquals(Integer.MIN_VALUE + 1, numbers.next());
    assertEquals(Integer.MIN_VALUE + 2, numbers.next());
  }

  @Test public void testIntersectionTwoInfinite() {
    final Range r = new Range().to(10).intersect(new Range().from(3));
    for (int ¢ = 3; ¢ <= 9; ++¢)
      assert r.includes(¢);
    assert !r.includes(2);
    assert !r.includes(10);
    assert !r.includes(-3123);
  }

  @Test public void testIntersectionEmpty() {
    assertNull(new Range().to(-3).intersect(new Range().from(3)));
    assertNull(new Range().to(3).intersect(new Range().from(3)));
  }

  @Test public void testIntersectionOne() {
    final Range r = new Range().to(4).intersect(new Range().from(3));
    assert r.includes(3);
    assert !r.includes(2);
    assert !r.includes(4);
  }

  @Test public void testIntersectionFull() {
    final Range r = new Range().from(2).to(8).intersect(new Range().from(2).to(8));
    for (int ¢ = 2; ¢ <= 7; ++¢)
      assert r.includes(¢);
    assert !r.includes(8);
    assert !r.includes(1);
  }

  @Test public void testIntersectionIncluded() {
    final Range r = new Range().from(1).to(111).intersect(new Range().from(2).to(8));
    for (int ¢ = 2; ¢ <= 7; ++¢)
      assert r.includes(¢);
    assert !r.includes(8);
    assert !r.includes(1);
  }

  @Test public void testIntersectionInfinity() {
    final Range r = new Range().intersect(new Range());
    for (int ¢ = Integer.MIN_VALUE; ¢ < Integer.MAX_VALUE; ++¢)
      assert r.includes(¢);
  }
}
