package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BoolTest {
  @Test @SuppressWarnings("null") public void trueConstructorTest() {
    assert unbox.unbox(new Bool(true).inner());
  }

  @Test @SuppressWarnings("null") public void falseConstructorTest() {
    assert !unbox.unbox(new Bool(false).inner());
  }

  @Test @SuppressWarnings("null") public void emptyConstructorTest() {
    assert !unbox.unbox(new Bool(false).inner());
  }

  @Test public void clearTest1() {
    assert !new Bool().clear().get();
  }

  @Test public void clearTest2() {
    assert !new Bool(false).clear().get();
  }

  @Test public void clearTest3() {
    assert !new Bool(true).clear().get();
  }

  @Test public void setTest1() {
    assert new Bool().set().get();
  }

  @Test public void setTest2() {
    assert new Bool(false).set().get();
  }

  @Test public void setTest3() {
    assert new Bool(true).set().get();
  }

  @Test public void getTest() {
    final Bool b = new Bool().set();
    assert b.get();
    b.clear();
    assert !b.get();
  }
}
