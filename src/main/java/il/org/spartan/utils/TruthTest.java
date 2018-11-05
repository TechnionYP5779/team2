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
    assert t == Truth.T;
    BooleanSupplier bf = () -> false;
    t = Truth.truthOf(bf);
    assert t == Truth.F;
    t = Truth.truthOf(null);
    assert t == Truth.N;
    BooleanSupplier ba = () -> {
      assert false;
      return true;
    };
    t = Truth.truthOf(ba);
    assert t == Truth.X;
    BooleanSupplier br = () -> {
      return 1 / 0 == 1;
    };
    t = Truth.truthOf(br);
    assert t == Truth.R;
    BooleanSupplier bo = () -> {
      throw new ExceptionInInitializerError();
    };
    t = Truth.truthOf(bo);
    assert t == Truth.Ħ;
  }

  @Test public void notTest() {
    BooleanSupplier bt = () -> true;
    Truth t = Truth.truthOf(bt);
    assert t.not() == Truth.F;
    BooleanSupplier bf = () -> false;
    t = Truth.truthOf(bf);
    assert t.not() == Truth.T;
    BooleanSupplier bo = () -> {
      throw new ExceptionInInitializerError();
    };
    t = Truth.truthOf(bo);
    assert t.not() == Truth.Ħ;
  }

  @Test public void orTest() {
    BooleanSupplier bt = () -> true;
    Truth t = Truth.truthOf(bt);
    assert t.or(Truth.F) == Truth.T;
    assert t.or(Truth.T) == Truth.T;
    BooleanSupplier bf = () -> false;
    t = Truth.truthOf(bf);
    assert t.or(Truth.T) == Truth.T;
    assert t.or(Truth.F) == Truth.F;
  }

  @Test public void andTest() {
    BooleanSupplier bt = () -> true;
    Truth t = Truth.truthOf(bt);
    assert t.and(Truth.F) == Truth.F;
    assert t.and(Truth.T) == Truth.T;
    BooleanSupplier bf = () -> false;
    t = Truth.truthOf(bf);
    assert t.and(Truth.T) == Truth.F;
    assert t.and(Truth.F) == Truth.F;
  }

  @Test public void letterOfTest() {
    BooleanSupplier bt = () -> true;
    assert Truth.letterOf(bt).equals("true");
  }

  @Test public void toStringTest() {
    BooleanSupplier bt = () -> true;
    Truth t = Truth.truthOf(bt);
    assert t.toString() == "true";
    BooleanSupplier bf = () -> false;
    t = Truth.truthOf(bf);
    assert t.toString() == "false";
    t = Truth.truthOf(null);
    assert t.toString() == "Null pointer exception";
  }
}
