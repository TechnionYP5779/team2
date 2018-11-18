package fluent.ly;


import java.util.*;

import org.eclipse.jdt.annotation.*;
import org.junit.*;
import static fluent.ly.azzert.*;
import an.*;
import il.org.spartan.*;

@SuppressWarnings("static-method") public class lispTest {
  @Test public void testChop1() {
    azzert.isNull(lisp.chop(empty.list()));
  }

  @Test public void testChop2() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(Utils.cantBeNull(lisp.chop(l)).get(0), is(box.box(2)));
  }

  @Test public void testCons() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    azzert.that(lisp.cons(box.box(3), l).get(0), is(box.box(3)));
  }

  @SuppressWarnings("null") @Test public void testNext1() {
    List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    azzert.that(lisp.next(2, l), is(box.box(1)));
  }

  @SuppressWarnings("null") @Test public void testNext2() {
    List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(lisp.next(1, l), is(box.box(3)));
  }

  @Test public void testGet1() {
    azzert.isNull(lisp.get(null, 0));
  }

  @SuppressWarnings("null") @Test public void testGet2() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(Utils.cantBeNull(lisp.get(l, 1)), is(box.box(3)));
  }

  @SuppressWarnings("null") @Test public void testPrev1() {
    List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(lisp.prev(0, l), is(box.box(1)));
  }

  @SuppressWarnings("null") @Test public void testPrev2() {
    List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(lisp.prev(2, l), is(box.box(2)));
  }

  @Test public void testReplace1() {
    List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.replace(l, box.box(10), -1) == l;
  }

  @Test public void testReplace2() {
    List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.replace(l, box.box(10), 100) == l;
  }

  @Test public void testReplace3() {
    List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.replace(l, box.box(10), 2) == l;
  }

  @Test public void testReplaceFirst() {
    List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.isNull(lisp.replaceFirst(null, box.box(10)));
  }

  @Test public void testReplaceLast() {
    List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(Utils.cantBeNull(lisp.replaceLast(l, box.box(10))).get(l.size() - 1), is(box.box(10)));
  }

  @Test public void testRest2() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    Iterable<Integer> l2 = lisp.rest2(l);
    Iterator<Integer> iter = l2.iterator();
    while(iter.hasNext()) {
      azzert.that(iter.next(),is(box.box(3)));
    }
  }

  @Test public void testAreEqual1() {
    assert !lisp.areEqual(null);
  }
  
  @Test public void testAreEqual2() {
    assert lisp.areEqual(box.box(1),box.box(1));
  }
  
  @Test public void testAreEqual3() {
    assert !lisp.areEqual(box.box(1),box.box(2));
  }

  @Test public void testChopLastListOfT() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(lisp.chopLast(l).get(l.size() - 2), is(box.box(2)));
  }

  @Test public void testChopLastString() {
    String str = "abc";
    azzert.that(lisp.chopLast(str), is("ab"));
  }

  @Test public void testRemoveFromList() {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    l1.add(box.box(1));
    l1.add(box.box(2));
    l1.add(box.box(3));
    l2.add(box.box(1));
    lisp.removeFromList(l2, l1);
    azzert.that(l1.get(0), is(box.box(2)));
  }

  @Test public void testRemoveLast() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    lisp.removeLast(l);
    azzert.that(l.get(l.size() - 1), is(box.box(2)));
  }

  @Test public void testSwap1() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.swap(l, 5, 5) == l;
  }
  
  @Test public void testSwap2() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.swap(l, 1, 5) == l;
  }
  
  @Test public void testSwap3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.swap(l, 1, 1) == l;
  }
}
