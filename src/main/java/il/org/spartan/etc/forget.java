package il.org.spartan.etc;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-16 */

/*
 * Interface forget is used to mark things we are not interested in as unused.
 */

@SuppressWarnings("unused")
public interface forget {
  /*
   * mark all objects as unused
   * @params Object_1, Object... _2
   */
  static void all(final Object _1, final Object... _2) {
    /**/ }

  /*
   * mark the boolean parameter as unused
   * @params boolean variable
   */
 static void it(final boolean __) {
    /**/ }

 /*
  * mark the double parameter as unused
  * @params double variable
  */
  static void it(final double __) {
    /**/ }

  /*
   * mark the long parameter as unused
   * @params long variable
   */
  static void it(final long __) {
    /**/ }
  
  /*
   * mark the Object parameter as unused
   * @params Object
   */
  static void it(final Object __) {
    /**/ }
}
