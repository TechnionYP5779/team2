package il.org.spartan.statistics;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class ImmutableStatisticsTest {
  @Test public void testAll() {
    assert Arrays.equals(new RealStatistics().record(1, 2, 3, 4, 5).all(), new double[] { 1, 2, 3, 4, 5 });
  }

  @Test public void testFlipping() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).flipping(), is(1.2));
  }

  @Test public void testMad() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).mad(), is(1.0));
  }

  @Test public void testMedian() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).median(), is(3.0));
  }

  @Test public void testRelativeMedianError() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).relativeMedianError(), is(0.3333333333333333));
  }

  @Test public void testRelativeMinError() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).relativeMinError(), is(2.0));
  }

  @Test public void testUnit() {
    assert new RealStatistics().record(1, 2, 3, 4, 5).unit() == null;
  }
}
