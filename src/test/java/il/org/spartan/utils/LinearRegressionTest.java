package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class LinearRegressionTest {
  @Test public void sumXsTest1() {
        final List<Double> xs = new ArrayList<>();
        xs.add(box(1.0));
        xs.add(box(2.0));
        xs.add(box(3.0));
        final List<Double> ys = new ArrayList<>();
        ys.add(box(0.0));
        ys.add(box(0.0));
        ys.add(box(0.0));
        final LinearRegression lr = new LinearRegression(xs, ys);
        azzert.that(lr.sumXs(), is(6.0));
      }

  @Test public void sumXsTest2() {
        final List<Double> xs = new ArrayList<>();
        xs.add(box(5.0));
        xs.add(box(2.0));
        xs.add(box(7.0));
        final List<Double> ys = new ArrayList<>();
        ys.add(box(0.0));
        ys.add(box(0.0));
        ys.add(box(0.0));
        final LinearRegression lr = new LinearRegression(xs, ys);
        azzert.that(lr.sumXs(), is(14.0));
      }

  @Test public void YxTest1() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(1.0));
    xs.add(box(2.0));
    xs.add(box(3.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(0.0));
    ys.add(box(0.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    azzert.that(lr.sumYs(), is(0.0));
  }

  @Test public void sumYsTest2() {
      final List<Double> xs = new ArrayList<>();
      xs.add(box(5.0));
      xs.add(box(2.0));
      xs.add(box(7.0));
      final List<Double> ys = new ArrayList<>();
      ys.add(box(0.0));
      ys.add(box(12.0));
      ys.add(box(0.0));
      final LinearRegression lr = new LinearRegression(xs, ys);
      azzert.that(lr.sumYs(), is(12.0));
    }

  @Test public void sumXsxTest1() {
        final List<Double> xs = new ArrayList<>();
        xs.add(box(1.0));
        xs.add(box(2.0));
        xs.add(box(3.0));
        final List<Double> ys = new ArrayList<>();
        ys.add(box(0.0));
        ys.add(box(0.0));
        ys.add(box(0.0));
        final LinearRegression lr = new LinearRegression(xs, ys);
        azzert.that(lr.sumXXs(), is(14.0));
      }

  @Test public void sumXsxTest2() {
        final List<Double> xs = new ArrayList<>();
        xs.add(box(5.0));
        xs.add(box(2.0));
        xs.add(box(7.0));
        final List<Double> ys = new ArrayList<>();
        ys.add(box(0.0));
        ys.add(box(0.0));
        ys.add(box(0.0));
        final LinearRegression lr = new LinearRegression(xs, ys);
        azzert.that(lr.sumXXs(), is(78.0));
      }

  @Test public void sumYsyTest1() {
      final List<Double> xs = new ArrayList<>();
      xs.add(box(1.0));
      xs.add(box(2.0));
      xs.add(box(3.0));
      final List<Double> ys = new ArrayList<>();
      ys.add(box(0.0));
      ys.add(box(0.0));
      ys.add(box(0.0));
      final LinearRegression lr = new LinearRegression(xs, ys);
      azzert.that(lr.sumYYs(), is(0.0));
    }

  @Test public void sumYsyTest2() {
      final List<Double> xs = new ArrayList<>();
      xs.add(box(5.0));
      xs.add(box(2.0));
      xs.add(box(7.0));
      final List<Double> ys = new ArrayList<>();
      ys.add(box(0.0));
      ys.add(box(2.0));
      ys.add(box(1.0));
      final LinearRegression lr = new LinearRegression(xs, ys);
      azzert.that(lr.sumYYs(), is(5.0));
    }

  @Test public void sumXsyTest1() {
        final List<Double> xs = new ArrayList<>();
        xs.add(box(1.0));
        xs.add(box(2.0));
        xs.add(box(3.0));
        final List<Double> ys = new ArrayList<>();
        ys.add(box(0.0));
        ys.add(box(0.0));
        ys.add(box(0.0));
        final LinearRegression lr = new LinearRegression(xs, ys);
        azzert.that(lr.sumXYs(), is(0.0));
      }

  @Test public void sumXsyTest2() {
        final List<Double> xs = new ArrayList<>();
        xs.add(box(5.0));
        xs.add(box(2.0));
        xs.add(box(7.0));
        final List<Double> ys = new ArrayList<>();
        ys.add(box(0.0));
        ys.add(box(2.0));
        ys.add(box(1.0));
        final LinearRegression lr = new LinearRegression(xs, ys);
        azzert.that(lr.sumXYs(), is(11.0));
      }

  @Test public void LRTest1() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(5.0));
    xs.add(box(2.0));
    xs.add(box(7.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(2.0));
    ys.add(box(1.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    final LinearLine line = lr.calcLinearRegression();
    azzert.that(line.getA(), is(-0.23684210526315788));
    azzert.that(line.getB(), is(2.1052631578947367));
  }

  @Test public void LRTest2() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(1.0));
    xs.add(box(2.0));
    xs.add(box(3.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(4.0));
    ys.add(box(2.0));
    ys.add(box(5.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    final LinearLine line = lr.calcLinearRegression();
    azzert.that(line.getA(), is(0.5));
    azzert.that(line.getB(), is(2.6666666666666667));
  }
}
