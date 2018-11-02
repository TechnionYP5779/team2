package fluent.ly;

import org.junit.*;

public class nilTest {
  @SuppressWarnings("static-method") @Test public void forgettingTest() {
    assert (nil.forgetting(new Object()) == null);
    assert (nil.forgetting(new Object(), new Object()) == null);
    assert (nil.forgetting(new Object(), new Object(), new Object()) == null);
  }

  @SuppressWarnings({ "boxing", "static-method" }) @Test public void guardinglyTest() {
    assert (nil.guardingly(x -> x).on(null) == null);
    assert ((Integer) nil.guardingly(x -> x).on(5) == 5);
    assert (nil.guardingly(x -> (Integer) x * (Integer) x).on(5) == 25);
  }

  @SuppressWarnings("static-method") @Test public void booleanIgnoringTest() {
    assert (nil.ignoring(true) == null);
    assert (nil.ignoring(false) == null);
  }

  @SuppressWarnings("static-method") @Test public void doubleIgnoringTest() {
    for (double i = -10; i < 10; i += 0.1) {
      assert (nil.ignoring(i) == null);
    }
  }

  @SuppressWarnings("static-method") @Test public void longIgnoringTest() {
    for (long i = -100; i < 101; i++) {
      assert (nil.ignoring(i) == null);
    }
  }
}
