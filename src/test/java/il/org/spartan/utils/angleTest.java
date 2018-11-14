package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class angleTest {
  @Test public void testDegrees() {
    assertEquals(20, angle.degrees(20).degrees, 0.1);
  }

  @Test public void testRadians() {
    assertEquals(1, angle.radians(1).radians, 0.1);
  }

  @Test public void testPI() {
    assertEquals(Math.PI, angle.pi.radians, 0.1);
  }

  @Test public void testHalfPI() {
    double d1;
    d1 = Math.PI / 2;
    assertEquals(d1, angle.halfPi.radians, 0.1);
  }

  @Test public void testHalfPiAdd1() {
    double d1;
    double d2;
    d2 = Math.PI / 2;
    d1 = d2 + 20;
    angle a1;
    a1 = angle.halfPi.add(angle.degrees(20));
    assertEquals(d1, a1.radians, 0.1);
  }

  @Test public void testHalfPiAdd2() {
    assertEquals(110, angle.halfPi.add(20).degrees, 0.1);
  }

  @Test public void testPiDegrees() {
    assertEquals(180, angle.pi.degrees(), 0.1);
  }

  @Test public void testOfDegrees() {
    double d1;
    angle a1;
    a1 = angle.of(20);
    d1 = a1.degrees();
    assertEquals(180, d1, 0.1);
  }

  @Test public void testPiRadians() {
    double d1;
    d1 = Math.PI / 2;
    double d2;
    d2 = angle.pi.radians();
    assertEquals((d1), d2, 0.1);
  }
}
