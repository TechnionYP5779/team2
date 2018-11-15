package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "boxing" }) public class isTest {
  @Test public void inEmptyListReturnsFasle() {
    assert !is.in("some string");
    assert !is.in("");
    assert !is.in(Integer.valueOf(1));
    assert !is.in(null);
    assert !is.in(Boolean.TRUE);
    assert !is.in(new Object());
  }

  @Test public void inReturnsFasleForNullItem() {
    assert !is.in(null, "", Integer.valueOf(5), Boolean.FALSE, null);
  }

  @Test public void inReturnsTrueForExistingItem() {
    assert is.in("", "", "some string", Integer.valueOf(5), Boolean.FALSE, null);
    assert is.in("some string", "", "some string", Integer.valueOf(5), Boolean.FALSE, null);
    assert is.in(Integer.valueOf(5), "", Integer.valueOf(5), Boolean.FALSE, null);
    assert is.in(Boolean.FALSE, "", Integer.valueOf(5), Boolean.FALSE, null);
    final int[] intArr1 = {};
    assert is.in(intArr1, "", Integer.valueOf(5), intArr1, Boolean.FALSE, null);
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    assert is.in(intArr3, "", Integer.valueOf(5), intArr3, Boolean.FALSE, null);
  }

  @Test public void inReturnsFalseForMissingItem() {
    assert !is.in("not the same", "", "some string", Integer.valueOf(5), Boolean.FALSE, null);
    assert !is.in(Integer.valueOf(10), "", Integer.valueOf(5), Boolean.FALSE, null);
    assert !is.in(Boolean.TRUE, "", Integer.valueOf(5), Boolean.FALSE, null);
    final int[] intArr1 = {}, intArr2 = {};
    assert !is.in(intArr1, "", Integer.valueOf(5), intArr2, Boolean.FALSE, null);
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 },
        intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    assert !is.in(intArr3, "", Integer.valueOf(5), intArr4, Boolean.FALSE, null);
  }

  @Test public void intIsInEmptyListReturnsFasle() {
    assert !is.intIsIn(5);
    assert !is.intIsIn(0);
    assert !is.intIsIn(Integer.MAX_VALUE);
    assert !is.intIsIn(Integer.MIN_VALUE);
  }

  @Test public void intIsInReturnsTrueForExistingItem() {
    assert is.intIsIn(0, 2, 5, 4, 8, 9, 0, 2, 15, 5, 3, 0);
    assert is.intIsIn(5, 6, -4, 1, 2, 3, 5, 6, 4, 5, 1);
    assert is.intIsIn(-1, 2, 5, 8, 9, 6, 0, 4, 7, 7, 7, 7, -1);
  }

  @Test public void intIsInReturnsFalseForMissingItem() {
    assert !is.intIsIn(0, 1, 2, 3, 4, 5, 6, 456, 5644, 2165, 65, 4, 89, 8);
    assert !is.intIsIn(-9, 231, 456, 1, -6458, -564, -8456, 0);
    assert !is.intIsIn(645, 89, 231, -231, 0, 789, 4654, 644, 666, 646);
  }

  @Test public void notInEmptyListReturnsTrue() {
    assert is.not.in("some string");
    assert is.not.in("");
    assert is.not.in(Integer.valueOf(1));
    assert is.not.in(null);
    assert is.not.in(Boolean.TRUE);
    assert is.not.in(new Object());
  }

  @Test public void notInReturnsFasleForNullItem() {
    assert is.not.in(null, "", Integer.valueOf(5), Boolean.FALSE, null);
  }

  @Test public void notInReturnsTrueForExistingItem() {
    assert !is.not.in("", "", "some string", Integer.valueOf(5), Boolean.FALSE, null);
    assert !is.not.in("some string", "", "some string", Integer.valueOf(5), Boolean.FALSE, null);
    assert !is.not.in(Integer.valueOf(5), "", Integer.valueOf(5), Boolean.FALSE, null);
    assert !is.not.in(Boolean.FALSE, "", Integer.valueOf(5), Boolean.FALSE, null);
    final int[] intArr1 = {};
    assert !is.not.in(intArr1, "", Integer.valueOf(5), intArr1, Boolean.FALSE, null);
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    assert !is.not.in(intArr3, "", Integer.valueOf(5), intArr3, Boolean.FALSE, null);
  }

  @Test public void notInReturnsFalseForMissingItem() {
    assert is.not.in("not the same", "", "some string", Integer.valueOf(5), Boolean.FALSE, null);
    assert is.not.in(Integer.valueOf(10), "", Integer.valueOf(5), Boolean.FALSE, null);
    assert is.not.in(Boolean.TRUE, "", Integer.valueOf(5), Boolean.FALSE, null);
    final int[] intArr1 = {}, intArr2 = {};
    assert is.not.in(intArr1, "", Integer.valueOf(5), intArr2, Boolean.FALSE, null);
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 },
        intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    assert is.not.in(intArr3, "", Integer.valueOf(5), intArr4, Boolean.FALSE, null);
  }

  @Test public void outEmptyListReturnsTrue() {
    assert is.out("some string");
    assert is.out("");
    assert is.out(Integer.valueOf(1));
    assert is.out(null);
    assert is.out(Boolean.TRUE);
    assert is.out(new Object());
  }

  @Test public void outReturnsFasleForNullItem() {
    assert is.out(null, "", Integer.valueOf(5), Boolean.FALSE, null);
  }

  @Test public void outReturnsTrueForExistingItem() {
    assert !is.out("", "", "some string", Integer.valueOf(5), Boolean.FALSE, null);
    assert !is.out("some string", "", "some string", Integer.valueOf(5), Boolean.FALSE, null);
    assert !is.out(Integer.valueOf(5), "", Integer.valueOf(5), Boolean.FALSE, null);
    assert !is.out(Boolean.FALSE, "", Integer.valueOf(5), Boolean.FALSE, null);
    final int[] intArr1 = {};
    assert !is.out(intArr1, "", Integer.valueOf(5), intArr1, Boolean.FALSE, null);
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    assert !is.out(intArr3, "", Integer.valueOf(5), intArr3, Boolean.FALSE, null);
  }

  @Test public void outReturnsFalseForMissingItem() {
    assert is.out("not the same", "", "some string", Integer.valueOf(5), Boolean.FALSE, null);
    assert is.out(Integer.valueOf(10), "", Integer.valueOf(5), Boolean.FALSE, null);
    assert is.out(Boolean.TRUE, "", Integer.valueOf(5), Boolean.FALSE, null);
    final int[] intArr1 = {}, intArr2 = {};
    assert is.out(intArr1, "", Integer.valueOf(5), intArr2, Boolean.FALSE, null);
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 },
        intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    assert is.out(intArr3, "", Integer.valueOf(5), intArr4, Boolean.FALSE, null);
  }

  @Test public void emptyReturnsTrueForNull() {
    assert is.empty((String) null);
    assert is.empty((Object[]) null);
    assert is.empty((Iterable<Object>) null);
    assert is.empty((Collection<Object>) null);
  }

  @Test public void emptyReturnsTrueForEmptyString() {
    assert is.empty("");
  }

  @Test public void emptyReturnsFalseForNotEmptyString() {
    assert !is.empty("some string");
  }

  @Test public void emptyReturnsTrueForEmptyArray() {
    assert is.empty(new Integer[0]);
    assert is.empty(new Object[0]);
  }

  @Test public void emptyReturnsFalseForNotEmptyArray() {
    assert !is.empty(new Integer[] { 1, 2, 3, 4 });
  }

  @Test public void emptyReturnsTrueForEmptyIterable() {
    assert is.empty((Iterable<Object>) new ArrayList<>());
    assert is.empty((Iterable<Object>) Collections.EMPTY_LIST);
  }

  @Test public void emptyReturnsFalseForNotEmptyIterable() {
    assert !is.empty((Iterable<Integer>) Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
  }

  @Test public void emptyReturnsTrueForEmptyCollection() {
    assert is.empty((Collection<Object>) new ArrayList<>());
    assert is.empty((Collection<Object>) Collections.EMPTY_LIST);
  }

  @Test public void emptyReturnsFalseForNotEmptyCollection() {
    assert !is.empty((Collection<Integer>) Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
  }
}
