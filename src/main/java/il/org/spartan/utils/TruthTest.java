package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.function.*;

import org.junit.*;


public class TruthTest {
  @Test public void truthOfTest() {
    
  }
  
  @Test public void notTest() {
      BooleanSupplier bt = ()->true;
      Truth t = Truth.truthOf(bt); 
      assert t.not() == Truth.F;
      BooleanSupplier bf = ()->false;
      t = Truth.truthOf(bf);
      assert t.not() == Truth.T;
    }
  
  @Test public void orTest() {
    BooleanSupplier bt = ()->true;
    Truth t = Truth.truthOf(bt); 
    assert t.or(Truth.F) == Truth.T;
    assert t.or(Truth.T) == Truth.T;
  
    BooleanSupplier bf = ()->false;
    t = Truth.truthOf(bf);
    assert t.or(Truth.T) == Truth.T;
    assert t.or(Truth.F) == Truth.F;
  }
}
