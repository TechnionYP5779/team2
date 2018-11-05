package an;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class emptyTest {
  @Test public void testEmpty() {
    List<Integer> l = empty.list();
    assertEquals(l.size(), 0);
    Iterator<Object> iter = empty.iterable().iterator();
    assertEquals(new Boolean(iter.hasNext()), new Boolean(false));
    assertEquals(iter.next(), null);
  }
}
