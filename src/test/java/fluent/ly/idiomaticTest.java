package fluent.ly;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.idiomatic;
import fluent.ly.idiomatic.*;
import java.io.IOException;
import java.util.function.*;

@SuppressWarnings("static-method") public class idiomaticTest {
  @Test @SuppressWarnings("null") public void testIncaseTrueReturnSameObj() {
    Integer integer = Integer.valueOf(5);
    azzert.assertTrue(idiomatic.incase(true, integer).equals(integer));
  }
  
  @Test public void testEval() {
    Holder<Integer> t = idiomatic.eval(()->Integer.valueOf(5));
    azzert.assertTrue(t.get().equals(Integer.valueOf(5)));
  }

  @Test public void testIncaseFalseReturnsNull() {
    azzert.assertTrue(idiomatic.incase(false, Integer.valueOf(5)) == null);
  }

  @Test @SuppressWarnings("null") public void testKatchingWithNoException() {
    azzert.assertTrue(idiomatic.catching((Producer<Integer>) () -> Integer.valueOf(5)).equals(Integer.valueOf(5)));
  }

  @Test @SuppressWarnings("null") public void testKatchingWithException() {
    azzert.assertTrue(idiomatic.catching((Producer<Integer>) () -> {
      throw new IOException();
    }) == null);
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
    azzert.assertTrue(idiomatic.when(1 == 3).eval(() -> Integer.valueOf(5)) == null);
  }

  @Test @SuppressWarnings("null") public void testUnlessFalseReturnsSame() {
    azzert.assertTrue(idiomatic.unless(1 == 3).eval(() -> Integer.valueOf(5)).equals(Integer.valueOf(5)));
  }

  @Test public void testUnlessTrueReturnsNull() {
    azzert.assertTrue(idiomatic.unless(true).eval(() -> Integer.valueOf(5)) == null);
  }

  @Test public void testUnlessFalseWithoutEval() {
    Integer i = Integer.valueOf(5);
    azzert.assertTrue(idiomatic.unless(false, i) == i);
  }

  @Test public void testUnlessTrueWithoutEval() {
    azzert.assertTrue(idiomatic.unless(true, Integer.valueOf(5)) == null);
  }
  
  class MyRunnable implements Runnable{
    
    Boolean ran = false;
    @Override public void run() {
      // TODO Auto-generated method stub
      ran = true;
    }
    
    public Boolean didRun() {
      return ran;
    }
    
  }
  
  
  @Test public void testRunnerRun() {
    
    MyRunnable r = new MyRunnable();
    Runner runner = idiomatic.run(r);
    azzert.assertFalse(r.didRun());
    runner.run();
    azzert.assertTrue(r.didRun());
  }
  
  @Test public void testRunnerWhen() {
    
    MyRunnable r = new MyRunnable();
    Runner runner = idiomatic.run(r);
    runner.when(false);
    azzert.assertFalse(r.didRun());
    runner.when(true);
    azzert.assertTrue(r.didRun());
  }

  @Test public void testRunnerUnless() {
  
    MyRunnable r = new MyRunnable();
    Runner runner = idiomatic.run(r);
    runner.unless(true);
    azzert.assertFalse(r.didRun());
    runner.unless(false);
    azzert.assertTrue(r.didRun());
  }
  
  class MyTrigger implements Trigger{

    @Override public <T> @Nullable T eval(Supplier<@Nullable T> t) {
      // TODO Auto-generated method stub
      return t.get();
    }
    
  }
  
  @Test public void testTriggerDefaultEval() {
    MyTrigger t = new MyTrigger();
    azzert.assertTrue(t.eval(Integer.valueOf(4)).equals(Integer.valueOf(4)));
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
