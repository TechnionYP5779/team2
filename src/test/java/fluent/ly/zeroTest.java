package fluent.ly;


import org.junit.*;

import static fluent.ly.box.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class zeroTest {
  @Test public void testForgettingOneObject() {
    azzert.that(zero.forgetting(box(1)), is(0));
  }

  @Test public void testForgettingMultipleObjects() {
    azzert.that(zero.forgetting(box(1), "Hi"), is(0));
  }

  @Test public void testZeroForgetBoolean() {
    azzert.that(zero.forget(true), is(0));
  }

  @Test public void testZeroForgetDouble() {
    azzert.that(zero.forget(19.5), is(0));
  }

  @Test public void testZeroForgetLong() {
    azzert.that(zero.forget(12123213123123123L), is(0));
  }
}
