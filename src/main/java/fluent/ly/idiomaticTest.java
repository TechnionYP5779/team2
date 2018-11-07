package fluent.ly;

import org.junit.*;

import fluent.ly.idiomatic;
import fluent.ly.idiomatic.*;
import java.io.IOException;

@SuppressWarnings("static-method") public class idiomaticTest {
  @Test @SuppressWarnings("null") public void testIncaseTrueReturnSameObj() {
    Integer integer = Integer.valueOf(5);
    assert idiomatic.incase(true, integer).equals(integer);
  }

  @Test public void testIncaseFalseReturnsNull() {
    assert idiomatic.incase(false, Integer.valueOf(5)) == null;
  }

  @Test @SuppressWarnings("null") public void testKatchingWithNoException() {
    assert idiomatic.katching((Producer<Integer>) () -> Integer.valueOf(5)).equals(Integer.valueOf(5));
  }

  @Ignore @Test @SuppressWarnings("null") public void testKatchingWithException() {
    assert idiomatic.katching((Producer<Integer>) () -> {
      throw new IOException();
    }) == null;
  }

  @Test public void testQuoteNotNullString() {
    assert "'hello'".equals(idiomatic.quote("hello"));
  }

  @Test public void testQuoteNullString() {
    assert "<null reference>".equals(idiomatic.quote(null));
  }

  @Test public void testDoubleQuote() {
    assert "''a''".equals(idiomatic.quote(idiomatic.quote("a")));
  }

  @Test @SuppressWarnings("null") public void testWhenTrueReturnsSame() {
    assert idiomatic.when(true).eval(() -> Integer.valueOf(5)).equals(Integer.valueOf(5));
  }

  @Test public void testWhenFalseReturnsNull() {
    assert idiomatic.when(1 == 3).eval(() -> Integer.valueOf(5)) == null;
  }

  @Test @SuppressWarnings("null") public void testUnlessFalseReturnsSame() {
    assert idiomatic.unless(1 == 3).eval(() -> Integer.valueOf(5)).equals(Integer.valueOf(5));
  }

  @Test public void testUnlessTrueReturnsNull() {
    assert idiomatic.unless(true).eval(() -> Integer.valueOf(5)) == null;
  }

  @Test public void testUnlessFalseWithoutEval() {
    Integer i = Integer.valueOf(5);
    assert idiomatic.unless(false, i) == i;
  }

  @Test public void testUnlessTrueWithoutEval() {
    assert idiomatic.unless(true, Integer.valueOf(5)) == null;
  }
}
