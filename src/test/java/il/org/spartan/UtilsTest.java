package il.org.spartan;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static il.org.spartan.Utils.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.Utils.FoundHandleForT.*;
import il.org.spartan.etc.*;

@SuppressWarnings("static-method") public class UtilsTest {
  @Test public void addIterableWithoutNulls() {
    Collection<Integer> c = new ArrayList<>();
    @NotNull Collection<Integer> i = cantBeNull(Arrays.asList(box(new int[] { 1, 2, 3, 4, 5, 6, 7 })));
    assertNotEquals(c, i);
    assert add(c, i) == c;
    assertCollectionsEqual(c, i);
  }

  @Test public void addIterableWithNulls() {
    Collection<Integer> c = new LinkedList<>(), i = new LinkedList<>();
    i.add(null);
    i.add(box(1));
    assertNotEquals(c, i);
    assert add(c, i) == c;
    assertContains(c, box(1));
    assertNotContains(c, null);
  }

  @Test public void addArrayWithoutNulls() {
    Collection<Integer> c = new ArrayList<>();
    Integer[] a = box(new int[] { 1, 2, 3, 4, 5, 6, 7 });
    assertNotEquals(c, Arrays.asList(a));
    assert add(c, cantBeNull(a)) == c;
    assertCollectionsEqual(c, cantBeNull(Arrays.asList(a)));
  }

  @Test @SuppressWarnings("null") public void addArrayWithNulls() {
    Collection<Integer> c = cantBeNull(new ArrayList<>());
    Integer[] a = box(new int[] { 1, 2 });
    a[1] = null;
    azzert.assertNotEquals(c, Arrays.asList(a));
    assert add(c, a) == c;
    azzert.assertCollectionsEqual(c, box(new int[] { 1 }));
  }

  @Test public void addAllCollectionWithoutNulls() {
    Collection<Integer> c = new ArrayList<>(), c1 = Arrays.asList(box(new int[] { 1 })), c2 = Arrays.asList(box(new int[] { 2 })),
        c12 = cantBeNull(Arrays.asList(box(new int[] { 1, 2 })));
    assertNotEquals(c, c12);
    assert addAll(c, c1, c2) == c;
    assertCollectionsEqual(c, c12);
  }

  @Test public void addAllCollectionWithNulls() {
    Collection<Integer> c = new ArrayList<>(), c1 = Arrays.asList(box(new int[] { 1 })), c2 = Arrays.asList(box(new int[] { 2 })),
        c12 = cantBeNull(Arrays.asList(box(new int[] { 1, 2 })));
    assertNotEquals(c, c12);
    assert addAll(c, c1, null, c2) == c;
    assertCollectionsEqual(c, c12);
  }

  @Test public void addAllIterableWithoutNulls() {
    Collection<Integer> c = new ArrayList<>();
    Iterable<Integer> i1 = Arrays.asList(box(new int[] { 1 })), i2 = Arrays.asList(box(new int[] { 2 }));
    Collection<Integer> c12 = cantBeNull(Arrays.asList(box(new int[] { 1, 2 })));
    assertNotEquals(c, c12);
    assert addAll(c, i1, i2) == c;
    assertCollectionsEqual(c, c12);
  }

  @Test public void addAllIterableWithNulls() {
    Collection<Integer> c = new ArrayList<>();
    Iterable<Integer> i1 = Arrays.asList(box(new int[] { 1 })), i2 = Arrays.asList(box(new int[] { 2 }));
    Collection<Integer> c12 = cantBeNull(Arrays.asList(box(new int[] { 1, 2 })));
    assertNotEquals(c, c12);
    assert addAll(c, i1, null, i2) == c;
    assertCollectionsEqual(c, c12);
  }

  @Test public void addAllArrayWithoutNulls() {
    Collection<Integer> c = new ArrayList<>();
    Integer[] a = box(new int[] { 1 });
    assertNotEquals(c, Arrays.asList(a));
    assert addAll(c, a) == c;
    assertCollectionsEqual(c, cantBeNull(Arrays.asList(a)));
  }

  @Test public void addAllArrayWithNulls() {
    Collection<Integer> c = new ArrayList<>();
    Integer[] a = new Integer[] { box(1), null };
    Collection<Integer> c1 = cantBeNull(Arrays.asList(box(new int[] { 1 })));
    assertNotEquals(c, c1);
    assert addAll(c, a) == c;
    assertCollectionsEqual(c, c1);
  }

  @Test public void appendTest() {
    azzert.that(append(box(new int[] { 0, 1 }), box(2)), is(box(new int[] { 0, 1, 2 })));
  }

  @Test @SuppressWarnings("null") public void applyTest() {
    azzert.that(apply((Integer i) -> i).to(new Integer[] { box(1), null, box(2) }), is(Arrays.asList(box(1), box(2))));
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
    FoundHandleForInt h = found(5);
    assert !h.in();
    assert !h.in(1, 2, 3, 4, 6);
    assert h.in(1, 2, 3, 4, 5, 6);
  }

  @Test @SuppressWarnings("null") public void foundT() {
    FoundHandleForT<Integer> h = found(box(5));
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
}
