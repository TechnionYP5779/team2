package fluent.ly;

import static il.org.spartan.Utils.*;

import java.util.*;

import org.hamcrest.*;
import org.hamcrest.core.*;
import org.hamcrest.number.*;
import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.utils.*;

/** Extends {@link org.junit.Assert} with more assertion for equality
 * comparisons. If the comparison yields a "not-equal" result, a JUnit assertion
 * failure is issued.
 * @author Itay Maman Jul 9, 2007
 * @author Yossi Gil revised 2015-07-18 */
@SuppressWarnings("null") //
public class azzert extends org.junit.Assert {
  public static <T> Matcher<T> allOf(final java.lang.Iterable<Matcher<? super T>> param) {
    return AllOf.allOf(param);
  }

  @SafeVarargs public static <T> Matcher<T> allOf(final Matcher<? super T>... param) {
    return AllOf.allOf(param);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second) {
    return AllOf.allOf(first, second);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second, final Matcher<? super T> third) {
    return AllOf.allOf(first, second, third);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth, final Matcher<? super T> fifth) {
    return AllOf.allOf(first, second, third, fourth, fifth);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth, final Matcher<? super T> fifth, final Matcher<? super T> sixth) {
    return AllOf.allOf(first, second, third, fourth, fifth, sixth);
  }

  public static <T> Matcher<T> any(final java.lang.Class<T> type) {
    return IsInstanceOf.any(type);
  }

  public static <T> @Nullable AnyOf<T> anyOf(final java.lang.Iterable<Matcher<? super T>> param) {
    return AnyOf.anyOf(param);
  }

  @SafeVarargs public static <T> @Nullable AnyOf<T> anyOf(final Matcher<? super T>... param) {
    return AnyOf.anyOf(param);
  }

  public static <T> @Nullable AnyOf<T> anyOf(final Matcher<T> first, final Matcher<? super T> second) {
    return AnyOf.anyOf(first, second);
  }

  public static <T> @Nullable AnyOf<T> anyOf(final Matcher<T> first, final Matcher<? super T> second, final Matcher<? super T> third) {
    return AnyOf.anyOf(first, second, third);
  }

  public static <T> @Nullable AnyOf<T> anyOf(final Matcher<T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth) {
    return AnyOf.anyOf(first, second, third, fourth);
  }

  public static <T> @Nullable AnyOf<@Nullable T> anyOf(final Matcher<T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth, final Matcher<? super T> fifth) {
    return AnyOf.anyOf(first, second, third, fourth, fifth);
  }

  public static <T> @Nullable AnyOf<T> anyOf(final Matcher<T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth, final Matcher<? super T> fifth, final Matcher<? super T> sixth) {
    return AnyOf.anyOf(first, second, third, fourth, fifth, sixth);
  }

  public static Matcher<@Nullable Object> anything() {
    return IsAnything.anything();
  }

  public static Matcher<@Nullable Object> anything(final @Nullable String description) {
    return IsAnything.anything(description);
  }

  public static <T> void assertCollectionsEqual(final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    assertCollectionsEqual("", c1, c2);
  }

  public static <T> void assertCollectionsEqual(final @NotNull Collection<T> ts1, final T[] ts2) {
    assertCollectionsEqual("", ts1, Arrays.asList(ts2));
  }

  public static <T> void assertCollectionsEqual(final @NotNull String s, final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    assertContained(s, c1, c2);
    assertContained(s, c2, c1);
  }

  public static <T> void assertCollectionsEqual(final @NotNull String s, final @NotNull Collection<T> ts1, final T[] ts2) {
    assertCollectionsEqual(s, ts1, Arrays.asList(ts2));
  }

  public static <T> void assertCollectionsEqual(final @NotNull String s, final T[] ts1, final @NotNull Collection<T> ts2) {
    assertCollectionsEqual(s, ts2, ts1);
  }

  public static <T> void assertContained(final @NotNull String s, final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    // assertLE(s, c1.size(), c2.size());
    final @NotNull ArrayList<T> missing = new ArrayList<>();
    for (final T ¢ : c1)
      if (!c2.contains(¢))
        missing.add(¢);
    switch (missing.size()) {
      case 0:
        return;
      case 1:
        fail(s + "Element '" + missing.get(0) + "' not found in " + c2.size() + " sized-\n collection " + c2);
        break;
      default:
        fail(s + "Element '" + missing.get(0) + "' and '" + missing.get(1) + "'  as well as " + (missing.size() - 2)
            + " other \n elements were not found in " + c2.size() + " sized-\n collection " + c2);
        break;
    }
  }

