package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;

public class OuterTest {
  @Test public void testHashCode1() {
    Outer<Integer> o = new Outer<>(box.box(1));
    o.inner = null;
    azzert.assertZero(o.hashCode());
  }

  @Test public void testHashCode2() {
    Outer<Integer> o = new Outer<>(box.box(1));
    azzert.that(o.hashCode(), is(box.box(1).hashCode()));
  }


  @Test public void testEqualsObject1() {
    Object o = new Outer<>(box.box(1));
    assert o.equals(o);
  }
  
  @Test public void testEqualsObject2() {
    Object o = new Outer<>(box.box(1));
    assert !o.equals(null);
  }
  
  @Test public void testEqualsObject3() {
    Object o = new Outer<>(box.box(1));
    assert !o.equals(box.box(1));
  }
  
  @Test public void testEqualsObject4() {
    Object o1 = new Outer<>(box.box(1));
    Object o2 = new Outer<>(box.box(2));
    assert !o1.equals(o2);
  }

  @Test public void testEqualsOuterOfInner1() {
    Outer<Integer> o1 = new Outer<>(box.box(1));
    o1.set(null);
    Outer<Integer> o2 = new Outer<>(box.box(1));
    assert !o1.equals(o2);
  }
  
  @Test public void testEqualsOuterOfInner2() {
    Outer<Integer> o1 = new Outer<>(box.box(1));
    o1.set(null);
    Outer<Integer> o2 = new Outer<>(box.box(1));
    o2.set(null);
    assert o1.equals(o2);
  }
  
  @Test public void testEqualsOuterOfInner3() {
    Outer<Integer> o1 = new Outer<>(box.box(1));
    Outer<Integer> o2 = new Outer<>(box.box(1));
    assert o1.equals(o2);
  }

  @Test public void testGet() {
    azzert.that(new Outer<>(box.box(1)).get(), is(box.box(1)));
  }

  @Test public void testSet() {
    Outer<Integer> o = new Outer<>(box.box(1));
    o.set(box.box(2));
    azzert.that(o.get(), is(box.box(2)));
  }

  @Test public void testToString1() {
    Outer<Integer> o = new Outer<>(box.box(1));
    o.inner = null;
    azzert.that(o.toString(), is("null"));
  }
  
  @Test public void testToString2() {
    Outer<Integer> o = new Outer<>(box.box(1));
    azzert.that(o.toString(), is(o.get().toString()));
  }
}
