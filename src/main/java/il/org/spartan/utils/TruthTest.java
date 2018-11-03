package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.function.*;

import org.junit.*;


public class TruthTest {
  @Test public void truthOfTest() {
    BooleanSupplier bt = ()->true;
    Truth t = Truth.truthOf(bt); 
    assert t == Truth.T;
    
    BooleanSupplier bf = ()->false;
    t = Truth.truthOf(bf); 
    assert t == Truth.F;
    
    t = Truth.truthOf(null); 
    assert t == Truth.N;
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
  
  @Test public void andTest() {
    BooleanSupplier bt = ()->true;
    Truth t = Truth.truthOf(bt); 
    assert t.and(Truth.F) == Truth.F;
    assert t.and(Truth.T) == Truth.T;
  
    BooleanSupplier bf = ()->false;
    t = Truth.truthOf(bf);
    assert t.and(Truth.T) == Truth.F;
    assert t.and(Truth.F) == Truth.F;
  }
  
  @Test public void letterOfTest() {
    BooleanSupplier bt = ()->true;
    assert Truth.letterOf(bt).equals("true");   
  }
  
  @Test public void toStringTest() {
    BooleanSupplier bt = ()->true;
    Truth t = Truth.truthOf(bt); 
    assert t.toString() == "true";
    
    BooleanSupplier bf = ()->false;
    t = Truth.truthOf(bf); 
    assert t.toString() == "false";
    
    t = Truth.truthOf(null); 
    assert t.toString() == "Null pointer exception";
   }
  
}
