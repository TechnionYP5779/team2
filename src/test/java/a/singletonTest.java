package a;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class singletonTest {
  @Test public void testList() {
    Integer a = Integer.valueOf(3);
    List<Integer> l = singleton.list(a);
    azzert.that(l.size(), is(1));
    azzert.that(l.get(0), is(a));
    l.add(a);
    azzert.that(l.size(), is(2));
  }

  @Test public void testArray() {
    Object[] l = singleton.array(null);
    azzert.that(l.length, is(1));
    azzert.isNull(l[0]);
  }
}
