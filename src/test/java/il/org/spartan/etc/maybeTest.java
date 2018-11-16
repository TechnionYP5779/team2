package il.org.spartan.etc;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class maybeTest {
  @Test public void usecase0() {
    azzert.isNull(maybe.no().get());
  }

  @Test public void usecase1() {
    azzert.isNull(maybe.yes(null).get());
  }

  @Test public void usecase2() {
    assert maybe.yes(new Object()).get() != null;
  }
}