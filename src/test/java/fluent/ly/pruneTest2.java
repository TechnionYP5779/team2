package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** A JUnit test class for the enclosing class.
 * @author Yossi Gil, the Technion.
 * @since 27/08/2008 */
@SuppressWarnings("static-method") public class pruneTest2 {
  @Nullable final String[] alternatingArray = new @Nullable String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String[] nonNullArray = { "1", "2", "4" };
  @NotNull private final List<String> sparseCollection = as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null,
      null, null, null);

  @Test public void nullsNotNullArrayLength() {
    azzert.that(nonNullArray.length, is(prune.nulls(cantBeNull(nonNullArray)).length));
  }

  @Test public void nullsNullArrayItems() {
    azzert.that("1", is(prune.nulls(cantBeNull(nonNullArray))[0]));
    azzert.that("2", is(prune.nulls(cantBeNull(nonNullArray))[1]));
    azzert.that("4", is(prune.nulls(cantBeNull(nonNullArray))[2]));
  }

  @Test public void nullsPruneArrayAltenatingItems() {
    azzert.that("A", is(prune.nulls(cantBeNull(alternatingArray))[0]));
    azzert.that("B", is(prune.nulls(cantBeNull(alternatingArray))[1]));
    azzert.that("C", is(prune.nulls(cantBeNull(alternatingArray))[2]));
  }

  @Test public void nullsPruneArrayAltenatingLength() {
    azzert.that(3, is(prune.nulls(cantBeNull(alternatingArray)).length));
  }

  @Test public void nullsPruneSparseCollectionContents() {
    final String[] a = prune.nulls(sparseCollection).toArray(new String[3]);
    azzert.that("A", is(a[0]));
    azzert.that("B", is(a[1]));
    azzert.that("C", is(a[2]));
    azzert.that(3, is(a.length));
  }

  @Test public void nullsPruneSparseCollectionLength() {
    azzert.that(3, is(prune.nulls(sparseCollection).size()));
  }

  @Test public void nullsPrunNotNull() {
    assert prune.nulls(sparseCollection) != null;
  }

  @Test public void shrinkArray() {
    azzert.that(0, is(prune.shrink(new Object[10]).length));
  }

  @Test public void shrinkEmptyArray() {
    azzert.that(0, is(prune.shrink(new Object[0]).length));
  }

  @Test public void whitesEmptyArray() {
    azzert.that(0, is(prune.whites().length));
  }

  @Test public void whitesEmptyList() {
    azzert.that(0, is(prune.whites().length));
  }
}