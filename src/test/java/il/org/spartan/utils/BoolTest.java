package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BoolTest {
  @Test @SuppressWarnings("null") public void trueConstructorTest() {
    azzert.assertTrue(unbox.unbox((new Bool(true)).inner()));
  }

  @Test @SuppressWarnings("null") public void falseConstructorTest() {
    azzert.assertFalse(unbox.unbox(new Bool(false).inner()));
  }

  @Test @SuppressWarnings("null") public void emptyConstructorTest() {
    azzert.assertFalse(unbox.unbox(new Bool(false).inner()));
  }

  @Test public void clearTest1() {
    azzert.assertFalse(new Bool().clear().get());
  }

  @Test public void clearTest2() {
    azzert.assertFalse(new Bool(false).clear().get());
  }

  @Test public void clearTest3() {
    azzert.assertFalse(new Bool(true).clear().get());
  }

  @Test public void setTest1() {
    azzert.assertTrue(new Bool().set().get());
  }

  @Test public void setTest2() {
    azzert.assertTrue(new Bool(false).set().get());
  }

  @Test public void setTest3() {
    azzert.assertTrue(new Bool(true).set().get());
  }

  @Test public void getTest() {
    final Bool b = new Bool().set();
    azzert.assertTrue(b.get());
    b.clear();
    azzert.assertFalse(b.get());
  }
}
