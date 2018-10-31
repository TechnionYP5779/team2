package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;

import fluent.ly.idiomatic;
import fluent.ly.idiomatic.*;
import java.io.IOException;

public class idiomaticTest {
  @Test public void testIncaseTrueReturnSameObj() {
    //fail("Not yet implemented");
    Integer integer = new Integer(5);
    assert idiomatic.incase(true, integer).equals(integer);
  }
  
  @Test public void testIncaseFalseReturnsNull() {
    assert idiomatic.incase(false,new Integer(5))==null;
  }
  
  @Test public void testKatchingWithNoException() {
    final Producer<Integer> p = () -> new Integer(5);
    assert idiomatic.katching(p).equals(new Integer(5));
  }
  
  @Ignore @Test public void testKatchingWithException() {
    final Producer<Integer> p = () -> {throw new IOException();};
    assert idiomatic.katching(p)==(null);
  }
  
  @Test public void testQuoteNotNullString() {
    assert idiomatic.quote("hello").equals("'hello'");
  }
  
  @Test public void testQuoteNullString() {
    assert idiomatic.quote(null).equals("<null reference>");
  }
  
  @Test public void testDoubleQuote() {
    assert idiomatic.quote(idiomatic.quote("a")).equals("''a''");
  }
  
  @Test public void testWhenTrueReturnsSame(){
    assert idiomatic.when(1==1).eval(()->new Integer(5)).equals(new Integer(5));
  }
  
  @Test public void testWhenFalseReturnsNull() {
    assert idiomatic.when(1==3).eval(()->new Integer(5)) == null;
  }
  
}
