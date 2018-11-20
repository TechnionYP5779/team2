package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.function.*;

import org.eclipse.jdt.annotation.*;
import org.junit.*;

public class lazyTest {
  final int SATISFYING_AMOUNT = 10;

  @Test @SuppressWarnings("null") public void testGet() {
    final lazy<@Nullable Integer> lazyInteger = lazy.get(new Supplier<@Nullable Integer>() {
      // The supplier always supplies new values, but our lazy will always return the
      // first
      int c;

      @Override public Integer get() {
        return box(c++);
      }
    });
    for (int ¢ = 0; ¢ < SATISFYING_AMOUNT; ++¢)
      azzert.that(lazyInteger.get(), is(box(0)));
  }
}