  public static <T> void assertContains(final @NotNull Collection<T> ts, final T t) {
    assertContains("", ts, t);
  }

  public static <T> void assertContains(final @NotNull String s, final @NotNull Collection<T> ts, final T t) {
    assert ts.contains(t) : s + " t = " + t;
  }

  public static void assertEquals(final boolean a, final boolean b) {
    assertEquals(Boolean.valueOf(a), Boolean.valueOf(b));
  }

  public static void assertEquals(final boolean b1, final Boolean b2) {
    assertEquals(Boolean.valueOf(b1), b2);
  }

  public static void assertEquals(final Boolean b1, final boolean b2) {
    assertEquals(b1, Boolean.valueOf(b2));
  }

  public static void assertEquals(final int expected, final int actual) {
    assertEquals(fluent.ly.box.it(expected), fluent.ly.box.it(actual));
  }

  public static void assertEquals(final int a, final Integer b) {
    assertEquals(Integer.valueOf(a), b);
  }

  public static void assertEquals(final Integer a, final int b) {
    assertEquals(a, Integer.valueOf(b));
  }

  public static void assertEquals(final @NotNull String message, final boolean b1, final boolean b2) {
    assertEquals(message, Boolean.valueOf(b1), Boolean.valueOf(b2));
  }

  public static void assertEquals(final @NotNull String message, final boolean b1, final Boolean b2) {
    assertEquals(message, Boolean.valueOf(b1), b2);
  }

  public static void assertEquals(final @NotNull String message, final Boolean b1, final boolean b2) {
    assertEquals(message, b1, Boolean.valueOf(b2));
  }

  public static void assertEquals(final @NotNull String reason, final int i1, final int i2) {
    assertThat(reason, fluent.ly.box.it(i1), CoreMatchers.equalTo(fluent.ly.box.it(i2)));
  }

  public static void assertEquals(final @NotNull String message, final int a, final Integer b) {
    assertEquals(message, Integer.valueOf(a), b);
  }

  public static void assertEquals(final @NotNull String message, final Integer a, final int b) {
    assertEquals(message, a, Integer.valueOf(b));
  }

  public static void assertFalse(final boolean param) {
    that("", Boolean.valueOf(param), is(Boolean.FALSE));
  }

  public static void assertFalse(final @NotNull String s, final boolean b) {
    that(s, b, is(Boolean.FALSE));
  }

  public static void assertLE(final @NotNull String s, final int i, final int m) {
    assert i <= m : s + " n=" + i + " m=" + m;
  }

  public static <T> void assertNotContains(final @NotNull Collection<T> ts, final T t) {
    assertNotContains("", ts, t);
  }

  public static <T> void assertNotContains(final @NotNull String s, final @NotNull Collection<T> ts, final T t) {
    assert !ts.contains(t) : s + " t = " + t;
  }

  public static void assertNotEquals(final Object o1, final @Nullable Object o2) {
    assertThat("", o1, CoreMatchers.not(o2));
  }

  public static void assertNotEquals(final @NotNull String message, final @NotNull Object o1, final Object o2) {
    assert !o1.equals(o2);
  }

  public static void assertNotEquals(final @NotNull String s1, final @NotNull String s2) {
    assertNotEquals(null, s1, s2);
  }

  public static void assertNotEquals(final @NotNull String message, final @NotNull String s1, final @NotNull String s2) {
    assert !s1.equals(s2) : message;
  }

  public static void assertNull(final @Nullable Object param) {
    assert param == null;
  }

  public static void assertNull(final @NotNull String message, final Object o) {
    assertEquals(message, null, o);
  }

  public static void assertPositive(final int param) {
    assert param > 0 : "Expecting a positive value, but got " + param;
  }

  public static <T> void assertSubset(final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    assertContained("", c1, c2);
  }

  public static void assertTrue(final boolean param) {
    that("", Boolean.valueOf(param), is(Boolean.TRUE));
  }

  public static void assertTrue(final @NotNull String s, final boolean b) {
    that(s, Boolean.valueOf(b), is(Boolean.TRUE));
  }

  public static void assertZero(final int param) {
    assertEquals("Expecting a zero", param, 0);
  }

