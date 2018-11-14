package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.*;

@SuppressWarnings("static-method")
public class RectangleTest {
  @Test  public void testCtor() throws Exception {
    azzert.assertNotEquals(new Rectangle(1, 2, 3, 4), null);
    azzert.assertNotEquals(new Rectangle(4, 3, 2, 1), null);
  }
  @Test(expected = IllegalArgumentException.class )  public void testInvalidCtorParms1() {
      forget.it(new Rectangle(1, 2, 1, 2));
  }
  @Test(expected = IllegalArgumentException.class )  public void testInvalidCtorParms2() {
    forget.it(new Rectangle(5, 2, 5, 2));
  }

//  @Test  public void testInvalidCtorParms() {
//    try {
//      new Rectangle(1, 2, 1, 2);
//      azzert.fail();
//    } catch (@SuppressWarnings("unused") final Exception e) {
//      // an exception has caught
//    }
//    try {
//      new Rectangle(5, 2, 5, 2);
//      azzert.fail();
//    } catch (@SuppressWarnings("unused") final Exception e) {
//      // an exception has caught
//    }
//    try {
//      new Rectangle(1, 2, 1, 4);
//      azzert.fail();
//    } catch (@SuppressWarnings("unused") final Exception e) {
//      // an exception has caught
//    }
//    try {
//      new Rectangle(5, 2, 5, 4);
//      azzert.fail();
//    } catch (@SuppressWarnings("unused") final Exception e) {
//      // an exception has caught
//    }
//    try {
//      new Rectangle(1, 2, 3, 2);
//      azzert.fail();
//    } catch (@SuppressWarnings("unused") final Exception e) {
//      // an exception has caught
//    }
//    try {
//      new Rectangle(1, 5, 3, 5);
//      azzert.fail();
//    } catch (@SuppressWarnings("unused") final Exception e) {
//      // an exception has caught
//    }
//  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void testGetPerimeter() throws Exception {
    Assert.assertEquals(new Rectangle(0, 0, -1, -1).getPerimeter(), 4.0, 0.00001);
    Assert.assertEquals(new Rectangle(0, 0, -2, -2).getPerimeter(), 8.0, 0.00001);
    Assert.assertEquals(new Rectangle(-1, -1, -2, -2).getPerimeter(), 4.0, 0.00001);
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void testGetArea() throws Exception {
    Assert.assertEquals(new Rectangle(0, 0, -1, -1).getArea(), 1.0, 0.00001);
    Assert.assertEquals(new Rectangle(0, 0, -2, -2).getArea(), 4.0, 0.00001);
    Assert.assertEquals(new Rectangle(-1, -1, -2, -2).getArea(), 1.0, 0.00001);
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void testGetHight() throws Exception {
    Assert.assertEquals(new Rectangle(0, 0, -1, -1).getHeight(), 1, 0.00001);
    Assert.assertEquals(new Rectangle(0, 0, -2, -2).getHeight(), 2, 0.00001);
    Assert.assertEquals(new Rectangle(-1, -1, -2, -2).getHeight(), 1, 0.00001);
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void testGetWidth() throws Exception {
    Assert.assertEquals(new Rectangle(0, 0, -1, -1).getWidth(), 1, 0.00001);
    Assert.assertEquals(new Rectangle(0, 0, -2, -2).getWidth(), 2, 0.00001);
    Assert.assertEquals(new Rectangle(-1, -1, -2, -2).getWidth(), 1, 0.00001);
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void testExpand() throws Exception {
    Rectangle r = new Rectangle(0, 0, -1, -1);
    r.expand(2);
    Assert.assertEquals(r.getArea(), 2, 0.00001);
    r = new Rectangle(-1, -1, -2, -2);
    r.expand(2);
    Assert.assertEquals(r.getArea(), 2, 0.00001);
    r = new Rectangle(0, 0, -2, -2);
    r.expand(4);
    Assert.assertEquals(r.getArea(), 16, 0.00001);
  }

  @Test @SuppressWarnings({ "static-method", "static-access" }) public void testRotate() throws Exception {
    Rectangle r = new Rectangle(0, 0, 1, 2);
    r.rotate();
    Assert.assertEquals(r.getHeight(), 1, 0.00001);
    Assert.assertEquals(r.getWidth(), 2, 0.00001);
    r = new Rectangle(0, 0, 4, 3);
    r.rotate();
    Assert.assertEquals(r.getHeight(), 4, 0.00001);
    Assert.assertEquals(r.getWidth(), 3, 0.00001);
  }
}
