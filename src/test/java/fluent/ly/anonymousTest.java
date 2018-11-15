package fluent.ly;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.assertEquals;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class anonymousTest {
  @Test public void booleanTest() {
    assert anonymous.ly(() -> true);
    assert !anonymous.ly(() -> false);
  }

  @Test public void doubleTest() {
    assertEquals(1.5, anonymous.ly(() -> 1.5), 0.0);
    assertEquals(500.0, anonymous.ly(() -> 500.0), 0.0);
  }

  @Test public void intTest() {
    assertEquals(1, anonymous.ly(() -> 1));
    assertEquals(500, anonymous.ly(() -> 500));
  }

  @Test public void longTest() {
    assertEquals(1325489434L, anonymous.ly(() -> 1325489434L));
    assertEquals(500548943L, anonymous.ly(() -> 500548943L));
  }

  @Test public void tTest() {
    assert anonymous.ly((BooleanSupplier) () -> true);
    assertEquals(fluent.ly.box.it(1), anonymous.ly((IntSupplier) () -> 1));
    assertEquals(1.5, anonymous.ly((DoubleSupplier) () -> 1.5), 0.0);
    assertEquals(1325489434L, anonymous.ly((LongSupplier) () -> 1325489434L));
  }
}