  @NotNull public static Asserter aye(final boolean claim) {
    return aye("", claim);
  }

  @NotNull public static Asserter aye(final @NotNull String reason, final boolean claim) {
    return new Asserter().andAye(reason, claim);
  }

  public static <LHS> CombinableMatcher.@Nullable CombinableBothMatcher<LHS> both(final Matcher<? super LHS> param) {
    return CombinableMatcher.both(param);
  }

  @Factory public static Matcher<@Nullable Boolean> comparesEqualTo(final boolean param) {
    return OrderingComparison.comparesEqualTo(Boolean.valueOf(param));
  }

  @Factory public static Matcher<@Nullable Byte> comparesEqualTo(final byte param) {
    return OrderingComparison.comparesEqualTo(Byte.valueOf(param));
  }

  @Factory public static Matcher<@Nullable Character> comparesEqualTo(final char param) {
    return OrderingComparison.comparesEqualTo(Character.valueOf(param));
  }

  @Factory public static Matcher<@Nullable Double> comparesEqualTo(final double param) {
    return OrderingComparison.comparesEqualTo(Double.valueOf(param));
  }

  @Factory public static Matcher<@Nullable Float> comparesEqualTo(final float param) {
    return OrderingComparison.comparesEqualTo(Float.valueOf(param));
  }

  @Factory public static Matcher<@Nullable Integer> comparesEqualTo(final int param) {
    return OrderingComparison.comparesEqualTo(Integer.valueOf(param));
  }

  @Factory public static Matcher<@Nullable Long> comparesEqualTo(final long param) {
    return OrderingComparison.comparesEqualTo(Long.valueOf(param));
  }

  @Factory public static Matcher<@Nullable Short> comparesEqualTo(final short param) {
    return OrderingComparison.comparesEqualTo(Short.valueOf(param));
  }

  public static Matcher<@Nullable String> containsString(final @NotNull String substring) {
    return StringContains.containsString(substring);
  }

  public static <T> Matcher<T> describedAs(final @NotNull String description, final Matcher<T> m, final Object... values) {
    return DescribedAs.describedAs(description, m, values);
  }

  public static <LHS> CombinableMatcher.@Nullable CombinableEitherMatcher<LHS> either(final Matcher<? super LHS> param) {
    return CombinableMatcher.either(param);
  }

  public static Matcher<String> endsWith(final @NotNull String suffix) {
    return StringEndsWith.endsWith(suffix);
  }

  public static <T> void equals(final @NotNull String prefix, final @NotNull Collection<T> set, final @NotNull Collection<T> ts) {
    @NotNull Set<T> temp = new HashSet<>();
    temp.addAll(set);
    temp.removeAll(ts);
    assert temp.isEmpty() : temp;
    temp = new HashSet<>();
    temp.addAll(ts);
    temp.removeAll(set);
    assert temp.isEmpty() : prefix + " - " + temp;
  }

  public static <T> Matcher<T> equalTo(final T operand) {
    return IsEqual.equalTo(operand);
  }

  public static Matcher<String> equalToIgnoringCase(final @NotNull String expectedString) {
    return org.hamcrest.Matchers.equalToIgnoringCase(expectedString);
  }

  public static Matcher<String> equalToIgnoringWhiteSpace(final @NotNull String expectedString) {
    return org.hamcrest.Matchers.equalToIgnoringWhiteSpace(expectedString);
  }

  public static <U> Matcher<java.lang.Iterable<U>> everyItem(final Matcher<U> itemMatcher) {
    return Every.everyItem(itemMatcher);
  }

  public static void fail() {
    Assert.fail();
  }

  public static void fail(final @NotNull String param) {
    Assert.fail(param);
  }

  public static void falze(final boolean param) {
    assert !param;
  }

  @Factory public static Matcher<@Nullable Boolean> greaterThan(final boolean param) {
    return OrderingComparison.greaterThan(Boolean.valueOf(param));
  }

  @Factory public static Matcher<@Nullable Byte> greaterThan(final byte param) {
    return OrderingComparison.greaterThan(Byte.valueOf(param));
  }

  @Factory public static Matcher<@Nullable Character> greaterThan(final char param) {
    return OrderingComparison.greaterThan(Character.valueOf(param));
  }

