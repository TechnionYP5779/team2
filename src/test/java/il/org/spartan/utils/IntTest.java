package il.org.spartan.utils;

import static fluent.ly.box.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method", "static-access"}) 
public class IntTest { 
  @Test public void creation() {
    azzert.assertZero(new Int().get());
  }
  
  @Test public void creation0() {
    final int min = Integer.MIN_VALUE;
    azzert.assertEquals(new Int(min).get(), Integer.MIN_VALUE);
  }
  
  @Test public void creation1() {
    final int min = Integer.MIN_VALUE;
    azzert.assertEquals(new Int(min - 1).get(), Integer.MAX_VALUE);
  }
  
  @Test public void creation2() {
    final int max = Integer.MAX_VALUE;
    azzert.assertEquals(new Int(max).get(), Integer.MAX_VALUE);
  }
  
  @Test public void creation3() {
    final int max = Integer.MAX_VALUE;
    azzert.assertEquals(new Int(max + 1).get(), Integer.MIN_VALUE);
  }

  @Test public void innerValue() {
    final Int v_default = new Int();
    azzert.assertZero(v_default.get());
  }
  
  @Test public void innerValue1() {
    final Int v_default = new Int();
    azzert.assertEquals(v_default.inner(), box(0));
  }
  
  @Test public void innerValue2() {
    final Int v_default = new Int();
    azzert.assertEquals(box(v_default.get()), v_default.inner());
  }
  
  @Test public void innerValue3() {
    final Int max = new Int(Integer.MAX_VALUE);
    azzert.assertEquals(max.get(), Integer.MAX_VALUE);
  }
  
  @Test public void innerValue4() {
    final Int max = new Int(Integer.MAX_VALUE);
    azzert.assertEquals(max.inner(), box(Integer.MAX_VALUE));
  }
  
  @Test public void innerValue5() {
    final Int max = new Int(Integer.MAX_VALUE);
    azzert.assertEquals(box(max.get()), max.inner());
  }
  
  @Test public void innerValue6() {
    final Int min = new Int(Integer.MIN_VALUE);
    azzert.assertEquals(min.get(), Integer.MIN_VALUE);
  }
  
  @Test public void innerValue7() {
    final Int min = new Int(Integer.MIN_VALUE);
    azzert.assertEquals(min.inner(), box(Integer.MIN_VALUE));
  }
  
  @Test public void innerValue8() {
    final Int min = new Int(Integer.MIN_VALUE);
    azzert.assertEquals(box(min.get()), min.inner());
  }

  @Test public void valueChanges() {
    Int v = new Int(); 
    azzert.assertZero(v.get());
  }
  
  @Test public void valueChanges1() {
    Int v = new Int();
    v.step();
    azzert.assertEquals(v.get(), 1);
  }
  
  @Test public void valueChanges2() {
    Int v = new Int();
    v.step();
    v.add(-1);
    azzert.assertZero(v.get());
  }
  
  @Test public void valueChanges3() {
    Int v = new Int();
    v.step();
    v.add(4);
    azzert.assertEquals(v.get(), 5);
  }
  
  @Test public void valueChanges4() {
    Int v = new Int();
    v.step();
    v.add(4);
    final Int addon = new Int(322);
    v.add(addon);
    azzert.assertEquals(v.get(), 327);
  }
  
  @Test public void valueChanges5() {
    Int v = new Int();
    v.step();
    v.add(4);
    v.set(-354654);
    azzert.assertEquals(v.get(), -354654);
  }
  
  @Test public void valueChanges6() {
    Int v = new Int();
    v.step();
    v.add(4);
    v.set(-354654);
    v.clear();
    azzert.assertZero(v.get());
  }
  
  @Test public void valueChanges7() {
    Int v = new Int(), v1 = new Int(), v2 = new Int();
    azzert.assertEquals(v.get(), v1.get());
  }
  
  @Test public void valueChanges8() {
    Int v = new Int(), v1 = new Int(), v2 = new Int();
    v.set(v1.next() + v2.next());
    azzert.assertEquals(v.get(), 2);
    v2.add(v.next());
    azzert.assertEquals(v.get(), 3);
  }
  
  @Test public void valueChanges9() {
    Int v = new Int(), v1 = new Int(), v2 = new Int();
    v.set(v1.next() + v2.next());
    v2.add(v.next());
    azzert.assertEquals(v.get(), 3);
  }
  
