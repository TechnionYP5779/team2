package il.org.spartan.utils;

import static fluent.ly.box.*;

import static fluent.ly.azzert.*;


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

  @SuppressWarnings("null") @Test public void testEquals() {
    final Pair<Integer, String> p1 = new Pair<>(box(12), "1"), p2 = new Pair<>(box(1), "2"),
        p3 = new Pair<>(box(2), "2"), p4 = new Pair<>(box(2), "2");
    azzert.that(p1, is(not(p2)));
    azzert.that(p2, is(not(p3)));
    azzert.that(p1, is(not(p3)));
    azzert.that(p3, is(p4));
  }
}