  @Factory public static Matcher<@Nullable Double> greaterThan(final double param) {
    return OrderingComparison.greaterThan(Double.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Float> greaterThan(final float param) {
    return OrderingComparison.greaterThan(Float.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Integer> greaterThan(final int param) {
    return OrderingComparison.greaterThan(Integer.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Long> greaterThan(final long param) {
    return OrderingComparison.greaterThan(Long.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Short> greaterThan(final short param) {
    return OrderingComparison.greaterThan(Short.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Boolean> greaterThanOrEqualTo(final boolean param) {
    return OrderingComparison.greaterThanOrEqualTo(Boolean.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Byte> greaterThanOrEqualTo(final byte param) {
    return OrderingComparison.greaterThanOrEqualTo(Byte.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Character> greaterThanOrEqualTo(final char param) {
    return OrderingComparison.greaterThanOrEqualTo(Character.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Double> greaterThanOrEqualTo(final double param) {
    return OrderingComparison.greaterThanOrEqualTo(Double.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Float> greaterThanOrEqualTo(final float param) {
    return OrderingComparison.greaterThanOrEqualTo(Float.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Integer> greaterThanOrEqualTo(final int param) {
    return OrderingComparison.greaterThanOrEqualTo(Integer.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Long> greaterThanOrEqualTo(final long param) {
    return OrderingComparison.greaterThanOrEqualTo(Long.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Short> greaterThanOrEqualTo(final short param) {
    return OrderingComparison.greaterThanOrEqualTo(Short.valueOf(param));
  }

  @NotNull public static <T> Matcher<java.lang.Iterable<? super @Nullable T>> hasItem(final Matcher<? super @Nullable T> itemMatcher) {
    return IsCollectionContaining.hasItem(itemMatcher);
  }

  @NotNull public static <T> Matcher<java.lang.Iterable<? super @Nullable T>> hasItem(final T item) {
    return IsCollectionContaining.hasItem(item);
  }

  @SafeVarargs @NotNull public static <T> Matcher<java.lang.Iterable<T>> hasItems(final Matcher<? super T>... itemMatchers) {
    return IsCollectionContaining.hasItems(itemMatchers);
  }

  @SafeVarargs @NotNull public static <T> Matcher<java.lang.Iterable<T>> hasItems(final T... items) {
    return IsCollectionContaining.hasItems(items);
  }

  @NotNull public static <T> Matcher<T> instanceOf(final java.lang.Class<?> type) {
    return IsInstanceOf.instanceOf(type);
  }

  @NotNull public static Matcher<@Nullable Boolean> is(final boolean param) {
    return is(Boolean.valueOf(param));
  }

  @NotNull public static Matcher<@Nullable Byte> is(final byte param) {
    return is(Byte.valueOf(param));
  }

  @NotNull public static Matcher<@Nullable Character> is(final char param) {
    return is(Character.valueOf(param));
  }

  @NotNull public static Matcher<@Nullable Double> is(final double param) {
    return is(Double.valueOf(param));
  }

  @NotNull public static Matcher<@Nullable Float> is(final float param) {
    return is(Float.valueOf(param));
  }

  @NotNull public static Matcher<@Nullable Integer> is(final int param) {
    return is(Integer.valueOf(param));
  }

  @NotNull public static Matcher<@Nullable Long> is(final long param) {
    return is(Long.valueOf(param));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> is(final @Nullable Matcher<@Nullable T> param) {
    return Is.is(param);
  }

  @NotNull public static Matcher<@Nullable Short> is(final short param) {
    return is(Short.valueOf(param));
  }

  @Contract(pure = true) public static <@Nullable T> @NotNull Matcher<T> is(final @Nullable T value) {
    return Is.is(value);
  }

  @NotNull public static <T> Matcher<T> isA(final java.lang.Class<T> type) {
    return Is.isA(type);
  }

  public static void isNull(final @Nullable Object param) {
    assertThat("", param, nullValue());
  }

  /** @param message what to print
   * @param o       what to examine */
  @Contract("_, !null -> fail") public static void isNull(final @NotNull String message, final @Nullable Object o) {
    azzert.assertNull(message, o);
  }

  @NotNull public static Outer<String> iz(final @NotNull String param) {
    return new Outer<>(param);
  }

  @Factory @NotNull public static Matcher<@Nullable Boolean> lessThan(final boolean param) {
    return OrderingComparison.lessThan(Boolean.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Byte> lessThan(final byte param) {
    return OrderingComparison.lessThan(Byte.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Character> lessThan(final char param) {
    return OrderingComparison.lessThan(Character.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Double> lessThan(final double param) {
    return OrderingComparison.lessThan(Double.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Float> lessThan(final float param) {
    return OrderingComparison.lessThan(Float.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Integer> lessThan(final int param) {
    return OrderingComparison.lessThan(Integer.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Long> lessThan(final long param) {
    return OrderingComparison.lessThan(Long.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Short> lessThan(final short param) {
    return OrderingComparison.lessThan(Short.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Boolean> lessThanOrEqualTo(final boolean param) {
    return OrderingComparison.lessThanOrEqualTo(Boolean.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Byte> lessThanOrEqualTo(final byte param) {
    return OrderingComparison.lessThanOrEqualTo(Byte.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Character> lessThanOrEqualTo(final char param) {
    return OrderingComparison.lessThanOrEqualTo(Character.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Double> lessThanOrEqualTo(final double param) {
    return OrderingComparison.lessThanOrEqualTo(Double.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Float> lessThanOrEqualTo(final float param) {
    return OrderingComparison.lessThanOrEqualTo(Float.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Integer> lessThanOrEqualTo(final int param) {
    return OrderingComparison.lessThanOrEqualTo(Integer.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Long> lessThanOrEqualTo(final long param) {
    return OrderingComparison.lessThanOrEqualTo(Long.valueOf(param));
  }

  @Factory @NotNull public static Matcher<@Nullable Short> lessThanOrEqualTo(final short param) {
    return OrderingComparison.lessThanOrEqualTo(Short.valueOf(param));
  }

  @NotNull public static Asserter nay(final boolean claim) {
    return nay("", claim);
  }

  @NotNull public static Asserter nay(final @NotNull String reason, final boolean claim) {
    return new Asserter().andNay(reason, claim);
  }

  public static void nonNulls(final @NotNull @Nullable Iterable<@Nullable Object> os) {
    assert os != null;
    assert os != null;
    for (final @Nullable Object ¢ : os)
      assert ¢ != null : os + "";
  }

  @NotNull public static Matcher<Boolean> not(final boolean param) {
    return cantBeNull(IsNot.not(Boolean.valueOf(param)));
  }

  @NotNull public static Matcher<Byte> not(final byte param) {
    return cantBeNull(IsNot.not(Byte.valueOf(param)));
  }

  @NotNull public static Matcher<Character> not(final char i) {
    return cantBeNull(IsNot.not(Character.valueOf(i)));
  }

  @NotNull public static Matcher<Double> not(final double param) {
    return cantBeNull(IsNot.not(Double.valueOf(param)));
  }

  @NotNull public static Matcher<Float> not(final float param) {
    return cantBeNull(IsNot.not(Float.valueOf(param)));
  }

  @NotNull public static Matcher<Integer> not(final int param) {
    return cantBeNull(IsNot.not(Integer.valueOf(param)));
  }

  @NotNull public static Matcher<Long> not(final long i) {
    return cantBeNull(IsNot.not(Long.valueOf(i)));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> not(final Matcher<T> param) {
    return IsNot.not(param);
  }

  @NotNull public static Matcher<Short> not(final short param) {
    return cantBeNull(IsNot.not(Short.valueOf(param)));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> not(final T value) {
    return IsNot.not(value);
  }

  public static void notNull(final @Nullable Object param) {
    assertThat("", param, notNullValue());
  }

  public static void notNull(final @NotNull String s, final @Nullable Object o) {
    assertThat(s, o, notNullValue());
  }

  @Contract(pure = true) @NotNull public static Matcher<@Nullable Object> notNullValue() {
    return IsNull.notNullValue();
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> notNullValue(final java.lang.Class<T> type) {
    return IsNull.notNullValue(type);
  }

  public static void notNullz(final @NotNull @Nullable Object @Nullable... os) {
    assert os != null;
    assert os != null;
    for (final @Nullable Object ¢ : os)
      assert ¢ != null : os + "";
  }

  @Contract(pure = true) @NotNull public static Matcher<@Nullable Object> nullValue() {
    return IsNull.nullValue();
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> nullValue(final java.lang.Class<T> type) {
    return IsNull.nullValue(type);
  }

  public static void positive(final int param) {
    azzert.that(param, greaterThan(0));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> sameInstance(final T target) {
    return IsSame.sameInstance(target);
  }

  @NotNull public static Matcher<String> startsWith(final @NotNull String prefix) {
    return StringStartsWith.startsWith(prefix);
  }

  public static void that(final boolean b, final @NotNull Matcher<? super @Nullable Boolean> m) {
    assertThat("", Boolean.valueOf(b), m);
  }

  public static void that(final byte b, final @NotNull Matcher<? super @Nullable Byte> m) {
    assertThat("", Byte.valueOf(b), m);
  }

  public static void that(final char c, final @NotNull Matcher<? super @Nullable Character> m) {
    assertThat("", Character.valueOf(c), m);
  }

  public static void that(final double d, final @NotNull Matcher<? super @Nullable Double> m) {
    assertThat("", Double.valueOf(d), m);
  }

  public static void that(final float f, final @NotNull Matcher<? super @Nullable Float> m) {
    assertThat("", Float.valueOf(f), m);
  }

  public static void that(final int i, final @NotNull Matcher<? super @Nullable Integer> m) {
    assertThat("", Integer.valueOf(i), m);
  }

  public static void that(final long l, final @NotNull Matcher<? super @Nullable Long> m) {
    assertThat("", Long.valueOf(l), m);
  }

  public static void that(final Object actual, final @NotNull Outer<@Nullable String> expected) {
    assertThat("", compressSpaces(actual + ""), is(compressSpaces(expected.get())));
  }

  public static void that(final short s, final @NotNull Matcher<? super @Nullable Short> m) {
    assertThat("", Short.valueOf(s), m);
  }

  public static void that(final @NotNull String reason, final boolean b, final @NotNull Matcher<? super Boolean> m) {
    assertThat(reason, Boolean.valueOf(b), m);
  }

  public static void that(final @NotNull String reason, final byte b, final @NotNull Matcher<? super @Nullable Byte> m) {
    assertThat(reason, Byte.valueOf(b), m);
  }

  public static void that(final @NotNull String reason, final char c, final @NotNull Matcher<? super Character> m) {
    assertThat(reason, Character.valueOf(c), m);
  }

  public static void that(final @NotNull String reason, final double d, final @NotNull Matcher<? super @Nullable Double> m) {
    assertThat(reason, Double.valueOf(d), m);
  }

  public static void that(final @NotNull String reason, final float f, final @NotNull Matcher<? super Float> m) {
    assertThat(reason, Float.valueOf(f), m);
  }

  public static void that(final @NotNull String reason, final int i, final @NotNull Matcher<? super Integer> m) {
    assertThat(reason, Integer.valueOf(i), m);
  }

  public static void that(final @NotNull String reason, final long l, final @NotNull Matcher<? super @Nullable Long> m) {
    assertThat(reason, Long.valueOf(l), m);
  }

  public static void that(final @NotNull String reason, final short s, final @NotNull Matcher<? super Short> m) {
    assertThat(reason, Short.valueOf(s), m);
  }

  public static <@Nullable T> void that(final @NotNull String reason, final @Nullable T actual, final @NotNull Matcher<? super @Nullable T> t) {
    assertThat(reason, actual, t);
  }

  public static <@Nullable T> void that(final @Nullable T actual, final @NotNull Matcher<? super @Nullable T> t) {
    assertThat("", actual, t);
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> theInstance(final T target) {
    return IsSame.theInstance(target);
  }

  public static void xassertEquals(final int a, final int b) {
    assertEquals("", a, b);
  }

  public static void xassertEquals(final @NotNull String s, final int a, final int b) {
    assertEquals(s, Integer.valueOf(a), Integer.valueOf(b));
  }

  /** Assert that an integer is zero
   * @param ¢ JD */
  public static void zero(final int param) {
    assertEquals(0, param);
  }

  /** Assert that long is zero
   * @param ¢ JD */
  public static void zero(final long param) {
    assertEquals(0L, param);
  }

  public static class ____META {
    //
  }

  public static class Asserter {
    @NotNull public Asserter andAye(final boolean claim) {
      return andAye("", claim);
    }

    @NotNull public Asserter andAye(final @NotNull String reason, final boolean claim) {
      assert claim : reason;
      return this;
    }

    @NotNull public Asserter andNay(final boolean claim) {
      return andNay("", claim);
    }

    @NotNull public Asserter andNay(final @NotNull String reason, final boolean claim) {
      assert !claim : reason;
      return this;
    }
  }
}
