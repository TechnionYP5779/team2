package fluent.ly;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-16 */
/* Interface forget is used to mark things we are not interested in as
 * unused. */
@SuppressWarnings("unused") public interface forget {
  /* mark all objects as unused
   *
   * @params Object_1, Object... _2 */
  static void all(final Object _1, final Object... _2) {
    /**/ }

  /* mark the boolean parameter as unused
   *
   * @params boolean variable */
  static void it(final boolean __) {
    /**/ }

  /* mark the double parameter as unused
   *
   * @params double variable */
  static void it(final double __) {
    /**/ }

  /* mark the long parameter as unused
   *
   * @params long variable */
  static void it(final long __) {
    /**/ }

  /* mark the Object parameter as unused
   *
   * @params Object */
  static void it(final Object __) {
    /**/ }

  /** A do nothing method to document the fact that a <code><b>long</b></code>
   * parameter, along with a optional list of {@link Object}s are not used by a
   * function, and to suppress the warning.
   * @param l   the unused parameter
   * @param os more unused parameters */
  static void ______unused(final long l, final Object... os) {
    forget.it(l);
    forget.all(os);
  }

  /** A do nothing method to document the fact that a <code><b>double</b></code>
   * parameter, along with a optional list of {@link Object}s are not used by a
   * function, and to suppress the warning.
   * @param __   the unused parameter
   * @param ____ more unused parameters */
  static void unused(final double __, final double... ____) {
    // empty
  }

  static void unused(final double __, final Object... ____) {
    // empty
  }

  /** A do nothing method to document the fact that a <code><b>long</b></code>
   * parameter, along with a optional list of {@link Object}s are not used by a
   * function, and to suppress the warning.
   * @param __   the unused parameter
   * @param ____ more unused parameters */
  static void unused(final int __, final int... ____) {
    // empty
  }

  /** A do nothing method to document the fact that a <code><b>long</b></code>
   * parameter, along with a optional list of {@link Object}s are not used by a
   * function, and to suppress the warning.
   * @param __   the unused parameter
   * @param ____ more unused parameters */
  static void unused(final long __, final long... ____) {
    // empty
  }

  /** A do nothing method to document the fact that some <code>Object</code>(s)
   * parameter(s) (or local variable(s)) are not used by a function. Calling this
   * method saves the caller the trouble of suppressing a "variable unused"
   * warnings on the argument(s).
   * @param ____ the unused parameters */
  static void unused(final Object... ____) {
    forget.it(____);
  }
}
