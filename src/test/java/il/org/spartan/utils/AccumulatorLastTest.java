package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Accumulator.*;

@SuppressWarnings("static-method") public class AccumulatorLastTest {
  @Test public void booleanAdds() {
    final @NotNull Accumulator.Last c = new Last();
    azzert.zero(as.bit(false));
    azzert.zero(c.value());
    c.add(true);
    azzert.that(c.value(), is(1));
    azzert.zero(as.bit(false));
    c.add(false);
    azzert.zero(c.value());
    c.add(false);
    azzert.zero(c.value());
    c.add(true);
    azzert.that(c.value(), is(1));
    c.add(true);
    azzert.that(c.value(), is(1));
  }

  @Test public void emptyAdds() {
    final @NotNull Accumulator.Last c = new Last();
    for (int ¢ = 0; ¢ < 19; ++¢)
      c.add(¢);
    c.add(11);
    azzert.that(c.value(), is(11));
  }
}