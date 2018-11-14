package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "boxing", "static-access" }) public class PairTest {
  @Test public void testCreate() {
    final Pair<Integer, String> p = new Pair<>(1, "Hi");
    azzert.assertEquals(1, p.first);
    Assert.assertEquals("Hi", p.second);
  }

  @Test public void testToString() {
    Assert.assertEquals("<str,2.33>", new Pair<>("str", 2.33) + "");
  }

  @Test public void testEquals() {
    final Pair<Integer, String> p1 = new Pair<>(12, "1"), p2 = new Pair<>(1, "2"), p3 = new Pair<>(2, "2"), p4 = new Pair<>(2, "2");
    azzert.assertNotEquals(p1, p2);
    azzert.assertNotEquals(p2, p3);
    azzert.assertNotEquals(p1, p3);
    Assert.assertEquals(p3, p4);
  }
}
