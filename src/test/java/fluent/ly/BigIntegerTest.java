package fluent.ly;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.assertNotEquals;

import org.junit.*;

@SuppressWarnings({ "static-method" }) public class BigIntegerTest {
  @Test public void testCreateFromString() {
    assertNotEquals(new BigInteger("123"), null);
  }

  @Test public void testsEquals() {
    assertEquals(new BigInteger("123"), new BigInteger("123"));
  }

  @Test public void testNotEquals() {
    assertNotEquals(new BigInteger("123"), new BigInteger("100"));
  }

  @Test public void testAdd() {
    assertEquals(new BigInteger("123").add(new BigInteger("5")), new BigInteger("128"));
  }

  @Test public void testAdd2() {
    assertEquals(new BigInteger("312345").add(new BigInteger("90000")), new BigInteger("402345"));
  }

  @Test public void testNegativeAdd() {
    assertEquals(new BigInteger("100").add(new BigInteger("-10")), new BigInteger("90"));
  }

  @Test public void testNegativeAdd2() {
    assertEquals(new BigInteger("-1234").add(new BigInteger("1234")), new BigInteger("0"));
  }

  @Test public void testNegativeAdd3() {
    assertEquals(new BigInteger("-1234").add(new BigInteger("1")), new BigInteger("-1233"));
  }

  @Test public void testAddBigNumber() {
    assertEquals(new BigInteger("1234567890123456789012345678901234567890").add(new BigInteger("5")),
        new BigInteger("1234567890123456789012345678901234567895"));
  }

  @Test public void testAddBigNumber2() {
    assertEquals(new BigInteger("15").add(new BigInteger("1234567890123456789012345678901234567890")),
        new BigInteger("1234567890123456789012345678901234567905"));
  }

  @Test public void testAddBigNumber3() {
    assertEquals(new BigInteger("9000000000000000000000000000000000000000").add(new BigInteger("1234567890123456789012345678901234567890")),
        new BigInteger("10234567890123456789012345678901234567890"));
  }
}
