package il.org.spartan.utils;

import org.junit.*;

@SuppressWarnings("static-method") public class TruthTest {
  /**
   * 
   */
  @Test public void truthOfTest() {
    Truth t = Truth.truthOf(() -> true);
    Assert.assertEquals(t,Truth.T);
    t = Truth.truthOf(() -> false);
    Assert.assertEquals(t,Truth.F);
    t = Truth.truthOf(null);
    Assert.assertEquals(t,Truth.N);
    t = Truth.truthOf(() -> {
      assert false;
      return true;
    });
    Assert.assertEquals(t,Truth.X);
    t = Truth.truthOf(() -> 1 / 0 == 1);
    Assert.assertEquals(t,Truth.R);
    t = Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    });
    Assert.assertEquals(t,Truth.Ħ);
  }

  @Test public void notTest() {
    Truth t = Truth.truthOf(() -> true);
    Assert.assertEquals(t.not(),Truth.F);
    t = Truth.truthOf(() -> false);
    Assert.assertEquals(t.not(),Truth.T);
    t = Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    });
    Assert.assertEquals(t.not(),Truth.Ħ);
  }

  @Test public void orTest() {
    Truth t = Truth.truthOf(() -> true);
    Assert.assertEquals(t.or(Truth.F),Truth.T);
    Assert.assertEquals(t.or(Truth.T),Truth.T);
    t = Truth.truthOf(() -> false);
    Assert.assertEquals(t.or(Truth.T),Truth.T);
    Assert.assertEquals(t.or(Truth.F),Truth.F);
  }

  @Test public void andTest() {
    Truth t = Truth.truthOf(() -> true);
    Assert.assertEquals(t.and(Truth.F),Truth.F);
    Assert.assertEquals(t.and(Truth.T),Truth.T);
    t = Truth.truthOf(() -> false);
    Assert.assertEquals(t.and(Truth.T),Truth.F);
    Assert.assertEquals(t.and(Truth.F),Truth.F);
  }

  @Test public void letterOfTest() {
    assert "true".equals(Truth.letterOf(() -> true));
  }

  @Test public void toStringTest() {
    Truth t = Truth.truthOf(() -> true);
    Assert.assertEquals("true",t + "");
    t = Truth.truthOf(() -> false);
    Assert.assertEquals("false", t + "");
    t = Truth.truthOf(null);
    Assert.assertEquals("Null pointer exception", t + "");
  }
}
