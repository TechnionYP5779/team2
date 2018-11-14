package fluent.ly;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.etc.*;
import il.org.spartan.etc.idiomatic.*;

import java.io.*;
import java.util.function.*;

@SuppressWarnings("static-method") public class idiomaticTest {
  @Test @SuppressWarnings("null") public void testIncaseTrueReturnSameObj() {
    Integer integer = Integer.valueOf(5);
    azzert.assertEquals(true, idiomatic.incase(true, integer).equals(integer));
  }
  
  @Test public void testEval() {
    azzert.assertEquals(true, idiomatic.eval(() -> Integer.valueOf(5)).get().equals(Integer.valueOf(5)));
  }

  @Test public void testIncaseFalseReturnsNull() {
    azzert.assertEquals(true, idiomatic.incase(false, Integer.valueOf(5)) == null);
  }

  @Test @SuppressWarnings("null") public void testKatchingWithNoException() {
    azzert.assertEquals(true, idiomatic.catching((Producer<Integer>) () -> Integer.valueOf(5)).equals(Integer.valueOf(5)));
  }

  @Test @SuppressWarnings("null") public void testKatchingWithException() {
    
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream(), errContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out, originalErr = System.err;
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
    
    
    azzert.assertEquals(true, idiomatic.catching((Producer<Integer>) () -> {
      throw new IOException();
    }) == null);
    
    System.setOut(originalOut);
    System.setErr(originalErr);
    
  }

  @Test public void testQuoteNotNullString() {
    azzert.assertEquals(true, "'hello'".equals(idiomatic.quote("hello")));
  }

  @Test public void testQuoteNullString() {
    azzert.assertEquals(true, "<null reference>".equals(idiomatic.quote(null)));
  }

  @Test public void testDoubleQuote() {
    azzert.assertEquals(true, "''a''".equals(idiomatic.quote(idiomatic.quote("a"))));
  }

  @Test @SuppressWarnings("null") public void testWhenTrueReturnsSame() {
    azzert.assertEquals(true, idiomatic.when(true).eval(() -> Integer.valueOf(5)).equals(Integer.valueOf(5)));
  }

  @Test public void testWhenFalseReturnsNull() {
    azzert.assertEquals(true, idiomatic.when(1 == 3).eval(() -> Integer.valueOf(5)) == null);
  }

  @Test @SuppressWarnings("null") public void testUnlessFalseReturnsSame() {
    azzert.assertEquals(true, idiomatic.unless(1 == 3).eval(() -> Integer.valueOf(5)).equals(Integer.valueOf(5)));
  }

  @Test public void testUnlessTrueReturnsNull() {
    azzert.assertEquals(true, idiomatic.unless(true).eval(() -> Integer.valueOf(5)) == null);
  }

  @Test public void testUnlessFalseWithoutEval() {
    Integer i = Integer.valueOf(5);
    azzert.assertEquals(true, idiomatic.unless(false, i) == i);
  }

  @Test public void testUnlessTrueWithoutEval() {
    azzert.assertEquals(true, idiomatic.unless(true, Integer.valueOf(5)) == null);
  }
  
  class MyRunnable implements Runnable{
    
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
    
    MyRunnable r = new MyRunnable();
    Runner runner = idiomatic.run(r);
    azzert.assertEquals(false, r.didRun());
    runner.run();
    azzert.assertEquals(true, r.didRun());
  }
  
  @Test public void testRunnerWhen() {
    
    MyRunnable r = new MyRunnable();
    Runner runner = idiomatic.run(r);
    runner.when(false);
    azzert.assertEquals(false, r.didRun());
    runner.when(true);
    azzert.assertEquals(true, r.didRun());
  }

  @Test public void testRunnerUnless() {
  
    MyRunnable r = new MyRunnable();
    Runner runner = idiomatic.run(r);
    runner.unless(true);
    azzert.assertEquals(false, r.didRun());
    runner.unless(false);
    azzert.assertEquals(true, r.didRun());
  }
  
  class MyTrigger implements Trigger{

    @Override @SuppressWarnings("null") public <T> @Nullable T eval(Supplier<@Nullable T> ¢) {
      return ¢.get();
    }
    
  }
  
  @Test @SuppressWarnings("null") public void testTriggerDefaultEval() {
    azzert.assertEquals(true, (new MyTrigger()).eval(Integer.valueOf(4)).equals(Integer.valueOf(4)));
  }
  
  @Test public void testTestUses() {
    idiomatic.TEST testClass = new idiomatic.TEST();
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
