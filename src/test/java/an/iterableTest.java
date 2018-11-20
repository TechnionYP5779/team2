package an;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class iterableTest {
  @Test public void singletonTest1() {
    assert iterable.singleton(box(1)).iterator().hasNext();
  }

  @Test public void singletonTest2() {
    azzert.that(iterable.singleton(box(1)).iterator().next(), is(1));
  }

  @Test public void singletonTest3() {
    final Iterator<Integer> iter = iterable.singleton(box(1)).iterator();
    iter.next();
    assert !iter.hasNext();
  }

  @Test public void overTest1() {
    assert iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator().hasNext();
  }

  @Test public void overTest2() {
    azzert.that(iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator().next(), is(1));
  }

  @Test public void overTest3() {
    final Iterator<Integer> iter = iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator();
    iter.next();
    assert iter.hasNext();
  }

  @Test public void overTest4() {
    final Iterator<Integer> iter = iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator();
    iter.next();
    azzert.that(iter.next(), is(2));
  }

  @Test public void overTest5() {
    final Iterator<Integer> iter = iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator();
    iter.next();
    iter.next();
    assert iter.hasNext();
  }

  @Test public void overTest6() {
    final Iterator<Integer> iter = iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator();
    iter.next();
    iter.next();
    azzert.that(iter.next(), is(3));
  }

  @Test public void overTest7() {
    final Iterator<Integer> iter = iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator();
    iter.next();
    iter.next();
    iter.next();
    assert iter.hasNext();
  }

  @Test public void overTest8() {
    final Iterator<Integer> iter = iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator();
    iter.next();
    iter.next();
    iter.next();
    azzert.that(iter.next(), is(4));
  }

  @Test public void overTest9() {
    final Iterator<Integer> iter = iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator();
    iter.next();
    iter.next();
    iter.next();
    iter.next();
    assert iter.hasNext();
  }

  @Test public void overTest10() {
    final Iterator<Integer> iter = iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator();
    iter.next();
    iter.next();
    iter.next();
    iter.next();
    azzert.that(iter.next(), is(5));
  }

  @Test public void overTest11() {
    final Iterator<Integer> iter = iterable.over(box(1), box(2), box(3), box(4), box(5)).iterator();
    iter.next();
    iter.next();
    iter.next();
    iter.next();
    iter.next();
    assert !iter.hasNext();
  }
}
