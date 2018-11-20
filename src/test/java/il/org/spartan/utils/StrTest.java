package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;
import static fluent.ly.box.*;

@SuppressWarnings("static-method") public class StrTest {
  @Test public void testStr() {
    azzert.isNull(new Str().inner);
  }

  @Test public void testStrObject() {
    azzert.that(new Str(box(1)).inner(), is("1"));
  }

  @Test public void testSet() {
    final Str s = new Str(box(1));
    s.set(box(2));
    azzert.that(s.inner(), is("2"));
  }

  @Test public void testIsEmptyx1() {
    assert new Str().isEmptyx();
  }

  @Test public void testIsEmptyx2() {
    assert !new Str(box(1)).isEmptyx();
  }

  @Test public void testNotEmpty1() {
    assert new Str(box(1)).notEmpty();
  }

  @Test public void testNotEmpty2() {
    assert !new Str().notEmpty();
  }
}
