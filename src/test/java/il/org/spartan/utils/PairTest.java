package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "static-access" }) public class PairTest {
  @Test public void testCreate() {
    final Pair<Integer, String> p = new Pair<>(fluent.ly.box.it(1), "Hi");
    azzert.assertEquals(1, p.first);
    azzert.assertEquals("Hi", p.second);
  }

  @Test public void testToString() {
    azzert.assertEquals("<str,2.33>", new Pair<>("str", fluent.ly.box.it(2.33)) + "");
  }

  @Test public void testEquals() {
    final Pair<Integer, String> p1 = new Pair<>(fluent.ly.box.it(12), "1"), p2 = new Pair<>(fluent.ly.box.it(1), "2"), p3 = new Pair<>(fluent.ly.box.it(2), "2"), p4 = new Pair<>(fluent.ly.box.it(2), "2");
    azzert.assertNotEquals(p1, p2);
    azzert.assertNotEquals(p2, p3);
    azzert.assertNotEquals(p1, p3);
    azzert.assertEquals(p3, p4);
  }
}
