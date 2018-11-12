package il.org.spartan.utils;


import java.util.*;

//import fluent.ly.azzert;
import org.junit.*;


@SuppressWarnings("static-method") public class RangeTest{

  @Test 
  public void testInfiniteRangeInc() {
    Range r = new Range();
    r.from(2);
    
    assert(r.includes(2));
    assert(r.includes(10));
    assert(r.includes(Integer.MAX_VALUE - 1));
    
    assert(!r.includes(1));
    assert(!r.includes(-7));
  }
  
  @Test @SuppressWarnings("boxing") public void testStartingPoint() {
    assert ((new Range()).from(2).from() == 2);
    assert ((new Range()).from(-4).from() != 8);
  }
  
  @Test
  public void testFromAndTo() {
    Range r = new Range();
    r.from(2).to(6);
    
    for(int ¢=2;¢<=5;++¢)
      assert (r.includes(¢));
    
    assert(!r.includes(1));
    assert(!r.includes(6));
    assert(!r.includes(1322));
    
  }
  
  
  @Test
  public void testInfiniteRangeDec() {
    Range r = new Range();
    r.to(2);
    
    assert(r.includes(1));
    assert(r.includes(0));
    assert(r.includes(Integer.MIN_VALUE));
    
    assert(!r.includes(2));
    assert(!r.includes(12313));
  }
  
  @Test
  public void testFromMinInt() {
    assert ((new Range()).to(2).from() == null);
  }
  
  
  @Test
  public void testToFrom() {
    Range r = new Range();
    r.to(2).from(-5);
    
    for(int ¢=-5;¢<=1;++¢)
      assert (r.includes(¢));
    
    assert(!r.includes(-6));
    assert(!r.includes(2));
    assert(!r.includes(1322));
  }
  
  
  @Test @SuppressWarnings("boxing") public void testNumbersFunction() {
    
    //finite range
    Iterator<Integer> numbers = new Range().from(3).to(10).numbers();
    while (numbers.hasNext())
      assert (numbers.next() < 10);
    
    assert(!numbers.hasNext() && numbers.next() == 10);
    
    
    //infinite range
    numbers = new Range().numbers();
    assert (numbers.next() == Integer.MIN_VALUE + 1);
    assert (numbers.next() == Integer.MIN_VALUE + 2);
  }
  
  
  
  @Test
  public void testIntersectionTwoInfinite() {
    Range r = new Range().to(10).intersect(new Range().from(3));
    
    for(int ¢=3;¢<=9;++¢)
      assert (r.includes(¢));
    
    assert(!r.includes(2));
    assert(!r.includes(10));
    assert(!r.includes(-3123));
    
  }
  
  
  @Test
  public void testIntersectionEmpty() {
    assert (new Range().to(-3).intersect(new Range().from(3)) == null);
    assert (new Range().to(3).intersect(new Range().from(3)) == null);
  }
  
  @Test
  public void testIntersectionOne() {
    Range r = new Range().to(4).intersect(new Range().from(3));
    
    assert(r.includes(3));
    assert(!r.includes(2));
    assert(!r.includes(4));
  }
  
  
  @Test
  public void testIntersectionFull() {
    Range r = new Range().from(2).to(8).intersect(new Range().from(2).to(8));
    
    for(int ¢=2;¢<=7;++¢)
      assert (r.includes(¢));
    
    assert(!r.includes(8));
    assert(!r.includes(1)); 
  }
  
  @Test
  public void testIntersectionIncluded() {
    Range r = new Range().from(1).to(111).intersect(new Range().from(2).to(8));
    
    for(int ¢=2;¢<=7;++¢)
      assert (r.includes(¢));
    
    assert(!r.includes(8));
    assert(!r.includes(1)); 
  }
  
  @Test
  public void testIntersectionInfinity() {
    Range r = new Range().intersect(new Range());
    
    for(int ¢=Integer.MIN_VALUE;¢<Integer.MAX_VALUE;++¢)
      assert (r.includes(¢));
    
    
  }
  
}

