package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class TruthTest {
  /**
   *
   */
  @Test public void truthOftTest() {
    azzert.that(Truth.truthOf(() -> true), is(Truth.T));
  }

  @Test public void truthOffTest() {
    azzert.that(Truth.truthOf(() -> false), is(Truth.F));
  }

  @Test public void truthOfnTest() {
    azzert.that(Truth.truthOf(null), is(Truth.N));
  }

  @Test public void truthOfxTest() {
    azzert.that(Truth.truthOf(() -> {
      assert false;
      return true;
    }), is(Truth.X));
  }

  @Test public void truthOfrTest() {
    azzert.that(Truth.truthOf(() -> 1 / 0 == 1), is(Truth.R));
  }

  @Test public void truthOfhTest() {
    azzert.that(Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    }), is(Truth.Ħ));
  }

  @Test public void notfTest() {
    azzert.that(Truth.truthOf(() -> true).not(), is(Truth.F));
  }

  @Test public void nottTest() {
    azzert.that(Truth.truthOf(() -> false).not(), is(Truth.T));
  }

  @Test public void nothTest() {
    azzert.that(Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    }).not(), is(Truth.Ħ));
  }

  @Test public void ortfTest() {
    azzert.that(Truth.truthOf(() -> true).or(Truth.F), is(Truth.T));
  }

  @Test public void orttTest() {
    azzert.that(Truth.truthOf(() -> true).or(Truth.T), is(Truth.T));
  }

  @Test public void orftTest() {
    azzert.that(Truth.truthOf(() -> false).or(Truth.T), is(Truth.T));
  }

  @Test public void orffTest() {
    azzert.that(Truth.truthOf(() -> false).or(Truth.F), is(Truth.F));
  }

  @Test public void andtfTest() {
    azzert.that(Truth.truthOf(() -> true).and(Truth.F), is(Truth.F));
  }

  @Test public void andttTest() {
    azzert.that(Truth.truthOf(() -> true).and(Truth.T), is(Truth.T));
  }

  @Test public void andftTest() {
    azzert.that(Truth.truthOf(() -> false).and(Truth.T), is(Truth.F));
  }

  @Test public void andffTest() {
    azzert.that(Truth.truthOf(() -> false).and(Truth.F), is(Truth.F));
  }

  @Test public void letterOfTest() {
    assert "true".equals(Truth.letterOf(() -> true));
  }

  @Test public void toStringtTest() {
    azzert.that("true", is(Truth.truthOf(() -> true) + ""));
  }

  @Test public void toStringfTest() {
    azzert.that("false", is(Truth.truthOf(() -> false) + ""));
  }

  @Test public void toStringnTest() {
    azzert.that("Null pointer exception", is(Truth.truthOf(null) + ""));
  }
}
