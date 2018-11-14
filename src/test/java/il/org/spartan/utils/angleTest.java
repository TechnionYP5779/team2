package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method","static-access"})
public class angleTest {
  @Test public void testDegrees1() {
    azzert.assertEquals(20, angle.degrees(20).degrees, 0.1);
  }
  @Test public void testDegrees2() {
    azzert.assertEquals (200, angle.degrees(200).degrees, 0.1);
  }

  @Test public void testRadians1() {
    azzert.assertEquals(1, angle.radians(1).radians, 0.1);
  }
  @Test public void testRadians2() {
    azzert.assertEquals(10, angle.radians(10).radians, 0.1);
  }

  @Test public void testPI() {
    azzert.assertEquals(Math.PI, angle.pi.radians, 0.1);
  }

  @Test public void testHalfPI() {
    azzert.assertEquals(Math.PI / 2, angle.halfPi.radians, 0.1);
  }

  @Test public void testHalfPiAdd1() {
    azzert.assertEquals(110, angle.halfPi.add(angle.degrees(20)).degrees, 0.1);
  }
  @Test public void testHalfPiAdd1_1() {
    azzert.assertEquals(290, angle.halfPi.add(angle.degrees(200)).degrees, 0.1);
  }

  @Test public void testHalfPiAdd2() {
    azzert.assertEquals(110, angle.halfPi.add(20).degrees, 0.1);
  }
  @Test public void testHalfPiAdd2_2() {
    azzert.assertEquals(290, angle.halfPi.add(200).degrees, 0.1);
  }

  @Test public void testPiDegrees1() {
    azzert.assertEquals(180, angle.pi.degrees(), 0.1);
  }
  @Test public void testPiDegrees2() {
    azzert.assertEquals(90, angle.halfPi.degrees(), 0.1);
  }

  @Test public void testOfDegrees1() {
    azzert.assertEquals(20, angle.of(20).degrees(), 0.1);
  }
  @Test public void testOfDegrees2() {
    azzert.assertEquals(180, angle.of(180).degrees(), 0.1);
  }

  @Test public void testPiRadians1() {
    azzert.assertEquals(Math.PI, angle.pi.radians(), 0.1);
  }
  @Test public void testPiRadians2() {
    azzert.assertEquals(Math.PI / 2, angle.halfPi.radians(), 0.1);
  }
}
