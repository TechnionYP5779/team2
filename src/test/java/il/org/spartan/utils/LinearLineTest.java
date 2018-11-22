package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class LinearLineTest {
  @Test public void test1() {
    final LinearLine ll = new LinearLine(1.0, 0.0);
    azzert.that(ll.yOf(1.0), is(1.0));
  }

  @Test public void test2() {
    final LinearLine ll = new LinearLine(1.0, 0.0);
    azzert.that(ll.yOf(2.0), is(2.0));
  }

  @Test public void getATest1() {
      final LinearLine ll = new LinearLine(1.0, 0.0);
      azzert.that(ll.getA(), is(1.0));
    }

  @Test public void getATest2() {
      final LinearLine ll = new LinearLine(2.0, 0.0);
      azzert.that(ll.getA(), is(2.0));
    }

  @Test public void getBTest1() {
      final LinearLine ll = new LinearLine(1.0, 1.0);
      azzert.that(ll.getB(), is(1.0));
    }

  @Test public void getBTest2() {
      final LinearLine ll = new LinearLine(0.0, 2.0);
      azzert.that(ll.getB(), is(2.0));
    }
}
