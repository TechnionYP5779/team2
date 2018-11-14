package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "boxing" }) public class isTest {
  @Test public void inEmptyListReturnsFasle() {
    azzert.assertEquals(false, is.in("some string"));
    azzert.assertEquals(false, is.in(""));
    azzert.assertEquals(false, is.in(Integer.valueOf(1)));
    azzert.assertEquals(false, is.in(null));
    azzert.assertEquals(false, is.in(Boolean.TRUE));
    azzert.assertEquals(false, is.in(new Object()));
  }

  @Test public void inReturnsFasleForNullItem() {
    azzert.assertEquals(false, is.in(null, "", Integer.valueOf(5), Boolean.FALSE, null));
  }

  @Test public void inReturnsTrueForExistingItem() {
    azzert.assertEquals(true, is.in("", "", "some string", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(true, is.in("some string", "", "some string", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(true, is.in(Integer.valueOf(5), "", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(true, is.in(Boolean.FALSE, "", Integer.valueOf(5), Boolean.FALSE, null));
    int[] intArr1 = {};
    azzert.assertEquals(true, is.in(intArr1, "", Integer.valueOf(5), intArr1, Boolean.FALSE, null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertEquals(true, is.in(intArr3, "", Integer.valueOf(5), intArr3, Boolean.FALSE, null));
  }

  @Test public void inReturnsFalseForMissingItem() {
    azzert.assertEquals(false, is.in("not the same", "", "some string", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(false, is.in(Integer.valueOf(10), "", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(false, is.in(Boolean.TRUE, "", Integer.valueOf(5), Boolean.FALSE, null));
    int[] intArr1 = {}, intArr2 = {};
    azzert.assertEquals(false, is.in(intArr1, "", Integer.valueOf(5), intArr2, Boolean.FALSE, null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 },
        intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertEquals(false, is.in(intArr3, "", Integer.valueOf(5), intArr4, Boolean.FALSE, null));
  }

  @Test public void intIsInEmptyListReturnsFasle() {
    azzert.assertEquals(false, is.intIsIn(5));
    azzert.assertEquals(false, is.intIsIn(0));
    azzert.assertEquals(false, is.intIsIn(Integer.MAX_VALUE));
    azzert.assertEquals(false, is.intIsIn(Integer.MIN_VALUE));
  }

  @Test public void intIsInReturnsTrueForExistingItem() {
    azzert.assertEquals(true, is.intIsIn(0, 2, 5, 4, 8, 9, 0, 2, 15, 5, 3, 0));
    azzert.assertEquals(true, is.intIsIn(5, 6, -4, 1, 2, 3, 5, 6, 4, 5, 1));
    azzert.assertEquals(true, is.intIsIn(-1, 2, 5, 8, 9, 6, 0, 4, 7, 7, 7, 7, -1));
  }

  @Test public void intIsInReturnsFalseForMissingItem() {
    azzert.assertEquals(false, is.intIsIn(0, 1, 2, 3, 4, 5, 6, 456, 5644, 2165, 65, 4, 89, 8));
    azzert.assertEquals(false, is.intIsIn(-9, 231, 456, 1, -6458, -564, -8456, 0));
    azzert.assertEquals(false, is.intIsIn(645, 89, 231, -231, 0, 789, 4654, 644, 666, 646));
  }

  @Test public void notInEmptyListReturnsTrue() {
    azzert.assertEquals(true, is.not.in("some string"));
    azzert.assertEquals(true, is.not.in(""));
    azzert.assertEquals(true, is.not.in(Integer.valueOf(1)));
    azzert.assertEquals(true, is.not.in(null));
    azzert.assertEquals(true, is.not.in(Boolean.TRUE));
    azzert.assertEquals(true, is.not.in(new Object()));
  }

  @Test public void notInReturnsFasleForNullItem() {
    azzert.assertEquals(true, is.not.in(null, "", Integer.valueOf(5), Boolean.FALSE, null));
  }

  @Test public void notInReturnsTrueForExistingItem() {
    azzert.assertEquals(false, is.not.in("", "", "some string", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(false, is.not.in("some string", "", "some string", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(false, is.not.in(Integer.valueOf(5), "", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(false, is.not.in(Boolean.FALSE, "", Integer.valueOf(5), Boolean.FALSE, null));
    int[] intArr1 = {};
    azzert.assertEquals(false, is.not.in(intArr1, "", Integer.valueOf(5), intArr1, Boolean.FALSE, null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertEquals(false, is.not.in(intArr3, "", Integer.valueOf(5), intArr3, Boolean.FALSE, null));
  }

  @Test public void notInReturnsFalseForMissingItem() {
    azzert.assertEquals(true, is.not.in("not the same", "", "some string", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(true, is.not.in(Integer.valueOf(10), "", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(true, is.not.in(Boolean.TRUE, "", Integer.valueOf(5), Boolean.FALSE, null));
    int[] intArr1 = {}, intArr2 = {};
    azzert.assertEquals(true, is.not.in(intArr1, "", Integer.valueOf(5), intArr2, Boolean.FALSE, null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 },
        intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertEquals(true, is.not.in(intArr3, "", Integer.valueOf(5), intArr4, Boolean.FALSE, null));
  }

  @Test public void outEmptyListReturnsTrue() {
    azzert.assertEquals(true, is.out("some string"));
    azzert.assertEquals(true, is.out(""));
    azzert.assertEquals(true, is.out(Integer.valueOf(1)));
    azzert.assertEquals(true, is.out(null));
    azzert.assertEquals(true, is.out(Boolean.TRUE));
    azzert.assertEquals(true, is.out(new Object()));
  }

  @Test public void outReturnsFasleForNullItem() {
    azzert.assertEquals(true, is.out(null, "", Integer.valueOf(5), Boolean.FALSE, null));
  }

  @Test public void outReturnsTrueForExistingItem() {
    azzert.assertEquals(false, is.out("", "", "some string", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(false, is.out("some string", "", "some string", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(false, is.out(Integer.valueOf(5), "", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(false, is.out(Boolean.FALSE, "", Integer.valueOf(5), Boolean.FALSE, null));
    int[] intArr1 = {};
    azzert.assertEquals(false, is.out(intArr1, "", Integer.valueOf(5), intArr1, Boolean.FALSE, null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertEquals(false, is.out(intArr3, "", Integer.valueOf(5), intArr3, Boolean.FALSE, null));
  }

  @Test public void outReturnsFalseForMissingItem() {
    azzert.assertEquals(true, is.out("not the same", "", "some string", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(true, is.out(Integer.valueOf(10), "", Integer.valueOf(5), Boolean.FALSE, null));
    azzert.assertEquals(true, is.out(Boolean.TRUE, "", Integer.valueOf(5), Boolean.FALSE, null));
    int[] intArr1 = {}, intArr2 = {};
    azzert.assertEquals(true, is.out(intArr1, "", Integer.valueOf(5), intArr2, Boolean.FALSE, null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 },
        intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    azzert.assertEquals(true, is.out(intArr3, "", Integer.valueOf(5), intArr4, Boolean.FALSE, null));
  }

  @Test public void emptyReturnsTrueForNull() {
    azzert.assertEquals(true, is.empty((String) null));
    azzert.assertEquals(true, is.empty((Object[]) null));
    azzert.assertEquals(true, is.empty((Iterable<Object>) null));
    azzert.assertEquals(true, is.empty((Collection<Object>) null));
  }

  @Test public void emptyReturnsTrueForEmptyString() {
    azzert.assertEquals(true, is.empty(""));
  }

  @Test public void emptyReturnsFalseForNotEmptyString() {
    azzert.assertEquals(false, is.empty("some string"));
  }

  @Test public void emptyReturnsTrueForEmptyArray() {
    azzert.assertEquals(true, is.empty(new Integer[0]));
    azzert.assertEquals(true, is.empty(new Object[0]));
  }

  @Test public void emptyReturnsFalseForNotEmptyArray() {
    azzert.assertEquals(false, is.empty(new Integer[] { 1, 2, 3, 4 }));
  }

  @Test public void emptyReturnsTrueForEmptyIterable() {
    azzert.assertEquals(true, is.empty((Iterable<Object>) new ArrayList<>()));
    azzert.assertEquals(true, is.empty((Iterable<Object>) Collections.EMPTY_LIST));
  }

  @Test public void emptyReturnsFalseForNotEmptyIterable() {
    azzert.assertEquals(false, is.empty((Iterable<Integer>) Arrays.asList(new Integer[] { 1, 2, 3, 4 })));
  }

  @Test public void emptyReturnsTrueForEmptyCollection() {
    azzert.assertEquals(true, is.empty((Collection<Object>) new ArrayList<>()));
    azzert.assertEquals(true, is.empty((Collection<Object>) Collections.EMPTY_LIST));
  }

  @Test public void emptyReturnsFalseForNotEmptyCollection() {
    azzert.assertEquals(false, is.empty((Collection<Integer>) Arrays.asList(new Integer[] { 1, 2, 3, 4 })));
  }
}
