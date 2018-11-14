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
    assertEquals(Math.PI / 2, angle.halfPi.radians, 0.1);
  }

  @Test public void testHalfPiAdd1() {
    assertEquals(Math.PI / 2 + 20, angle.halfPi.add(angle.degrees(20)).radians, 0.1);
  }

  @Test public void testHalfPiAdd2() {
    assertEquals(110, angle.halfPi.add(20).degrees, 0.1);
  }

  @Test public void testPiDegrees() {
    assertEquals(180, angle.pi.degrees(), 0.1);
  }

  @Test public void testOfDegrees() {
    assertEquals(180, angle.of(20).degrees(), 0.1);
  }

  @Test public void testPiRadians() {
    assertEquals(Math.PI / 2, angle.pi.radians(), 0.1);
  }
}
