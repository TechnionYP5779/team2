package fluent.ly;

import static fluent.ly.azzert.*;

// import fluent.ly.azzert;
import org.junit.*;
import static fluent.ly.box.*;

@SuppressWarnings("static-method") public class rangeTest {
  @Test public void testInfinteRangeNotEmpty() {
    assert !range.from(2).isEmpty();
  }

  @Test public void testInfinteRangeInfinte() {
    assert range.from(2).isInfinite();
  }

  @Test public void testInfinteRangeStartsFrom() {
    azzert.that(range.from(2).from(), is(2));
  }

  @Test public void testInfinteRangeIncludesFirst() {
    assert range.from(2).includes(2);
  }

  @Test public void testInfiniteRangeMaxValue() {
    assert range.from(2).includes(Integer.MAX_VALUE - 2);
  }

  @Test public void testFromAndToNotInfinte() {
    assert !range.from(2).to(6).isInfinite();
  }

  @Test public void testFromAndToEndPoint() {
    assert !range.from(2).to(6).includes(6);
  }

  @Test public void testFromAndToEndPointIncludes() {
    assert range.from(2).to(6).includes(5);
  }

  @Test public void testInfiniteRangeDec() {
    assert !range.to(2).includes(2);
  }

  @Test public void testInfiniteRangeInfinite() {
    assert range.to(2).isInfinite();
  }

  @Test public void testInfiniteRangeMin() {
    assert range.to(2).includes(Integer.MIN_VALUE);
  }

  @Test public void testToFromNotInfinite() {
    assert !range.to(2).from(-5).isInfinite();
  }

  @Test public void testToFromFirst() {
    assert range.to(2).from(-5).includes(-5);
  }

  @Test public void testToFromLast() {
    assert range.to(2).from(-5).includes(1);
  }

  @Test public void testTo2InfiniteFromIsNull() {
    assert range.to(2).from() == null;
  }

  @Test public void testToFromFromNotNull() {
    azzert.that(range.to(2).from(-19).from(), is(box(-19)));
  }

  @Test public void testFrom2InfiniteToIsNull() {
    assert range.from(2).to() == null;
  }

  @Test public void testToFromToNotNull() {
    azzert.that(range.to(2).from(-19).to(), is(2));
  }

  public void testNumbersFunction() {
    int c = Integer.MIN_VALUE;
    for (final Integer $ : range.numbers) {
      if (c < 22)
        break;
      azzert.that(box(c), is($));
      ++c;
    }
  }

  @Test public void testIntersectionTwoFinite() {
    assert range.from(3).to(10).intersect(range.from(1).to(14)).includes(9);
  }

  @Test public void testIntersectionNoIntersection() {
    assert range.from(3).to(10).intersect(range.from(29).to(99)).isEmpty();
  }

  @Test public void testIntersectionTwoInfinite() {
    assert range.to(10).intersect(range.from(3)).includes(9);
  }

  @Test public void testIntersectionTwoInfiniteNoIntersection() {
    assert range.to(10).intersect(range.from(10)).isEmpty();
  }

  @Test public void testIntersectionTwoInfiniteFrom() {
    assert range.from(3).intersect(range.from(22)).includes(22);
  }
}
