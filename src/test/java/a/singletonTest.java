package a;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class singletonTest {
  @Test public void testList() {
    final Integer a = Integer.valueOf(3);
    final List<Integer> l = singleton.list(a);
    assertEquals(l.size(), 1);
    assertEquals(l.get(0), a);
    l.add(a);
    assertEquals(l.size(), 2);
  }

  @Test public void testArray() {
    final Object[] l = singleton.array(null);
    assertEquals(l.length, 1);
    Assert.assertEquals(l[0], null);
  }
}
