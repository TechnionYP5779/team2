package fluent.ly;


import java.util.*;

import org.eclipse.jdt.annotation.*;
import org.junit.*;

import an.*;
import il.org.spartan.*;
import static fluent.ly.azzert.*;
@SuppressWarnings("static-method") public class theTest {
  @Test public void testIndex1() {
    azzert.zero(the.index(0, 0, 2, 3));
  }

  @Test public void testIndex2() {
    azzert.that(the.index(4, 1, 2, 3),is(-1));
  }

  @Test public void testNil() {
    azzert.isNull(the.nil());
  }

  @Test public void testNthIntCollectionOfQ() {
    azzert.that(the.nth(4, new ArrayList<Integer>()),is(new String(" #4/0")));
  }

  @Test public void testNthIntInt() {
    azzert.that(the.nth(4, 2),is(new String(" #4/2")));
  }
  
  @Test public void testNthStringString() {
    azzert.that(the.nth("abc", "def"),is(new String(" #abc/def")));
  }

  @Test public void testPenultimateOf1() {
    azzert.isNull(the.penultimateOf(null));
  }

  @Test public void testPenultimateOf2() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    azzert.isNull(the.penultimateOf(l));
  }

  @SuppressWarnings("null") @Test public void testPenultimateOf3() {
    List<@Nullable Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(4));
    azzert.that(Utils.cantBeNull(the.penultimateOf(l)),is(box.box(5)));
  }

  @Test public void testPrevious1() {
    azzert.isNull(the.previous(box.box(3), null));
  }

  @Test public void testPrevious2() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    azzert.isNull(the.previous(box.box(3), l));
  }

  @SuppressWarnings("null") @Test public void testPrevious3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(3));
    l.add(box.box(4));
    azzert.that(Utils.cantBeNull(the.previous(box.box(4), l)),is(box.box(3)));
  }

  @Test public void testTailOfListOfT() {
    List<Integer> l = null;
    azzert.assertZero(the.tailOf(l).size());
  }

  @Test public void testTailOfString() {
    String s = new String("abc");
    azzert.that(the.tailOf(s),is("bc"));
  }

  @Test public void testRestTIterableOfT1() {
    List<Integer> l = new ArrayList<>();
    Integer i = box.box(2);
    l.add(i);
    l.add(box.box(4));
    azzert.that(the.rest(i,l).get(0),is(box.box(4)));
  }
  
  @Test public void testRestTIterableOfT2() {
    List<Integer> l = new ArrayList<>();
    Integer i = box.box(2);
    l.add(box.box(4));
    azzert.assertZero(the.rest(i,l).size());
  }

  @Test public void testHeadOf1() {
    azzert.isNull(the.headOf(null));
  }

  @Test public void testHeadOf2() {
    azzert.isNull(the.penultimateOf(empty.list()));
  }

  @SuppressWarnings("null") @Test public void testHeadOf3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(4));
    azzert.that(Utils.cantBeNull(the.headOf(l)),is(box.box(5)));
  }
  @Test public void testCharacterOf() {
    azzert.that(the.characterOf("abc"),is('c'));
  }

  @Test public void testIth() {
    azzert.that(the.ith("abc", 1),is('b'));
  }

  @Test public void testLastOfListOfT1() {
    List<Integer> l = null;
    azzert.isNull(the.lastOf(l));
  }

  @SuppressWarnings("null") @Test public void testLastOfListOfT2() {
    @Nullable List<@Nullable Integer> l = new ArrayList<>();
    azzert.isNull(the.lastOf(l));
  }

  @SuppressWarnings("null") @Test public void testLastOfListOfT3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(4));
    azzert.that(Utils.cantBeNull(the.lastOf(l)),is(box.box(4)));
  }

  @Test public void testLastOfString() {
    azzert.that(the.lastOf("abc"),is('c'));
  }

  @Test public void testBeforeLastOf() {
    azzert.that(the.beforeLastOf("abc", 0),is('c'));
  }

  @Test public void testLastOfIterableOfT() {
    List<Integer> t = new ArrayList<>();
    t.add(box.box(1));
    t.add(box.box(1));
    Iterable<Integer> l = new ArrayList<>(t);
    Iterator<Integer> iter = the.lastOf(l).iterator();
    while(iter.hasNext()) {
      azzert.that(iter.next(),is(box.box(1)));
    }
    
  }

  @Test public void testOnlyOneOf1() {
    azzert.isNull(the.onlyOneOf(null));
  }
  
  @Test public void testOnlyOneOf2() {
    azzert.isNull(the.onlyOneOf(empty.list()));
  }
  
  @SuppressWarnings("null") @Test public void testOnlyOneOf3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    azzert.that(Utils.cantBeNull(the.onlyOneOf(l)),is(box.box(1)));
  }

  @Test public void testSecondOf1() {
    azzert.isNull(the.secondOf(null));
  }
  
  @Test public void testSecondOf2() {
    azzert.isNull(the.secondOf(empty.list()));
  }
  
  @SuppressWarnings("null") @Test public void testSecondOf3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    azzert.that(Utils.cantBeNull(the.secondOf(l)),is(box.box(2)));
  }

  @Test public void testMax() {
    azzert.that(the.max(1, 3,2),azzert.is(3));
  }

  @Test public void testMin() {
    azzert.that(the.min(1, 3,2),azzert.is(1));
  }

  @SuppressWarnings("null") @Test public void testLastOfTArray() {
    @Nullable Integer[] arr = {box.box(1)};
    azzert.that(the.lastOf(arr),azzert.is(box.box(1)));
  }


  @Test public void testSqr() {
    azzert.that(the.sqr(2),azzert.is(4));
  }


  @Test public void testTailOfTArray() {
    Integer[] arr = {box.box(1),box.box(2)};
    azzert.that(the.tailOf(arr)[0],is(box.box(2)));
  }

}
