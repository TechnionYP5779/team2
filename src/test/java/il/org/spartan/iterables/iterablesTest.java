package il.org.spartan.iterables;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

import an.*;
import fluent.ly.*;

//
/** A static nested class hosting unit tests for the nesting class Unit test for
 * the containing class. Note the naming convention: a) names of test methods do
 * not use are not prefixed by "test". This prefix is redundant. b) test methods
 * begin with the name of the method they check.
 * @author Yossi Gil
 * @since 2014-05-31 */
@SuppressWarnings("static-method") public class iterablesTest {
  @Test public void containsDegenerate() {
    azzert.nay(contains("Hello"));
  }

  @Test public void containseturnsFalseTypical() {
    azzert.nay(contains("Hello", null, "x", "y", null, "z", "w", "u", "v"));
  }

  @Test public void containsSimple() {
    azzert.aye("", contains("Hello", "e"));
  }

  @Test public void containsTypical() {
    azzert.aye("", contains("Hello", "a", "b", "c", "d", "e", "f"));
  }

  @Test public void containsWithNulls() {
    azzert.aye("", contains("Hello", null, "a", "b", null, "c", "d", "e", "f", null));
  }

  @Test public void countDoesNotIncludeNull() {
    azzert.that(3, is(iterables.count(iterable.over(null, "One", null, "Two", null, "Three"))));
  }

  @Test public void countEmpty() {
    azzert.that(0, is(iterables.count(iterables.<String> empty())));
  }

  @Test public void countSingleton() {
    azzert.that(1, is(iterables.count(iterable.singleton(new Object()))));
  }

  @Test public void countThree() {
    azzert.that(3, is(iterables.count(iterable.over("One", "Two", "Three"))));
  }

  @Test public void singletonIteratorTest1() {
    assert iterables.singletonIterator(box(10)).hasNext();
  }

  @Test public void singletonIteratorTest2() {
    azzert.that(iterables.singletonIterator(box(10)).next(), is(10));
  }

  @Test public void singletonIteratorTest3() {
    final Iterator<Integer> iter = iterables.singletonIterator(box(10));
    iter.next();
    assert !iter.hasNext();
  }

  @Test public void isEmptyTestFalse() {
    assert !iterables.isEmpty(iterable.over("nope"));
  }

  @Test public void isEmptyTestTrue() {
    assert iterables.isEmpty(iterable.over());
  }

  public static class Alternate {
    @Test public void alternateTest1() {
      azzert.isNull(iterables.alternate(null, null));
    }

    @Test public void alternateTest2() {
      final Iterable<Integer> it1 = iterable.over(box(new int[] { 1, 2, 3, 4, 5 }));
      azzert.that(iterables.alternate(it1, null), is(it1));
    }

    @Test public void alternateTest3() {
      final Iterable<Integer> it2 = iterable.over(box(new int[] { 1, 2, 3, 4, 5 }));
      azzert.that(iterables.alternate(null, it2), is(it2));
    }

