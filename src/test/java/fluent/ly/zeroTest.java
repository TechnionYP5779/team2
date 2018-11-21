package fluent.ly;

import static fluent.ly.box.*;

import org.junit.*;

@SuppressWarnings("static-method") public class zeroTest {
  @Test public void testForgettingOneObject() {
    azzert.zero(zero.forgetting(box(1)));
  }

  @Test public void testForgettingMultipleObjects() {
    azzert.zero(zero.forgetting(box(1), "Hi"));
  }

  @Test public void testZeroForgetBoolean() {
    azzert.zero(zero.forget(true));
  }

  @Test public void testZeroForgetDouble() {
    azzert.zero(zero.forget(19.5));
  }

  @Test public void testZeroForgetLong() {
    azzert.zero(zero.forget(12123213123123123L));
  }
}
