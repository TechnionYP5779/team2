package fluent.ly;

import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class isTest {
  @Test public void inEmptyListReturnsFasleNull() {
    assert !is.in(null);
  }

  @Test public void inEmptyListReturnsFasle() {
    assert !is.in(new Object());
  }

  @Test public void inReturnsFasleForNullItem() {
    assert !is.in(null, "", box(5), Boolean.FALSE, null);
  }

  @Test public void inReturnsTrueForExistingItem() {
    assert !is.in(new int[] {}, "", box(5), new int[] {}, Boolean.FALSE, null);
  }

  @Test public void inReturnsFalseForMissingItem() {
    assert !is.in("not the same", "", "some string", box(5), Boolean.FALSE, null);
  }

  @Test public void intIsInEmptyListReturnsFasle() {
    assert !is.intIsIn(0);
  }

  @Test public void intIsInReturnsTrueForExistingItem() {
    assert is.intIsIn(0, 2, 5, 4, 8, 9, 0, 2, 15, 5, 3, 0);
  }

  @Test public void intIsInReturnsFalseForMissingItem() {
    assert !is.intIsIn(-9, 231, 456, 1, -6458, -564, -8456, 0);
  }

  @Test public void notInEmptyListReturnsTrue() {
    assert is.not.in(new Object());
  }

  @Test public void notInReturnsFasleForNullItem() {
    assert is.not.in(null, "", box(5), Boolean.FALSE, null);
  }

  @Test public void notInReturnsTrueForExistingItem() {
    assert !is.not.in("some string", "", "some string", box(5), Boolean.FALSE, null);
  }

  @Test public void notInReturnsFalseForMissingItem() {
    assert is.not.in("not the same", "", "some string", box(5), Boolean.FALSE, null);
  }

  @Test public void outEmptyListReturnsTrue() {
    assert is.out(new Object());
  }

  @Test public void outReturnsFasleForNullItem() {
    assert is.out(null, "", box(5), Boolean.FALSE, null);
  }

  @Test public void outReturnsTrueForExistingItem() {
    assert !is.out("some string", "", "some string", box(5), Boolean.FALSE, null);
  }

  @Test public void outReturnsFalseForMissingItem() {
    assert is.out("not the same", "", "some string", box(5), Boolean.FALSE, null);
  }

  @Test public void emptyReturnsTrueForNull() {
    assert is.empty((Object[]) null);
  }

  @Test public void emptyReturnsTrueForEmptyString() {
    assert is.empty("");
  }

  @Test public void emptyReturnsFalseForNotEmptyString() {
    assert !is.empty("some string");
  }

  @Test public void emptyReturnsTrueForEmptyArray() {
    assert is.empty(new Object[0]);
  }

  @Test public void emptyReturnsFalseForNotEmptyArray() {
    assert !is.empty(box(new int[] { 1, 2, 3, 4 }));
  }

  @Test public void emptyReturnsTrueForEmptyIterable() {
    assert is.empty((Iterable<Object>) Collections.EMPTY_LIST);
  }

  @Test public void emptyReturnsFalseForNotEmptyIterable() {
    assert !is.empty((Iterable<Integer>) Arrays.asList(box(new int[] { 1, 2, 3, 4 })));
  }

  @Test public void emptyReturnsTrueForEmptyCollection() {
    assert is.empty((Collection<Object>) Collections.EMPTY_LIST);
  }

  @Test public void emptyReturnsFalseForNotEmptyCollection() {
    assert !is.empty((Collection<Integer>) Arrays.asList(box(new int[] { 1, 2, 3, 4 })));
  }
}
