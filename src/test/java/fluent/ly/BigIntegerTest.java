package fluent.ly;

import org.junit.*;

import static fluent.ly.unbox.*;

import static il.org.spartan.Utils.*;

@SuppressWarnings({ "static-method", "static-access" }) public class BigIntegerTest {
  @Test public void testCreateFromString() {
    azzert.assertNotEquals(new BigInteger("123"), null);
  }

  @Test public void testsEquals() {
    Assert.assertEquals(new BigInteger("123"), new BigInteger("123"));
  }

  @Test public void testNotEquals() {
    azzert.assertNotEquals(new BigInteger("123"), new BigInteger("100"));
  }

  @Test public void testAdd() {
    azzert.assertEquals(new BigInteger("123").add(new BigInteger("5")), new BigInteger("128"));
  }

  @Test public void testAdd2() {
    azzert.assertEquals(new BigInteger("312345").add(new BigInteger("90000")), new BigInteger("402345"));
  }

  @Test public void testNegativeAdd() {
    azzert.assertEquals(new BigInteger("100").add(new BigInteger("-10")), new BigInteger("90"));
  }

  @Test public void testNegativeAdd2() {
    azzert.assertEquals(new BigInteger("-1234").add(new BigInteger("1234")), new BigInteger("0"));
  }

  @Test public void testNegativeAdd3() {
    azzert.assertEquals(new BigInteger("-1234").add(new BigInteger("1")), new BigInteger("-1233"));
  }

  @Test public void testAddBigNumber() {
    azzert.assertEquals(new BigInteger("1234567890123456789012345678901234567890").add(new BigInteger("5")),
        new BigInteger("1234567890123456789012345678901234567895"));
  }

  @Test public void testAddBigNumber2() {
    azzert.assertEquals(new BigInteger("15").add(new BigInteger("1234567890123456789012345678901234567890")),
        new BigInteger("1234567890123456789012345678901234567905"));
  }

  @Test public void testAddBigNumber3() {
    azzert.assertEquals(new BigInteger("9000000000000000000000000000000000000000").add(new BigInteger("1234567890123456789012345678901234567890")),
        new BigInteger("10234567890123456789012345678901234567890"));
  }
  
  @Test public void testNegative() {
    azzert.assertEquals(new BigInteger("10").negate(), new BigInteger("-10"));
  }
  
  @Test public void testNegative2() {
    azzert.assertEquals(new BigInteger("1234567890123456789012345678901234567890").negate(), new BigInteger("-1234567890123456789012345678901234567890"));
  }
  
  @Test public void testNegative3() {
    azzert.assertEquals(new BigInteger("175688854").negate(), new BigInteger("-175688854"));
  }
  
  @Test public void testIsBiggerThan() {
    assert unbox(cantBeNull(cantBeNull((new BigInteger("4"))).isBiggerThan(new BigInteger("2"))));
  }
  
  @Test public void testIsBiggerThan2() {
    assert unbox(cantBeNull((new BigInteger("7")).isBiggerThan(new BigInteger("-3"))));
  }
  
  @Test public void testIsBiggerThan3() {
    assert unbox(cantBeNull((new BigInteger("7")).isBiggerThan(new BigInteger("-34"))));
  }
  
  @Test public void testIsBiggerThan4() {
    assert unbox(cantBeNull((new BigInteger("77")).isBiggerThan(new BigInteger("-34"))));
  }
  
  @Test public void testIsBiggerThan5() {
    assert unbox(cantBeNull((new BigInteger("77")).isBiggerThan(new BigInteger("-3"))));
  }
  
  @Test public void testIsBiggerThan6() {
    assert unbox(cantBeNull((new BigInteger("77")).isBiggerThan(new BigInteger("0"))));
  }
  
  @Test public void testIsBiggerThan7() {
    assert unbox(cantBeNull((new BigInteger("-77")).isBiggerThan(new BigInteger("-100"))));
  }
  
  @Test public void testIsBiggerThan8() {
    assert unbox(cantBeNull((new BigInteger("1234567890123456789012345678901234567890"))
        .isBiggerThan(new BigInteger("1234567890123456789012345678901234567889"))));
  }
  
  @Test public void testIsBiggerThan9() {
    assert unbox(cantBeNull((new BigInteger("12345")).isBiggerThan(new BigInteger("-12345"))));
  }
}