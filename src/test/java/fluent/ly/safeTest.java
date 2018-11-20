package fluent.ly;

import java.util.function.*;

import org.eclipse.jdt.annotation.*;
import org.junit.*;

import static fluent.ly.box.*;
import static fluent.ly.azzert.*;


import org.junit.*;

@SuppressWarnings("static-method")
public class safeTest {
   @Test public void testDivNormalFull() {
    azzert.that(safe.div(2, 2), is(box(1.0)));
  }
  
  @Test public void testDivNormalNotFull() {
    azzert.that(safe.div(1, 4), is(box(0.25)));
  }
  
@Test public void testDivByZero() {
    azzert.that(safe.div(10, 0), is(box(1.0)));
  }
}
