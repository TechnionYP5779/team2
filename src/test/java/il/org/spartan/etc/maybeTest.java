package il.org.spartan.etc;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.*;

@SuppressWarnings("static-method") public class maybeTest {
  @Test public void usecase0() {
    azzert.isNull(maybe.no().get());
  }

  @Test public void usecase1() {
    azzert.isNull(maybe.yes(null).get());
  }

  @Test public void usecase2() {
    azzert.notNull(maybe.yes(new Object()).get());
  }

  @Test public void testClear() {
    azzert.isNull(maybe.yes(new Integer(3)).clear().get());
  }

  @Test public void testMissing1() {
    assert maybe.yes(new Integer(3)).clear().missing();
  }

  @Test public void testMissing2() {
    assert !maybe.yes(new Integer(3)).missing();
  }

  @Test public void testPresent1() {
    assert !maybe.yes(new Integer(3)).clear().present();
  }

  @Test public void testPresent2() {
    assert maybe.yes(new Integer(3)).present();
  }

  @Test public void testSet() {
    Integer i = maybe.yes(new Integer(3)).set(new Integer(10)).get();
    assert Utils.cantBeNull(i).equals(new Integer(10));
  }
}