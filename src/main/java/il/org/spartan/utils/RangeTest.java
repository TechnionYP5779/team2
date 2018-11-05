package il.org.spartan.utils;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

@SuppressWarnings("static-method") public class RangeTest {
  @Test public void testEquals() {
    Range r1 = new Range(0, 3);
    Range r2 = new Range(r1);
    Range r3 = new Range(1, 3);
    Assert.assertFalse(r1.equals(null));
    Assert.assertTrue(r1.equals(r2));
    Assert.assertTrue(r2.equals(r1));
    Assert.assertFalse(r2.equals(r3));
    Assert.assertFalse(r3.equals(r2));
  }

  @Test public void testIncludedIn() {
    Range r1 = new Range(0, 3);
    Range r2 = new Range(0, 1);
    Assert.assertTrue(r2.includedIn(r1));
    Assert.assertFalse(r1.includedIn(r2));
    Assert.assertTrue(r1.includedIn(r1));
    Assert.assertTrue(r2.includedIn(r2));
  }

  @Test public void testMerge() {
    Range r1 = new Range(0, 3);
    Range r2 = new Range(0, 1);
    Range r3 = new Range(3, 5);
    Assert.assertTrue(r1.merge(r2).equals(r1));
    Assert.assertTrue(r2.merge(r3).equals(new Range(0, 5)));
  }

  @Test public void testOverlapping() {
    Range r1 = new Range(0, 3);
    Range r2 = new Range(0, 1);
    Range r3 = new Range(3, 5);
    Range r4 = new Range(3, 0);
    // from >= ¢.from || to <= ¢.to
    Assert.assertTrue(r1.overlapping(r2)); // true || false
    Assert.assertTrue(r2.overlapping(r1)); // true || true
    Assert.assertTrue(r1.overlapping(r3)); // false || true
    Assert.assertTrue(r3.overlapping(r1)); // true || false
    Assert.assertTrue(r2.overlapping(r3)); // false || true
    Assert.assertTrue(r3.overlapping(r2)); // true || false
    Assert.assertFalse(r2.overlapping(r4)); // false || false
  }

  @Test public void testIsEmpty() {
    Range r1 = new Range(0,2);
    Range r2 = new Range(2,0);
    Assert.assertFalse(r1.isEmpty());
    Assert.assertTrue(r2.isEmpty());
    
  }
  @Test public void testPrune() {
    Range r1 = new Range(0, 3);
    Range r2 = new Range(0, 1);
    Range r3 = new Range(3, 5);
    Range r4 = new Range(2, 4);
    List<Range> l = new ArrayList<>();
    l.add(r1);
    l.add(r2);
    l.add(r3);
    l.add(r4);
    r1.pruneIncluders(l);
    Assert.assertTrue(l.containsAll(l.stream().filter(r -> !r.equals(r1)).collect(Collectors.toSet())));
    r2.pruneIncluders(l);
    Assert.assertTrue(l.containsAll(l.stream().filter(r -> !r.equals(r2)).collect(Collectors.toSet())));
  }
  
  @Test public void testToString() {
    Range r = new Range(0,3);
    Assert.assertEquals(r.toString(), "[0, 3]");
  }
}
