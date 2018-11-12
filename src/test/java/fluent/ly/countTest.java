package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings("boxing") public class countTest {
  private List<Integer> l;

  @Before public void setUp() {
    l = new ArrayList<>();
  }

  @Test public void testCreateEmpty() {
    Assert.assertEquals(0, count.of(l));
  }

  @Test public void testAdd() {
    l.add(3);
    l.add(2);
    l.add(111);
    Assert.assertEquals(3, count.of(l));
  }

  @Test public void testAddRemove() {
    l.add(5);
    l.remove(0);
    Assert.assertEquals(0, count.of(l));
  }
}
