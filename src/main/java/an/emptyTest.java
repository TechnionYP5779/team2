package an;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class emptyTest {
  @Test public void testEmpty() {
    assertEquals(empty.list().size(), 0);
    Iterator<Object> iter = empty.iterable().iterator();
    assertEquals(Boolean.valueOf(iter.hasNext()), Boolean.FALSE);
    assertEquals(iter.next(), null);
  }
}
