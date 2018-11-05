package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class BoolTest {
  @SuppressWarnings({ "boxing" }) @Test public void trueConstructorTest() {
    Bool b = new Bool(true);
    if (!b.inner()) {
      fail("Did not save the constructor value");
    }
  }

  @SuppressWarnings({ "boxing" }) @Test public void falseConstructorTest() {
    Bool b = new Bool(false);
    if (b.inner()) {
      fail("Did not save the constructor value");
    }
  }

  @SuppressWarnings({ "boxing" }) @Test public void emptyConstructorTest() {
    Bool b = new Bool();
    if (b.inner() != false) {
      fail("Did not save the constructor value");
    }
  }

  @Test public void clearTest() {
    Bool b1 = new Bool();
    b1.clear();
    if (b1.get()) {
      fail("Error in the clear function");
    }
    Bool b2 = new Bool(false);
    b2.clear();
    if (b2.get()) {
      fail("Error in the clear function");
    }
    Bool b3 = new Bool(true);
    b3.clear();
    if (b3.get()) {
      fail("Error in the clear function");
    }
  }

  @Test public void setTest() {
    Bool b1 = new Bool();
    b1.set();
    if (!b1.get()) {
      fail("Error in the set function");
    }
    Bool b2 = new Bool(false);
    b2.set();
    if (!b2.get()) {
      fail("Error in the set function");
    }
    Bool b3 = new Bool(true);
    b3.set();
    if (!b3.get()) {
      fail("Error in the set function");
    }
  }

  @Test public void getTest() {
    Bool b = new Bool();
    b.set();
    if (!b.get()) {
      fail("Error in the get function");
    }
    b.clear();
    if (b.get()) {
      fail("Error in the get function");
    }
  }
}
