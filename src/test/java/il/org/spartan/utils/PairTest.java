package il.org.spartan.utils;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.assertEquals;
import static fluent.ly.azzert.assertNotEquals;

import org.junit.*;

@SuppressWarnings("static-method") public class PairTest {
  @Test public void testCreate() {
    final Pair<Integer, String> p = new Pair<>(fluent.ly.box.it(1), "Hi");
    assertEquals(1, p.first);
    assertEquals("Hi", p.second);
  }

  @Test public void testToString() {
    assertEquals("<str,2.33>", new Pair<>("str", fluent.ly.box.it(2.33)) + "");
  }

  @Test public void testEquals() {
    final Pair<Integer, String> p1 = new Pair<>(fluent.ly.box.it(12), "1"), p2 = new Pair<>(fluent.ly.box.it(1), "2"),
        p3 = new Pair<>(fluent.ly.box.it(2), "2"), p4 = new Pair<>(fluent.ly.box.it(2), "2");
    assertNotEquals(p1, p2);
    assertNotEquals(p2, p3);
    assertNotEquals(p1, p3);
    assertEquals(p3, p4);
  }
}
