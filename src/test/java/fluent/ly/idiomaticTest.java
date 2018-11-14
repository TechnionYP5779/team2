package fluent.ly;

import java.io.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.etc.*;
import il.org.spartan.etc.idiomatic.*;

@SuppressWarnings("static-method") public class idiomaticTest {
  @Test @SuppressWarnings("null") public void testIncaseTrueReturnSameObj() {
    final Integer integer = Integer.valueOf(5);
    azzert.assertTrue(idiomatic.incase(true, integer).equals(integer));
  }

  @Test public void testEval() {
    azzert.assertTrue(idiomatic.eval(() -> fluent.ly.box.it(5)).get().equals(fluent.ly.box.it(5)));
  }

  @Test public void testIncaseFalseReturnsNull() {
    azzert.assertTrue(idiomatic.incase(false, fluent.ly.box.it(5)) == null);
  }

  @Test @SuppressWarnings("null") public void testKatchingWithNoException() {
    azzert.assertTrue(idiomatic.catching((Producer<Integer>) () -> Integer.valueOf(5)).equals(fluent.ly.box.it(5)));
  }

  @Test @SuppressWarnings("null") public void testKatchingWithException() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream(), errContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out, originalErr = System.err;
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
    azzert.assertTrue(idiomatic.catching((Producer<Integer>) () -> {
      throw new IOException();
    }) == null);
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test public void testQuoteNotNullString() {
    azzert.assertTrue("'hello'".equals(idiomatic.quote("hello")));
  }

  @Test public void testQuoteNullString() {
    azzert.assertTrue("<null reference>".equals(idiomatic.quote(null)));
  }

  @Test public void testDoubleQuote() {
    azzert.assertTrue("''a''".equals(idiomatic.quote(idiomatic.quote("a"))));
  }

  @Test @SuppressWarnings("null") public void testWhenTrueReturnsSame() {
    azzert.assertTrue(idiomatic.when(true).eval(() -> Integer.valueOf(5)).equals(Integer.valueOf(5)));
  }

  @Test public void testWhenFalseReturnsNull() {
    azzert.assertTrue(idiomatic.when(1 == 3).eval(() -> fluent.ly.box.it(5)) == null);
  }

  @Test @SuppressWarnings("null") public void testUnlessFalseReturnsSame() {
    azzert.assertTrue(idiomatic.unless(1 == 3).eval(() -> fluent.ly.box.it(5)).equals(fluent.ly.box.it(5)));
  }

  @Test public void testUnlessTrueReturnsNull() {
    azzert.assertTrue(idiomatic.unless(true).eval(() -> fluent.ly.box.it(5)) == null);
  }

  @Test public void testUnlessFalseWithoutEval() {
    final Integer i = Integer.valueOf(5);
    azzert.assertTrue(idiomatic.unless(false, i) == i);
  }

  @Test public void testUnlessTrueWithoutEval() {
    azzert.assertTrue(idiomatic.unless(true, fluent.ly.box.it(5)) == null);
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
    azzert.assertFalse(r.didRun());
    runner.run();
    azzert.assertTrue(r.didRun());
  }

  @Test public void testRunnerWhen() {
    @NotNull final MyRunnable r = new MyRunnable();
    final Runner runner = idiomatic.run(r);
    runner.when(false);
    azzert.assertFalse(r.didRun());
    runner.when(true);
    azzert.assertTrue(r.didRun());
  }

  @Test public void testRunnerUnless() {
    final MyRunnable r = new MyRunnable();
    final Runner runner = idiomatic.run(r);
    runner.unless(true);
    azzert.assertFalse(r.didRun());
    runner.unless(false);
    azzert.assertTrue(r.didRun());
  }

  class MyTrigger implements Trigger {
    @Override @SuppressWarnings("null") public <T> @Nullable T eval(final Supplier<@Nullable T> ¢) {
      return ¢.get();
    }
  }

  @Test @SuppressWarnings("null") public void testTriggerDefaultEval() {
    azzert.assertTrue(new MyTrigger().eval(fluent.ly.box.it(4)).equals(fluent.ly.box.it(4)));
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
