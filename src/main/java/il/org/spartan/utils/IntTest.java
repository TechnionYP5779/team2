package il.org.spartan.utils;

import org.junit.*;

public class IntTest {
  @SuppressWarnings("static-method") @Test public void creation() {
    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;
    Int v = new Int();
    Assert.assertEquals(v.get(), 0);
    Int v1 = new Int(max);
    Assert.assertEquals(v1.get(), Integer.MAX_VALUE);
    Int v2 = new Int(max + 1);
    Assert.assertEquals(v2.get(), Integer.MIN_VALUE);
    Int v3 = new Int(min - 1);
    Assert.assertEquals(v3.get(), Integer.MAX_VALUE);
  }

  @SuppressWarnings("static-method") @Test public void innerValue() {
    Int v_default = new Int();
    Assert.assertEquals(v_default.get(), 0);
    Assert.assertEquals(v_default.inner(), Integer.valueOf(0));
    Assert.assertEquals(Integer.valueOf(v_default.get()), v_default.inner());
    Int max = new Int(Integer.MAX_VALUE);
    Assert.assertEquals(max.get(), Integer.MAX_VALUE);
    Assert.assertEquals(max.inner(), Integer.valueOf(Integer.MAX_VALUE));
    Assert.assertEquals(Integer.valueOf(max.get()), max.inner());
    Int min = new Int(Integer.MAX_VALUE);
    Assert.assertEquals(min.get(), Integer.MAX_VALUE);
    Assert.assertEquals(min.inner(), Integer.valueOf(Integer.MAX_VALUE));
    Assert.assertEquals(Integer.valueOf(min.get()), min.inner());
  }

  @SuppressWarnings("static-method") @Test public void valueChanges() {
    Int v = new Int();
    Assert.assertEquals(v.get(), 0);
  }
}