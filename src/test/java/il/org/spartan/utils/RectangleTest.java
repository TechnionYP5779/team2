package il.org.spartan.utils;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.assertNotEquals;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.*;

@SuppressWarnings("static-method") public class RectangleTest {
  @Test public void testCtor1() throws IllegalArgumentException {
    assertNotEquals(new Rectangle(1, 2, 3, 4), null);
  }

  @Test public void testCtor2() throws IllegalArgumentException {
    assertNotEquals(new Rectangle(4, 3, 2, 1), null);
  }

  @Test(expected = IllegalArgumentException.class) public void testInvalidCtorParms1() {
    forget.it(new Rectangle(1, 2, 1, 2));
  }

  @Test(expected = IllegalArgumentException.class) public void testInvalidCtorParms2() {
    forget.it(new Rectangle(5, 2, 5, 2));
  }

  @Test(expected = IllegalArgumentException.class) public void testInvalidCtorParms3() {
    forget.it(new Rectangle(1, 2, 1, 4));
  }

  @Test(expected = IllegalArgumentException.class) public void testInvalidCtorParms4() {
    forget.it(new Rectangle(5, 2, 5, 4));
  }

  @Test(expected = IllegalArgumentException.class) public void testInvalidCtorParms5() {
    forget.it(new Rectangle(1, 2, 3, 2));
  }

  @Test(expected = IllegalArgumentException.class) public void testInvalidCtorParms6() {
    forget.it(new Rectangle(1, 5, 3, 5));
  }

  @Test public void testGetPerimeter() throws IllegalArgumentException {
    assertEquals(new Rectangle(0, 0, -1, -1).getPerimeter(), 4.0, 0.00001);
    assertEquals(new Rectangle(0, 0, -2, -2).getPerimeter(), 8.0, 0.00001);
    assertEquals(new Rectangle(-1, -1, -2, -2).getPerimeter(), 4.0, 0.00001);
  }

  @Test public void testGetArea() throws IllegalArgumentException {
    assertEquals(new Rectangle(0, 0, -1, -1).getArea(), 1.0, 0.00001);
    assertEquals(new Rectangle(0, 0, -2, -2).getArea(), 4.0, 0.00001);
    assertEquals(new Rectangle(-1, -1, -2, -2).getArea(), 1.0, 0.00001);
  }

  @Test public void testGetHight() throws IllegalArgumentException {
    assertEquals(new Rectangle(0, 0, -1, -1).getHeight(), 1, 0.00001);
    assertEquals(new Rectangle(0, 0, -2, -2).getHeight(), 2, 0.00001);
    assertEquals(new Rectangle(-1, -1, -2, -2).getHeight(), 1, 0.00001);
  }

  @Test public void testGetWidth() throws IllegalArgumentException {
    assertEquals(new Rectangle(0, 0, -1, -1).getWidth(), 1, 0.00001);
    assertEquals(new Rectangle(0, 0, -2, -2).getWidth(), 2, 0.00001);
    assertEquals(new Rectangle(-1, -1, -2, -2).getWidth(), 1, 0.00001);
  }

  @Test public void testExpand() throws IllegalArgumentException {
    Rectangle r = new Rectangle(0, 0, -1, -1);
    r.expand(2);
    assertEquals(r.getArea(), 2, 0.00001);
    r = new Rectangle(-1, -1, -2, -2);
    r.expand(2);
    assertEquals(r.getArea(), 2, 0.00001);
    r = new Rectangle(0, 0, -2, -2);
    r.expand(4);
    assertEquals(r.getArea(), 16, 0.00001);
  }

  @Test public void testRotate() throws Exception {
    Rectangle r = new Rectangle(0, 0, 1, 2);
    r.rotate(Math.PI / 2);
    assertEquals(r.getHeight(), 1, 0.00001);
    assertEquals(r.getWidth(), 2, 0.00001);
    r.rotate(Math.PI / 2);
    assertEquals(r.getHeight(), 2, 0.00001);
    assertEquals(r.getWidth(), 1, 0.00001);
    r = new Rectangle(0, 0, 4, 3);
    r.rotate(Math.PI / 2);
    assertEquals(r.getHeight(), 4, 0.00001);
    assertEquals(r.getWidth(), 3, 0.00001);
  }
}
