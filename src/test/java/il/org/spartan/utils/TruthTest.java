package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method","static-access"}) public class TruthTest {
  /**
   * 
   */
  @Test public void truthOfTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.assertEquals(t,Truth.T);
    t = Truth.truthOf(() -> false);
    azzert.assertEquals(t,Truth.F);
    t = Truth.truthOf(null);
    azzert.assertEquals(t,Truth.N);
    t = Truth.truthOf(() -> {
      assert false;
      return true;
    });
    azzert.assertEquals(t,Truth.X);
    t = Truth.truthOf(() -> 1 / 0 == 1);
    azzert.assertEquals(t,Truth.R);
    t = Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    });
    azzert.assertEquals(t,Truth.Ħ);
  }

  @Test public void notTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.assertEquals(t.not(),Truth.F);
    t = Truth.truthOf(() -> false);
    azzert.assertEquals(t.not(),Truth.T);
    t = Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    });
    azzert.assertEquals(t.not(),Truth.Ħ);
  }

  @Test public void orTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.assertEquals(t.or(Truth.F),Truth.T);
    azzert.assertEquals(t.or(Truth.T),Truth.T);
    t = Truth.truthOf(() -> false);
    azzert.assertEquals(t.or(Truth.T),Truth.T);
    azzert.assertEquals(t.or(Truth.F),Truth.F);
  }

  @Test public void andTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.assertEquals(t.and(Truth.F),Truth.F);
    azzert.assertEquals(t.and(Truth.T),Truth.T);
    t = Truth.truthOf(() -> false);
    azzert.assertEquals(t.and(Truth.T),Truth.F);
    azzert.assertEquals(t.and(Truth.F),Truth.F);
  }

  @Test public void letterOfTest() {
    assert "true".equals(Truth.letterOf(() -> true));
  }

  @Test public void toStringTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.assertEquals("true",t + "");
    t = Truth.truthOf(() -> false);
    azzert.assertEquals("false", t + "");
    t = Truth.truthOf(null);
    azzert.assertEquals("Null pointer exception", t + "");
  }
}
