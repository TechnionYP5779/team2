package fluent.ly;


import java.util.*;

import org.junit.*;


@SuppressWarnings("static-method") public class allTest {
   @Test public void testNotNullIterableOfT1() {
    Iterable<Integer> l = null;
    assert !all.notNull(l);
  }
  
  @Test public void testNotNullIterableOfT2() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(null);
    assert !all.notNull(l);
  }
  
  @Test public void testNotNullIterableOfT3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    assert all.notNull(l);
  }

  @SuppressWarnings("null") @Test public void testNotNullTArray1() {
    Integer[] arr = null;
    assert !all.notNull(arr);
  }
  
  @SuppressWarnings("null") @Test public void testNotNullTArray2() {
    Integer[] arr = {box.box(1),null};
    assert !all.notNull(arr);
  }
  
  @SuppressWarnings("null") @Test public void testNotNullTArray3() {
    Integer[] arr = {box.box(1),box.box(2)};
    assert all.notNull(arr);
  }

}
