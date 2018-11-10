package il.org.spartan.utils;


//import fluent.ly.azzert;
import org.junit.*;


@SuppressWarnings("static-method") public class RangeTest{

  @Test 
  public void testInfiniteRangeInc() {
    Range r = new Range();
    r.from(2);
    
    assert(r.includes(2));
    assert(r.includes(10));
    assert(r.includes(Integer.MAX_VALUE));
    
    assert(!r.includes(1));
    assert(!r.includes(-7));
  }
  
  @Test
  public void testStartingPoint() {
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
}

