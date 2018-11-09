package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class BoolTest {
  @Test @SuppressWarnings("boxing") public void trueConstructorTest() {
    if (!(new Bool(true)).inner())
      fail("Did not save the constructor value");
  }

  @Test @SuppressWarnings("boxing") public void falseConstructorTest() {
    if ((new Bool(false)).inner())
      fail("Did not save the constructor value");
  }

  @Test @SuppressWarnings("boxing") public void emptyConstructorTest() {
    if ((new Bool()).inner())
      fail("Did not save the constructor value");
  }

  @Test public void clearTest() {
    Bool b1 = new Bool();
    b1.clear();
    if (b1.get())
      fail("Error in the clear function");
    Bool b2 = new Bool(false);
    b2.clear();
    if (b2.get())
      fail("Error in the clear function");
    Bool b3 = new Bool(true);
    b3.clear();
    if (b3.get())
      fail("Error in the clear function");
  }

  @Test public void setTest() {
    Bool b1 = new Bool();
    b1.set();
    if (!b1.get())
      fail("Error in the set function");
    Bool b2 = new Bool(false);
    b2.set();
    if (!b2.get())
      fail("Error in the set function");
    Bool b3 = new Bool(true);
    b3.set();
    if (!b3.get())
      fail("Error in the set function");
  }

  @Test public void getTest() {
    Bool b = new Bool();
    b.set();
    if (!b.get())
      fail("Error in the get function");
    b.clear();
    if (b.get())
      fail("Error in the get function");
  }
}
