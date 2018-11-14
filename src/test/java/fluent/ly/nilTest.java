package fluent.ly;

import org.junit.*;

@SuppressWarnings({"static-method","static-access" }) public class nilTest {
  @Test public void forgettingTest() {
    azzert.assertNull(nil.forgetting(new Object()));
    azzert.assertNull(nil.forgetting(new Object(), new Object()));
    azzert.assertNull(nil.forgetting(new Object(), new Object(), new Object()));
  }

  @Test @SuppressWarnings("boxing") public void guardinglyTest() {
    azzert.assertNull(nil.guardingly(λ -> λ).on(null));
    azzert.assertEquals(fluent.ly.box.it(5), nil.guardingly(λ -> λ).on(5));
    azzert.assertEquals(fluent.ly.box.it(25), nil.guardingly(λ -> fluent.ly.box.it((Integer) λ * (Integer) λ)).on(5));
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
