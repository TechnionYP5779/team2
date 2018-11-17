package fluent.ly;

import static il.org.spartan.etc.idiomatic.*;

import static fluent.ly.___.*;

import java.util.*;

import org.jetbrains.annotations.*;

import il.org.spartan.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-12 */
public interface the {
  static int index(final int i, final int... is) {
    for (final Integer $ : range.from(0).to(is.length)) {
      if (is[unbox.unbox(Utils.cantBeNull($))] == i) {
        return unbox.unbox(Utils.cantBeNull($));
      }
    }
    return -1;
  }

  static <@Nullable T> T nil() {
    return null;
  }

  static String nth(final int i, final Collection<?> os) {
    return the.nth(i, os.size());
  }

  static String nth(final int i, final int n) {
    return nth(i + "", n + "");
  }

  static String nth(final @NotNull String s, final @NotNull String n) {
    return " #" + s + "/" + n;
  }

  static <T> @Nullable T penultimateOf(final List<T> param) {
    return param == null || param.size() < 2 ? null : param.get(param.size() - 2);
  }

  static <T> @Nullable T previous(final T t, final List<T> ts) {
    if (ts == null)
      return null;
    final int $ = ts.indexOf(t);
    return $ < 1 ? null : ts.get($ - 1);
  }

  static <@Nullable T> @NotNull List<T> tailOf(final @Nullable List<T> param) {
    final @NotNull List<T> $ = as.list(param);
    $.remove(the.headOf($));
    return $;
  }

  static String tailOf(final @NotNull String param) {
    return param.substring(1);
  }

  static <T> List<T> rest(final T t, final Iterable<T> ts) {
    boolean add = false;
    final List<T> $ = an.empty.list();
    for (final T x : ts)
      if (add)
        $.add(x);
      else
        add = x == t;
    return $;
  }

  @Contract("null -> null") @Nullable static <T> T headOf(final @Nullable List<T> param) {
    return param == null || param.isEmpty() ? null : param.get(0);
  }

  static char characterOf(final @NotNull String param) {
    return the.beforeLastOf(param, 0);
  }

  @Contract(pure = true) static char ith(final @NotNull String s, final int i) {
    return s.charAt(i);
  }

  @Contract("null -> null") @Nullable static <@Nullable T> T lastOf(final @Nullable List<@Nullable T> param) {
    return param == null || param.isEmpty() ? null : param.get(param.size() - 1);
  }

  static char lastOf(final @NotNull String param) {
    return beforeLastOf(param, 0);
  }

  static char beforeLastOf(final @NotNull String s, final int i) {
    return s.charAt(s.length() - i - 1);
  }

  @NotNull static <T> Iterable<T> lastOf(final @NotNull Iterable<T> param) {
    return () -> new Iterator<T>() {
      Iterator<T> $ = param.iterator();
      {
        $.next();
      }

      @Override public boolean hasNext() {
        return $.hasNext();
      }

      @Override public T next() {
        return $.next();
      }
    };
  }

  @Nullable static <T> T onlyOneOf(final @Nullable List<T> param) {
    return param == null || param.size() != 1 ? null : headOf(param);
  }

  @Contract("null -> null") @Nullable static <T> T secondOf(final @Nullable List<T> param) {
    return param == null || param.size() < 2 ? null : param.get(1);
  }

  /** Computes the maximum of two or more integers.
   * @param a  some integer
   * @param is additional integers
   * @return largest of the parameters */
  static int max(final int a, final int... is) {
    int $ = a;
    for (final int ¢ : is)
      $ = Math.max($, ¢);
    return $;
  }

  /** Computes the minimum of two or more integers
   * @param a  some integer
   * @param is additional
   * @return smallest of the parameters */
  static int min(final int a, final int... is) {
    int $ = a;
    for (final int ¢ : is)
      $ = Math.min($, ¢);
    return $;
  }

  static <T> T lastOf(final T[] param) {
    return param[param.length - 1];
  }

  /** @param <T> JD
   * @param ¢ JD
   * @return last item in a list or <code><b>null</b></code> if the parameter is
   *         <code><b>null</b></code> or empty */
  @SuppressWarnings("null") static <T> @Nullable T last(final @Nullable List<T> param) {
    return eval(() -> param.get(param.size() - 1)).unless(param == null || param.isEmpty());
  }

  /** Computes the square of a given integer
   * @param ¢ some integer
   * @return square of the parameter */
  static int sqr(final int param) {
    return param * param;
  }

  /** Chop the first character of a string.
   * @param ¢ a non-<code><b>null</b></code> string of length at least one
   * @return <code>s</code> but without its first character. */
  static String rest(final @NotNull String param) {
    nonnull(param);
    positive(param.length());
    return param.substring(1);
  }

  static <T> T[] tailOf(final T[] param) {
    return Arrays.copyOfRange(param, 1, param.length);
  }
}
