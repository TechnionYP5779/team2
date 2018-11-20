package il.org.spartan.etc;

import static il.org.spartan.Utils.*;
import static il.org.spartan.etc.idiomatic.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import java.io.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class idiomaticTest {
  @Test public void testIncaseTrueReturnSameObj() {
    final Integer integer = box(5);
    assert cantBeNull(idiomatic.incase(true, integer)).equals(integer);
  }

  @Test public void testEval() {
    assert idiomatic.eval(() -> fluent.ly.box.it(5)).get().equals(fluent.ly.box.it(5));
  }

  @Test public void testIncaseFalseReturnsNull() {
    assert idiomatic.incase(false, fluent.ly.box.it(5)) == null;
  }

  @Test @SuppressWarnings("null") public void testKatchingWithNoException() {
    assert cantBeNull(idiomatic.catching((Producer<Integer>) () -> box(5))).equals(fluent.ly.box.it(5));
  }

  @Test @SuppressWarnings("null") public void testKatchingWithException() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream(), errContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out, originalErr = System.err;
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
    assert idiomatic.catching((Producer<Integer>) () -> {
      throw new IOException();
    }) == null;
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test public void testQuoteNotNullString() {
    assert "'hello'".equals(idiomatic.quote("hello"));
  }

  @Test public void testQuoteNullString() {
    assert "<null reference>".equals(idiomatic.quote(null));
  }

  @Test public void testDoubleQuote() {
    assert "''a''".equals(idiomatic.quote(idiomatic.quote("a")));
  }

  @Test public void testWhenTrueReturnsSame() {
    assert cantBeNull(idiomatic.when(true).eval(() -> box(5))).equals(box(5));
  }

  @Test public void testWhenFalseReturnsNull() {
    assert idiomatic.when(1 == 3).eval(() -> fluent.ly.box.it(5)) == null;
  }

  @Test public void testUnlessFalseReturnsSame() {
    assert cantBeNull(idiomatic.unless(1 == 3).eval(() -> fluent.ly.box.it(5))).equals(fluent.ly.box.it(5));
  }

  @Test public void testUnlessTrueReturnsNull() {
    assert idiomatic.unless(true).eval(() -> fluent.ly.box.it(5)) == null;
  }

  @Test public void testUnlessFalseWithoutEval() {
    final Integer i = box(5);
    assert idiomatic.unless(false, i) == i;
  }

  @Test public void testUnlessTrueWithoutEval() {
    assert idiomatic.unless(true, fluent.ly.box.it(5)) == null;
  }

  class MyRunnable implements Runnable {
    Boolean ran = Boolean.FALSE;

    @Override public void run() {
      // TODO Auto-generated method stub
      ran = Boolean.TRUE;
    }

    public Boolean didRun() {
      return ran;
    }
  }

  @Test public void testRunnerRun() {
    final MyRunnable r = new MyRunnable();
    final Runner runner = idiomatic.run(r);
    assert !unbox(cantBeNull(r.didRun()));
    runner.run();
    assert unbox(cantBeNull(r.didRun()));
  }

  @Test public void testRunnerWhen() {
    @NotNull final MyRunnable r = new MyRunnable();
    final Runner runner = idiomatic.run(r);
    runner.when(false);
    assert !unbox(cantBeNull(r.didRun()));
    runner.when(true);
    assert unbox(cantBeNull(r.didRun()));
  }

  @Test public void testRunnerUnless() {
    final MyRunnable r = new MyRunnable();
    final Runner runner = idiomatic.run(r);
    runner.unless(true);
    assert !unbox(cantBeNull(r.didRun()));
    runner.unless(false);
    assert unbox(cantBeNull(r.didRun()));
  }

  class MyTrigger implements Trigger {
    @Override public <@Nullable T> @Nullable T eval(final Supplier<@Nullable T> ¢) {
      return ¢.get();
    }
  }

  @Test public void testTriggerDefaultEval() {
    assert cantBeNull(new MyTrigger().eval(fluent.ly.box.it(4))).equals(fluent.ly.box.it(4));
  }

  @Test public void use0() {
    azzert.assertNotEquals(new Storer<>(this), null);
  }

  @Test public void use8() {
    azzert.isNull(unless(true).eval(() -> new Object()));
  }

  @Test public void use9() {
    assert unless(false).eval(() -> new Object()) != null;
  }

  @Test public void use1() {
    assert new Storer<>(this) != null;
    new Storer<>(this).when(true);
  }

  @Test public void use10() {
    assert when(true).eval(() -> new Object()) != null;
  }

  @Test public void use11() {
    azzert.isNull(when(false).eval(() -> new Object()));
  }

  @Test public void use2() {
    assert take(this) != null;
    azzert.isNull(take(this).when(false));
  }

  @Test public void use3() {
    azzert.that(take(this).when(true), is(this));
  }

  @Test public void use4() {
    azzert.isNull(take(this).when(false));
  }

  @Test public void use5() {
    azzert.that(take(this).unless(false), is(this));
  }

  @Test public void use6() {
    azzert.isNull(take(this).unless(true));
  }

  @Test public void use7() {
    azzert.isNull(take(this).unless(true));
    azzert.isNull(take(null).unless(true));
    azzert.isNull(take(null).unless(false));
  }
}
