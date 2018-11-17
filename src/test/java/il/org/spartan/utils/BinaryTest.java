package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;
@SuppressWarnings("static-method") public class BinaryTest {
  @Test public void testHashCode() {
    azzert.that(Binary.T.hashCode(),is(1));
  }

  @Test public void testAnd1() {
    assert (Binary.and(Binary.T, Binary.T) == (Binary.T));
  }
  
  @Test public void testAnd2() {
    assert (Binary.and(Binary.T, Binary.F) == (Binary.F));
  }
  
  @Test public void testAnd3() {
    assert (Binary.and(Binary.F, Binary.T) == (Binary.F));
  }
  
  @Test public void testAnd4() {
    assert (Binary.and(Binary.F, Binary.F) == (Binary.F));
  }

  @Test public void testAsBoolean1() {
    assert (Binary.asBoolean(Binary.T) == (Binary.T));
  }
  
  @Test public void testAsBoolean2() {
    assert (Binary.asBoolean(Binary.F) == (Binary.F));
  }

  @Test public void testEq1() {
    assert (Binary.eq(Binary.T,Binary.T) == Binary.T);
  }
  
  @Test public void testEq2() {
    assert (Binary.eq(Binary.T,Binary.F) == Binary.F);
  }

  @Test public void testNot1() {
    assert (Binary.not(Binary.T) == (Binary.F));
  }
  
  @Test public void testNot2() {
    assert (Binary.not(Binary.F) == (Binary.T));
  }

  @Test public void testOr1() {
    assert (Binary.or(Binary.T, Binary.T) == (Binary.T));
  }
  
  @Test public void testOr2() {
    assert (Binary.or(Binary.T, Binary.F) == (Binary.T));
  }
  
  @Test public void testOr3() {
    assert (Binary.or(Binary.F, Binary.T) == (Binary.T));
  }
  
  @Test public void testOr4() {
    assert (Binary.or(Binary.F, Binary.F) == (Binary.F));
  }

  @Test public void testEqualsObject() {
   boolean flag = true;
   try {
    Binary.T.equals(Binary.T);
    flag = false;
   }
   catch(IllegalArgumentException e) {
     e.getMessage();
   }
   assert flag;
  }

}
