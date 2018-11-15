package il.org.spartan.utils;

import static org.junit.Assert.*;

import org.junit.*;

@SuppressWarnings({ "static-method" }) public class TruthTest {
  /**
   *
   */
  @Test public void truthOfTest() {
    Truth t = Truth.truthOf(() -> true);
    assertEquals(t, Truth.T);
    t = Truth.truthOf(() -> false);
    assertEquals(t, Truth.F);
    t = Truth.truthOf(null);
    assertEquals(t, Truth.N);
    t = Truth.truthOf(() -> {
      assert false;
      return false;
    });
    assertEquals(t, Truth.X);
    t = Truth.truthOf(() -> 1 / 0 == 1);
    assertEquals(t, Truth.R);
    t = Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    });
    assertEquals(t, Truth.Ħ);
  }

  @Test public void notTest() {
    Truth t = Truth.truthOf(() -> true);
    assertEquals(t.not(), Truth.F);
    t = Truth.truthOf(() -> false);
    assertEquals(t.not(), Truth.T);
    t = Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    });
    assertEquals(t.not(), Truth.Ħ);
  }

  @Test public void orTest() {
    Truth t = Truth.truthOf(() -> true);
    assertEquals(t.or(Truth.F), Truth.T);
    assertEquals(t.or(Truth.T), Truth.T);
    t = Truth.truthOf(() -> false);
    assertEquals(t.or(Truth.T), Truth.T);
    assertEquals(t.or(Truth.F), Truth.F);
  }

  @Test public void andTest() {
    Truth t = Truth.truthOf(() -> true);
    assertEquals(t.and(Truth.F), Truth.F);
    assertEquals(t.and(Truth.T), Truth.T);
    t = Truth.truthOf(() -> false);
    assertEquals(t.and(Truth.T), Truth.F);
    assertEquals(t.and(Truth.F), Truth.F);
  }

  @Test public void letterOfTest() {
    assert "true".equals(Truth.letterOf(() -> true));
  }

  @Test public void toStringTest() {
    Truth t = Truth.truthOf(() -> true);
    assertEquals("true", t + "");
    t = Truth.truthOf(() -> false);
    assertEquals("false", t + "");
    t = Truth.truthOf(null);
    assertEquals("Null pointer exception", t + "");
  }
}
