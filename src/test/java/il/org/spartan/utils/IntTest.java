package il.org.spartan.utils;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class IntTest {
  @Test public void creation() {
    azzert.assertZero(new Int().get());
  }

  @Test public void creation0() {
    azzert.that(new Int(Integer.MIN_VALUE).get(), is(Integer.MIN_VALUE));
  }

  @Test public void creation1() {
    azzert.that(new Int(Integer.MIN_VALUE - 1).get(), is(Integer.MAX_VALUE));
  }

  @Test public void creation2() {
    azzert.that(new Int(Integer.MAX_VALUE).get(), is(Integer.MAX_VALUE));
  }

  @Test public void creation3() {
    azzert.that(new Int(Integer.MAX_VALUE + 1).get(), is(Integer.MIN_VALUE));
  }

  @Test public void innerValue() {
    azzert.assertZero(new Int().get());
  }

  @Test public void innerValue1() {
    azzert.zero(unbox(cantBeNull(new Int().inner())));
  }

  @Test public void innerValue2() {
    final Int v_default = new Int();
    azzert.that(box(v_default.get()), is(v_default.inner()));
  }

  @Test public void innerValue3() {
    azzert.that(new Int(Integer.MAX_VALUE).get(), is(Integer.MAX_VALUE));
  }

  @Test public void innerValue4() {
    azzert.that(new Int(Integer.MAX_VALUE).inner(), is(Integer.MAX_VALUE));
  }

  @Test public void innerValue5() {
    final Int max = new Int(Integer.MAX_VALUE);
    azzert.that(box(max.get()), is(max.inner()));
  }

  @Test public void innerValue6() {
    azzert.that(new Int(Integer.MIN_VALUE).get(), is(Integer.MIN_VALUE));
  }

  @Test public void innerValue7() {
    azzert.that(new Int(Integer.MIN_VALUE).inner(), is(Integer.MIN_VALUE));
  }

  @Test public void innerValue8() {
    final Int min = new Int(Integer.MIN_VALUE);
    azzert.that(box(min.get()), is(min.inner()));
  }

  @Test public void valueChanges() {
    azzert.assertZero(new Int().get());
  }

  @Test public void valueChanges1() {
    final Int v = new Int();
    v.step();
    azzert.that(v.get(), is(1));
  }

  @Test public void valueChanges2() {
    final Int v = new Int();
    v.step();
    v.add(-1);
    azzert.assertZero(v.get());
  }

  @Test public void valueChanges3() {
    final Int v = new Int();
    v.step();
    v.add(4);
    azzert.that(v.get(), is(5));
  }

  @Test public void valueChanges4() {
    final Int v = new Int();
    v.step();
    v.add(4);
    v.add(new Int(322));
    azzert.that(v.get(), is(327));
  }

  @Test public void valueChanges5() {
    final Int v = new Int();
    v.step();
    v.add(4);
    v.set(-354654);
    azzert.that(v.get(), is(-354654));
  }

  @Test public void valueChanges6() {
    final Int v = new Int();
    v.step();
    v.add(4);
    v.set(-354654);
    v.clear();
    azzert.assertZero(v.get());
  }

  @Test public void valueChanges7() {
    azzert.that(new Int().get(), is(new Int().get()));
  }

  @Test public void valueChanges8() {
    final Int v = new Int(), v2 = new Int();
    v.set(new Int().next() + v2.next());
    azzert.that(v.get(), is(2));
    v2.add(v.next());
    azzert.that(v.get(), is(3));
  }

  @Test public void valueChanges9() {
    final Int v = new Int(), v2 = new Int();
    v.set(new Int().next() + v2.next());
    v2.add(v.next());
    azzert.that(v.get(), is(3));
  }

  @Test public void valueChangesMax1() {
    azzert.that(new Int(Integer.MAX_VALUE).get(), is(Integer.MAX_VALUE));
  }

  @Test public void valueChangesMax2() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    azzert.that(max.get(), is(Integer.MIN_VALUE));
  }

  @Test public void valueChangesMax3() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(-1);
    azzert.that(max.get(), is(Integer.MAX_VALUE));
  }

  @Test public void valueChangesMax4() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(4);
    azzert.that(max.get(), is(Integer.MAX_VALUE + 5));
  }

  @Test public void valueChangesMax5() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(4);
    final Int v = new Int(327);
    max.add(v);
    azzert.that(max.get(), is(Integer.MAX_VALUE + 5 + v.get()));
  }

  @Test public void valueChangesMax6() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(4);
    final Int v = new Int(-354654);
    max.add(v);
    max.set(-354654);
    azzert.that(v.get(), is(max.get()));
  }

  @Test public void valueChangesMax7() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(4);
    final Int v = new Int(-354654);
    max.add(v);
    max.set(-354654);
    v.clear();
    max.clear();
    azzert.that(v.get(), is(max.get()));
  }

  @Test public void valueChangesMax8() {
    final Int max = new Int(Integer.MAX_VALUE);
    max.step();
    max.add(4);
    final Int v = new Int(-354654);
    max.add(v);
    max.set(-354654);
    v.clear();
    max.clear();
    max.set(8 + v.get());
    azzert.that(max.get(), is(8));
  }

  @Test public void valueChangesMin1() {
    azzert.that(new Int(Integer.MIN_VALUE).get(), is(Integer.MIN_VALUE));
  }

  @Test public void valueChangesMin2() {
    final Int min = new Int(Integer.MIN_VALUE);
    min.step();
    azzert.that(min.get(), is(Integer.MIN_VALUE + 1));
  }

  @Test public void valueChangesMin3() {
    final Int min = new Int(Integer.MIN_VALUE);
    min.step();
    min.add(-1);
    azzert.that(min.get(), is(Integer.MIN_VALUE));
  }

  @Test public void valueChangesMin4() {
    final Int min = new Int(Integer.MIN_VALUE);
    min.step();
    min.add(4);
    azzert.that(min.get(), is(Integer.MIN_VALUE + 5));
  }

  @Test public void valueChangesMin5() {
    final Int min = new Int(Integer.MIN_VALUE);
    min.step();
    min.add(4);
    final Int addon = new Int(322);
    min.add(addon.next());
    azzert.that(min.get(), is(Integer.MIN_VALUE + 5 + addon.get()));
  }

  @Test public void valueChangesMin6() {
    final Int min = new Int(Integer.MIN_VALUE);
    min.step();
    min.add(4);
    final Int addon = new Int(322);
    min.add(addon.next());
    azzert.that(min.get(), is(Integer.MIN_VALUE + 5 + addon.get()));
    min.set(-354654);
    azzert.that(min.get(), is(-354654));
  }

  @Test public void valueChangesMin7() {
    final Int min = new Int(Integer.MIN_VALUE);
    min.step();
    min.add(4);
    min.add(new Int(322).next());
    min.set(-354654);
    min.clear();
    azzert.assertZero(min.get());
  }

  @Test public void valueOfTest0() {
    azzert.zero(Int.valueOf(0).get());
  }

  @Test public void valueOfTest1() {
    azzert.that(Int.valueOf(0).inner(), is(box(0)));
  }

  @Test public void valueOfTest2() {
    azzert.assertEquals(new Int(Integer.MAX_VALUE).get(), Int.valueOf(Integer.MAX_VALUE).get());
  }

  @Test public void valueOfTest3() {
    azzert.that(new Int(Integer.MAX_VALUE).inner(), is(Int.valueOf(Integer.MAX_VALUE).inner()));
  }

  @Test public void valueOfTest4() {
    azzert.assertEquals(new Int(Integer.MIN_VALUE).get(), Int.valueOf(Integer.MIN_VALUE).get());
  }

  @Test public void valueOfTest5() {
    azzert.that(new Int(Integer.MIN_VALUE).inner(), is(Int.valueOf(Integer.MIN_VALUE).inner()));
  }

  @Test public void toStringCheck() {
    azzert.that(new Int() + "", is("0"));
  }

  @Test public void toStringCheck1() {
    azzert.that(new Int(Integer.MAX_VALUE) + "", is(Integer.MAX_VALUE + ""));
  }

  @Test public void toStringCheck2() {
    azzert.that(new Int(Integer.MIN_VALUE) + "", is(Integer.MIN_VALUE + ""));
  }

  @Test public void toStringCheck3() {
    final Int v = new Int();
    final int val = 546116854;
    v.set(val);
    azzert.that(v + "", is(val + ""));
  }

  @Test public void toStringCheck4() {
    final Int v = new Int(546116854);
    v.step();
    v.add(-5);
    azzert.that(v + "", is("546116850"));
  }

  @Test public void toStringCheck5() {
    final Int v = new Int(546116850);
    v.clear();
    azzert.that(v + "", is("0"));
  }

  @Test public void toStringCheck6() {
    final Int v = new Int();
    v.step();
    v.add(99);
    azzert.that(v + "", is("100"));
  }
}