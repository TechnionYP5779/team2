package fluent.ly;

import org.jetbrains.annotations.*;
import org.junit.*;

public class hasTest {
  @Nullable private final String nul = null;

  @Test public void seriesA01() {
    azzert.aye(has.nulls(nul));
  }

  @Test @SuppressWarnings("static-method") public void seriesA02() {
    azzert.nay(has.nulls("A"));
  }
}