package il.org.spartan.utils;

import static fluent.ly.azzert.*;


// import fluent.ly.azzert;
import org.junit.*;

import fluent.ly.*;


@SuppressWarnings("static-method") 

public class RangeTest {
  
  @Test
  public void testInfinteRangeNotEmpty() {
    assert !Range.from(2).isEmpty(); 
  }
  
  @Test
  public void testInfinteRangeInfinte() {
    assert Range.from(2).isInfinite();
  }
  
  @Test
  public void testInfinteRangeStartsFrom() {
    assert Range.from(2).from() == 2;
  }
  
  @Test
  public void testInfinteRangeIncludesFirst() {
    assert Range.from(2).includes(2);
    //System.out.println(Range.from(2).iterator().next());
  }
  
  @Test public void testInfiniteRangeMaxValue() {
    assert Range.from(2).includes(Integer.MAX_VALUE -2 );
  }

  
  @Test public void testFromAndToNotInfinte() {
    assert !Range.from(2).to(6).isInfinite();
  }
  
  @Test public void testFromAndToEndPoint() {
    assert !Range.from(2).to(6).includes(6);
  }
  
  @Test public void testFromAndToEndPointIncludes() {
    assert Range.from(2).to(6).includes(5);
  }

  
  @Test public void testInfiniteRangeDec() {
    assert !Range.to(2).includes(2);
  }
  
  @Test public void testInfiniteRangeInfinite() {
    assert Range.to(2).isInfinite();
  }
  
  @Test public void testInfiniteRangeMin() {
    assert Range.to(2).includes(Integer.MIN_VALUE);
  }

  

  @Test public void testToFromNotInfinite() {
    assert !Range.to(2).from(-5).isInfinite();
  }
  
  @Test public void testToFromFirst() {
    assert Range.to(2).from(-5).includes(-5);
  }
  
  @Test public void testToFromLast() {
    assert Range.to(2).from(-5).includes(1);
  }
  
  @Test public void testTo2InfiniteFromIsNull() {
    assert Range.to(2).from() == null;
  }
  
  @Test public void testToFromFromNotNull() {
    assert Range.to(2).from(-19).from() == box.box(-19);
  }
  
  @Test public void testFrom2InfiniteToIsNull() {
    assert Range.from(2).to() == null;
  }
  
  @Test public void testToFromToNotNull() {
    assert Range.to(2).from(-19).to() == 2;
  }

  
  @Test @SuppressWarnings("boxing") public void testNumbersFunction() {
    int c = Integer.MIN_VALUE;
    for (final Integer $ : Range.numbers) {
      if (c < 22)
        break;
      assert c == $;
      ++c;
    }
  }
  
  
  @Test public void testIntersectionTwoFinite() {
    assert Range.from(3).to(10).intersect(Range.from(1).to(14)).includes(9);
  }
  
  @Test public void testIntersectionNoIntersection() {
    assert Range.from(3).to(10).intersect(Range.from(29).to(99)).isEmpty();
  }

  
  @Test public void testIntersectionTwoInfinite() {
    assert Range.to(10).intersect(Range.from(3)).includes(9);
  }
  
  @Test public void testIntersectionTwoInfiniteNoIntersection() {
    assert Range.to(10).intersect(Range.from(10)).isEmpty();
  }
  
  @Test public void testIntersectionTwoInfiniteFrom() {
    assert Range.from(3).intersect(Range.from(22)).includes(22);
  }
}
