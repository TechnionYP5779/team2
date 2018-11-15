package fluent.ly;

import java.util.function.*;

import org.jetbrains.annotations.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-12 */
public interface nulling {
  static <@Nullable T> @Nullable T ly(final BooleanSupplier param) {
    return nil.ignoring(param.getAsBoolean());
  }

  static <@Nullable T> @Nullable T ly(final DoubleSupplier param) {
    return nil.ignoring(param.getAsDouble());
  }

  static <@Nullable T> @Nullable T ly(final IntSupplier param) {
    return nil.ignoring(param.getAsInt());
  }

  static <@Nullable T> @Nullable T ly(final LongSupplier param) {
    return nil.ignoring(param.getAsLong());
  }

  static <@Nullable T> @Nullable T ly(final Runnable param) {
    param.run();
    return the.nil();
  }

  static <@Nullable T, @Nullable R> T ly(final Supplier<R> param) {
    return nil.forgetting(param.get());
  }
}
