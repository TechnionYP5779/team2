package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import java.io.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.etc.*;
import il.org.spartan.etc.idiomatic.*;

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

  @SuppressWarnings("null") @Test public void testKatchingWithNoException() {
    assert cantBeNull(idiomatic.catching((Producer<Integer>) () -> box(5))).equals(fluent.ly.box.it(5));
  }

  @SuppressWarnings("null") @Test public void testKatchingWithException() {
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

  @Test public void testTestUses() {
    final idiomatic.TEST testClass = new idiomatic.TEST();
    testClass.use0();
    testClass.use1();
    testClass.use2();
    testClass.use3();
    testClass.use4();
    testClass.use5();
    testClass.use6();
    testClass.use7();
    testClass.use8();
    testClass.use9();
    testClass.use10();
    testClass.use11();
  }
}
