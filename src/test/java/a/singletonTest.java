package a;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method","static-access"})public class singletonTest {
  
  @Test public void testList() {
    final Integer a = Integer.valueOf(3);
    final List<Integer> l = singleton.list(a);
    azzert.assertEquals(l.size(), 1);
    azzert.assertEquals(l.get(0), a);
    l.add(a);
    azzert.assertEquals(l.size(), 2);
  }

   @Test public void testArray() {
    final Object[] l = singleton.array(null);
    azzert.assertEquals(l.length, 1);
    azzert.assertEquals(l[0], null);
  }
}
