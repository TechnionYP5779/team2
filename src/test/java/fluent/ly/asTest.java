package fluent.ly;

import static il.org.spartan.Utils.*;
import static org.junit.Assert.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

// No values in an 'enum' which serves as a name space for a collection of
// 'static' functions.
/** A static nested class hosting unit tests for the nesting class Unit test for
 * the containing class. Note the naming convention: a) names of test methods do
 * not use are not prefixed by "test". This prefix is redundant. b) test methods
 * begin with the name of the method they check.
 * @author Yossi Gil
 * @since 2014-05-31 */
@SuppressWarnings("static-method") public class asTest {
  @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), is(0));
  }

  @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), is(1));
  }

  @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    assertArrayEquals(is, as.intArray(as.ingeterList(is)));
  }

  @Test public void asListSimple() {
    // direct call `as.list(12, 13, 14)` kills Travis --or
    final @NotNull List<Integer> is = cantBeNull(as.list(new int @NotNull [] { 12, 13, 14 }));
    azzert.that(is.get(0), is(fluent.ly.box.it(12)));
    azzert.that(is.get(1), is(fluent.ly.box.it(13)));
    azzert.that(is.get(2), is(fluent.ly.box.it(14)));
    azzert.that(is.size(), is(3));
  }

  @Test public void stringOfNull() {
    azzert.that(as.string(null), is("null"));
  }

  @Test public void stringWhenToStringReturnsNull() {
    azzert.that(as.string(new Object() {
      @Override @Nullable public String toString() {
        return null;
      }
    }), is("null"));
  }

  @Test public void asIterableTest1() {
    final int[] res = new int[] { 1, 2, 3, 2, 4, 6, 3, 6, 9, 4, 8, 12, 5, 10, 15 };
    int i = 0;
    for (final Integer f : as.asIterable(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))))
      for (final Integer p : as.asIterable(cantBeNull(box(new int[] { 1, 2, 3 }))))
        azzert.that(unbox(cantBeNull(f)) * unbox(cantBeNull(p)), is(res[i++]));
  }

  @Test public void asIterableTest2() {
    final int[] res = new int[] { 1, 2, 3, 2, 4, 6, 3, 6, 9, 4, 8, 12, 5, 10, 15 };
    int i = 0;
    for (final Integer f : as.asIterable(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))))
      for (final Integer p : as.asIterable(cantBeNull(box(new int[] { 1, 2, 3 }))))
        azzert.that(unbox(cantBeNull(f)) * unbox(cantBeNull(p)), is(res[i++]));
  }

  @Test public void bitTrueTest() {
    azzert.that(as.bit(true), is(1));
  }

  @Test public void bitFalseTest() {
    azzert.zero(as.bit(false));
  }

  @Test public void bitNullTest() {
    azzert.zero(as.bit(null));
  }

  @Test public void bitIntTest() {
    azzert.that(as.bit(box(5)), is(1));
  }

  @Test public void bitFloatTest() {
    azzert.that(as.bit(box(0.05f)), is(1));
  }

  @Test public void listTest1() {
    azzert.that(as.ingeterList(-1, -2, -3), is(Arrays.asList(box(new int[] { -1, -2, -3 }))));
  }

  @Test public void listTest2() {
    azzert.that(as.ingeterList(1, 2, 3, 4, 5, 6), is(Arrays.asList(box(new int[] { 1, 2, 3, 4, 5, 6 }))));
  }

  @Test public void listTest3() {
    azzert.that(as.list("a", "abc", "test"), is(Arrays.asList(new String[] { "a", "abc", "test" })));
  }

  @Test public void listTest4() {
    azzert.that(as.list(box(new boolean[] { true, false, false, true, false, true })),
        is(Arrays.asList(box(new boolean[] { true, false, false, true, false, true }))));
  }

  @Test public void listTest5() {
    final ArrayList<Integer> al = new ArrayList<>();
    for (int ¢ = 0; ¢ < 10; ++¢)
      al.add(box(¢ + 1));
    final List<Integer> al_lst = as.list(al);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(al_lst.get(¢), is(¢ + 1));
  }

  @Test public void intArrayTest() {
    final int[] array1 = as.intArray(1, 2, 3, 4, 5, 6);
    for (int ¢ = 0; ¢ < 6; ++¢)
      azzert.that(array1[¢], is(¢ + 1));
    final int[] array2 = as.intArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(array2[¢], is(¢ + 1));
  }

  @Test public void intArrayTest1() {
    final int[] array = as.intArray(new ArrayList<>(Arrays.asList(box(new int[] { 10, 20, 30, 40, 50 }))));
    for (int ¢ = 10; ¢ < 6; ¢ += 10)
      azzert.that(array[¢], is(¢));
  }

  @Test public void iteratorTest1() {
    final Iterator<Integer> int_iter = as.iterator(box(new int[] { 1, 2, 3, 4, 5 }));
    for (int ¢ = 1; ¢ < 6; ++¢) {
      azzert.that(int_iter.next(), is(¢));
      azzert.that(int_iter.hasNext(), is(¢ != 5));
    }
  }

  @Test public void iteratorTest2() {
    final Iterator<Boolean> bool_iter = as.iterator(box(new boolean[] { true, false, true, false }));
    boolean b = true;
    for (int ¢ = 1; ¢ < 5; ++¢) {
      azzert.that(bool_iter.next(), is(b));
      b = !b;
      azzert.that(bool_iter.hasNext(), is(¢ != 4));
    }
  }

  @Test public void setTest1() {
    final Set<Integer> s = new HashSet<>();
    for (int ¢ = 1; ¢ < 6; ++¢)
      s.add(box(¢));
    azzert.that(s, is(as.set(box(1), box(1), box(2), box(2), box(3), box(3), box(4), box(4), box(5), box(5))));
  }

  @Test public void setTest2() {
    final Set<String> s2 = new HashSet<>();
    s2.add("abcdefg");
    s2.add("hijklmnop");
    s2.add("qrstuv");
    s2.add("wxyz");
    final Set<String> s = new LinkedHashSet<>(Arrays.asList(new String[] { "abcdefg", "hijklmnop", "qrstuv", "wxyz" }));
    azzert.assertSubset(s, cantBeNull(s2));
    azzert.assertSubset(cantBeNull(s2), s);
  }

  @Test public void setTest3() {
    final Set<Boolean> s3 = new HashSet<>();
    s3.add(box(true));
    s3.add(box(false));
    s3.add(box(true));
    s3.add(box(true));
    s3.add(box(false));
    s3.add(box(false));
    azzert.assertContains(cantBeNull(s3), box(true));
    azzert.assertContains(cantBeNull(s3), box(false));
  }

  @Test public void setTest4() {
    final Set<Boolean> s4 = new HashSet<>();
    s4.add(box(true));
    s4.add(box(true));
    s4.add(box(true));
    s4.add(box(true));
    azzert.assertContains(cantBeNull(s4), box(true));
    azzert.assertNotContains(cantBeNull(s4), box(false));
  }

  @Test public void setTest5() {
    final Set<Boolean> s5 = new HashSet<>();
    s5.add(box(false));
    s5.add(box(false));
    s5.add(box(false));
    azzert.assertContains(cantBeNull(s5), box(false));
    azzert.assertNotContains(cantBeNull(s5), box(true));
  }

  @Test public void stringsNullTest() {
    azzert.that(as.string(null), is("null"));
  }

  @Test public void stringTest1() {
    azzert.that(as.string(box(5)), is("5"));
  }

  @Test public void stringTest2() {
    final Integer x1 = box(10);
    azzert.that(as.string(x1), is(x1 + ""));
  }

  @Test public void stringTest3() {
    azzert.that(as.string(box(654.654f)), is("654.654"));
  }

  @Test public void stringTest4() {
    final Float y1 = box(0.44645f);
    azzert.that(as.string(y1), is(y1 + ""));
  }

  @Test public void stringTest5() {
    azzert.that(as.string(box(true)), is("true"));
  }

  @Test public void stringTest6() {
    final Boolean b1 = box(false);
    azzert.that(as.string(b1), is(b1 + ""));
  }

  @Test public void stringCharTest1() {
    azzert.that(as.string('a'), is("a"));
  }

  @Test public void stringCharTest2() {
    azzert.that(as.string('b'), is("b"));
  }

  @Test public void stringCharTest3() {
    azzert.that(as.string('c'), is("c"));
  }

  @Test public void stringCharTest4() {
    azzert.that(as.string('d'), is("d"));
  }

  @Test public void stringCharTest5() {
    azzert.that(as.string('e'), is("e"));
  }

  @Test public void stringCharTest6() {
    azzert.that(as.string('f'), is("f"));
  }

  @Test public void stringSignCharTest1() {
    azzert.that(as.string('+'), is("+"));
  }

  @Test public void stringSignCharTest2() {
    azzert.that(as.string('*'), is("*"));
  }

  @Test public void stringSignCharTest3() {
    azzert.that(as.string('_'), is("_"));
  }

  @Test public void stringSignCharTest4() {
    azzert.that(as.string('='), is("="));
  }

  @Test public void stringSignCharTest5() {
    azzert.that(as.string('\\'), is("\\"));
  }

  @Test public void stringSignCharTest6() {
    azzert.that(as.string('\n'), is("\n"));
  }

  @Test public void stringSignCharTest7() {
    azzert.that(as.string('\t'), is("\t"));
  }

  @Test public void stringNumCharTest1() {
    azzert.that(as.string('1'), is("1"));
  }

  @Test public void stringNumCharTest2() {
    azzert.that(as.string('2'), is("2"));
  }

  @Test public void stringNumCharTest3() {
    azzert.that(as.string('3'), is("3"));
  }

  @Test public void stringNumCharTest4() {
    azzert.that(as.string('4'), is("4"));
  }

  @Test public void stringNumCharTest5() {
    azzert.that(as.string('5'), is("5"));
  }

  @Test public void stringNullInputTest() {
    azzert.that(as.string(null), is("null"));
  }

  @Test public void stringStrTest1() {
    azzert.that(as.string("abc"), is("abc"));
  }

  @Test public void stringStrTest2() {
    azzert.that(as.string("abc"), is("abc"));
  }

  @Test public void stringStrTest3() {
    azzert.that(as.string("supercalifragilisticexpialidocious"), is("supercalifragilisticexpialidocious"));
  }

  @Test public void stringsStrTest1() {
    azzert.zero(as.strings(null).length);
  }

  @Test public void stringsTest2() {
    azzert.zero(as.strings(new ArrayList<>()).length);
  }

  @Test public void stringsTest3() {
    final ArrayList<Integer> al = new ArrayList<>();
    azzert.that(as.strings(al).length, is(0));
    for (int ¢ = 0; ¢ < 10; ++¢)
      al.add(box(¢ + 1));
    final String[] intarr = as.strings(al);
    for (int ¢ = 0; ¢ < 10; ++¢)
      azzert.that(intarr[¢], is(¢ + 1 + ""));
  }

  @Test public void stringsTest4() {
    final ArrayList<String> al1 = new ArrayList<>();
    al1.add("abcd");
    al1.add("efg");
    al1.add("hijklmonp");
    al1.add("qrstuv");
    al1.add("wxyz");
    al1.add("+_-*/\n\t");
    azzert.that(al1, is(Arrays.asList(new String[] { "abcd", "efg", "hijklmonp", "qrstuv", "wxyz", "+_-*/\n\t" })));
  }

  @Test public void asIterableLambdaTest() {
    final Iterable<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 })));
    assert iter.iterator().hasNext();
    azzert.that(iter.iterator().next(), is(1));
  }

  @Test public void asIterableEssenceTest() {
    final Iterable<Integer> iter = as.asIterableEssence(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 })));
    assert iter.iterator().hasNext();
  }

  @Test public void asIterableLambdaTest2() {
    final Iterator<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))).iterator();
    azzert.that(iter.next(), is(1));
  }

  @Test public void asIterableLambdaTest3() {
    final Iterator<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))).iterator();
    iter.next();
    assert iter.hasNext();
  }

  @Test public void asIterableLambdaTest4() {
    final Iterator<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))).iterator();
    iter.next();
    azzert.that(iter.next(), is(2));
  }

  @Test public void asIterableLambdaTest5() {
    final Iterator<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))).iterator();
    iter.next();
    iter.next();
    assert iter.hasNext();
  }

  @Test public void asIterableLambdaTest6() {
    final Iterator<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))).iterator();
    iter.next();
    iter.next();
    azzert.that(iter.next(), is(3));
  }

  @Test public void asIterableLambdaTest7() {
    final Iterator<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))).iterator();
    iter.next();
    iter.next();
    iter.next();
    assert iter.hasNext();
  }

  @Test public void asIterableLambdaTest8() {
    final Iterator<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))).iterator();
    iter.next();
    iter.next();
    iter.next();
    azzert.that(iter.next(), is(4));
  }

  @Test public void asIterableLambdaTest9() {
    final Iterator<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))).iterator();
    iter.next();
    iter.next();
    iter.next();
    iter.next();
    assert iter.hasNext();
  }

  @Test public void asIterableLambdaTest10() {
    final Iterator<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))).iterator();
    iter.next();
    iter.next();
    iter.next();
    iter.next();
    azzert.that(iter.next(), is(5));
  }

  @Test public void asIterableLambdaTest11() {
    final Iterator<Integer> iter = as.asIterableLambda(cantBeNull(box(new int[] { 1, 2, 3, 4, 5 }))).iterator();
    iter.next();
    iter.next();
    iter.next();
    iter.next();
    iter.next();
    assert !iter.hasNext();
  }

  @Test public void arrayTest() {
    final Integer[] array = as.array(box(new int[] { 1, 2, 3, 4, 5 }));
    for (int ¢ = 0; ¢ < 5; ++¢)
      azzert.that(array[¢], is(¢ + 1));
  }
}