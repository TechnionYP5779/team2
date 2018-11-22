package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class LinearRegressionTest {
  @Test public void SxTest1() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(1.0));
    xs.add(box(2.0));
    xs.add(box(3.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(0.0));
    ys.add(box(0.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    azzert.that(lr.Sx(), is(6.0));
  }

  @Test public void SxTest2() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(5.0));
    xs.add(box(2.0));
    xs.add(box(7.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(0.0));
    ys.add(box(0.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    azzert.that(lr.Sx(), is(14.0));
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
    azzert.that(lr.Sy(), is(0.0));
  }

  @Test public void SyTest2() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(5.0));
    xs.add(box(2.0));
    xs.add(box(7.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(12.0));
    ys.add(box(0.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    azzert.that(lr.Sy(), is(12.0));
  }

  @Test public void SxxTest1() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(1.0));
    xs.add(box(2.0));
    xs.add(box(3.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(0.0));
    ys.add(box(0.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    azzert.that(lr.Sxx(), is(14.0));
  }

  @Test public void SxxTest2() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(5.0));
    xs.add(box(2.0));
    xs.add(box(7.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(0.0));
    ys.add(box(0.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    azzert.that(lr.Sxx(), is(78.0));
  }

  @Test public void SyyTest1() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(1.0));
    xs.add(box(2.0));
    xs.add(box(3.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(0.0));
    ys.add(box(0.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    azzert.that(lr.Syy(), is(0.0));
  }

  @Test public void SyyTest2() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(5.0));
    xs.add(box(2.0));
    xs.add(box(7.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(2.0));
    ys.add(box(1.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    azzert.that(lr.Syy(), is(5.0));
  }

  @Test public void SxyTest1() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(1.0));
    xs.add(box(2.0));
    xs.add(box(3.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(0.0));
    ys.add(box(0.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    azzert.that(lr.Sxy(), is(0.0));
  }

  @Test public void SxyTest2() {
    final List<Double> xs = new ArrayList<>();
    xs.add(box(5.0));
    xs.add(box(2.0));
    xs.add(box(7.0));
    final List<Double> ys = new ArrayList<>();
    ys.add(box(0.0));
    ys.add(box(2.0));
    ys.add(box(1.0));
    final LinearRegression lr = new LinearRegression(xs, ys);
    azzert.that(lr.Sxy(), is(11.0));
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
    azzert.that(line.geta(), is(-0.23684210526315788));
    azzert.that(line.getb(), is(2.1052631578947367));
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
    azzert.that(line.geta(), is(0.5));
    azzert.that(line.getb(), is(2.6666666666666667));
  }
}
