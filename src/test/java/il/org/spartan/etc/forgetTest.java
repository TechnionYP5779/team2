package il.org.spartan.etc;

import static fluent.ly.box.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class forgetTest {
  @Test public void testForgetAll() {
    forget.all("hi");
    forget.all("hi", "bye");
    forget.all(box(1), "hi", box(3));
    forget.all(box(1.1), box(2));
  }

  @Test public void testForgetItBoolean() {
    forget.it(true);
    forget.it(false);
  }

  @Test public void testForgetItDouble() {
    forget.it(1.19);
  }

  @Test public void testForgetItLong() {
    forget.it(Long.MAX_VALUE / 2);
  }

  @Test public void testForgetItObject() {
    forget.it("hi");
    forget.it(true);
    forget.it(box(3));
  }
  
  @Test public void testUnused() {
    forget.______unused(4234234l,new Object());
    forget.unused(new Object());
  }
  
}
