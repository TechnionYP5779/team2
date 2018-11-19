package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.io.*;
import java.util.function.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.PropositionPrettyPrinter.*;

@SuppressWarnings("static-method")
public class PropositionPrettyPrinterTest {
  
  static class MockListener implements Listener<BooleanSupplier>{
    
    public int downCalled = 0;
    public int upCalled = 0;
    public int nextCalled = 0;
    public int inTrueCalled = 0;
    public int inFalseCalled = 0;
    
    @Override public void down(){
      downCalled++;
    }
    @Override public void up(){
      upCalled++;
    }
    @Override public void next(){
      nextCalled++;
    }
    @Override public void in(final BooleanSupplier __){
      if(__.getAsBoolean()) {
        inTrueCalled++;
      }else {
        inFalseCalled++;
      }
    }
    
    public void print() {
      System.out.println("downCalled = "+downCalled);
      System.out.println("upCalled = "+upCalled);
      System.out.println("nextCalled = "+nextCalled);
      System.out.println("inTrueCalled = "+inTrueCalled);
      System.out.println("inFalseCalled = "+inFalseCalled);
    }
    
  }
  
  MockListener listener;
  
  @Before public void createListener() {
    this.listener = new MockListener();
  }
  

  
  @Test public void testTopDown1() {
    PropositionTreeTraversal propositionTreeTraversal = new PropositionTreeTraversal(listener);
    propositionTreeTraversal.topDown(Proposition.AND(()->true, ()->true));
    
    azzert.that(listener.downCalled, is(1));
    azzert.that(listener.upCalled, is(1));
    azzert.that(listener.nextCalled, is(2));
    azzert.that(listener.inTrueCalled, is(3));
    azzert.that(listener.inFalseCalled, is(0));
  }
  
  @Test public void testTopDown2() {
    PropositionTreeTraversal propositionTreeTraversal = new PropositionTreeTraversal(listener);
    propositionTreeTraversal.topDown(Proposition.that(()->true));
    
    azzert.that(listener.downCalled, is(1));
    azzert.that(listener.upCalled, is(1));
    azzert.that(listener.nextCalled, is(0));
    azzert.that(listener.inTrueCalled, is(1));
    azzert.that(listener.inFalseCalled, is(0));
  }
  
  @Test public void testTopDown3() {
    PropositionTreeTraversal propositionTreeTraversal = new PropositionTreeTraversal(listener);
    propositionTreeTraversal.topDown(Proposition.that(Proposition.T));
    
    azzert.that(listener.downCalled, is(2));
    azzert.that(listener.upCalled, is(2));
    azzert.that(listener.nextCalled, is(0));
    azzert.that(listener.inTrueCalled, is(2));
    azzert.that(listener.inFalseCalled, is(0));
  }
  
  @Test public void testNumberLess() {
    PropositionPrettyPrinter.Number number = new PropositionPrettyPrinter.Number();
    azzert.assertNull(number.less());
  }
  
  @Test public void testNumberNext() {
    PropositionPrettyPrinter.Number number = new PropositionPrettyPrinter.Number();
    number.next();
    azzert.that(number.toString(), is("2"));
  }
  
  @Test public void testNumberMore() {
    PropositionPrettyPrinter.Number number = new PropositionPrettyPrinter.Number();
    number.next();
    number = number.more();
    number.next();
    azzert.that(number.toString(), is("2.2"));
  }
  
  @Test public void testNumberWithTabMore() {
    PropositionPrettyPrinter.NumberWithTab number = new PropositionPrettyPrinter.NumberWithTab();
    number.more();
    azzert.that(number.toString(), is("\t1.1) "));
  }
  
  @Test public void testNumberWithTabLess() {
    PropositionPrettyPrinter.NumberWithTab number = new PropositionPrettyPrinter.NumberWithTab();
    number.more();
    number.less();
    azzert.that(number.toString(), is("1) "));
  }
  
  @Test public void testNumberWithTabNext() {
    PropositionPrettyPrinter.NumberWithTab number = new PropositionPrettyPrinter.NumberWithTab();
    number.more();
    number.next();
    azzert.that(number.toString(), is("\t1.2) "));
  }
  
  @Test public void testMain(){
    final String main_output = new StringBuilder()
      .append("1) (And) MAIN, SUB1 ==> Assertion exception\r\n")
        .append("\t1.1)  X ==> Assertion exception\r\n")
        .append("\t1.2)  F ==> false\r\n")
        .append("\t1.3) (Or) SUB2 ==> true\r\n")
          .append("\t\t1.3.1)  T ==> true\r\n")
          .append("\t\t1.3.2) (Not) N ==> Null pointer exception\r\n")
            .append("\t\t\t1.3.2.1)  N ==> Null pointer exception\r\n")
          .append("\t\t1.3.3)  ==> true\r\n")
          .append("\t\t1.3.4)  OH NO ==> Runtime exception\r\n")
.append("\r\n")
      .append("1) (And) MAIN ==> true\r\n")
        .append("\t1.1) (Or) SUB ==> true\r\n")
          .append("\t\t1.1.1)  T ==> true\r\n")
          .append("\t\t1.1.2)  F ==> false\r\n")
        .append("\t1.2)  T ==> true\r\n")
.append("\r\n")
      .append("1)  MAIN ==> true\r\n")
        .append("\t1.1)  T ==> true\r\n")
.append("\r\n")
      .append("1) (And) [SUB, T] ==> true\r\n")
        .append("\t1.1) (Or) SUB ==> true\r\n")
          .append("\t\t1.1.1)  T ==> true\r\n")
          .append("\t\t1.1.2)  F ==> false\r\n")
        .append("\t1.2)  T ==> true\r\n")
.append("\r\n")
      .append("1) (And) [F, X] ==> false\r\n")
        .append("\t1.1)  F ==> false\r\n")
        .append("\t1.2)  X ==> Assertion exception\r\n")
.append("\r\n")
      .append("1) (Or) SUB2 ==> true\r\n")
        .append("\t1.1)  T ==> true\r\n")
        .append("\t1.2) (Not) N ==> Null pointer exception\r\n")
          .append("\t\t1.2.1) (Not) N ==> Null pointer exception\r\n")
            .append("\t\t\t1.2.1.1)  N ==> Null pointer exception\r\n")
        .append("\t1.3)  ==> true\r\n")
        .append("\t1.4)  OH NO ==> Runtime exception\r\n")
.append("\r\n").toString();

    
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream(), errContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out, originalErr = System.err;
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
    
    
    PropositionPrettyPrinter.main(null);
    
    azzert.that(outContent.toString(), is(main_output));
    
    System.setOut(originalOut);
    System.setErr(originalErr);
  }
  
}
