package fluent.ly;

import static il.org.spartan.Utils.*;
import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.assertNull;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import org.junit.*;

@SuppressWarnings("static-method") public class nilTest {
  @Test public void forgettingTest() {
    assertNull(nil.forgetting(new Object()));
    assertNull(nil.forgetting(new Object(), new Object()));
    assertNull(nil.forgetting(new Object(), new Object(), new Object()));
  }

  @Test public void guardinglyTest() {
    assertNull(nil.guardingly(λ -> λ).on(null));
    assertEquals(fluent.ly.box.it(5), nil.guardingly(λ -> λ).on(box(5)));
    assertEquals(fluent.ly.box.it(25), nil.guardingly((final Integer λ) -> fluent.ly.box.it(unbox(cantBeNull(λ)) * unbox(cantBeNull(λ)))).on(box(5)));
  }

  @Test public void booleanIgnoringTest() {
    assert nil.ignoring(true) == null;
    assert nil.ignoring(false) == null;
  }

  @Test public void doubleIgnoringTest() {
    for (double i = -10; i < 10; i += 0.1)
      assert nil.ignoring(i) == null;
  }

  @Test public void longIgnoringTest() {
    for (long i = -100; i < 101; ++i)
      assert nil.ignoring(i) == null;
  }
}
