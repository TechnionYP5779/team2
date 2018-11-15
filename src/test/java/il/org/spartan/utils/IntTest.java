package il.org.spartan.utils;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.assertEquals;

import org.junit.*;

@SuppressWarnings("static-method") public class IntTest {
  @Test public void creation() {
    final int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
    assertEquals(new Int().get(), 0);
    assertEquals(new Int(max).get(), Integer.MAX_VALUE);
    assertEquals(new Int(max + 1).get(), Integer.MIN_VALUE);
    assertEquals(new Int(min - 1).get(), Integer.MAX_VALUE);
  }

  @Test public void innerValue() {
    final Int v_default = new Int();
    assertEquals(v_default.get(), 0);
    assertEquals(v_default.inner(), Integer.valueOf(0));
    assertEquals(Integer.valueOf(v_default.get()), v_default.inner());
    final Int max = new Int(Integer.MAX_VALUE);
    assertEquals(max.get(), Integer.MAX_VALUE);
    assertEquals(max.inner(), Integer.valueOf(Integer.MAX_VALUE));
    assertEquals(Integer.valueOf(max.get()), max.inner());
    final Int min = new Int(Integer.MIN_VALUE);
    assertEquals(min.get(), Integer.MIN_VALUE);
    assertEquals(min.inner(), Integer.valueOf(Integer.MIN_VALUE));
    assertEquals(Integer.valueOf(min.get()), min.inner());
  }

  @Test public void valueChanges() {
    final Int v = new Int(), max = new Int(Integer.MAX_VALUE), min = new Int(Integer.MIN_VALUE);
    assertEquals(v.get(), 0);
    assertEquals(max.get(), Integer.MAX_VALUE);
    assertEquals(min.get(), Integer.MIN_VALUE);
    v.step();
    max.step();
    min.step();
    assertEquals(v.get(), 1);
    assertEquals(max.get(), Integer.MIN_VALUE);
    assertEquals(min.get(), Integer.MIN_VALUE + 1);
    v.add(-1);
    max.add(-1);
    min.add(-1);
    assertEquals(v.get(), 0);
    assertEquals(max.get(), Integer.MAX_VALUE);
    assertEquals(min.get(), Integer.MIN_VALUE);
    v.add(5);
    max.add(5);
    min.add(5);
    assertEquals(v.get(), 5);
    assertEquals(max.get(), Integer.MAX_VALUE + 5);
    assertEquals(min.get(), Integer.MIN_VALUE + 5);
    final Int addon = new Int(322);
    v.add(addon);
    assertEquals(v.get(), 327);
    max.add(v);
    assertEquals(max.get(), Integer.MAX_VALUE + 5 + v.get());
    min.add(addon.next());
    assertEquals(min.get(), Integer.MIN_VALUE + 5 + addon.get());
    v.set(-354654);
    max.set(-354654);
    min.set(-354654);
    assertEquals(v.get(), -354654);
    assertEquals(v.get(), max.get());
    assertEquals(min.get(), max.get());
    v.clear();
    max.clear();
    min.clear();
    assertEquals(v.get(), 0);
    assertEquals(v.get(), max.get());
    assertEquals(min.get(), max.get());
    v.set(max.next() + min.next());
    assertEquals(v.get(), 2);
    min.add(Int.valueOf(v.next()));
    assertEquals(v.get(), 3);
    assertEquals(min.get(), 4);
    max.set(min.next() + v.get());
    assertEquals(max.get(), 8);
  }

  @Test public void toStringCheck() {
    final Int v = new Int(), max = new Int(Integer.MAX_VALUE), min = new Int(Integer.MIN_VALUE);
    final int val = 546116854;
    assertEquals(v + "", "0");
    assertEquals(max + "", Integer.MAX_VALUE + "");
    assertEquals(min + "", Integer.MIN_VALUE + "");
    v.set(val);
    assertEquals(v + "", val + "");
    v.step();
    v.add(-5);
    assertEquals(v + "", "546116850");
    v.clear();
    assertEquals(v + "", "0");
    v.step();
    v.add(99);
    assertEquals(v + "", "100");
  }
}