package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class IntTest {
  @Test public void creation() {
    final int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
    azzert.assertEquals(new Int().get(), 0);
    azzert.assertEquals(new Int(max).get(), Integer.MAX_VALUE);
    azzert.assertEquals(new Int(max + 1).get(), Integer.MIN_VALUE);
    azzert.assertEquals(new Int(min - 1).get(), Integer.MAX_VALUE);
  }

  @Test @SuppressWarnings("static-access") public void innerValue() {
    final Int v_default = new Int();
    azzert.assertEquals(v_default.get(), 0);
    Assert.assertEquals(v_default.inner(), Integer.valueOf(0));
    Assert.assertEquals(Integer.valueOf(v_default.get()), v_default.inner());
    final Int max = new Int(Integer.MAX_VALUE);
    azzert.assertEquals(max.get(), Integer.MAX_VALUE);
    Assert.assertEquals(max.inner(), Integer.valueOf(Integer.MAX_VALUE));
    Assert.assertEquals(Integer.valueOf(max.get()), max.inner());
    final Int min = new Int(Integer.MIN_VALUE);
    azzert.assertEquals(min.get(), Integer.MIN_VALUE);
    Assert.assertEquals(min.inner(), Integer.valueOf(Integer.MIN_VALUE));
    Assert.assertEquals(Integer.valueOf(min.get()), min.inner());
  }

  @Test public void valueChanges() {
    final Int v = new Int(), max = new Int(Integer.MAX_VALUE), min = new Int(Integer.MIN_VALUE);
    azzert.assertEquals(v.get(), 0);
    azzert.assertEquals(max.get(), Integer.MAX_VALUE);
    azzert.assertEquals(min.get(), Integer.MIN_VALUE);
    v.step();
    max.step();
    min.step();
    azzert.assertEquals(v.get(), 1);
    azzert.assertEquals(max.get(), Integer.MIN_VALUE);
    azzert.assertEquals(min.get(), Integer.MIN_VALUE + 1);
    v.add(-1);
    max.add(-1);
    min.add(-1);
    azzert.assertEquals(v.get(), 0);
    azzert.assertEquals(max.get(), Integer.MAX_VALUE);
    azzert.assertEquals(min.get(), Integer.MIN_VALUE);
    v.add(5);
    max.add(5);
    min.add(5);
    azzert.assertEquals(v.get(), 5);
    azzert.assertEquals(max.get(), Integer.MAX_VALUE + 5);
    azzert.assertEquals(min.get(), Integer.MIN_VALUE + 5);
    final Int addon = new Int(322);
    v.add(addon);
    azzert.assertEquals(v.get(), 327);
    max.add(v);
    azzert.assertEquals(max.get(), Integer.MAX_VALUE + 5 + v.get());
    min.add(addon.next());
    azzert.assertEquals(min.get(), Integer.MIN_VALUE + 5 + addon.get());
    v.set(-354654);
    max.set(-354654);
    min.set(-354654);
    azzert.assertEquals(v.get(), -354654);
    azzert.assertEquals(v.get(), max.get());
    azzert.assertEquals(min.get(), max.get());
    v.clear();
    max.clear();
    min.clear();
    azzert.assertEquals(v.get(), 0);
    azzert.assertEquals(v.get(), max.get());
    azzert.assertEquals(min.get(), max.get());
    v.set(max.next() + min.next());
    azzert.assertEquals(v.get(), 2);
    min.add(Int.valueOf(v.next()));
    azzert.assertEquals(v.get(), 3);
    azzert.assertEquals(min.get(), 4);
    max.set(min.next() + v.get());
    azzert.assertEquals(max.get(), 8);
  }

  @Test @SuppressWarnings("static-access") public void toStringCheck() {
    final Int v = new Int(), max = new Int(Integer.MAX_VALUE), min = new Int(Integer.MIN_VALUE);
    final int val = 546116854;
    Assert.assertEquals(v + "", "0");
    Assert.assertEquals(max + "", Integer.MAX_VALUE + "");
    Assert.assertEquals(min + "", Integer.MIN_VALUE + "");
    v.set(val);
    Assert.assertEquals(v + "", val + "");
    v.step();
    v.add(-5);
    Assert.assertEquals(v + "", "546116850");
    v.clear();
    Assert.assertEquals(v + "", "0");
    v.step();
    v.add(99);
    Assert.assertEquals(v + "", "100");
  }
}