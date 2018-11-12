package il.org.spartan.utils;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class TruthTest {
  /**
   * 
   */
  @Test public void truthOfTest() {
    BooleanSupplier bt = () -> true;
    Truth t = Truth.truthOf(bt);
    Assert.assertEquals(t,Truth.T);
    BooleanSupplier bf = () -> false;
    t = Truth.truthOf(bf);
    Assert.assertEquals(t,Truth.F);
    t = Truth.truthOf(null);
    Assert.assertEquals(t,Truth.N);
    BooleanSupplier ba = () -> {
      Assert.assertTrue(false);
      return true;
      
    };
    t = Truth.truthOf(ba);
    Assert.assertEquals(t,Truth.X);
    BooleanSupplier br = () -> {
      return 1 / 0 == 1;
    };
    t = Truth.truthOf(br);
    Assert.assertEquals(t,Truth.R);
    BooleanSupplier bo = () -> {
      throw new ExceptionInInitializerError();
    };
    t = Truth.truthOf(bo);
    Assert.assertEquals(t,Truth.Ħ);
  }

  @Test public void notTest() {
    BooleanSupplier bt = () -> true;
    Truth t = Truth.truthOf(bt);
    Assert.assertEquals(t.not(),Truth.F);
    BooleanSupplier bf = () -> false;
    t = Truth.truthOf(bf);
    Assert.assertEquals(t.not(),Truth.T);
    BooleanSupplier bo = () -> {
      throw new ExceptionInInitializerError();
    };
    t = Truth.truthOf(bo);
    Assert.assertEquals(t.not(),Truth.Ħ);
  }

  @Test public void orTest() {
    BooleanSupplier bt = () -> true;
    Truth t = Truth.truthOf(bt);
    Assert.assertEquals(t.or(Truth.F),Truth.T);
    Assert.assertEquals(t.or(Truth.T),Truth.T);
    BooleanSupplier bf = () -> false;
    t = Truth.truthOf(bf);
    Assert.assertEquals(t.or(Truth.T),Truth.T);
    Assert.assertEquals(t.or(Truth.F),Truth.F);
  }

  @Test public void andTest() {
    BooleanSupplier bt = () -> true;
    Truth t = Truth.truthOf(bt);
    Assert.assertEquals(t.and(Truth.F),Truth.F);
    Assert.assertEquals(t.and(Truth.T),Truth.T);
    BooleanSupplier bf = () -> false;
    t = Truth.truthOf(bf);
    Assert.assertEquals(t.and(Truth.T),Truth.F);
    Assert.assertEquals(t.and(Truth.F),Truth.F);
  }

  @Test public void letterOfTest() {
    BooleanSupplier bt = () -> true;
    Assert.assertTrue(Truth.letterOf(bt).equals("true"));
  }

  @Test public void toStringTest() {
    BooleanSupplier bt = () -> true;
    Truth t = Truth.truthOf(bt);
    Assert.assertTrue(t.toString().equals("true"));
    BooleanSupplier bf = () -> false;
    t = Truth.truthOf(bf);
    Assert.assertTrue(t.toString().equals("false"));
    t = Truth.truthOf(null);
    Assert.assertTrue(t.toString().equals("Null pointer exception"));
  }
}
