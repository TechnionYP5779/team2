package il.org.spartan.utils;
import static fluent.ly.azzert.*;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PairListTest {
  
  @Test public void testRecord() {
    PairList pl = new PairList();
    pl.record(1.0,2.0);
  }
  
  @Test public void testAt() {
    PairList pl = new PairList();
    pl.record(0.0,3.0);
    pl.record(0.0,1.0);
    pl.record(0.0,2.0);
    pl.record(0.0,4.0);

    azzert.that(pl.at(0).second, is(3.0));
    azzert.that(pl.at(1).second, is(1.0));
    azzert.that(pl.at(2).second, is(2.0));
    azzert.that(pl.at(3).second, is(4.0));
  }
  
  @Test public void testSort() {
    PairList pl = new PairList();
    pl.record(0.0,3.0);
    pl.record(0.0,1.0);
    pl.record(0.0,2.0);
    pl.record(0.0,4.0);

    pl.sort();
    azzert.that(pl.at(0).second, is(1.0));
    azzert.that(pl.at(1).second, is(2.0));
    azzert.that(pl.at(2).second, is(3.0));
    azzert.that(pl.at(3).second, is(4.0));
  }
  
  @Test public void testIteratorSort() {
    PairList pl = new PairList();
    pl.record(0.0,3.0);
    pl.record(0.0,1.0);

    ListIterator<SortableDoublePair> iter = pl.sortedIterator();
    assert iter.hasNext();
    azzert.that(iter.next().getPair().second, is(1.0));    
  }
  
  @Test public void testCount() {
    PairList pl = new PairList();
    pl.record(0.0,3.0);
    pl.record(0.0,1.0);
    pl.record(0.0,2.0);
    pl.record(0.0,4.0);

    azzert.that(pl.count(), is(4));
  }
  
  @Test public void testDistSum() {
    PairList pl = new PairList();
    pl.record(0.0,3.0);
    pl.record(0.0,1.0);
    pl.record(0.0,2.0);
    pl.record(0.0,4.0);

    azzert.that(pl.distSum(), is(10.0));
  }
  
  @Test public void testSum() {
    PairList pl = new PairList();
    pl.record(0.0,3.0);
    pl.record(0.0,1.0);
    pl.record(0.0,2.0);
    pl.record(0.0,4.0);

    azzert.that(pl.sum(), is(10.0));
  }
}
