package il.org.spartan;

import static il.org.spartan.Utils.*;
import static org.junit.Assert.*;

import static fluent.ly.azzert.*;
import static fluent.ly.azzert.assertNotEquals;
import static fluent.ly.box.*;

import java.io.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.Utils.FoundHandleForT.*;
import il.org.spartan.etc.*;

@SuppressWarnings("static-method") public class UtilsTest {
  @Test public void addIterableWithoutNulls() {
    final Collection<Integer> c = new ArrayList<>();
    @NotNull final Collection<Integer> i = cantBeNull(Arrays.asList(box(new int[] { 1, 2, 3, 4, 5, 6, 7 })));
    assertNotEquals(c, i);
    assert add(c, i) == c;
    assertCollectionsEqual(c, i);
  }

  @Test public void addIterableWithNulls() {
    final Collection<Integer> c = new LinkedList<>(), i = new LinkedList<>();
    i.add(null);
    i.add(box(1));
    assertNotEquals(c, i);
    assert add(c, i) == c;
    assertContains(c, box(1));
    assertNotContains(c, null);
  }

  @Test public void addArrayWithoutNulls() {
    final Collection<Integer> c = new ArrayList<>();
    final Integer[] a = box(new int[] { 1, 2, 3, 4, 5, 6, 7 });
    assertNotEquals(c, Arrays.asList(a));
    assert add(c, cantBeNull(a)) == c;
    assertCollectionsEqual(c, cantBeNull(Arrays.asList(a)));
  }

  @Test @SuppressWarnings("null") public void addArrayWithNulls() {
    final Collection<Integer> c = cantBeNull(new ArrayList<>());
    final Integer[] a = box(new int[] { 1, 2 });
    a[1] = null;
    azzert.assertNotEquals(c, Arrays.asList(a));
    assert add(c, a) == c;
    azzert.assertCollectionsEqual(c, box(new int[] { 1 }));
  }

  @Test public void addAllCollectionWithoutNulls() {
    final Collection<Integer> c = new ArrayList<>(), c1 = Arrays.asList(box(new int[] { 1 })), c2 = Arrays.asList(box(new int[] { 2 })),
        c12 = cantBeNull(Arrays.asList(box(new int[] { 1, 2 })));
    assertNotEquals(c, c12);
    assert addAll(c, c1, c2) == c;
    assertCollectionsEqual(c, c12);
  }

  @Test public void addAllCollectionWithNulls() {
    final Collection<Integer> c = new ArrayList<>(), c1 = Arrays.asList(box(new int[] { 1 })), c2 = Arrays.asList(box(new int[] { 2 })),
        c12 = cantBeNull(Arrays.asList(box(new int[] { 1, 2 })));
    assertNotEquals(c, c12);
    assert addAll(c, c1, null, c2) == c;
    assertCollectionsEqual(c, c12);
  }

  @Test public void addAllIterableWithoutNulls() {
    final Collection<Integer> c = new ArrayList<>();
    final Iterable<Integer> i1 = Arrays.asList(box(new int[] { 1 })), i2 = Arrays.asList(box(new int[] { 2 }));
    final Collection<Integer> c12 = cantBeNull(Arrays.asList(box(new int[] { 1, 2 })));
    assertNotEquals(c, c12);
    assert addAll(c, i1, i2) == c;
    assertCollectionsEqual(c, c12);
  }

  @Test public void addAllIterableWithNulls() {
    final Collection<Integer> c = new ArrayList<>();
    final Iterable<Integer> i1 = Arrays.asList(box(new int[] { 1 })), i2 = Arrays.asList(box(new int[] { 2 }));
    final Collection<Integer> c12 = cantBeNull(Arrays.asList(box(new int[] { 1, 2 })));
    assertNotEquals(c, c12);
    assert addAll(c, i1, null, i2) == c;
    assertCollectionsEqual(c, c12);
  }

  @Test public void addAllArrayWithoutNulls() {
    final Collection<Integer> c = new ArrayList<>();
    final Integer[] a = box(new int[] { 1 });
    assertNotEquals(c, Arrays.asList(a));
    assert addAll(c, a) == c;
    assertCollectionsEqual(c, cantBeNull(Arrays.asList(a)));
  }

  @Test public void addAllArrayWithNulls() {
    final Collection<Integer> c = new ArrayList<>();
    final Integer[] a = new Integer[] { box(1), null };
    final Collection<Integer> c1 = cantBeNull(Arrays.asList(box(new int[] { 1 })));
    assertNotEquals(c, c1);
    assert addAll(c, a) == c;
    assertCollectionsEqual(c, c1);
  }

  @Test public void appendTest() {
    azzert.that(append(box(new int[] { 0, 1 }), box(2)), is(box(new int[] { 0, 1, 2 })));
  }

