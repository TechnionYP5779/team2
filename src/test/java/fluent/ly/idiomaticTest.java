package fluent.ly;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.idiomatic;
import fluent.ly.idiomatic.*;
import java.io.IOException;
import java.util.function.*;

@SuppressWarnings("static-method") public class idiomaticTest {
  @Test @SuppressWarnings("null") public void testIncaseTrueReturnSameObj() {
    Integer integer = Integer.valueOf(5);
    assert idiomatic.incase(true, integer).equals(integer);
  }
  
  @Test public void testEval() {
    Holder<Integer> t = idiomatic.eval(()->Integer.valueOf(5));
    assert t.get().equals(Integer.valueOf(5));
  }

  @Test public void testIncaseFalseReturnsNull() {
    assert idiomatic.incase(false, Integer.valueOf(5)) == null;
  }

  @Test @SuppressWarnings("null") public void testKatchingWithNoException() {
    assert idiomatic.catching((Producer<Integer>) () -> Integer.valueOf(5)).equals(Integer.valueOf(5));
  }

  @Ignore @Test @SuppressWarnings("null") public void testKatchingWithException() {
    assert idiomatic.catching((Producer<Integer>) () -> {
      throw new IOException();
    }) == null;
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

  @Test @SuppressWarnings("null") public void testWhenTrueReturnsSame() {
    assert idiomatic.when(true).eval(() -> Integer.valueOf(5)).equals(Integer.valueOf(5));
  }

  @Test public void testWhenFalseReturnsNull() {
    assert idiomatic.when(1 == 3).eval(() -> Integer.valueOf(5)) == null;
  }

  @Test @SuppressWarnings("null") public void testUnlessFalseReturnsSame() {
    assert idiomatic.unless(1 == 3).eval(() -> Integer.valueOf(5)).equals(Integer.valueOf(5));
  }

  @Test public void testUnlessTrueReturnsNull() {
    assert idiomatic.unless(true).eval(() -> Integer.valueOf(5)) == null;
  }

  @Test public void testUnlessFalseWithoutEval() {
    Integer i = Integer.valueOf(5);
    assert idiomatic.unless(false, i) == i;
  }

  @Test public void testUnlessTrueWithoutEval() {
    assert idiomatic.unless(true, Integer.valueOf(5)) == null;
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
    assert r.didRun()==false;
    runner.run();
    assert r.didRun() == true;
  }
  
  @Test public void testRunnerWhen() {
    
    MyRunnable r = new MyRunnable();
    Runner runner = idiomatic.run(r);
    runner.when(false);
    assert r.didRun() == false;
    runner.when(true);
    assert r.didRun() == true;
  }

  @Test public void testRunnerUnless() {
  
    MyRunnable r = new MyRunnable();
    Runner runner = idiomatic.run(r);
    runner.unless(true);
    assert r.didRun() == false;
    runner.unless(false);
    assert r.didRun() == true;
  }
  
  class MyTrigger implements Trigger{

    @Override public <T> @Nullable T eval(Supplier<@Nullable T> t) {
      // TODO Auto-generated method stub
      return t.get();
    }
    
  }
  
  @Test public void testTriggerDefaultEval() {
    MyTrigger t = new MyTrigger();
    assert t.eval(Integer.valueOf(4)).equals(Integer.valueOf(4));
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
