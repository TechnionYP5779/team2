package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

public class countTest {
  private List<Integer> l;

  @Before public void setUp() {
    l = new ArrayList<>();
  }

  @Test public void testCreateEmpty() {
    azzert.zero(count.of(l));
  }

  @Test public void testAdd() {
    l.add(box(3));
    l.add(box(2));
    l.add(box(111));
    azzert.that(count.of(l), is(3));
  }

  @Test public void testAddRemove() {
    l.add(box(5));
    l.remove(0);
    azzert.zero(count.of(l));
  }
}
