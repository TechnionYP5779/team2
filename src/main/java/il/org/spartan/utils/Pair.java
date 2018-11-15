package il.org.spartan.utils;

import org.jetbrains.annotations.*;

import il.org.spartan.*;

public class Pair<First, Second> {
  @SuppressWarnings("unchecked") //
  public static <First, Second> Pair<First, Second> @NotNull [] makePairs(final int param) {
    return new Pair[param];
  }

  public static <First, Second> Pair<First, Second> @NotNull [] makePairs(final int i, final int m) {
    return makePairs(i * m);
  }

  @NotNull public static <A, B> Pair<A, B> newPair(final A a, final B b) {
    return new Pair<>(a, b);
  }

  private static boolean eq(final @Nullable Object a, final @Nullable Object o) {
    return a == null ? o == null : a.equals(o);
  }

  public final First first;
  public final Second second;

  public Pair(final First first, final Second second) {
    this.first = first;
    this.second = second;
  }

  @Override public boolean equals(final @Nullable Object param) {
    return param == this
        || param != null && getClass().equals(param.getClass()) && eq(first, ((Pair<?, ?>) param).first) && eq(second, ((Pair<?, ?>) param).second);
  }

  @Override public int hashCode() {
    return Utils.hash(second) ^ Utils.hash(first) >>> 1;
  }

  @Override @NotNull public String toString() {
    return "<" + first + "," + second + ">";
  }
}
