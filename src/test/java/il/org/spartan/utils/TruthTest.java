package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class TruthTest {
  /**
   *
   */
  @Test public void truthOfTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that(t, is(Truth.T));
    t = Truth.truthOf(() -> false);
    azzert.that(t, is(Truth.F));
    t = Truth.truthOf(null);
    azzert.that(t, is(Truth.N));
    t = Truth.truthOf(() -> {
      assert false;
      return false;
    });
    azzert.that(t, is(Truth.X));
    t = Truth.truthOf(() -> 1 / 0 == 1);
    azzert.that(t, is(Truth.R));
    t = Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    });
    azzert.that(t, is(Truth.Ħ));
  }

  @Test public void notTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that(t.not(), is(Truth.F));
    t = Truth.truthOf(() -> false);
    azzert.that(t.not(), is(Truth.T));
    t = Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    });
    azzert.that(t.not(), is(Truth.Ħ));
  }

  @Test public void orTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that(t.or(Truth.F), is(Truth.T));
    azzert.that(t.or(Truth.T), is(Truth.T));
    t = Truth.truthOf(() -> false);
    azzert.that(t.or(Truth.T), is(Truth.T));
    azzert.that(t.or(Truth.F), is(Truth.F));
  }

  @Test public void andTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that(t.and(Truth.F), is(Truth.F));
    azzert.that(t.and(Truth.T), is(Truth.T));
    t = Truth.truthOf(() -> false);
    azzert.that(t.and(Truth.T), is(Truth.F));
    azzert.that(t.and(Truth.F), is(Truth.F));
  }

  @Test public void letterOfTest() {
    assert "true".equals(Truth.letterOf(() -> true));
  }

  @Test public void toStringTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that("true", is(t + ""));
    t = Truth.truthOf(() -> false);
    azzert.that("false", is(t + ""));
    t = Truth.truthOf(null);
    azzert.that("Null pointer exception", is(t + ""));
  }
}
