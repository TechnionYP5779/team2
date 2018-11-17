package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class TruthTest {
  /**
   *
   */
  @Test public void truthOftTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that(t, is(Truth.T));
  }
  
  @Test public void truthOffTest() {
    Truth t = Truth.truthOf(() -> false);
    azzert.that(t, is(Truth.F));
  }
  
  @Test public void truthOfnTest() {
    Truth t = Truth.truthOf(null);
    azzert.that(t, is(Truth.N));
  }
  
  @Test public void truthOfxTest() {
    Truth t = Truth.truthOf(() -> {
      assert false;
      return true;
    });
    azzert.that(t, is(Truth.X));
  }
  
  @Test public void truthOfrTest() {
    Truth t = Truth.truthOf(() -> 1 / 0 == 1);
    azzert.that(t, is(Truth.R));
  }
  
  @Test public void truthOfhTest() {
    Truth t = Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    });
    azzert.that(t, is(Truth.Ħ));
  }
  
  @Test public void notfTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that(t.not(), is(Truth.F));
  }
  
  @Test public void nottTest() {
    Truth t = Truth.truthOf(() -> false);
    azzert.that(t.not(), is(Truth.T));
  }
  
  @Test public void nothTest() {
    Truth t = Truth.truthOf(() -> {
      throw new ExceptionInInitializerError();
    });
    azzert.that(t.not(), is(Truth.Ħ));
  }
  
  @Test public void ortfTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that(t.or(Truth.F), is(Truth.T));
  }
  
  @Test public void orttTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that(t.or(Truth.T), is(Truth.T));
  }
  
  @Test public void orftTest() {
    Truth t = Truth.truthOf(() -> false);
    azzert.that(t.or(Truth.T), is(Truth.T));
  }
  
  @Test public void orffTest() {
    Truth t = Truth.truthOf(() -> false);
    azzert.that(t.or(Truth.F), is(Truth.F));
  }

  @Test public void andtfTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that(t.and(Truth.F), is(Truth.F));
  }
  
  @Test public void andttTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that(t.and(Truth.T), is(Truth.T));
  }
  
  @Test public void andftTest() {
    Truth t = Truth.truthOf(() -> false);
    azzert.that(t.and(Truth.T), is(Truth.F));
  }
  
  @Test public void andffTest() {
    Truth t = Truth.truthOf(() -> false);
    azzert.that(t.and(Truth.F), is(Truth.F));
  }

  @Test public void letterOfTest() {
    assert "true".equals(Truth.letterOf(() -> true));
  }
  
  @Test public void toStringtTest() {
    Truth t = Truth.truthOf(() -> true);
    azzert.that("true", is(t + ""));
  }

  @Test public void toStringfTest() {
    Truth t = Truth.truthOf(() -> false);
    azzert.that("false", is(t + ""));
  }
  
  @Test public void toStringnTest() {
    Truth t = Truth.truthOf(null);
    azzert.that("Null pointer exception", is(t + ""));
  }
}
