package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.eclipse.jdt.annotation.*;
import org.junit.*;

import an.*;
import static il.org.spartan.Utils.*;

@SuppressWarnings("static-method") public class lispTest {
  @Test public void testChop1() {
    azzert.isNull(lisp.chop(empty.list()));
  }

  @Test public void testChop2() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(cantBeNull(lisp.chop(l)).get(0), is(box.box(2)));
  }

  @Test public void testCons() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    azzert.that(lisp.cons(box.box(3), l).get(0), is(box.box(3)));
  }

  @Test @SuppressWarnings("null") public void testNext1() {
    final List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    azzert.that(lisp.next(2, l), is(box.box(1)));
  }

  @Test @SuppressWarnings("null") public void testNext2() {
    final List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(lisp.next(1, l), is(box.box(3)));
  }

  @Test public void testGet1() {
    azzert.isNull(lisp.get(null, 0));
  }

  @Test @SuppressWarnings("null") public void testGet2() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(cantBeNull(lisp.get(l, 1)), is(box.box(3)));
  }

  @Test @SuppressWarnings("null") public void testPrev1() {
    final List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(lisp.prev(0, l), is(box.box(1)));
  }

  @Test @SuppressWarnings("null") public void testPrev2() {
    final List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(lisp.prev(2, l), is(box.box(2)));
  }

  @Test public void testReplace1() {
    final List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.replace(l, box.box(10), -1) == l;
  }

  @Test public void testReplace2() {
    final List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.replace(l, box.box(10), 100) == l;
  }

  @Test public void testReplace3() {
    final List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.replace(l, box.box(10), 2) == l;
  }

  @Test public void testReplaceFirst() {
    final List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.isNull(lisp.replaceFirst(null, box.box(10)));
  }

  @Test public void testReplaceLast() {
    final List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(cantBeNull(lisp.replaceLast(l, box.box(10))).get(l.size() - 1), is(box.box(10)));
  }

  @Test public void testRest2() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    for (final Integer ¢ : lisp.rest2(l))
      azzert.that(¢, is(box.box(3)));
  }

  @Test public void testAreEqual1() {
    assert !lisp.areEqual(null);
  }

  @Test public void testAreEqual2() {
    assert lisp.areEqual(box.box(1), box.box(1));
  }

  @Test public void testAreEqual3() {
    assert !lisp.areEqual(box.box(1), box.box(2));
  }

  @Test public void testChopLastListOfT() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    azzert.that(lisp.chopLast(l).get(l.size() - 2), is(box.box(2)));
  }

  @Test public void testChopLastString() {
    azzert.that(lisp.chopLast("abc"), is("ab"));
  }

  @Test public void testRemoveFromList() {
    final List<Integer> l1 = new ArrayList<>();
    final List<Integer> l2 = new ArrayList<>();
    l1.add(box.box(1));
    l1.add(box.box(2));
    l1.add(box.box(3));
    l2.add(box.box(1));
    lisp.removeFromList(l2, l1);
    azzert.that(l1.get(0), is(box.box(2)));
  }

  @Test public void testRemoveLast() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    lisp.removeLast(l);
    azzert.that(l.get(l.size() - 1), is(box.box(2)));
  }

  @Test public void testSwap1() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.swap(l, 5, 5) == l;
  }

  @Test public void testSwap2() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.swap(l, 1, 5) == l;
  }

  @Test public void testSwap3() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    l.add(box.box(3));
    assert lisp.swap(l, 1, 1) == l;
  }
}
