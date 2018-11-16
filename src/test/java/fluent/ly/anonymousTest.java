package fluent.ly;

import static fluent.ly.anonymous.*;
import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class anonymousTest {
  @Test public void booleanTest() {
    assert ly(() -> true);
    assert !ly(() -> false);
  }

  @Test public void doubleTest() {
    azzert.that(1.5, is(ly(() -> 1.5)));
    azzert.that(500.0, is(ly(() -> 500.0)));
  }

  @Test public void intTest() {
    azzert.that(1, is(ly(() -> 1)));
    azzert.that(500, is(ly(() -> 500)));
  }

  @Test public void longTest() {
    azzert.that(1325489434L, is(ly(() -> 1325489434L)));
    azzert.that(500548943L, is(ly(() -> 500548943L)));
  }

  @Test public void tTest() {
    assert ly((BooleanSupplier) () -> true);
    azzert.that(box.it(1), is(ly((IntSupplier) () -> 1)));
    azzert.that(1.5, is(ly((DoubleSupplier) () -> 1.5)));
    azzert.that(1325489434L, is(ly((LongSupplier) () -> 1325489434L)));
  }
}