    @Test public void alternateTest4() {
      assert iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 }))).iterator().hasNext();
    }

    @Test public void alternateTest5() {
      azzert.that(iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 }))).iterator().next(), is(1));
    }

    @Test public void alternateTest6() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest7() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      azzert.that(iter.next(), is(2));
    }

    @Test public void alternateTest8() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest9() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      iter.next();
      azzert.that(iter.next(), is(3));
    }

    @Test public void alternateTest10() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      iter.next();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest11() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      iter.next();
      iter.next();
      azzert.that(iter.next(), is(4));
    }

    @Test public void alternateTest12() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest13() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      azzert.that(iter.next(), is(5));
    }

    @Test public void alternateTest14() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest15() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      azzert.that(iter.next(), is(6));
    }

    @Test public void alternateTest16() {
      final Iterator<Integer> iter = iterables.alternate(iterable.over(box(new int[] { 1, 3, 5 })), iterable.over(box(new int[] { 2, 4, 6 })))
          .iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      assert !iter.hasNext();
    }

    @Test public void alternateTest17() {
      assert iterables.alternate(iterable.over(new String[] { "hello" }), iterable.over(new String[] { "world!" })).iterator().hasNext();
    }

    @Test public void alternateTest18() {
      azzert.that(iterables.alternate(iterable.over(new String[] { "hello" }), iterable.over(new String[] { "world!" })).iterator().next(),
          is("hello"));
    }

    @Test public void alternateTest19() {
      final Iterator<String> iter = iterables.alternate(iterable.over(new String[] { "hello" }), iterable.over(new String[] { "world!" })).iterator();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest20() {
      final Iterator<String> iter = iterables.alternate(iterable.over(new String[] { "hello" }), iterable.over(new String[] { "world!" })).iterator();
      iter.next();
      azzert.that(iter.next(), is("world!"));
    }

    @Test public void alternateTest21() {
      final Iterator<String> iter = iterables.alternate(iterable.over(new String[] { "hello" }), iterable.over(new String[] { "world!" })).iterator();
      iter.next();
      iter.next();
      assert !iter.hasNext();
    }

    @Test public void alternateTest22() {
      final Iterator<String> iter = iterables
          .alternate(iterable.over(new String[] { "hello", "bla", "wawa" }), iterable.over(new String[] { "world!" })).iterator();
      iter.next();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest23() {
      final Iterator<String> iter = iterables
          .alternate(iterable.over(new String[] { "hello", "bla", "wawa" }), iterable.over(new String[] { "world!" })).iterator();
      iter.next();
      iter.next();
      azzert.that(iter.next(), is("bla"));
    }

    @Test public void alternateTest24() {
      final Iterator<String> iter = iterables
          .alternate(iterable.over(new String[] { "hello", "bla", "wawa" }), iterable.over(new String[] { "world!" })).iterator();
      iter.next();
      iter.next();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest25() {
      final Iterator<String> iter = iterables
          .alternate(iterable.over(new String[] { "hello", "bla", "wawa" }), iterable.over(new String[] { "world!" })).iterator();
      iter.next();
      iter.next();
      iter.next();
      azzert.that(iter.next(), is("wawa"));
    }

    @Test public void alternateTest26() {
      final Iterator<String> iter = iterables
          .alternate(iterable.over(new String[] { "hello" }), iterable.over(new String[] { "world!", "bla", "wawa" })).iterator();
      iter.next();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest27() {
      final Iterator<String> iter = iterables
          .alternate(iterable.over(new String[] { "hello" }), iterable.over(new String[] { "world!", "bla", "wawa" })).iterator();
      iter.next();
      iter.next();
      azzert.that(iter.next(), is("bla"));
    }

    @Test public void alternateTest28() {
      final Iterator<String> iter = iterables
          .alternate(iterable.over(new String[] { "hello" }), iterable.over(new String[] { "world!", "bla", "wawa" })).iterator();
      iter.next();
      iter.next();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest29() {
      final Iterator<String> iter = iterables
          .alternate(iterable.over(new String[] { "hello" }), iterable.over(new String[] { "world!", "bla", "wawa" })).iterator();
      iter.next();
      iter.next();
      iter.next();
      azzert.that(iter.next(), is("wawa"));
    }

    @Test public void alternateTest30() {
      final Iterator<String> iter = iterables
          .alternate(iterable.over(new String[] { "hello" }), iterable.over(new String[] { "world!", "bla", "wawa" })).iterator();
      iter.next();
      iter.next();
      iter.next();
      iter.next();
      assert !iter.hasNext();
    }

    @Test public void alternateTest31() {
      azzert.that(iterables.alternate(iterables.alternate(iterable.over(new String[] { "A" }), iterable.over(new String[] { "C" })),
          iterable.over(new String[] { "B" })).iterator().next(), is("A"));
    }

    @Test public void alternateTest32() {
      final Iterator<String> iter = iterables.alternate(iterables.alternate(iterable.over(new String[] { "A" }), iterable.over(new String[] { "C" })),
          iterable.over(new String[] { "B" })).iterator();
      iter.next();
      azzert.that(iter.next(), is("B"));
    }

    @Test public void alternateTest33() {
      final Iterator<String> iter = iterables.alternate(iterables.alternate(iterable.over(new String[] { "A" }), iterable.over(new String[] { "C" })),
          iterable.over(new String[] { "B" })).iterator();
      iter.next();
      iter.next();
      azzert.that(iter.next(), is("C"));
    }

    @Test public void alternateTest34() {
      assert iterables.alternate(iterable.over(new String[] {}), iterable.over(new String[] { "A", "B" })).iterator().hasNext();
    }

    @Test public void alternateTest35() {
      azzert.that(iterables.alternate(iterable.over(new String[] {}), iterable.over(new String[] { "A", "B" })).iterator().next(), is("A"));
    }

    @Test public void alternateTest36() {
      final Iterator<String> iter = iterables.alternate(iterable.over(new String[] {}), iterable.over(new String[] { "A", "B" })).iterator();
      iter.next();
      assert iter.hasNext();
    }

    @Test public void alternateTest37() {
      final Iterator<String> iter = iterables.alternate(iterable.over(new String[] {}), iterable.over(new String[] { "A", "B" })).iterator();
      iter.next();
      azzert.that(iter.next(), is("B"));
    }

    @Test public void alternateTest38() {
      final Iterator<String> iter = iterables.alternate(iterable.over(new String[] {}), iterable.over(new String[] { "A", "B" })).iterator();
      iter.next();
      iter.next();
      assert !iter.hasNext();
    }
  }
}