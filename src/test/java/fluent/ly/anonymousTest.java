package fluent.ly;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "static-access" }) public class anonymousTest {
  @Test public void booleanTest() {
    assert anonymous.ly(() -> true);
    assert !anonymous.ly(() -> false);
  }

  @Test public void doubleTest() {
    Assert.assertEquals(1.5, anonymous.ly(() -> 1.5), 0.0);
    Assert.assertEquals(500.0, anonymous.ly(() -> 500.0), 0.0);
  }

  @Test public void intTest() {
    azzert.assertEquals(1, anonymous.ly(() -> 1));
    azzert.assertEquals(500, anonymous.ly(() -> 500));
  }

  @Test public void longTest() {
    Assert.assertEquals(1325489434L, anonymous.ly(() -> 1325489434L));
    Assert.assertEquals(500548943L, anonymous.ly(() -> 500548943L));
  }

  @Test @SuppressWarnings("boxing") public void tTest() {
    assert anonymous.ly((BooleanSupplier) () -> Boolean.TRUE);
    azzert.assertEquals(Integer.valueOf(1), anonymous.ly((IntSupplier) () -> Integer.valueOf(1)));
    Assert.assertEquals(1.5, anonymous.ly((DoubleSupplier) () -> Double.valueOf(1.5)), 0.0);
    final Long l = Long.valueOf(1325489434L);
    Assert.assertEquals(l.longValue(), anonymous.ly((LongSupplier) () -> l));
  }
}
