package fluent.ly;


import java.util.*;

import org.eclipse.jdt.annotation.*;
import org.junit.*;

import an.*;
import il.org.spartan.*;

@SuppressWarnings("static-method") public class theTest {
  @Test public void testIndex1() {
    azzert.zero(the.index(0, 0, 2, 3));
  }

  @Test public void testIndex2() {
    assert the.index(4, 1, 2, 3) == -1;
  }

  @Test public void testNil() {
    azzert.isNull(the.nil());
  }

  @Test public void testNthIntCollectionOfQ() {
    assert the.nth(4, new ArrayList<Integer>()).equals(new String(" #4/0"));
  }

  @Test public void testNthIntInt() {
    assert the.nth(4, 2).equals(new String(" #4/2"));
  }

  @Test public void testNthStringString() {
    assert the.nth("abc", "def").equals(new String(" #abc/def"));
  }

  @Test public void testPenultimateOf1() {
    azzert.isNull(the.penultimateOf(null));
  }

  @Test public void testPenultimateOf2() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    azzert.isNull(the.penultimateOf(l));
  }

  @Test public void testPenultimateOf3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(4));
    assert Utils.cantBeNull(the.penultimateOf(l)).equals(box.box(5));
  }

  @Test public void testPrevious1() {
    azzert.isNull(the.previous(box.box(3), null));
  }

  @Test public void testPrevious2() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    azzert.isNull(the.previous(box.box(3), l));
  }

  @Test public void testPrevious3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(3));
    l.add(box.box(4));
    assert Utils.cantBeNull(the.previous(box.box(4), l)).equals(box.box(3));
  }

  @Test public void testTailOfListOfT() {
    List<Integer> l = null;
    azzert.assertZero(the.tailOf(l).size());
  }

  @Test public void testTailOfString() {
    String s = new String("abc");
    assert the.tailOf(s).equals("bc");
  }

  @Test public void testRestTIterableOfT1() {
    List<Integer> l = new ArrayList<>();
    Integer i = box.box(2);
    l.add(i);
    l.add(box.box(4));
    assert the.rest(i,l).get(0).equals(box.box(4));
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

  @Test public void testHeadOf3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(5));
    l.add(box.box(4));
    assert Utils.cantBeNull(the.headOf(l)).equals(box.box(5));
  }
  @Test public void testCharacterOf() {
    assert the.characterOf("abc") == 'c';
  }

  @Test public void testIth() {
   assert the.ith("abc", 1) == 'b';
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
    assert Utils.cantBeNull(the.lastOf(l)).equals(box.box(4));
  }

  @Test public void testLastOfString() {
    assert the.lastOf("abc") == 'c';
  }

  @Test public void testBeforeLastOf() {
    assert the.beforeLastOf("abc", 0) == 'c';
  }

//  @Test public void testLastOfIterableOfT() {
//    
//  }

  @Test public void testOnlyOneOf1() {
    azzert.isNull(the.onlyOneOf(null));
  }
  
  @Test public void testOnlyOneOf2() {
    azzert.isNull(the.onlyOneOf(empty.list()));
  }
  
  @Test public void testOnlyOneOf3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    assert Utils.cantBeNull(the.onlyOneOf(l)).equals(box.box(1));
  }

  @Test public void testSecondOf1() {
    azzert.isNull(the.secondOf(null));
  }
  
  @Test public void testSecondOf2() {
    azzert.isNull(the.secondOf(empty.list()));
  }
  
  @Test public void testSecondOf3() {
    List<Integer> l = new ArrayList<>();
    l.add(box.box(1));
    l.add(box.box(2));
    assert Utils.cantBeNull(the.secondOf(l)).equals(box.box(2));
  }

//  @Test public void testMax() {
//    fail("Not yet implemented");
//  }
//
//  @Test public void testMin() {
//    fail("Not yet implemented");
//  }

  @Test public void testLastOfTArray() {
    Integer[] arr = {box.box(1)};
    assert the.lastOf(arr).equals(box.box(1));
  }

//  @Test public void testLast() {
//    fail("Not yet implemented");
//  }

  @Test public void testSqr() {
    assert the.sqr(2)==4;
  }

//  @Test public void testRestString() {
//    fail("Not yet implemented");
//  }
//
//  @Test public void testTailOfTArray() {
//    fail("Not yet implemented");
//  }
}
