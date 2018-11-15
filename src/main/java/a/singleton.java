package a;

import java.util.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

/** Singleton collections.
 * @author Ori Roth
 * @since 2017-04-16 */
public interface singleton {
  /** Singleton list. */
  static <T> @NotNull List<T> list(final T param) {
    return as.list(param);
  }

  /** Singleton array. */
  static <T> T[] array(final T param) {
    return as.array(param);
  }
}
