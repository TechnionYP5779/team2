package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.eclipse.jdt.annotation.*;
import org.junit.*;

import an.*;
import static il.org.spartan.Utils.*;

@SuppressWarnings("static-method") public class theTest {
  @Test public void testIndex1() {
    azzert.zero(the.index(0, 0, 2, 3));
  }

  @Test public void testIndex2() {
    azzert.that(the.index(4, 1, 2, 3), is(-1));
  }

  @Test public void testNil() {
    azzert.isNull(the.nil());
  }

  @Test public void testNthIntCollectionOfQ() {
    azzert.that(the.nth(4, new ArrayList<Integer>()), is(String.valueOf(" #4/0")));
  }

  @Test public void testNthIntInt() {
    azzert.that(the.nth(4, 2), is(String.valueOf(" #4/2")));
  }

  @Test public void testNthStringString() {
    azzert.that(the.nth("abc", "def"), is(String.valueOf(" #abc/def")));
  }

  @Test public void testPenultimateOf1() {
    azzert.isNull(the.penultimateOf(null));
  }

  @Test public void testPenultimateOf2() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    azzert.isNull(the.penultimateOf(l));
  }

  @Test @SuppressWarnings("null") public void testPenultimateOf3() {
    final List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(4));
    azzert.that(cantBeNull(the.penultimateOf(l)), is(box.box(5)));
  }

  @Test public void testPrevious1() {
    azzert.isNull(the.previous(box.box(3), null));
  }

  @Test public void testPrevious2() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    azzert.isNull(the.previous(box.box(3), l));
  }

  @Test @SuppressWarnings("null") public void testPrevious3() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(3));
    l.add(box.box(4));
    azzert.that(cantBeNull(the.previous(box.box(4), l)), is(box.box(3)));
  }

  @Test public void testTailOfListOfT() {
    azzert.assertZero(the.tailOf((List<Integer>) null).size());
  }

  @Test public void testTailOfString() {
    azzert.that(the.tailOf(cantBeNull(String.valueOf("abc"))), is("bc"));
  }

  @Test public void testRestTIterableOfT1() {
    final List<Integer> l = new ArrayList<>();
    final Integer i = box.box(2);
    l.add(i);
    l.add(box.box(4));
    azzert.that(the.rest(i, l).get(0), is(box.box(4)));
  }

  @Test public void testRestTIterableOfT2() {
    final List<Integer> l = new ArrayList<>();
    final Integer i = box.box(2);
    l.add(box.box(4));
    azzert.assertZero(the.rest(i, l).size());
  }

  @Test public void testHeadOf1() {
    azzert.isNull(the.headOf(null));
  }

  @Test public void testHeadOf2() {
    azzert.isNull(the.penultimateOf(empty.list()));
  }

  @Test @SuppressWarnings("null") public void testHeadOf3() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(4));
    azzert.that(cantBeNull(the.headOf(l)), is(box.box(5)));
  }

  @Test public void testCharacterOf() {
    azzert.that(the.characterOf("abc"), is('c'));
  }

  @Test public void testIth() {
    azzert.that(the.ith("abc", 1), is('b'));
  }

  @Test public void testLastOfListOfT1() {
    azzert.isNull(the.lastOf((List<Integer>) null));
  }

  @Test @SuppressWarnings("null") public void testLastOfListOfT2() {
    azzert.isNull(the.lastOf(new ArrayList<>()));
  }

  @Test @SuppressWarnings("null") public void testLastOfListOfT3() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(4));
    azzert.that(cantBeNull(the.lastOf(l)), is(box.box(4)));
  }

  @Test public void testLastOfString() {
    azzert.that(the.lastOf("abc"), is('c'));
  }

  @Test public void testBeforeLastOf() {
    azzert.that(the.beforeLastOf("abc", 0), is('c'));
  }

  @Test public void testLastOfIterableOfT() {
    final List<Integer> t = new ArrayList<>();
    t.add(box.box(1));
    t.add(box.box(1));
    for (final Integer ¢ : the.lastOf((Iterable<Integer>) new ArrayList<>(t)))
      azzert.that(¢, is(box.box(1)));
  }

  @Test public void testOnlyOneOf1() {
    azzert.isNull(the.onlyOneOf(null));
  }

  @Test public void testOnlyOneOf2() {
    azzert.isNull(the.onlyOneOf(empty.list()));
  }

  @Test @SuppressWarnings("null") public void testOnlyOneOf3() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    azzert.that(cantBeNull(the.onlyOneOf(l)), is(box.box(1)));
  }

  @Test public void testSecondOf1() {
    azzert.isNull(the.secondOf(null));
  }

  @Test public void testSecondOf2() {
    azzert.isNull(the.secondOf(empty.list()));
  }

  @Test @SuppressWarnings("null") public void testSecondOf3() {
    final List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    azzert.that(cantBeNull(the.secondOf(l)), is(box.box(2)));
  }

  @Test public void testMax() {
    azzert.that(the.max(1, 3, 2), is(3));
  }

  @Test public void testMin() {
    azzert.that(the.min(1, 3, 2), is(1));
  }

  @Test @SuppressWarnings("null") public void testLastOfTArray() {
    azzert.that(the.lastOf(new Integer[] { box.box(1) }), is(box.box(1)));
  }

  @Test public void testSqr() {
    azzert.that(the.sqr(2), is(4));
  }

  @Test public void testTailOfTArray() {
    azzert.that(the.tailOf(new Integer[] { box.box(1), box.box(2) })[0], is(box.box(2)));
  }
}
