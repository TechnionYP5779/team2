package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class angleTest {
  @Test public void testDegrees1() {
    assertEquals(20, angle.degrees(20).degrees, 0.1);
  }

  @Test public void testDegrees2() {
    assertEquals(200, angle.degrees(200).degrees, 0.1);
  }

  @Test public void testRadians1() {
    assertEquals(1, angle.radians(1).radians, 0.1);
  }

  @Test public void testRadians2() {
    assertEquals(10, angle.radians(10).radians, 0.1);
  }

  @Test public void testPI() {
    assertEquals(Math.PI, angle.pi.radians, 0.1);
  }

  @Test public void testHalfPI() {
    assertEquals(Math.PI / 2, angle.halfPi.radians, 0.1);
  }

  @Test public void testHalfPiAdd1() {
    assertEquals(110, angle.add(angle.degrees(20)).degrees, 0.1);
  }

  @Test public void testHalfPiAdd1_1() {
    assertEquals(290, angle.add(angle.degrees(200)).degrees, 0.1);
  }

  @Test public void testHalfPiAdd2() {
    assertEquals(110, angle.add(20).degrees, 0.1);
  }

  @Test public void testHalfPiAdd2_2() {
    assertEquals(290, angle.add(200).degrees, 0.1);
  }

  @Test public void testPiDegrees1() {
    assertEquals(180, angle.pi.degrees(), 0.1);
  }

  @Test public void testPiDegrees2() {
    assertEquals(90, angle.halfPi.degrees(), 0.1);
  }

  @Test public void testOfDegrees1() {
    assertEquals(20, angle.of(20).degrees(), 0.1);
  }

  @Test public void testOfDegrees2() {
    assertEquals(180, angle.of(180).degrees(), 0.1);
  }

  @Test public void testPiRadians1() {
    assertEquals(Math.PI, angle.pi.radians(), 0.1);
  }

  @Test public void testPiRadians2() {
    assertEquals(Math.PI / 2, angle.halfPi.radians(), 0.1);
  }
}
