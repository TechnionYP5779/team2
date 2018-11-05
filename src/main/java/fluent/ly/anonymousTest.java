package fluent.ly;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class anonymousTest {
  @Test public void booleanTest() {
    BooleanSupplier bt = () -> true;
    Assert.assertTrue(anonymous.ly(bt));
    BooleanSupplier bf = () -> false;
    Assert.assertFalse(anonymous.ly(bf));
  }

  @Test public void doubleTest() {
    DoubleSupplier b1 = () -> 1.5;
    Assert.assertEquals(1.5, anonymous.ly(b1), 0.0);
    DoubleSupplier b500 = () -> 500.0;
    Assert.assertEquals(500.0, anonymous.ly(b500), 0.0);
  }

  @Test public void intTest() {
    IntSupplier b1 = () -> 1;
    Assert.assertEquals(1, anonymous.ly(b1));
    IntSupplier b500 = () -> 500;
    Assert.assertEquals(500, anonymous.ly(b500));
  }

  @Test public void longTest() {
    LongSupplier b1 = () -> 1325489434L;
    Assert.assertEquals(1325489434L, anonymous.ly(b1));
    LongSupplier b500 = () -> 500548943L;
    Assert.assertEquals(500548943L, anonymous.ly(b500));
  }

  @SuppressWarnings("boxing") @Test public void tTest() {
    Supplier<Boolean> bt = () -> Boolean.valueOf(true);
    Assert.assertTrue(anonymous.ly(bt));
    Supplier<Integer> b1 = () -> Integer.valueOf(1);
    Assert.assertEquals(Integer.valueOf(1), anonymous.ly(b1));
    Supplier<Double> b15 = () -> Double.valueOf(1.5);
    Assert.assertEquals(1.5, anonymous.ly(b15), 0.0);
    Long l = Long.valueOf(1325489434L);
    Supplier<Long> b132 = () -> l;
    Assert.assertEquals(l, anonymous.ly(b132));
  }
}
