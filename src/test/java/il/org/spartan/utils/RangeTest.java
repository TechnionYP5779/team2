package il.org.spartan.utils;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

@SuppressWarnings("static-method") public class RangeTest {
  @Test public void testEquals() {
    Range r1 = new Range(0, 3), r2 = new Range(r1), r3 = new Range(1, 3);
    assert !r1.equals(null);
    assert r1.equals(r2);
    assert r2.equals(r1);
    assert !r2.equals(r3);
    assert !r3.equals(r2);
  }

  @Test public void testIncludedIn() {
    Range r1 = new Range(0, 3), r2 = new Range(0, 1);
    assert r2.includedIn(r1);
    assert !r1.includedIn(r2);
    assert r1.includedIn(r1);
    assert r2.includedIn(r2);
  }

  @Test public void testMerge() {
    Range r1 = new Range(0, 3), r2 = new Range(0, 1), r3 = new Range(3, 5);
    assert r1.merge(r2).equals(r1);
    assert r2.merge(r3).equals(new Range(0, 5));
  }

  @Test public void testOverlapping() {
    Range r1 = new Range(0, 3), r2 = new Range(0, 1), r3 = new Range(3, 5), r4 = new Range(3, 0);
    assert r1.overlapping(r2);
    assert r2.overlapping(r1);
    assert r1.overlapping(r3);
    assert r3.overlapping(r1);
    assert r2.overlapping(r3);
    assert r3.overlapping(r2);
    assert !r2.overlapping(r4);
  }

  @Test public void testIsEmpty() {
    Range r2 = new Range(2, 0);
    assert !new Range(0, 2).isEmpty();
    assert r2.isEmpty();
    
  }
  @Test public void testPrune() {
    Range r1 = new Range(0, 3), r2 = new Range(0, 1), r3 = new Range(3, 5), r4 = new Range(2, 4);
    List<Range> l = new ArrayList<>();
    l.add(r1);
    l.add(r2);
    l.add(r3);
    l.add(r4);
    r1.pruneIncluders(l);
    assert l.containsAll(l.stream().filter(λ -> !λ.equals(r1)).collect(Collectors.toSet()));
    r2.pruneIncluders(l);
    assert l.containsAll(l.stream().filter(λ -> !λ.equals(r2)).collect(Collectors.toSet()));
  }
  
  @Test public void testToString() {
    Assert.assertEquals(new Range(0, 3) + "", "[0, 3]");
  }
}
