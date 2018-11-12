package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

@SuppressWarnings("unused") public class PairTest {
  
  @Test @SuppressWarnings({ "static-method", "boxing" }) public void testCreate() {
    Pair<Integer, String> p = new Pair<>(1, "Hi");
    assert (p.first == 1 && "Hi".equals(p.second));
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void testToString() {
    assert ("<str,2.33>".equals(new Pair<>("str", 2.33) + ""));
  }

  @Test @SuppressWarnings({ "static-method", "boxing" }) public void testEquals() {
    Pair<Integer, String> p1 = new Pair<>(12, "1"), p2 = new Pair<>(1, "2"), p3 = new Pair<>(2, "2"), p4 = new Pair<>(2, "2");
    assert (!p1.equals(p2));
    assert (!p2.equals(p3));
    assert (!p1.equals(p3));
    assert (p3.equals(p4));
  }
  
 
}
