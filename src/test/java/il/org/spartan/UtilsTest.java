package il.org.spartan;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class UtilsTest {
  @Test public void addIterableWithoutNulls() {
    Collection<Integer> c = new ArrayList<>();
    @NotNull Collection<Integer> i = Utils.cantBeNull(Arrays.asList(box.box(new int[] { 1, 2, 3, 4, 5, 6, 7 })));
    azzert.assertNotEquals(c, i);
    assert Utils.add(c, i) == c;
    azzert.assertCollectionsEqual(c, i);
  }

  @Test public void addIterableWithNulls() {
    Collection<Integer> c = new LinkedList<>(), i = new LinkedList<>();
    i.add(null);
    i.add(box.box(1));
    azzert.assertNotEquals(c, i);
    assert Utils.add(c, i) == c;
    azzert.assertContains(c, box.box(1));
    azzert.assertNotContains(c, null);
  }

  @Test public void addArrayWithoutNulls() {
    Collection<Integer> c = new ArrayList<>();
    Integer[] a = box.box(new int[] { 1, 2, 3, 4, 5, 6, 7 });
    azzert.assertNotEquals(c, Arrays.asList(a));
    assert Utils.add(c, Utils.cantBeNull(a)) == c;
    azzert.assertCollectionsEqual(c, Utils.cantBeNull(Arrays.asList(a)));
  }

  @Test @SuppressWarnings("null") public void addArrayWithNulls() {
    Collection<Integer> c = Utils.cantBeNull(new ArrayList<>());
    Integer[] a = box.box(new int[] { 1, 2 });
    a[1] = null;
    azzert.assertNotEquals(c, Arrays.asList(a));
    assert Utils.add(c, a) == c;
    azzert.assertCollectionsEqual(c, box.box(new int[] { 1 }));
  }

  @Test public void addAllCollectionWithoutNulls() {
    Collection<Integer> c = new ArrayList<>(), c1 = Arrays.asList(box.box(new int[] { 1 })), c2 = Arrays.asList(box.box(new int[] { 2 })),
        c12 = Utils.cantBeNull(Arrays.asList(box.box(new int[] { 1, 2 })));
    azzert.assertNotEquals(c, c12);
    assert Utils.addAll(c, c1, c2) == c;
    azzert.assertCollectionsEqual(c, c12);
  }

  @Test public void addAllCollectionWithNulls() {
    Collection<Integer> c = new ArrayList<>(), c1 = Arrays.asList(box.box(new int[] { 1 })), c2 = Arrays.asList(box.box(new int[] { 2 })),
        c12 = Utils.cantBeNull(Arrays.asList(box.box(new int[] { 1, 2 })));
    azzert.assertNotEquals(c, c12);
    assert Utils.addAll(c, c1, null, c2) == c;
    azzert.assertCollectionsEqual(c, c12);
  }

  @Test public void addAllIterableWithoutNulls() {
    Collection<Integer> c = new ArrayList<>();
    Iterable<Integer> i1 = Arrays.asList(box.box(new int[] { 1 })), i2 = Arrays.asList(box.box(new int[] { 2 }));
    Collection<Integer> c12 = Utils.cantBeNull(Arrays.asList(box.box(new int[] { 1, 2 })));
    azzert.assertNotEquals(c, c12);
    assert Utils.addAll(c, i1, i2) == c;
    azzert.assertCollectionsEqual(c, c12);
  }

  @Test public void addAllIterableWithNulls() {
    Collection<Integer> c = new ArrayList<>();
    Iterable<Integer> i1 = Arrays.asList(box.box(new int[] { 1 })), i2 = Arrays.asList(box.box(new int[] { 2 }));
    Collection<Integer> c12 = Utils.cantBeNull(Arrays.asList(box.box(new int[] { 1, 2 })));
    azzert.assertNotEquals(c, c12);
    assert Utils.addAll(c, i1, null, i2) == c;
    azzert.assertCollectionsEqual(c, c12);
  }

  @Test public void addAllArrayWithoutNulls() {
    Collection<Integer> c = new ArrayList<>();
    Integer[] a = box.box(new int[] { 1 });
    azzert.assertNotEquals(c, Arrays.asList(a));
    assert Utils.addAll(c, a) == c;
    azzert.assertCollectionsEqual(c, Utils.cantBeNull(Arrays.asList(a)));
  }

  @Test public void addAllArrayWithNulls() {
    Collection<Integer> c = new ArrayList<>();
    Integer[] a = new Integer[] { box.box(1), null };
    Collection<Integer> c1 = Utils.cantBeNull(Arrays.asList(box.box(new int[] { 1 })));
    azzert.assertNotEquals(c, c1);
    assert Utils.addAll(c, a) == c;
    azzert.assertCollectionsEqual(c, c1);
  }
}