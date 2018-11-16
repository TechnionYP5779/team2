package il.org.spartan.etc;

import org.junit.*;
import static fluent.ly.box.*;

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
    forget.it(box(1.19));
  }

  @Test public void testForgetItLong() {
    forget.it(box(Long.MAX_VALUE/2));
  }

  @Test public void testForgetItObject() {
    forget.it("hi");
    forget.it(true);
    forget.it(box(3));
  }
}