  @Test public void valueChangesMax1() {
    final Int max = new Int(Integer.MAX_VALUE);
    azzert.assertEquals(max.get(), Integer.MAX_VALUE);
  }
  
  @Test public void valueChangesMax2() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    azzert.assertEquals(max.get(), Integer.MIN_VALUE);
  }
  
  @Test public void valueChangesMax3() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(-1);
    azzert.assertEquals(max.get(), Integer.MAX_VALUE);
  }
  
  @Test public void valueChangesMax4() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(4);
    azzert.assertEquals(max.get(), Integer.MAX_VALUE + 5);
  }
  
  @Test public void valueChangesMax5() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(4);
    Int v = new Int(327);
    max.add(v);
    azzert.assertEquals(max.get(), Integer.MAX_VALUE + 5 + v.get());
  }
  
  @Test public void valueChangesMax6() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(4);
    Int v = new Int(-354654);
    max.add(v);
    max.set(-354654);
    azzert.assertEquals(v.get(), max.get());
  }
  
  @Test public void valueChangesMax7() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(4);
    Int v = new Int(-354654);
    max.add(v);
    max.set(-354654);
    v.clear();
    max.clear();
    azzert.assertEquals(v.get(), max.get());
  }
  
  @Test public void valueChangesMax8() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(4);
    Int v = new Int(-354654);
    max.add(v);
    max.set(-354654);
    v.clear();
    max.clear();
    max.set(8 + v.get());
    azzert.assertEquals(max.get(), 8);

  }
  
  
  @Test public void valueChangesMin1() {
    final Int min = new Int(Integer.MIN_VALUE);
    azzert.assertEquals(min.get(), Integer.MIN_VALUE);
  }
  
  @Test public void valueChangesMin2() {
    Int min = new Int(Integer.MIN_VALUE);
    min.step();
    azzert.assertEquals(min.get(), Integer.MIN_VALUE + 1);
  }
  
  @Test public void valueChangesMin3() {
    Int min = new Int(Integer.MIN_VALUE);
    min.step();
    min.add(-1);
    azzert.assertEquals(min.get(), Integer.MIN_VALUE);
  }
  
  @Test public void valueChangesMin4() {
    Int min = new Int(Integer.MIN_VALUE);
    min.step();
    min.add(4);
    azzert.assertEquals(min.get(), Integer.MIN_VALUE + 5);
  }
  
  @Test public void valueChangesMin5() {
    Int min = new Int(Integer.MIN_VALUE);
    min.step();
    min.add(4);
    final Int addon = new Int(322);
    min.add(addon.next());
    azzert.assertEquals(min.get(), Integer.MIN_VALUE + 5 + addon.get());
  }
  
  @Test public void valueChangesMin6() {
    Int min = new Int(Integer.MIN_VALUE);
    min.step();
    min.add(4);
    final Int addon = new Int(322);
    min.add(addon.next());
    azzert.assertEquals(min.get(), Integer.MIN_VALUE + 5 + addon.get());
    min.set(-354654);
    azzert.assertEquals(min.get(), -354654);
  }
  
  @Test public void valueChangesMin7() {
    Int min = new Int(Integer.MIN_VALUE);
    min.step();
    min.add(4);
    final Int addon = new Int(322);
    min.add(addon.next());
    min.set(-354654);
    min.clear();
    azzert.assertZero(min.get());
  }
  
  @Test public void toStringCheck() {
    final Int v = new Int();
    azzert.assertEquals(v + "", "0");
  }
  
  @Test public void toStringCheck1() {
    final Int max = new Int(Integer.MAX_VALUE);
    azzert.assertEquals(max + "", Integer.MAX_VALUE + "");
  }
  
  @Test public void toStringCheck2() {
    final Int min = new Int(Integer.MIN_VALUE);
    azzert.assertEquals(min + "", Integer.MIN_VALUE + "");
  }
  
  @Test public void toStringCheck3() {
    final Int v = new Int();
    final int val = 546116854;
    v.set(val);
    azzert.assertEquals(v + "", val + "");
  }
  
  @Test public void toStringCheck4() {
    final Int v = new Int(546116854);
    v.step();
    v.add(-5);
    azzert.assertEquals(v + "", "546116850");
  }
  
  @Test public void toStringCheck5() {
    final Int v = new Int(546116850);
    v.clear();
    azzert.assertEquals(v + "", "0");
  }
  
  @Test public void toStringCheck6() {
    final Int v = new Int();
    v.step();
    v.add(99);
    azzert.assertEquals(v + "", "100");
  }
}