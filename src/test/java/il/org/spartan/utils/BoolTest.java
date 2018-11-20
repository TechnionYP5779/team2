package il.org.spartan.utils;

import static il.org.spartan.Utils.*;

import static fluent.ly.unbox.*;

import org.junit.*;

@SuppressWarnings("static-method") public class BoolTest {
  @Test public void trueConstructorTest() {
    assert unbox(cantBeNull(new Bool(true).inner()));
  }

  @Test public void valueOfTrueTest() {
    assert Bool.valueOf(true).inner;
  }

  @Test public void valueOfFalseTest() {
    assert !Bool.valueOf(false).inner;
  }

  @Test public void falseConstructorTest() {
    assert !unbox(cantBeNull(new Bool(false).inner()));
  }

  @Test public void emptyConstructorTest() {
    assert !unbox(cantBeNull(new Bool(false).inner()));
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
