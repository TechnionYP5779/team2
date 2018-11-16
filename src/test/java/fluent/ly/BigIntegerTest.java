package fluent.ly;

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
    azzert.that(new BigInteger("123"), is(not(new BigInteger("100"))));
  }

  @Test public void testAdd() {
    azzert.that(new BigInteger("123").add(new BigInteger("5")), is(new BigInteger("128")));
  }

  @Test public void testAdd2() {
    azzert.that(new BigInteger("312345").add(new BigInteger("90000")), is(new BigInteger("402345")));
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
}
