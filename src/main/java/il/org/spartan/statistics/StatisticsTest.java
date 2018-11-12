package il.org.spartan.statistics;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method","static-access"})
public class StatisticsTest {
  @Test public void medianTest() {
    double[] a = { 1, 2, 3, 4, 5 };
    azzert.assertEquals(Statistics.median(a), 3, 0.00001);
    double[] b = { 1, 1, 1, 1, 1, 1 };
    azzert.assertEquals(Statistics.median(b), 1, 0.00001);
    double[] c = { 2, 3, 2, 5, 2, 2 };
    azzert.assertEquals(Statistics.median(c), 2, 0.00001);
  }

  @Test public void madTest() {
    double[] a = { 1, 2, 3, 4, 5 };
    azzert.assertEquals(Statistics.mad(a), 1, 0.00001);
    double[] b = { 1, 1, 1, 1, 1, 1 };
    azzert.assertEquals(Statistics.mad(b), 0, 0.00001);
    double[] c = { 2, 3, 2, 5, 2, 2 };
    azzert.assertEquals(Statistics.mad(c), 0, 0.00001);
  }

  @Test public void sampleMeanTest() {
    double[] a = { 1, 2, 3, 4, 5 };
    azzert.assertEquals(Statistics.sampleMean(a), 3.0, 0.00001);
    double[] b = { 1, 1, 1, 1, 1, 1 };
    azzert.assertEquals(Statistics.sampleMean(b), 1.0, 0.00001);
    double[] c = { 2, 3, 2, 5, 2, 2 };
    azzert.assertEquals(Statistics.sampleMean(c), 2.6666666666666665, 0.00001);
  }

  @Test public void sampleVarianceTest() {
    double[] a = { 1, 2, 3, 4, 5 };
    azzert.assertEquals(Statistics.sampleVariance(a), 2.5, 0.00001);
    double[] b = { 1, 1, 1, 1, 1, 1 };
    azzert.assertEquals(Statistics.sampleVariance(b), 0.0, 0.00001);
    double[] c = { 2, 3, 2, 5, 2, 2 };
    azzert.assertEquals(Statistics.sampleVariance(c), 1.4666666666666668, 0.00001);
  }

  @Test public void isEmptyTest() {
    RealStatistics z = new RealStatistics().record();
    azzert.assertEquals(Boolean.valueOf(z.isEmpty()), Boolean.valueOf(true));
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(Boolean.valueOf(a.isEmpty()), Boolean.valueOf(false));
  }

  @Test (expected = ArithmeticException.class) public void maxTestExp() {
    RealStatistics z = new RealStatistics().record();
      z.max();
  }

  @Test public void maxTest() {
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(a.max(), 5, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.max(), 1, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.max(), 5, 0.00001);
  }

  @Test (expected = ArithmeticException.class) public void minTestExp() {
    RealStatistics z = new RealStatistics().record();
      z.min();
  }
  
  @Test public void minTest() {
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(a.min(), 1, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.min(), 1, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.min(), 2, 0.00001);
  }
  
  @Test (expected = ArithmeticException.class) public void meanTestExp() {
    RealStatistics z = new RealStatistics().record();
      z.mean();
  }
  
  @Test public void meanTest() {
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(a.mean(), 3, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.mean(), 1, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.mean(), 2.6666666666666665, 0.00001);
  }

  @Test public void missingTest() {
    RealStatistics z = new RealStatistics().record();
    azzert.assertEquals(z.missing(), 0, 0.00001);
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5).record(z.v());
    azzert.assertEquals(a.missing(), 1, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.missing(), 0, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.missing(), 0, 0.00001);
  }

  @Test public void nTest() {
    RealStatistics z = new RealStatistics().record();
    azzert.assertEquals(z.n(), 0, 0.00001);
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(a.n(), 5, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.n(), 6, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.n(), 6, 0.00001);
  }

  @Test (expected = ArithmeticException.class) public void sdTestExp() {
    RealStatistics z = new RealStatistics().record();
      z.sd();
  }
  
  @Test public void sdTest() {
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(a.sd(), 1.4142135623730951, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.sd(), 0.0, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.sd(), 1.1055415967851336, 0.00001);
  }

  @Test (expected = ArithmeticException.class) public void relativeErrorTestExp() {
    RealStatistics z = new RealStatistics().record();
      z.relativeError();
  }
  
  @Test public void relativeErrorTest() {
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(a.relativeError(), 0.47140452079103173, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.relativeError(), 0.0, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.relativeError(), 0.41457809879442514, 0.00001);
  }

  @Test public void sumTest() {
    RealStatistics z = new RealStatistics().record();
    azzert.assertEquals(z.sum(), 0.0, 0.00001);
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(a.sum(), 15.0, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.sum(), 6.0, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.sum(), 16.0, 0.00001);
  }

  @Test public void sum2Test() {
    RealStatistics z = new RealStatistics().record();
    azzert.assertEquals(z.sum2(), 0.0, 0.00001);
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(a.sum2(), 55.0, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.sum2(), 6.0, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.sum2(), 50.0, 0.00001);
  }

  @Test public void vTest() {
    RealStatistics z = new RealStatistics().record();
    azzert.assertTrue(Double.isNaN(z.v()));
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(a.v(), 2.5, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.v(), 0.0, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.v(), 1.4666666666666668, 0.00001);
  }
  
  @Test (expected = ArithmeticException.class) public void varianceTestExp() {
    RealStatistics z = new RealStatistics().record();
      z.variance();
  }

  @Test public void varianceTest() {
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    azzert.assertEquals(a.variance(), 2.0, 0.00001);
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    azzert.assertEquals(b.variance(), 0.0, 0.00001);
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    azzert.assertEquals(c.variance(), 1.2222222222222232, 0.00001);
  }

  @Test (expected = ArithmeticException.class) public void checkEmptyTestExp() {
    RealStatistics z = new RealStatistics().record();
      z.checkEmpty();
  }
  
  @Test public void checkEmptyTest() {
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    a.checkEmpty();
  }
}