package fluent.ly;

import static il.org.spartan.Utils.*;
import static org.junit.Assert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** A JUnit test class for the enclosing class.
 * @author Yossi Gil, the Technion.
 * @since 27/08/2008 */
@SuppressWarnings({ "static-method" }) //
public class pruneTest2 {
  @Nullable final String[] alternatingArray = new @Nullable String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String[] nonNullArray = { "1", "2", "4" };
  @NotNull private final List<String> sparseCollection = as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null,
      null, null, null);

  @Test public void nullsNotNullArrayLength() {
    assertEquals(nonNullArray.length, prune.nulls(cantBeNull(nonNullArray)).length);
  }

  @Test public void nullsNullArrayItems() {
    assertEquals("1", prune.nulls(cantBeNull(nonNullArray))[0]);
    assertEquals("2", prune.nulls(cantBeNull(nonNullArray))[1]);
    assertEquals("4", prune.nulls(cantBeNull(nonNullArray))[2]);
  }

  @Test public void nullsPruneArrayAltenatingItems() {
    assertEquals("A", prune.nulls(cantBeNull(alternatingArray))[0]);
    assertEquals("B", prune.nulls(cantBeNull(alternatingArray))[1]);
    assertEquals("C", prune.nulls(cantBeNull(alternatingArray))[2]);
  }

  @Test public void nullsPruneArrayAltenatingLength() {
    assertEquals(3, prune.nulls(cantBeNull(alternatingArray)).length);
  }

  @Test public void nullsPruneSparseCollectionContents() {
    final String[] a = prune.nulls(sparseCollection).toArray(new String[3]);
    assertEquals("A", a[0]);
    assertEquals("B", a[1]);
    assertEquals("C", a[2]);
    assertEquals(3, a.length);
  }

  @Test public void nullsPruneSparseCollectionLength() {
    assertEquals(3, prune.nulls(sparseCollection).size());
  }

  @Test public void nullsPrunNotNull() {
    assert prune.nulls(sparseCollection) != null;
  }

  @Test public void shrinkArray() {
    assertEquals(0, prune.shrink(new Object[10]).length);
  }

  @Test public void shrinkEmptyArray() {
    assertEquals(0, prune.shrink(new Object[0]).length);
  }

  @Test public void whitesEmptyArray() {
    assertEquals(0, prune.whites().length);
  }

  @Test public void whitesEmptyList() {
    assertEquals(0, prune.whites().length);
  }
}