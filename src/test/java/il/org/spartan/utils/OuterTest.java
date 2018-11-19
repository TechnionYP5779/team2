package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import static fluent.ly.box.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class OuterTest {
  @Test public void testHashCode1() {
    final Outer<Integer> o = new Outer<>(box(1));
    o.inner = null;
    azzert.assertZero(o.hashCode());
  }

  @Test public void testHashCode2() {
    azzert.that((new Outer<>(box(1))).hashCode(), is(box(1).hashCode()));
  }

  @Test public void testEqualsObject1() {
    final Object o = new Outer<>(box(1));
    assert o.equals(o);
  }

  @Test public void testEqualsObject2() {
    azzert.notNull(new Outer<>(box(1)));
  }

  @SuppressWarnings("unlikely-arg-type") @Test public void testEqualsObject3() {
    assert !(new Outer<>(box(1))).equals(box(1));
  }

  @Test public void testEqualsObject4() {
    assert !(new Outer<>(box(1))).equals(new Outer<>(box(2)));
  }

  @Test public void testEqualsOuterOfInner1() {
    final Outer<Integer> o1 = new Outer<>(box(1));
    o1.set(null);
    assert !o1.equals(new Outer<>(box(1)));
  }

  @Test public void testEqualsOuterOfInner2() {
    final Outer<Integer> o1 = new Outer<>(box(1));
    o1.set(null);
    final Outer<Integer> o2 = new Outer<>(box(1));
    o2.set(null);
    assert o1.equals(o2);
  }

  @Test public void testEqualsOuterOfInner3() {
    assert (new Outer<>(box(1))).equals(new Outer<>(box(1)));
  }

  @Test public void testGet() {
    azzert.that(new Outer<>(box(1)).get(), is(box(1)));
  }

  @Test public void testSet() {
    final Outer<Integer> o = new Outer<>(box(1));
    o.set(box(2));
    azzert.that(o.get(), is(box(2)));
  }

  @Test public void testToString1() {
    final Outer<Integer> o = new Outer<>(box(1));
    o.inner = null;
    azzert.that(o + "", is("null"));
  }

  @Test public void testToString2() {
    final Outer<Integer> o = new Outer<>(box(1));
    azzert.that(o + "", is(o.get() + ""));
  }
}
