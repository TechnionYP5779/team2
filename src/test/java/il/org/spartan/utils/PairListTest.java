package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PairListTest {
  @Test public void testRecord() {
    new PairList().record(1.0, 2.0);
  }

  @Test public void testAt() {
    final PairList pl = new PairList();
    pl.record(0.0, 3.0);
    pl.record(0.0, 1.0);
    pl.record(0.0, 2.0);
    pl.record(0.0, 4.0);
    azzert.that(pl.at(0).second, is(3.0));
    azzert.that(pl.at(1).second, is(1.0));
    azzert.that(pl.at(2).second, is(2.0));
    azzert.that(pl.at(3).second, is(4.0));
  }

  @Test public void testAt2() {
    final PairList pl = new PairList();
    pl.record(0.0, 5.0);
    pl.record(0.0, 1.0);
    pl.record(0.0, 3.0);
    pl.record(0.0, 4.0);
    azzert.that(pl.at(0).second, is(5.0));
    azzert.that(pl.at(1).second, is(1.0));
    azzert.that(pl.at(2).second, is(3.0));
    azzert.that(pl.at(3).second, is(4.0));
  }

  @Test public void testSort() {
    final PairList pl = new PairList();
    pl.record(0.0, 3.0);
    pl.record(0.0, 1.0);
    pl.record(0.0, 2.0);
    pl.record(0.0, 4.0);
    pl.sort();
    azzert.that(pl.at(0).second, is(1.0));
    azzert.that(pl.at(1).second, is(2.0));
    azzert.that(pl.at(2).second, is(3.0));
    azzert.that(pl.at(3).second, is(4.0));
  }

  @Test public void testSort2() {
    final PairList pl = new PairList();
    pl.record(0.0, 5.0);
    pl.record(0.0, 1.0);
    pl.record(0.0, 3.0);
    pl.record(0.0, 4.0);
    pl.sort();
    azzert.that(pl.at(0).second, is(1.0));
    azzert.that(pl.at(1).second, is(3.0));
    azzert.that(pl.at(2).second, is(4.0));
    azzert.that(pl.at(3).second, is(5.0));
  }

  @Test public void testIteratorSort() {
    final PairList pl = new PairList();
    pl.record(0.0, 3.0);
    pl.record(0.0, 1.0);
    final ListIterator<SortableDoublePair> iter = pl.sortedIterator();
    assert iter.hasNext();
    azzert.that(iter.next().getPair().second, is(1.0));
  }

  @Test public void testIteratorSort2() {
    final PairList pl = new PairList();
    pl.record(0.0, 3.0);
    pl.record(0.0, 2.0);
    final ListIterator<SortableDoublePair> iter = pl.sortedIterator();
    assert iter.hasNext();
    azzert.that(iter.next().getPair().second, is(2.0));
  }

  @Test public void testCount() {
    final PairList pl = new PairList();
    pl.record(0.0, 3.0);
    pl.record(0.0, 1.0);
    pl.record(0.0, 2.0);
    pl.record(0.0, 4.0);
    azzert.that(pl.count(), is(4));
  }

  @Test public void testCount2() {
    final PairList pl = new PairList();
    pl.record(0.0, 3.0);
    pl.record(0.0, 1.0);
    pl.record(0.0, 2.0);
    azzert.that(pl.count(), is(3));
  }

  @Test public void testDistSum() {
    final PairList pl = new PairList();
    pl.record(0.0, 3.0);
    pl.record(0.0, 1.0);
    pl.record(0.0, 2.0);
    pl.record(0.0, 4.0);
    azzert.that(pl.distSum(), is(10.0));
  }

  @Test public void testDistSum2() {
    final PairList pl = new PairList();
    pl.record(0.0, 3.0);
    pl.record(0.0, 1.0);
    pl.record(0.0, 2.0);
    pl.record(0.0, 3.0);
    azzert.that(pl.distSum(), is(9.0));
  }

  @Test public void testSum() {
    final PairList pl = new PairList();
    pl.record(0.0, 3.0);
    pl.record(0.0, 1.0);
    pl.record(0.0, 2.0);
    pl.record(0.0, 4.0);
    azzert.that(pl.sum(), is(10.0));
  }

  @Test public void testSum2() {
    final PairList pl = new PairList();
    pl.record(0.0, 3.0);
    pl.record(0.0, 1.0);
    pl.record(0.0, 2.0);
    pl.record(0.0, 3.0);
    azzert.that(pl.sum(), is(9.0));
  }

  @Test public void LinearRegressionTest() {
    final PairList pl = new PairList();
    pl.record(1.0, 3.0);
    pl.record(0.0, 1.0);
    pl.record(3.0, 2.0);
    pl.record(0.0, 4.0);
    final List<Double> xs = new ArrayList<>();
    final List<Double> ys = new ArrayList<>();
    for (int ¢ = 0; ¢ < pl.count(); ++¢) {
      xs.add(pl.at(¢).first);
      ys.add(pl.at(¢).second);
    }
    final LinearRegression lr = new LinearRegression(xs, ys);
    final LinearLine line = lr.calcLinearRegression();
    azzert.that(line.geta(), is(-0.16666666666666666));
    azzert.that(line.getb(), is(2.6666666666666667));
  }

  @Test public void LinearRegressionTest2() {
    final PairList pl = new PairList();
    pl.record(1.0, 2.0);
    pl.record(9.0, 1.0);
    pl.record(0.0, 7.0);
    pl.record(1.0, 4.0);
    final List<Double> xs = new ArrayList<>();
    final List<Double> ys = new ArrayList<>();
    for (int ¢ = 0; ¢ < pl.count(); ++¢) {
      xs.add(pl.at(¢).first);
      ys.add(pl.at(¢).second);
    }
    final LinearRegression lr = new LinearRegression(xs, ys);
    final LinearLine line = lr.calcLinearRegression();
    azzert.that(line.geta(), is(-0.44549763033175355));
    azzert.that(line.getb(), is(4.725118483412322));
  }
}
