package fluent.ly;


import static il.org.spartan.Utils.*;

import static fluent.ly.unbox.*;
import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class BigIntegerTest {
  @Test public void testCreateFromString() {
    azzert.notNull(new BigInteger("123"));
  }

  @Test public void testsEquals() {
    azzert.that(new BigInteger("123"), is(new BigInteger("123")));
  }

  @Test @SuppressWarnings("null") public void testNotEquals() {
    BigInteger i = new BigInteger("100");
    azzert.that(new BigInteger("123"), is(not(i)));
  }

  @Test public void testAdd() {
    azzert.that(new BigInteger("123").add(new BigInteger("5")), is(new BigInteger("128")));
  }

  @Test public void testAdd2() {
    azzert.that(new BigInteger("312345").add(new BigInteger("90000")),is(new BigInteger("402345")));
  }

  @Test public void testNegativeAdd() {
    azzert.that(new BigInteger("100").add(new BigInteger("-10")), is(new BigInteger("90")));
  }

  @Test public void testNegativeAdd2() {
    azzert.that(new BigInteger("-1234").add(new BigInteger("1234")), is(new BigInteger("0")));
  }

  @Test public void testNegativeAdd3() {
    azzert.that(new BigInteger("-1234").add(new BigInteger("1")), is(new BigInteger("-1233")));
  }

  @Test public void testAddBigNumber() {
    azzert.that(new BigInteger("1234567890123456789012345678901234567890").add(new BigInteger("5")),
        is(new BigInteger("1234567890123456789012345678901234567895")));
  }

  @Test public void testAddBigNumber2() {
    azzert.that(new BigInteger("15").add(new BigInteger("1234567890123456789012345678901234567890")),
        is(new BigInteger("1234567890123456789012345678901234567905")));
  }

  @Test public void testAddBigNumber3() {
    azzert.that(new BigInteger("9000000000000000000000000000000000000000").add(new BigInteger("1234567890123456789012345678901234567890")),
        is(new BigInteger("10234567890123456789012345678901234567890")));

  }

  @Test public void testNegative() {
    azzert.that(new BigInteger("10").negate(), is(new BigInteger("-10")));
  }

  @Test public void testNegative2() {
    azzert.that(new BigInteger("1234567890123456789012345678901234567890").negate(), is(new BigInteger("-1234567890123456789012345678901234567890")));
  }

  @Test public void testNegative3() {
    azzert.that(new BigInteger("175688854").negate(), is(new BigInteger("-175688854")));
  }

  @Test public void testIsBiggerThan() {
    assert unbox(cantBeNull(cantBeNull(new BigInteger("4")).isBiggerThan(new BigInteger("2"))));
  }

  @Test public void testIsBiggerThan2() {
    assert unbox(cantBeNull(new BigInteger("7").isBiggerThan(new BigInteger("-3"))));
  }

  @Test public void testIsBiggerThan3() {
    assert unbox(cantBeNull(new BigInteger("7").isBiggerThan(new BigInteger("-34"))));
  }

  @Test public void testIsBiggerThan4() {
    assert unbox(cantBeNull(new BigInteger("77").isBiggerThan(new BigInteger("-34"))));
  }

  @Test public void testIsBiggerThan5() {
    assert unbox(cantBeNull(new BigInteger("77").isBiggerThan(new BigInteger("-3"))));
  }

  @Test public void testIsBiggerThan6() {
    assert unbox(cantBeNull(new BigInteger("77").isBiggerThan(new BigInteger("0"))));
  }

  @Test public void testIsBiggerThan7() {
    assert unbox(cantBeNull(new BigInteger("-77").isBiggerThan(new BigInteger("-100"))));
  }

  @Test public void testIsBiggerThan8() {
    assert unbox(cantBeNull(
        new BigInteger("1234567890123456789012345678901234567890").isBiggerThan(new BigInteger("1234567890123456789012345678901234567889"))));
  }

  @Test public void testIsBiggerThan9() {
    assert unbox(cantBeNull(new BigInteger("12345").isBiggerThan(new BigInteger("-12345"))));
  }
  
  @Test public void testIsBiggerThan10() {
    assert !unbox(cantBeNull(new BigInteger("-12343").isBiggerThan(new BigInteger("12345"))));
  }
  
  @Test public void testSubstract1() {
    BigInteger i = new BigInteger("100").subtract(new BigInteger("10"));
    azzert.that(i, is(new BigInteger("90")));
  }
}