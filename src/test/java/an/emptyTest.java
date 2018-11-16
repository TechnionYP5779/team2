package an;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class emptyTest {
  @Test public void testEmpty() {
    azzert.zero(empty.list().size());
    final Iterator<Object> iter = empty.iterable().iterator();
    assert !iter.hasNext();
    azzert.isNull(iter.next());
  }
}
