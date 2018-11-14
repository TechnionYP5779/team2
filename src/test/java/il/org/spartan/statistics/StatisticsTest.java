package il.org.spartan.statistics;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method","static-access"})
public class StatisticsTest {
  @Test public void medianTest() {
    azzert.assertEquals(Statistics.median(new double[] { 1, 2, 3, 4, 5 }), 3, 0.00001);
    azzert.assertEquals(Statistics.median(new double[] { 1, 1, 1, 1, 1, 1 }), 1, 0.00001);
    azzert.assertEquals(Statistics.median(new double[] { 2, 3, 2, 5, 2, 2 }), 2, 0.00001);
  }

  @Test public void madTest() {
    azzert.assertEquals(Statistics.mad(new double[] { 1, 2, 3, 4, 5 }), 1, 0.00001);
    azzert.assertEquals(Statistics.mad(new double[] { 1, 1, 1, 1, 1, 1 }), 0, 0.00001);
    azzert.assertEquals(Statistics.mad(new double[] { 2, 3, 2, 5, 2, 2 }), 0, 0.00001);
  }

  @Test public void sampleMeanTest() {
    azzert.assertEquals(Statistics.sampleMean(new double[] { 1, 2, 3, 4, 5 }), 3.0, 0.00001);
    azzert.assertEquals(Statistics.sampleMean(new double[] { 1, 1, 1, 1, 1, 1 }), 1.0, 0.00001);
    azzert.assertEquals(Statistics.sampleMean(new double[] { 2, 3, 2, 5, 2, 2 }), 2.6666666666666665, 0.00001);
  }

  @Test public void sampleVarianceTest() {
    azzert.assertEquals(Statistics.sampleVariance(new double[] { 1, 2, 3, 4, 5 }), 2.5, 0.00001);
    azzert.assertEquals(Statistics.sampleVariance(new double[] { 1, 1, 1, 1, 1, 1 }), 0.0, 0.00001);
    azzert.assertEquals(Statistics.sampleVariance(new double[] { 2, 3, 2, 5, 2, 2 }), 1.4666666666666668, 0.00001);
  }

  @Test public void isEmptyTest() {
    azzert.assertEquals(Boolean.valueOf(new RealStatistics().record().isEmpty()), Boolean.TRUE);
    azzert.assertEquals(Boolean.valueOf(new RealStatistics().record(1, 2, 3, 4, 5).isEmpty()), Boolean.FALSE);
  }

  @Test (expected = ArithmeticException.class) public void maxTestExp() {
    new RealStatistics().record().max();
  }

  @Test public void maxTest() {
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).max(), 5, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).max(), 1, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).max(), 5, 0.00001);
  }

  @Test (expected = ArithmeticException.class) public void minTestExp() {
    new RealStatistics().record().min();
  }
  
  @Test public void minTest() {
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).min(), 1, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).min(), 1, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).min(), 2, 0.00001);
  }
  
  @Test (expected = ArithmeticException.class) public void meanTestExp() {
    new RealStatistics().record().mean();
  }
  
  @Test public void meanTest() {
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).mean(), 3, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).mean(), 1, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).mean(), 2.6666666666666665, 0.00001);
  }

  @Test public void missingTest() {
    RealStatistics z = new RealStatistics().record();
    azzert.assertEquals(z.missing(), 0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).record(z.v()).missing(), 1, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).missing(), 0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).missing(), 0, 0.00001);
  }

  @Test public void nTest() {
    azzert.assertEquals(new RealStatistics().record().n(), 0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).n(), 5, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).n(), 6, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).n(), 6, 0.00001);
  }

  @Test (expected = ArithmeticException.class) public void sdTestExp() {
    new RealStatistics().record().sd();
  }
  
  @Test public void sdTest() {
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).sd(), 1.4142135623730951, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).sd(), 0.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).sd(), 1.1055415967851336, 0.00001);
  }

  @Test (expected = ArithmeticException.class) public void relativeErrorTestExp() {
    new RealStatistics().record().relativeError();
  }
  
  @Test public void relativeErrorTest() {
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).relativeError(), 0.47140452079103173, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).relativeError(), 0.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).relativeError(), 0.41457809879442514, 0.00001);
  }

  @Test public void sumTest() {
    azzert.assertEquals(new RealStatistics().record().sum(), 0.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).sum(), 15.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).sum(), 6.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).sum(), 16.0, 0.00001);
  }

  @Test public void sum2Test() {
    azzert.assertEquals(new RealStatistics().record().sum2(), 0.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).sum2(), 55.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).sum2(), 6.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).sum2(), 50.0, 0.00001);
  }

  @Test public void vTest() {
    assert Double.isNaN(new RealStatistics().record().v());
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).v(), 2.5, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).v(), 0.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).v(), 1.4666666666666668, 0.00001);
   }
  
  @Test public void intvTest() {
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).ν(), 4);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).ν(), 5);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).ν(), 5);
  }
  
  @Test (expected = ArithmeticException.class) public void varianceTestExp() {
    new RealStatistics().record().variance();
  }

  @Test public void varianceTest() {
    azzert.assertEquals(new RealStatistics().record(1, 2, 3, 4, 5).variance(), 2.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(1, 1, 1, 1, 1, 1).variance(), 0.0, 0.00001);
    azzert.assertEquals(new RealStatistics().record(2, 3, 2, 5, 2, 2).variance(), 1.2222222222222232, 0.00001);
  }

  @Test (expected = ArithmeticException.class) public void checkEmptyTestExp() {
    new RealStatistics().record().checkEmpty();
  }
  
  @Test public void checkEmptyTest() {
    new RealStatistics().record(1, 2, 3, 4, 5).checkEmpty();
  }
}