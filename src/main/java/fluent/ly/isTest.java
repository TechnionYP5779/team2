package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class isTest {
  @Test public void inEmptyListReturnsFasle() {
    Assert.assertFalse(is.in("some string"));
    Assert.assertFalse(is.in(""));
    Assert.assertFalse(is.in(Integer.valueOf(1)));
    Assert.assertFalse(is.in(null));
    Assert.assertFalse(is.in(Boolean.valueOf(true)));
    Assert.assertFalse(is.in(new Object()));
  }

  @Test public void inReturnsFasleForNullItem() {
    Assert.assertFalse(is.in(null, "", Integer.valueOf(5), Boolean.valueOf(false), null));
  }

  @Test public void inReturnsTrueForExistingItem() {
    Assert.assertTrue(is.in("", "", "some string", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertTrue(is.in("some string", "", "some string", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertTrue(is.in(Integer.valueOf(5), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertTrue(is.in(Boolean.valueOf(false), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    int[] intArr1 = {};
    Assert.assertTrue(is.in(intArr1, "", Integer.valueOf(5), intArr1, Boolean.valueOf(false), null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    Assert.assertTrue(is.in(intArr3, "", Integer.valueOf(5), intArr3, Boolean.valueOf(false), null));
  }

  @Test public void inReturnsFalseForMissingItem() {
    Assert.assertFalse(is.in("not the same", "", "some string", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertFalse(is.in(Integer.valueOf(10), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertFalse(is.in(Boolean.valueOf(true), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    int[] intArr1 = {};
    int[] intArr2 = {};
    Assert.assertFalse(is.in(intArr1, "", Integer.valueOf(5), intArr2, Boolean.valueOf(false), null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    int[] intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    Assert.assertFalse(is.in(intArr3, "", Integer.valueOf(5), intArr4, Boolean.valueOf(false), null));
  }

  @Test public void intIsInEmptyListReturnsFasle() {
    Assert.assertFalse(is.intIsIn(5));
    Assert.assertFalse(is.intIsIn(0));
    Assert.assertFalse(is.intIsIn(Integer.MAX_VALUE));
    Assert.assertFalse(is.intIsIn(Integer.MIN_VALUE));
  }

  @Test public void intIsInReturnsTrueForExistingItem() {
    Assert.assertTrue(is.intIsIn(0, 2, 5, 4, 8, 9, 0, 2, 15, 5, 3, 0));
    Assert.assertTrue(is.intIsIn(5, 6, -4, 1, 2, 3, 5, 6, 4, 5, 1));
    Assert.assertTrue(is.intIsIn(-1, 2, 5, 8, 9, 6, 0, 4, 7, 7, 7, 7, -1));
  }

  @Test public void intIsInReturnsFalseForMissingItem() {
    Assert.assertFalse(is.intIsIn(0, 1, 2, 3, 4, 5, 6, 456, 5644, 2165, 65, 4, 89, 8));
    Assert.assertFalse(is.intIsIn(-9, 231, 456, 1, -6458, -564, -8456, 0));
    Assert.assertFalse(is.intIsIn(645, 89, 231, -231, 0, 789, 4654, 644, 666, 646));
  }

  @Test public void notInEmptyListReturnsTrue() {
    Assert.assertTrue(is.not.in("some string"));
    Assert.assertTrue(is.not.in(""));
    Assert.assertTrue(is.not.in(Integer.valueOf(1)));
    Assert.assertTrue(is.not.in(null));
    Assert.assertTrue(is.not.in(Boolean.valueOf(true)));
    Assert.assertTrue(is.not.in(new Object()));
  }

  @Test public void notInReturnsFasleForNullItem() {
    Assert.assertTrue(is.not.in(null, "", Integer.valueOf(5), Boolean.valueOf(false), null));
  }

  @Test public void notInReturnsTrueForExistingItem() {
    Assert.assertFalse(is.not.in("", "", "some string", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertFalse(is.not.in("some string", "", "some string", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertFalse(is.not.in(Integer.valueOf(5), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertFalse(is.not.in(Boolean.valueOf(false), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    int[] intArr1 = {};
    Assert.assertFalse(is.not.in(intArr1, "", Integer.valueOf(5), intArr1, Boolean.valueOf(false), null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    Assert.assertFalse(is.not.in(intArr3, "", Integer.valueOf(5), intArr3, Boolean.valueOf(false), null));
  }

  @Test public void notInReturnsFalseForMissingItem() {
    Assert.assertTrue(is.not.in("not the same", "", "some string", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertTrue(is.not.in(Integer.valueOf(10), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertTrue(is.not.in(Boolean.valueOf(true), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    int[] intArr1 = {};
    int[] intArr2 = {};
    Assert.assertTrue(is.not.in(intArr1, "", Integer.valueOf(5), intArr2, Boolean.valueOf(false), null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    int[] intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    Assert.assertTrue(is.not.in(intArr3, "", Integer.valueOf(5), intArr4, Boolean.valueOf(false), null));
  }

  @Test public void outEmptyListReturnsTrue() {
    Assert.assertTrue(is.out("some string"));
    Assert.assertTrue(is.out(""));
    Assert.assertTrue(is.out(Integer.valueOf(1)));
    Assert.assertTrue(is.out(null));
    Assert.assertTrue(is.out(Boolean.valueOf(true)));
    Assert.assertTrue(is.out(new Object()));
  }

  @Test public void outReturnsFasleForNullItem() {
    Assert.assertTrue(is.out(null, "", Integer.valueOf(5), Boolean.valueOf(false), null));
  }

  @Test public void outReturnsTrueForExistingItem() {
    Assert.assertFalse(is.out("", "", "some string", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertFalse(is.out("some string", "", "some string", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertFalse(is.out(Integer.valueOf(5), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertFalse(is.out(Boolean.valueOf(false), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    int[] intArr1 = {};
    Assert.assertFalse(is.out(intArr1, "", Integer.valueOf(5), intArr1, Boolean.valueOf(false), null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    Assert.assertFalse(is.out(intArr3, "", Integer.valueOf(5), intArr3, Boolean.valueOf(false), null));
  }

  @Test public void outReturnsFalseForMissingItem() {
    Assert.assertTrue(is.out("not the same", "", "some string", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertTrue(is.out(Integer.valueOf(10), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    Assert.assertTrue(is.out(Boolean.valueOf(true), "", Integer.valueOf(5), Boolean.valueOf(false), null));
    int[] intArr1 = {};
    int[] intArr2 = {};
    Assert.assertTrue(is.out(intArr1, "", Integer.valueOf(5), intArr2, Boolean.valueOf(false), null));
    int[] intArr3 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    int[] intArr4 = { 1, 2, 4, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -54, 42 };
    Assert.assertTrue(is.out(intArr3, "", Integer.valueOf(5), intArr4, Boolean.valueOf(false), null));
  }

  @Test public void emptyReturnsTrueForNull() {
    Assert.assertTrue(is.empty((String) null));
    Assert.assertTrue(is.empty((Object[]) null));
    Assert.assertTrue(is.empty((Iterable<Object>) null));
    Assert.assertTrue(is.empty((Collection<Object>) null));
  }

  @Test public void emptyReturnsTrueForEmptyString() {
    Assert.assertTrue(is.empty((String) null));
    Assert.assertTrue(is.empty(""));
  }

  @Test public void emptyReturnsTrueForEmptyArray() {
    Assert.assertTrue(is.empty((Integer[]) null));
    Assert.assertTrue(is.empty(new Integer[0]));
    Assert.assertTrue(is.empty(new Object[0]));
  }

  @Test public void emptyReturnsTrueForEmptyIterable() {
    Assert.assertTrue(is.empty((Iterable<Object>) null));
    Assert.assertTrue(is.empty((Iterable<Object>) new ArrayList<>()));
    Assert.assertTrue(is.empty((Iterable<Object>) Collections.EMPTY_LIST));
  }

  @Test public void emptyReturnsTrueForEmptyCollection() {
    Assert.assertTrue(is.empty((Collection<Object>) null));
    Assert.assertTrue(is.empty((Collection<Object>) new ArrayList<>()));
    Assert.assertTrue(is.empty((Collection<Object>) Collections.EMPTY_LIST));
  }
}
