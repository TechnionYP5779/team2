package an;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("static-method") public class emptyTest {
  @Test public void testEmpty() {
    int i1 = empty.list().size();
    assertEquals(i1, 0);
    final Iterator<Object> iter;
    Iterable<@Nullable Object> os1 = empty.iterable();
    iter = os1.iterator();
    assertEquals(Boolean.valueOf(iter.hasNext()), Boolean.FALSE);
    assertEquals(iter.next(), null);
  }
}
