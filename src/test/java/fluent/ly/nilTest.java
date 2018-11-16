package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.box.*;
import static fluent.ly.nil.*;
import static fluent.ly.unbox.*;

import org.junit.*;

@SuppressWarnings("static-method") public class nilTest {
  @Test public void forgettingTest() {
    azzert.isNull(forgetting(new Object()));
    azzert.isNull(forgetting(new Object(), new Object()));
    azzert.isNull(forgetting(new Object(), new Object(), new Object()));
  }

  @Test public void guardinglyTest() {
    azzert.isNull(guardingly(λ -> λ).on(null));
    assert guardingly(λ -> λ).on(box(5)).equals(box(5));
    assert guardingly((final Integer λ) -> box(unbox(cantBeNull(λ)) * unbox(cantBeNull(λ)))).on(box(5)).equals(box(25));
  }

  @Test public void booleanIgnoringTest() {
    azzert.isNull(ignoring(true));
    azzert.isNull(ignoring(false));
  }

  @Test public void doubleIgnoringTest() {
    for (double i = -10; i < 10; i += 0.1)
      assert ignoring(i) == null;
  }

  @Test public void longIgnoringTest() {
    for (long i = -100; i < 101; ++i)
      assert ignoring(i) == null;
  }
}
