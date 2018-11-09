package il.org.spartan.statistics;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class StatisticsTest {
  @Test public void medianTest() {
    assert Statistics.median(new double[] { 1, 2, 3, 4, 5 }) == 3;
    assert Statistics.median(new double[] { 1, 1, 1, 1, 1, 1 }) == 1;
    assert Statistics.median(new double[] { 2, 3, 2, 5, 2, 2 }) == 2;
  }

  @Test public void madTest() {
    assert Statistics.mad(new double[] { 1, 2, 3, 4, 5 }) == 1;
    assert Statistics.mad(new double[] { 1, 1, 1, 1, 1, 1 }) == 0;
    assert Statistics.mad(new double[] { 2, 3, 2, 5, 2, 2 }) == 0;
  }

  @Test public void pruneTest() {
    // TODO
    assert true;
  }

  @Test public void sampleMeanTest() {
    assert Statistics.sampleMean(new double[] { 1, 2, 3, 4, 5 }) == 3.0;
    assert Statistics.sampleMean(new double[] { 1, 1, 1, 1, 1, 1 }) == 1.0;
    assert Statistics.sampleMean(new double[] { 2, 3, 2, 5, 2, 2 }) == 2.6666666666666665;
  }

  @Test public void sampleVarianceTest() {
    assert Statistics.sampleVariance(new double[] { 1, 2, 3, 4, 5 }) == 2.5;
    assert Statistics.sampleVariance(new double[] { 1, 1, 1, 1, 1, 1 }) == 0.0;
    assert Statistics.sampleVariance(new double[] { 2, 3, 2, 5, 2, 2 }) == 1.4666666666666668;
  }

  @Test public void isEmptyTest() {
    assert new RealStatistics().record().isEmpty();
    assert !new RealStatistics().record(1, 2, 3, 4, 5).isEmpty();
  }

  @Test public void maxTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.max();
      assert false;
    } catch (final ArithmeticException ¢) {
      forget.it(¢);
      assert true;
    } catch (final Throwable ¢) {
      forget.it(¢);
      assert false;
    }
    assert new RealStatistics().record(1, 2, 3, 4, 5).max() == 5;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).max() == 1;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).max() == 5;
  }

  @Test public void minTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.min();
      assert false;
    } catch (final ArithmeticException ¢) {
      forget.it(¢);
      assert true;
    } catch (final Throwable ¢) {
      forget.it(¢);
      assert false;
    }
    assert new RealStatistics().record(1, 2, 3, 4, 5).min() == 1;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).min() == 1;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).min() == 2;
  }

  @Test public void meanTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.mean();
      assert false;
    } catch (final ArithmeticException ¢) {
      forget.it(¢);
      assert true;
    } catch (final Throwable ¢) {
      forget.it(¢);
      assert false;
    }
    assert new RealStatistics().record(1, 2, 3, 4, 5).mean() == 3;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).mean() == 1;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).mean() == 2.6666666666666665;
  }

  @Test public void missingTest() {
    RealStatistics z = new RealStatistics().record();
    assert z.missing() == 0;
    assert new RealStatistics().record(1, 2, 3, 4, 5).record(z.v()).missing() == 1;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).missing() == 0;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).missing() == 0;
  }

  @Test public void nTest() {
    assert new RealStatistics().record().n() == 0;
    assert new RealStatistics().record(1, 2, 3, 4, 5).n() == 5;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).n() == 6;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).n() == 6;
  }

  @Test public void sdTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.sd();
      assert false;
    } catch (final ArithmeticException ¢) {
      forget.it(¢);
      assert true;
    } catch (final Throwable ¢) {
      forget.it(¢);
      assert false;
    }
    assert new RealStatistics().record(1, 2, 3, 4, 5).sd() == 1.4142135623730951;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).sd() == 0.0;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).sd() == 1.1055415967851336;
  }

  @Test public void relativeErrorTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.relativeError();
      assert false;
    } catch (final ArithmeticException ¢) {
      forget.it(¢);
      assert true;
    } catch (final Throwable ¢) {
      forget.it(¢);
      assert false;
    }
    assert new RealStatistics().record(1, 2, 3, 4, 5).relativeError() == 0.47140452079103173;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).relativeError() == 0.0;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).relativeError() == 0.41457809879442514;
  }

  @Test public void sumTest() {
    assert new RealStatistics().record().sum() == 0.0;
    assert new RealStatistics().record(1, 2, 3, 4, 5).sum() == 15.0;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).sum() == 6.0;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).sum() == 16.0;
  }

  @Test public void sum2Test() {
    assert new RealStatistics().record().sum2() == 0.0;
    assert new RealStatistics().record(1, 2, 3, 4, 5).sum2() == 55.0;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).sum2() == 6.0;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).sum2() == 50.0;
  }

  @Test public void vTest() {
    assert Double.isNaN(new RealStatistics().record().v());
    assert new RealStatistics().record(1, 2, 3, 4, 5).v() == 2.5;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).v() == 0.0;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).v() == 1.4666666666666668;
  }

  @Test public void varianceTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.variance();
      assert false;
    } catch (final ArithmeticException ¢) {
      forget.it(¢);
      assert true;
    } catch (final Throwable ¢) {
      forget.it(¢);
      assert false;
    }
    assert new RealStatistics().record(1, 2, 3, 4, 5).variance() == 2.0;
    assert new RealStatistics().record(1, 1, 1, 1, 1, 1).variance() == 0.0;
    assert new RealStatistics().record(2, 3, 2, 5, 2, 2).variance() == 1.2222222222222232;
  }

  @Test public void checkEmptyTest() {
    RealStatistics z = new RealStatistics().record();
    try {
      z.checkEmpty();
      assert false;
    } catch (final ArithmeticException ¢) {
      forget.it(¢);
      assert true;
    } catch (final Throwable ¢) {
      forget.it(¢);
      assert false;
    }
    new RealStatistics().record(1, 2, 3, 4, 5).checkEmpty();
  }
}