package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

public class countTest {
  private List<Integer> l;

  @Before public void setUp() {
    l = new ArrayList<>();
  }

  @Test public void testCreateEmpty() {
    assertEquals(0, count.of(l));
  }

  @Test public void testAdd() {
    l.add(fluent.ly.box.it(3));
    l.add(fluent.ly.box.it(2));
    l.add(fluent.ly.box.it(111));
    assertEquals(3, count.of(l));
  }

  @Test public void testAddRemove() {
    l.add(fluent.ly.box.it(5));
    l.remove(0);
    assertEquals(0, count.of(l));
  }
}
