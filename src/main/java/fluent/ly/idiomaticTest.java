package fluent.ly;

import org.junit.*;

import fluent.ly.idiomatic;
import fluent.ly.idiomatic.*;
import java.io.IOException;

@SuppressWarnings("static-method") public class idiomaticTest {
  @SuppressWarnings("null") @Test public void testIncaseTrueReturnSameObj() {
    Integer integer = new Integer(5);
    assert idiomatic.incase(true, integer).equals(integer);
  }

  @Test public void testIncaseFalseReturnsNull() {
    assert idiomatic.incase(false, new Integer(5)) == null;
  }

  @SuppressWarnings("null") @Test public void testKatchingWithNoException() {
    final Producer<Integer> p = () -> new Integer(5);
    assert idiomatic.katching(p).equals(new Integer(5));
  }

  @SuppressWarnings("null") @Ignore @Test public void testKatchingWithException() {
    final Producer<Integer> p = () -> {
      throw new IOException();
    };
    assert idiomatic.katching(p) == (null);
  }

  @Test public void testQuoteNotNullString() {
    assert idiomatic.quote("hello").equals("'hello'");
  }

  @Test public void testQuoteNullString() {
    assert idiomatic.quote(null).equals("<null reference>");
  }

  @Test public void testDoubleQuote() {
    assert idiomatic.quote(idiomatic.quote("a")).equals("''a''");
  }

  @SuppressWarnings("null") @Test public void testWhenTrueReturnsSame() {
    assert idiomatic.when(true).eval(() -> new Integer(5)).equals(new Integer(5));
  }

  @Test public void testWhenFalseReturnsNull() {
    assert idiomatic.when(1 == 3).eval(() -> new Integer(5)) == null;
  }
  
  @SuppressWarnings("null") @Test public void testUnlessFalseReturnsSame() {
    assert idiomatic.unless(1 == 3).eval(() -> new Integer(5)).equals(new Integer(5));
  }

  @Test public void testUnlessTrueReturnsNull() {
    assert idiomatic.unless(4 == 4).eval(() -> new Integer(5)) == null;
  }
  
  @Test public void testUnlessFalseWithoutEval() {
    Integer i = new Integer(5);
    assert idiomatic.unless(false, i) == i;
  }
  
  @Test public void testUnlessTrueWithoutEval() {
    Integer i = new Integer(5);
    assert idiomatic.unless(true, i) == null;
  }
  
}