  @Test @SuppressWarnings("null") public void applyTest() {
    azzert.that(apply((final Integer i) -> i).to(new Integer[] { box(1), null, box(2) }), is(Arrays.asList(box(1), box(2))));
  }

  @Test public void canBeNullTest() {
    azzert.that(canBeNull(box(1)), is(box(1)));
    azzert.isNull(canBeNull(null));
  }

  @Test public void testCantBeNullWithNotNull() {
    azzert.that(canBeNull(box(1)), is(box(1)));
  }

  @Test(expected = AssertionError.class) public void testCantBeNullWithNull() {
    forget.it(cantBeNull(null));
  }

  @Test public void compareTest() {
    azzert.that(compare(false, false), is(0));
    azzert.that(compare(false, true), is(-1));
    azzert.that(compare(true, false), is(1));
    azzert.that(compare(true, true), is(0));
  }

  @Test public void compressSpacesTest() {
    azzert.that(compressSpaces("some \n \n \n       string\n  a   +   -   b    \n ==  <  <=   |"), is("some string a+-b==<<=|"));
  }

  @Test public void containsTest() {
    assert !contains("some string +-+-", "*", "1", null, "-+-+");
    assert contains("some string +-+-", "*", "1", null, "-+-+", "me s");
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class) public void deleteOutOfBoundsTest() {
    delete(box(new int[] { 0, 1, 2, 3, 4, 5 }), 6);
  }

  @Test public void deleteTest() {
    azzert.that(delete(box(new int[] { 0, 1, 2 }), 0), is(box(new int[] { 1, 2 })));
    azzert.that(delete(box(new int[] { 0, 1, 2 }), 1), is(box(new int[] { 0, 2 })));
    azzert.that(delete(box(new int[] { 0, 1, 2 }), 2), is(box(new int[] { 0, 1 })));
  }

  @Test public void foundInt() {
    final FoundHandleForInt h = found(5);
    assert !h.in();
    assert !h.in(1, 2, 3, 4, 6);
    assert h.in(1, 2, 3, 4, 5, 6);
  }

  @Test @SuppressWarnings("null") public void foundT() {
    final FoundHandleForT<Integer> h = found(box(5));
    assert !h.in();
    assert !h.in(new Integer[] { box(1), null, box(2) });
    assert !h.in(box(new int[] { 1, 2, 3, 4, 6 }));
    assert h.in(box(new int[] { 1, 2, 3, 4, 5, 6 }));
  }

  @Test public void hasNullTest() {
    assert !hasNull();
    assert !hasNull(box(1), box(2));
    assert hasNull((Object) null);
    assert hasNull(box(1), null, box(2));
  }

  @Test @SuppressWarnings("null") public void inTest() {
    assert !in((Object) null);
    final Object[] a = new Object[] { box(1), box(true), null };
    assert !in((Object) null, a);
    assert !in(box(false), a);
    assert in(box(true), a);
  }

  @Test public void inRangeTest() {
    assert !inRange(0, new ArrayList<Integer>());
    assert !inRange(1, Arrays.asList(box(1)));
    assert !inRange(-1, Arrays.asList(box(1)));
    assert inRange(0, Arrays.asList(box(1)));
  }

  @Test public void lastInTest() {
    assert lastIn(null, Arrays.asList());
    assert !lastIn(null, Arrays.asList(box(1)));
    assert !lastIn(box(1), Arrays.asList(box(1), box(2)));
    assert !lastIn(box(3), Arrays.asList(box(1), box(2)));
    assert lastIn(box(2), Arrays.asList(box(1), box(2)));
  }

  @Test(expected = AssertionError.class) public void mustBeNullWithNotNull() {
    mustBeNull(box(1));
  }

  @Test public void mustBeNullWithNull() {
    azzert.isNull(mustBeNull(null));
  }

  @Test public void nameWithNull() {
    final File f = new File("someFile");
    assert "someFile".equals(name(f));
    f.delete();
  }

  @Test(expected = AssertionError.class) public void penultimateInWithNullList() {
    penultimateIn(box(1), null);
  }

  @Test @SuppressWarnings("null") public void penultimateInWithNotNullList() {
    List<Integer> l = Arrays.asList(box(1), box(2), null, box(3));
    assert !penultimateIn(box(1), l);
    assert penultimateIn(null, l);
    l = Arrays.asList(box(1), box(2), box(3));
    assert penultimateIn(box(2), l);
  }

  @Test public void prependStringBuilderChar() {
    assert "some string".equals(prepend(new StringBuilder("ome string"), 's') + "");
  }

  @Test public void prependStringBuilderString() {
    assert "some string".equals(prepend(new StringBuilder("ome string"), "s") + "");
  }

  @Test public void quoteTest() {
    assert "<null reference>".equals(quote(null));
    assert "''".equals(quote(""));
    assert "'some some'".equals(quote("some some"));
  }

