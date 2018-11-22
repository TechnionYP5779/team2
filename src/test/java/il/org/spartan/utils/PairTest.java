package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PairTest {
  @Test public void testCreate() {
    final Pair<Integer, String> p = new Pair<>(box(1), "Hi");
    azzert.that(box(1), is(p.first));
    azzert.that("Hi", is(p.second));
  }

  @Test public void testToString() {
    azzert.that("<str,2.33>", is(new Pair<>("str", box(2.33)) + ""));
  }

  @Test @SuppressWarnings("null") public void testEquals() {
    final Pair<Integer, String> p1 = new Pair<>(box(12), "1"), p2 = new Pair<>(box(1), "2"), p3 = new Pair<>(box(2), "2"),
        p4 = new Pair<>(box(2), "2"), p5 = new Pair<>(box(2), "2");
    azzert.that(p1, is(not(p2)));
    azzert.that(p2, is(not(p3)));
    azzert.that(p1, is(not(p3)));
    azzert.that(p3, is(p4));
    assert p1.equals(p1);
    assert p4.equals(p5);
  }

  @Test public void testEqualsNullFirst() {
    assert new Pair<>(null, "1").equals(new Pair<>(null, "1"));
  }

  @Test public void testEqualsNullSecond() {
    assert new Pair<>(box(1), null).equals(new Pair<>(box(1), null));
  }

  @Test public void testEqualsNullBoth() {
    assert new Pair<>(null, null).equals(new Pair<>(null, null));
  }
  
  @Test public void testEqualsNotNullWithNull() {
    assert !new Pair<>(box(1), box(2)).equals(new Pair<>(null, null));
  }
  
  @Test public void testEqualsFalse() {
    assert !new Pair<>(box(1), box(2)).equals(new Pair<>(box(2), (box(1))));
  }

  @Test @SuppressWarnings("unlikely-arg-type") public void testEqualsNotSameClass() {
    assert !new Pair<>(null, null).equals(box(2));
  }

  @Test @SuppressWarnings("boxing") public void testHash() {
    final Integer first = 1;
    final Integer second = 2;
    final Pair<Integer, Integer> p = new Pair<>(first, second);
    azzert.that(p.hashCode(), is(p.hashCode()));
  }

  @Test public void testMakePairsArray() {
    azzert.that(Pair.makePairs(5).length, is(5));
  }

  @Test public void testMakePairsMatrix() {
    azzert.that(Pair.makePairs(4, 9).length, is(36));
  }

  @Test public void testNewPair() {
    final Pair<Integer, Integer> p = Pair.newPair(box(1), box(2));
    azzert.that(p.first, is(box(1)));
    azzert.that(p.second, is(box(2)));
  }
}
