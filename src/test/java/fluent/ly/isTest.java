package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "boxing" }) public class isTest {
  @Test public void inEmptyListReturnsFasle() {
    azzert.assertFalse(is.in("some string"));
    azzert.assertFalse(is.in(""));
    azzert.assertFalse(is.in(fluent.ly.box.it(1)));
    azzert.assertFalse(is.in(null));
    azzert.assertFalse(is.in(Boolean.TRUE));
    azzert.assertFalse(is.in(new Object()));
  }

  @Test public void inReturnsFasleForNullItem() {
    azzert.assertFalse(is.in(null, "", fluent.ly.box.it(5), Boolean.FALSE, null));
  }

  @Test public void inReturnsTrueForExistingItem() {
    azzert.assertTrue(is.in("", "", "some string", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertTrue(is.in("some string", "", "some string", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertTrue(is.in(fluent.ly.box.it(5), "", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertTrue(is.in(Boolean.FALSE, "", fluent.ly.box.it(5), Boolean.FALSE, null));
    final int[] intArr1 = {};
    azzert.assertTrue(is.in(intArr1, "", fluent.ly.box.it(5), intArr1, Boolean.FALSE, null));
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertTrue(is.in(intArr3, "", fluent.ly.box.it(5), intArr3, Boolean.FALSE, null));
  }

  @Test public void inReturnsFalseForMissingItem() {
    azzert.assertFalse(is.in("not the same", "", "some string", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertFalse(is.in(fluent.ly.box.it(10), "", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertFalse(is.in(Boolean.TRUE, "", fluent.ly.box.it(5), Boolean.FALSE, null));
    final int[] intArr1 = {}, intArr2 = {};
    azzert.assertFalse(is.in(intArr1, "", fluent.ly.box.it(5), intArr2, Boolean.FALSE, null));
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 },
        intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertFalse(is.in(intArr3, "", fluent.ly.box.it(5), intArr4, Boolean.FALSE, null));
  }

  @Test public void intIsInEmptyListReturnsFasle() {
    azzert.assertFalse(is.intIsIn(5));
    azzert.assertFalse(is.intIsIn(0));
    azzert.assertFalse(is.intIsIn(Integer.MAX_VALUE));
    azzert.assertFalse(is.intIsIn(Integer.MIN_VALUE));
  }

  @Test public void intIsInReturnsTrueForExistingItem() {
    azzert.assertTrue(is.intIsIn(0, 2, 5, 4, 8, 9, 0, 2, 15, 5, 3, 0));
    azzert.assertTrue(is.intIsIn(5, 6, -4, 1, 2, 3, 5, 6, 4, 5, 1));
    azzert.assertTrue(is.intIsIn(-1, 2, 5, 8, 9, 6, 0, 4, 7, 7, 7, 7, -1));
  }

  @Test public void intIsInReturnsFalseForMissingItem() {
    azzert.assertFalse(is.intIsIn(0, 1, 2, 3, 4, 5, 6, 456, 5644, 2165, 65, 4, 89, 8));
    azzert.assertFalse(is.intIsIn(-9, 231, 456, 1, -6458, -564, -8456, 0));
    azzert.assertFalse(is.intIsIn(645, 89, 231, -231, 0, 789, 4654, 644, 666, 646));
  }

  @Test public void notInEmptyListReturnsTrue() {
    azzert.assertTrue(is.not.in("some string"));
    azzert.assertTrue(is.not.in(""));
    azzert.assertTrue(is.not.in(fluent.ly.box.it(1)));
    azzert.assertTrue(is.not.in(null));
    azzert.assertTrue(is.not.in(Boolean.TRUE));
    azzert.assertTrue(is.not.in(new Object()));
  }

  @Test public void notInReturnsFasleForNullItem() {
    azzert.assertTrue(is.not.in(null, "", fluent.ly.box.it(5), Boolean.FALSE, null));
  }

  @Test public void notInReturnsTrueForExistingItem() {
    azzert.assertFalse(is.not.in("", "", "some string", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertFalse(is.not.in("some string", "", "some string", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertFalse(is.not.in(fluent.ly.box.it(5), "", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertFalse(is.not.in(Boolean.FALSE, "", fluent.ly.box.it(5), Boolean.FALSE, null));
    final int[] intArr1 = {};
    azzert.assertFalse(is.not.in(intArr1, "", fluent.ly.box.it(5), intArr1, Boolean.FALSE, null));
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertFalse(is.not.in(intArr3, "", fluent.ly.box.it(5), intArr3, Boolean.FALSE, null));
  }

  @Test public void notInReturnsFalseForMissingItem() {
    azzert.assertTrue(is.not.in("not the same", "", "some string", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertTrue(is.not.in(fluent.ly.box.it(10), "", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertTrue(is.not.in(Boolean.TRUE, "", fluent.ly.box.it(5), Boolean.FALSE, null));
    final int[] intArr1 = {}, intArr2 = {};
    azzert.assertTrue(is.not.in(intArr1, "", fluent.ly.box.it(5), intArr2, Boolean.FALSE, null));
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 },
        intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertTrue(is.not.in(intArr3, "", fluent.ly.box.it(5), intArr4, Boolean.FALSE, null));
  }

  @Test public void outEmptyListReturnsTrue() {
    azzert.assertTrue(is.out("some string"));
    azzert.assertTrue(is.out(""));
    azzert.assertTrue(is.out(fluent.ly.box.it(1)));
    azzert.assertTrue(is.out(null));
    azzert.assertTrue(is.out(Boolean.TRUE));
    azzert.assertTrue(is.out(new Object()));
  }

  @Test public void outReturnsFasleForNullItem() {
    azzert.assertTrue(is.out(null, "", fluent.ly.box.it(5), Boolean.FALSE, null));
  }

  @Test public void outReturnsTrueForExistingItem() {
    azzert.assertFalse(is.out("", "", "some string", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertFalse(is.out("some string", "", "some string", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertFalse(is.out(fluent.ly.box.it(5), "", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertFalse(is.out(Boolean.FALSE, "", fluent.ly.box.it(5), Boolean.FALSE, null));
    final int[] intArr1 = {};
    azzert.assertFalse(is.out(intArr1, "", fluent.ly.box.it(5), intArr1, Boolean.FALSE, null));
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertFalse(is.out(intArr3, "", fluent.ly.box.it(5), intArr3, Boolean.FALSE, null));
  }

  @Test public void outReturnsFalseForMissingItem() {
    azzert.assertTrue(is.out("not the same", "", "some string", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertTrue(is.out(fluent.ly.box.it(10), "", fluent.ly.box.it(5), Boolean.FALSE, null));
    azzert.assertTrue(is.out(Boolean.TRUE, "", fluent.ly.box.it(5), Boolean.FALSE, null));
    final int[] intArr1 = {}, intArr2 = {};
    azzert.assertTrue(is.out(intArr1, "", fluent.ly.box.it(5), intArr2, Boolean.FALSE, null));
    final int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 },
        intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertTrue(is.out(intArr3, "", fluent.ly.box.it(5), intArr4, Boolean.FALSE, null));
  }

  @Test public void emptyReturnsTrueForNull() {
    azzert.assertTrue(is.empty((String) null));
    azzert.assertTrue(is.empty((Object[]) null));
    azzert.assertTrue(is.empty((Iterable<Object>) null));
    azzert.assertTrue(is.empty((Collection<Object>) null));
  }

  @Test public void emptyReturnsTrueForEmptyString() {
    azzert.assertTrue(is.empty(""));
  }

  @Test public void emptyReturnsFalseForNotEmptyString() {
    azzert.assertFalse(is.empty("some string"));
  }

  @Test public void emptyReturnsTrueForEmptyArray() {
    azzert.assertTrue(is.empty(new Integer[0]));
    azzert.assertTrue(is.empty(new Object[0]));
  }

  @Test public void emptyReturnsFalseForNotEmptyArray() {
    azzert.assertFalse(is.empty(new Integer[] { 1, 2, 3, 4 }));
  }

  @Test public void emptyReturnsTrueForEmptyIterable() {
    azzert.assertTrue(is.empty((Iterable<Object>) new ArrayList<>()));
    azzert.assertTrue(is.empty((Iterable<Object>) Collections.EMPTY_LIST));
  }

  @Test public void emptyReturnsFalseForNotEmptyIterable() {
    azzert.assertFalse(is.empty((Iterable<Integer>) Arrays.asList(new Integer[] { 1, 2, 3, 4 })));
  }

  @Test public void emptyReturnsTrueForEmptyCollection() {
    azzert.assertTrue(is.empty((Collection<Object>) new ArrayList<>()));
    azzert.assertTrue(is.empty((Collection<Object>) Collections.EMPTY_LIST));
  }

  @Test public void emptyReturnsFalseForNotEmptyCollection() {
    azzert.assertFalse(is.empty((Collection<Integer>) Arrays.asList(new Integer[] { 1, 2, 3, 4 })));
  }
}