  @Test public void removeDuplicatesTest() {
    final List<Integer> l = new LinkedList<>(Arrays.asList(box(new int[] { 1, 2, 3, 1, 2, 3, 1, 2, 3 })));
    removeDuplicates(l);
    assert l.equals(new LinkedList<>(Arrays.asList(box(new int[] { 1, 2, 3 }))));
  }

  @Test public void removePrefixTest() {
    assert "efg".equals(removePrefix("abcabcabcefg", "abc"));
  }

  @Test public void removeSuffixTest() {
    assert "abc".equals(removeSuffix("abcefgefgefg", "efg"));
  }

  @Test public void removeWhitesTest() {
    assert "abc".equals(removeWhites("a    b    c \n \n    \t"));
  }

  @Test public void sortTest() throws Exception {
    final int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    assert a == sort(a);
    azzert.that(a, is(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
  }

  @Test public void sqrTest() throws Exception {
    assert sqr(0) == 0;
    assert sqr(-1) == 1;
    assert sqr(1) == 1;
    assert sqr(-32) == 1024;
  }

  @Test public void suffixedByFileIterable() throws Exception {
    final File f = new File("someFile.som");
    assert !suffixedBy(f, Arrays.asList(new String[] { ".txt", ".mov", ".docx" }));
    assert suffixedBy(f, Arrays.asList(new String[] { ".txt", ".mov", ".som", ".docx" }));
    f.delete();
  }

  @Test @SuppressWarnings("null") public void suffixedByFileArray() throws Exception {
    final File f = new File("someFile.som");
    assert !suffixedBy(f, new String[] { ".txt", ".mov", ".docx" });
    assert suffixedBy(f, new String[] { ".txt", ".mov", ".som", ".docx" });
    f.delete();
  }

  @Test @SuppressWarnings("null") public void suffixedByArray() throws Exception {
    final String s = "someFile.som";
    assert !suffixedBy(s, new String[] { ".txt", ".mov", ".docx" });
    assert suffixedBy(s, new String[] { ".txt", ".mov", ".som", ".docx" });
  }

  @Test public void suffixedByIterable() throws Exception {
    final String s = "someFile.som";
    assert !suffixedBy(s, Arrays.asList(new String[] { ".txt", ".mov", ".docx" }));
    assert suffixedBy(s, Arrays.asList(new String[] { ".txt", ".mov", ".som", ".docx" }));
  }

  @Test public void swapTest() throws Exception {
    final Integer[] a = box(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    swap(a, 0, 8);
    azzert.that(a, is(box(new int[] { 9, 2, 3, 4, 5, 6, 7, 8, 1 })));
  }

  @NotNull @SuppressWarnings("null") public static Integer[] intToIntegers(final int... is) {
    final Integer @NotNull [] $ = new Integer @NotNull [is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = fluent.ly.box.it(is[¢]);
    return $;
  }

  @Test @SuppressWarnings({ "unchecked", "null" }) public void addAllTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).addAll(as.set("A", "B"), null, as.set("B", "C", "D"));
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final @NotNull String ¢ : ss)
      azzert.aye("", ss.contains(¢));
  }

  @Test @SuppressWarnings("null") public void addTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).add(null, "A", null, "B", "B", null, "C", "D", null);
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final @NotNull String ¢ : ss)
      azzert.aye("", ss.contains(¢));
    azzert.aye(ss.contains("A"));
  }

  @Test public void cantBeNullOfNull() {
    try {
      cantBeNull(null);
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void cantBeNullTypical() {
    assert cantBeNull(new Object()) != null;
  }

  @Test public void isNullTypical() {
    try {
      isNull(mustBeNull(null));
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void mustBeNullOfNotNull() {
    try {
      mustBeNull(new Object());
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void quoteEmptyString() {
    azzert.that(idiomatic.quote(""), is("''"));
  }

  @Test public void quoteNull() {
    azzert.that(idiomatic.quote(null), is("<null reference>"));
  }

  @Test public void quoteSimpleString() {
    azzert.that(idiomatic.quote("A"), is("'A'"));
  }

  @Test public void swapDegenerate() {
    @SuppressWarnings("null") final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
    swap(ss, 1, 1);
    assertArrayEquals(as.array("A", "B", "C", "D"), ss);
  }

  @Test public void swapTypical() {
    @SuppressWarnings("null") final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
    swap(ss, 1, 2);
    assertArrayEquals(as.array("A", "C", "B", "D"), ss);
  }

  @Test public void swapTypicalCase() {
    @SuppressWarnings("null") final Integer @NotNull [] $ = intToIntegers(29, 1, 60);
    swap($, 0, 1);
    assertArrayEquals(intToIntegers(1, 29, 60), $);
  }

  @Test public void hashTest() throws Exception {
    assert hash(null) == 0;
    assert hash(box(987545L)) == box(987545L).hashCode();
  }
}
