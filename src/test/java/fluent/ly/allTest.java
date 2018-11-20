package fluent.ly;

import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class allTest {
  @Test public void testNotNullIterableOfT1() {
    assert !all.notNull((Iterable<Integer>) null);
  }

  @Test public void testNotNullIterableOfT2() {
    final List<Integer> l = new ArrayList<>();
    l.add(box(1));
    l.add(null);
    assert !all.notNull(l);
  }

  @Test public void testNotNullIterableOfT3() {
    final List<Integer> l = new ArrayList<>();
    l.add(box(1));
    l.add(box(2));
    assert all.notNull(l);
  }

  @Test @SuppressWarnings("null") public void testNotNullTArray1() {
    assert !all.notNull((Integer[]) null);
  }

  @Test @SuppressWarnings("null") public void testNotNullTArray2() {
    assert !all.notNull(new Integer[] { box(1), null });
  }

  @Test @SuppressWarnings("null") public void testNotNullTArray3() {
    assert all.notNull(new Integer[] { box(1), box(2) });
  }
}
