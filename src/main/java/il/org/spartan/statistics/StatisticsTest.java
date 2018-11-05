package il.org.spartan.statistics;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method")
public class StatisticsTest {
  @Test public void medianTest() {
    double[] a = { 1, 2, 3, 4, 5 };
    Assert.assertEquals(Statistics.median(a), 3, 0.001);
    double[] b = { 1, 1, 1, 1, 1, 1 };
    Assert.assertEquals(Statistics.median(b), 1, 0.001);
    double[] c = { 2, 3, 2, 5, 2, 2 };
    Assert.assertEquals(Statistics.median(c), 2, 0.001);
  }

  @Test public void madTest() {
    double[] a = { 1, 2, 3, 4, 5 };
    assert Statistics.mad(a) == 1;
    double[] b = { 1, 1, 1, 1, 1, 1 };
    assert Statistics.mad(b) == 0;
    double[] c = { 2, 3, 2, 5, 2, 2 };
    assert Statistics.mad(c) == 0;
  }

  @Test public void pruneTest() {
    // TODO 
    assert true;
  }

  @Test public void sampleMeanTest() {
    double[] a = { 1, 2, 3, 4, 5 };
    assert Statistics.sampleMean(a) == 3.0;
    double[] b = { 1, 1, 1, 1, 1, 1 };
    assert Statistics.sampleMean(b) == 1.0;
    double[] c = { 2, 3, 2, 5, 2, 2 };
    assert Statistics.sampleMean(c) == 2.6666666666666665;
  }

  @Test public void sampleVarianceTest() {
    double[] a = { 1, 2, 3, 4, 5 };
    assert Statistics.sampleVariance(a) == 2.5;
    double[] b = { 1, 1, 1, 1, 1, 1 };
    assert Statistics.sampleVariance(b) == 0.0;
    double[] c = { 2, 3, 2, 5, 2, 2 };
    assert Statistics.sampleVariance(c) == 1.4666666666666668;
  }

  @Test public void isEmptyTest() {
    RealStatistics z = new RealStatistics().record();
    assert z.isEmpty() == true;
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.isEmpty() == false;
  }

  @Test public void maxTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.max();
      assert false;
    } catch (final ArithmeticException e) {
      forget.it(e);
      assert true;
    } catch (final Throwable e) {
      forget.it(e);
      assert false;
    }
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.max() == 5;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.max() == 1;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.max() == 5;
  }

  @Test public void minTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.min();
      assert false;
    } catch (final ArithmeticException e) {
      forget.it(e);
      assert true;
    } catch (final Throwable e) {
      forget.it(e);
      assert false;
    }
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.min() == 1;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.min() == 1;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.min() == 2;
  }

  @Test public void meanTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.mean();
      assert false;
    } catch (final ArithmeticException e) {
      forget.it(e);
      assert true;
    } catch (final Throwable e) {
      forget.it(e);
      assert false;
    }
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.mean() == 3;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.mean() == 1;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.mean() == 2.6666666666666665;
  }

  @Test public void missingTest() {
    RealStatistics z = new RealStatistics().record();
    assert z.missing() == 0;
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5).record(z.v());
    assert a.missing() == 1;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.missing() == 0;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.missing() == 0;
  }

  @Test public void nTest() {
    RealStatistics z = new RealStatistics().record();
    assert z.n() == 0;
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.n() == 5;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.n() == 6;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.n() == 6;
  }

  @Test public void sdTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.sd();
      assert false;
    } catch (final ArithmeticException e) {
      forget.it(e);
      assert true;
    } catch (final Throwable e) {
      forget.it(e);
      assert false;
    }
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.sd() == 1.4142135623730951;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.sd() == 0.0;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.sd() == 1.1055415967851336;
  }

  @Test public void relativeErrorTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.relativeError();
      assert false;
    } catch (final ArithmeticException e) {
      forget.it(e);
      assert true;
    } catch (final Throwable e) {
      forget.it(e);
      assert false;
    }
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.relativeError() == 0.47140452079103173;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.relativeError() == 0.0;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.relativeError() == 0.41457809879442514;
  }

  @Test public void sumTest() {
    RealStatistics z = new RealStatistics().record();
    assert z.sum() == 0.0;
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.sum() == 15.0;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.sum() == 6.0;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.sum() == 16.0;
  }

  @Test public void sum2Test() {
    RealStatistics z = new RealStatistics().record();
    assert z.sum2() == 0.0;
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.sum2() == 55.0;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.sum2() == 6.0;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.sum2() == 50.0;
  }

  @Test public void vTest() {
    RealStatistics z = new RealStatistics().record();
    assert Double.isNaN(z.v());
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.v() == 2.5;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.v() == 0.0;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.v() == 1.4666666666666668;
  }

  @Test public void varianceTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.variance();
      assert false;
    } catch (final ArithmeticException e) {
      forget.it(e);
      assert true;
    } catch (final Throwable e) {
      forget.it(e);
      assert false;
    }
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    assert a.variance() == 2.0;
    RealStatistics b = new RealStatistics().record(1, 1, 1, 1, 1, 1);
    assert b.variance() == 0.0;
    RealStatistics c = new RealStatistics().record(2, 3, 2, 5, 2, 2);
    assert c.variance() == 1.2222222222222232;
  }

  @Test public void checkEmptyTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.checkEmpty();
      assert false;
    } catch (final ArithmeticException e) {
      forget.it(e);
      assert true;
    } catch (final Throwable e) {
      forget.it(e);
      assert false;
    }
    RealStatistics a = new RealStatistics().record(1, 2, 3, 4, 5);
    a.checkEmpty();
  }
}