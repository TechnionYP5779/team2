package il.org.spartan.statistics;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class StatisticsTest {
  @Test public void medianTest() {
    azzert.that(Statistics.median(new double[] { 1, 2, 3, 4, 5 }), is(3.0));
    azzert.that(Statistics.median(new double[] { 1, 1, 1, 1, 1, 1 }), is(1.0));
    azzert.that(Statistics.median(new double[] { 2, 3, 2, 5, 2, 2 }), is(2.0));
  }

  @Test public void madTest() {
    azzert.that(Statistics.mad(new double[] { 1, 2, 3, 4, 5 }), is(1.0));
    azzert.that(Statistics.mad(new double[] { 1, 1, 1, 1, 1, 1 }), is(0.0));
    azzert.that(Statistics.mad(new double[] { 2, 3, 2, 5, 2, 2 }), is(0.0));
  }

  @Test public void sampleMeanTest() {
    azzert.that(Statistics.sampleMean(new double[] { 1, 2, 3, 4, 5 }), is(3.0));
    azzert.that(Statistics.sampleMean(new double[] { 1, 1, 1, 1, 1, 1 }), is(1.0));
    azzert.that(Statistics.sampleMean(new double[] { 2, 3, 2, 5, 2, 2 }), is(2.6666666666666665));
  }

  @Test public void sampleVarianceTest() {
    azzert.that(Statistics.sampleVariance(new double[] { 1, 2, 3, 4, 5 }), is(2.5));
    azzert.that(Statistics.sampleVariance(new double[] { 1, 1, 1, 1, 1, 1 }), is(0.0));
    azzert.that(Statistics.sampleVariance(new double[] { 2, 3, 2, 5, 2, 2 }), is(1.4666666666666668));
  }

  @Test public void isEmptyTest() {
    assert new RealStatistics().record().isEmpty();
    assert !new RealStatistics().record(1, 2, 3, 4, 5).isEmpty();
  }

  @Test(expected = ArithmeticException.class) public void maxTestExp() {
    new RealStatistics().record().max();
  }

  @Test public void maxTest() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).max(), is(5.0));
    azzert.that(new RealStatistics().record(1, 1, 1, 1, 1, 1).max(), is(1.0));
    azzert.that(new RealStatistics().record(2, 3, 2, 5, 2, 2).max(), is(5.0));
  }

  @Test(expected = ArithmeticException.class) public void minTestExp() {
    new RealStatistics().record().min();
  }

  @Test public void minTest() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).min(), is(1.0));
    azzert.that(new RealStatistics().record(1, 1, 1, 1, 1, 1).min(), is(1.0));
    azzert.that(new RealStatistics().record(2, 3, 2, 5, 2, 2).min(), is(2.0));
  }

  @Test(expected = ArithmeticException.class) public void meanTestExp() {
    new RealStatistics().record().mean();
  }

  @Test public void meanTest() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).mean(), is(3.0));
    azzert.that(new RealStatistics().record(1, 1, 1, 1, 1, 1).mean(), is(1.0));
    azzert.that(new RealStatistics().record(2, 3, 2, 5, 2, 2).mean(), is(2.6666666666666665));
  }

  @Test public void missingTest() {
    final RealStatistics z = new RealStatistics().record();
    azzert.zero(z.missing());
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).record(z.v()).missing(), is(1));
    azzert.zero(new RealStatistics().record(1, 1, 1, 1, 1, 1).missing());
    azzert.zero(new RealStatistics().record(2, 3, 2, 5, 2, 2).missing());
  }

  @Test public void nTest() {
    azzert.zero(new RealStatistics().record().n());
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).n(), is(5));
    azzert.that(new RealStatistics().record(1, 1, 1, 1, 1, 1).n(), is(6));
    azzert.that(new RealStatistics().record(2, 3, 2, 5, 2, 2).n(), is(6));
  }

  @Test(expected = ArithmeticException.class) public void sdTestExp() {
    new RealStatistics().record().sd();
  }

  @Test public void sdTest() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).sd(), is(1.4142135623730951));
    azzert.that(new RealStatistics().record(1, 1, 1, 1, 1, 1).sd(), is(0.0));
    azzert.that(new RealStatistics().record(2, 3, 2, 5, 2, 2).sd(), is(1.1055415967851336));
  }

  @Test(expected = ArithmeticException.class) public void relativeErrorTestExp() {
    new RealStatistics().record().relativeError();
  }

  @Test public void relativeErrorTest() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).relativeError(), is(0.47140452079103173));
    azzert.that(new RealStatistics().record(1, 1, 1, 1, 1, 1).relativeError(), is(0.0));
    azzert.that(new RealStatistics().record(2, 3, 2, 5, 2, 2).relativeError(), is(0.41457809879442514));
  }

  @Test public void sumTest() {
    azzert.that(new RealStatistics().record().sum(), is(0.0));
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).sum(), is(15.0));
    azzert.that(new RealStatistics().record(1, 1, 1, 1, 1, 1).sum(), is(6.0));
    azzert.that(new RealStatistics().record(2, 3, 2, 5, 2, 2).sum(), is(16.0));
  }

  @Test public void sum2Test() {
    azzert.that(new RealStatistics().record().sum2(), is(0.0));
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).sum2(), is(55.0));
    azzert.that(new RealStatistics().record(1, 1, 1, 1, 1, 1).sum2(), is(6.0));
    azzert.that(new RealStatistics().record(2, 3, 2, 5, 2, 2).sum2(), is(50.0));
  }

  @Test public void vTest() {
    assert Double.isNaN(new RealStatistics().record().v());
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).v(), is(2.5));
    azzert.that(new RealStatistics().record(1, 1, 1, 1, 1, 1).v(), is(0.0));
    azzert.that(new RealStatistics().record(2, 3, 2, 5, 2, 2).v(), is(1.4666666666666668));
  }

  @Test(expected = ArithmeticException.class) public void varianceTestExp() {
    new RealStatistics().record().variance();
  }

  @Test public void varianceTest() {
    azzert.that(new RealStatistics().record(1, 2, 3, 4, 5).variance(), is(2.0));
    azzert.that(new RealStatistics().record(1, 1, 1, 1, 1, 1).variance(), is(0.0));
    azzert.that(new RealStatistics().record(2, 3, 2, 5, 2, 2).variance(), is(1.2222222222222232));
  }

  @Test(expected = ArithmeticException.class) public void checkEmptyTestExp() {
    new RealStatistics().record().checkEmpty();
  }

  @Test public void checkEmptyTest() {
    new RealStatistics().record(1, 2, 3, 4, 5).checkEmpty();
  }
}